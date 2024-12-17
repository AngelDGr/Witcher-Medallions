package witcher_medallions.items.medallions;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketEnums;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.items.MedallionBaseItem;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class ActivedMedallionBaseItem extends MedallionBaseItem {
    protected final RawAnimation SWING_ANIMATION = RawAnimation.begin().thenLoop("medallion_animation");
    protected final RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
    protected final RawAnimation STRONG_ANIMATION = RawAnimation.begin().thenLoop("medallion_animation_strong");

    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    public ActivedMedallionBaseItem(Settings settings) {
        super(settings);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    public SoundEvent getAnimalSound(){
        return null;
    }

    public SoundEvent getStrongAnimalSound(){
        return null;
    }

    protected Object getRenderer(){
        return null;
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {
            @Override
            public BuiltinModelItemRenderer getCustomRenderer() {
                return (BuiltinModelItemRenderer)getRenderer();
            }
        });
    }

    //Trinkets
    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
                       MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity,
                       float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
    }

    protected String getTooltip(){
        return "";
    }

    protected Formatting getTooltipColor(){
        return Formatting.GRAY;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable(getTooltip()+"_1").formatted(getTooltipColor()));
        tooltip.add(Text.translatable(getTooltip()+"_2").formatted(getTooltipColor()));
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    //Medallions with soul bound
    @Override
    public TrinketEnums.DropRule getDropRule(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(WitcherMedallions_Main.CONFIG.medallionsHaveSoulbound())
        {return TrinketEnums.DropRule.KEEP;}
        else
        {return TrinketEnums.DropRule.DEFAULT;}
    }


    //Medallion Animation Stuff
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "mainController",
                5,
                state -> PlayState.STOP)
                .triggerableAnim("swing", SWING_ANIMATION)
                .triggerableAnim("strong", STRONG_ANIMATION)
                .triggerableAnim("idle", IDLE));
    }

    //Trinkets tick
    @Override
    public void tick(ItemStack stack, SlotReference slot, LivingEntity entity) {
        this.inventoryTick(stack, entity.getWorld(), entity, slot.index(), true);
    }


    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if(entity.getWorld().isClient){
            return;
        }

        if(entity instanceof PlayerEntity player){
            if(player.witcherMedallionsMod$getHasStrongMagicNear()){
                this.triggerAnim(entity, stack, "strong");
            }
            else if(player.witcherMedallionsMod$getHasMagicMobNear()){
                this.triggerAnim(entity, stack, "swing");
            } else {
                this.triggerAnim(entity, stack, "idle");
            }
        } else {
            this.triggerAnim(entity, stack, "idle");
        }
    }

    private void triggerAnim(Entity entity, ItemStack stack, String animName){
        this.triggerAnim(entity, GeoItem.getOrAssignId(stack, (ServerWorld) entity.getWorld()), "mainController", animName);
    }

}
