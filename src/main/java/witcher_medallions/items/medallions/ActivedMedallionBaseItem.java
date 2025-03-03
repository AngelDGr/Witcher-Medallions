package witcher_medallions.items.medallions;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketEnums;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.item.BuiltinModelItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
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
import witcher_medallions.items.WitcherMedallions_Items;
import witcher_medallions.util.MiscUtil;

import java.util.List;
import java.util.UUID;
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


    //Attributes
    public static final RegistryEntry<EntityAttribute> SIGN_INTENSITY = Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(Identifier.of("witcher_rpg", "sign_intensity")));
    private final RegistryEntry<EntityAttribute> GENERIC_ATTACK= Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(Identifier.of("minecraft","generic.attack_damage")));
    public static final RegistryEntry<EntityAttribute> ADRENALINE_GAIN = Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(Identifier.of("witcher_rpg", "adrenaline_modifier")));
    private final RegistryEntry<EntityAttribute> GENERIC_ATTACK_SPEED = Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(Identifier.of("minecraft","generic.attack_speed")));
    private final RegistryEntry<EntityAttribute> KNOCKBACK_RESISTANCE = Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(Identifier.of("minecraft","generic.knockback_resistance")));
    private final RegistryEntry<EntityAttribute> SPELL_HASTE = Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(Identifier.of("spell_power","haste")));
    private final RegistryEntry<EntityAttribute> GENERIC_SPEED = Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(Identifier.of("minecraft","generic.movement_speed")));
    private final RegistryEntry<EntityAttribute> WITCHER_TOXICITY = Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(Identifier.of("minecraft","generic.witcher_toxicity")));


    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, UUID uuid) {
        var modifiers = super.getModifiers(stack, slot, entity, uuid);

        //If Witcher RPG its loaded applies attributes
        if(FabricLoader.getInstance().isModLoaded("witcher_rpg")){
            //Wolf / Ancient Wolf:
            //+5% Sign Intensity
            //+2% Attack Damage
            if(stack.isOf(WitcherMedallions_Items.Witcher_WolfMedallion) || stack.isOf(WitcherMedallions_Items.Witcher_AncientWolfMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, SIGN_INTENSITY,UUID.fromString("8fc34e8b-e47e-43ed-8aba-432241f4e327"), 0.05);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_ATTACK, UUID.fromString("a69adc74-73e4-4389-880f-e9eada16d8e0"), 0.02);
            }
            //Cat:
            //+4% Adrenaline Gain
            //+2% Attack Speed
            else if(stack.isOf(WitcherMedallions_Items.Witcher_CatMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, ADRENALINE_GAIN, UUID.fromString("362037bb-74c8-42f3-9604-2bfb480e85d3"), 0.04);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_ATTACK_SPEED, UUID.fromString("4da57500-b001-495c-ae7c-6f98d469d93f"), 0.02);
            }
            //Bear
            //+5% Adrenaline Gain
            //+5% Knockback Resistance
            else if(stack.isOf(WitcherMedallions_Items.Witcher_BearMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, ADRENALINE_GAIN, UUID.fromString("d7175f39-4f94-4129-9d49-368ba03b64cc"), 0.05);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, KNOCKBACK_RESISTANCE, UUID.fromString("eee379b9-6f9a-4ee0-83a8-c7eb1a59d830"), 0.05);
            }
            //Griffin
            //+10% Sign Intensity
            //+2% Spell Haste
            else if(stack.isOf(WitcherMedallions_Items.Witcher_GriffinMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, SIGN_INTENSITY, UUID.fromString("8bf0f73a-5a50-45a1-881e-b507f9f9f5fc"), 0.10);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, SPELL_HASTE, UUID.fromString("2b88fc30-742f-4367-9b9d-621419397bf8"), 0.02);
            }
            //Viper
            //+2% Movement Speed
            //+5% Attack Speed
            else if(stack.isOf(WitcherMedallions_Items.Witcher_ViperMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_SPEED, UUID.fromString("cd05d82c-916f-427c-9649-0bc52d729475"), 0.02);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_ATTACK_SPEED, UUID.fromString("5239edd0-6e29-4048-8cab-338a82376868"), 0.05);
            }
            //Manticore
            //+10 Max Toxicity/+2% Sign Intensity
            //+5% Adrenaline Gain
            else if(stack.isOf(WitcherMedallions_Items.Witcher_ManticoreMedallion)){
                //If TCOTS is loaded applies toxicity, in other case applies sign intensity
                if(FabricLoader.getInstance().isModLoaded("tcots-witcher")){
                    MiscUtil.addAdditionAttributeTrinket(modifiers, WITCHER_TOXICITY, UUID.fromString("be7461d3-9455-4ef0-8b27-ae67796ca230"), 10);
                } else {
                    MiscUtil.addMultiplyAttributeTrinket(modifiers, SIGN_INTENSITY, UUID.fromString("cbf1267e-5670-4aaa-abe4-408213c5e9bd"), 0.02);
                }

                MiscUtil.addMultiplyAttributeTrinket(modifiers, ADRENALINE_GAIN, UUID.fromString("cde62380-c567-477a-bb3b-552f1a1e8774"), 0.05);
            }
        }
        //If ONLY TCOTS is loaded, applies only toxicity
        else if(FabricLoader.getInstance().isModLoaded("tcots-witcher")){
            //Manticore
            //+10 Max Toxicity
            if(stack.isOf(WitcherMedallions_Items.Witcher_ManticoreMedallion)){
                MiscUtil.addAdditionAttributeTrinket(modifiers, WITCHER_TOXICITY, UUID.fromString("be7461d3-9455-4ef0-8b27-ae67796ca230"), 10);
            }
        }

        return modifiers;
    }
}
