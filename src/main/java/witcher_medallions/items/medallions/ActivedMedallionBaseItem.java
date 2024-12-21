package witcher_medallions.items.medallions;

import com.google.common.collect.Multimap;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketEnums;
import net.fabricmc.loader.api.FabricLoader;
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
import net.minecraft.item.tooltip.TooltipType;
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
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.util.GeckoLibUtil;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.items.MedallionBaseItem;
import witcher_medallions.items.WitcherMedallions_Items;
import witcher_medallions.util.MiscUtil;

import java.util.List;
import java.util.function.Consumer;

public abstract class ActivedMedallionBaseItem extends MedallionBaseItem {
    protected final RawAnimation SWING_ANIMATION = RawAnimation.begin().thenLoop("medallion_animation");
    protected final RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
    protected final RawAnimation STRONG_ANIMATION = RawAnimation.begin().thenLoop("medallion_animation_strong");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

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
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(new GeoRenderProvider() {
            @Override
            public @Nullable BuiltinModelItemRenderer getGeoItemRenderer() {
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
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
        tooltip.add(Text.translatable(getTooltip()+"_1").formatted(getTooltipColor()));
        tooltip.add(Text.translatable(getTooltip()+"_2").formatted(getTooltipColor()));
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
    private final Identifier SIGN_INTENSITY= Identifier.of("witcher_rpg","sign_intensity");
    private final Identifier GENERIC_ATTACK= Identifier.ofVanilla("generic.attack_damage");
    private final Identifier ADRENALINE_GAIN = Identifier.of("witcher_rpg", "adrenaline_modifier");
    private final Identifier GENERIC_ATTACK_SPEED = Identifier.ofVanilla("generic.attack_speed");
    private final Identifier KNOCKBACK_RESISTANCE = Identifier.ofVanilla("generic.knockback_resistance");
    private final Identifier SPELL_HASTE = Identifier.of("spell_power","haste");
    private final Identifier GENERIC_SPEED = Identifier.ofVanilla("generic.movement_speed");
    private final Identifier WITCHER_TOXICITY = Identifier.of("tcots-witcher","generic.witcher_toxicity");
    @Override
    public Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, Identifier slotIdentifier) {
        var modifiers = super.getModifiers(stack, slot, entity, slotIdentifier);

        //If Witcher RPG its loaded applies attributes
        if(FabricLoader.getInstance().isModLoaded("witcher_rpg")){
            //Wolf / Ancient Wolf:
            //+5% Sign Intensity
            //+2% Attack Damage
            if(stack.isOf(WitcherMedallions_Items.Witcher_WolfMedallion) || stack.isOf(WitcherMedallions_Items.Witcher_AncientWolfMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, SIGN_INTENSITY,"wolf-sign", 0.05);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_ATTACK, "wolf-damage", 0.02);
            }
            //Cat:
            //+4% Adrenaline Gain
            //+2% Attack Speed
            else if(stack.isOf(WitcherMedallions_Items.Witcher_CatMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, ADRENALINE_GAIN, "cat-adrenaline", 0.04);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_ATTACK_SPEED, "cat-speed", 0.02);
            }
            //Bear
            //+5% Adrenaline Gain
            //+5% Knockback Resistance
            else if(stack.isOf(WitcherMedallions_Items.Witcher_BearMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, ADRENALINE_GAIN, "bear-adrenaline", 0.05);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, KNOCKBACK_RESISTANCE, "bear-resistance", 0.05);
            }
            //Griffin
            //+10% Sign Intensity
            //+2% Spell Haste
            else if(stack.isOf(WitcherMedallions_Items.Witcher_GriffinMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, SIGN_INTENSITY, "griffin-power", 0.10);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, SPELL_HASTE, "griffin-haste", 0.02);
            }
            //Viper
            //+2% Movement Speed
            //+5% Attack Speed
            else if(stack.isOf(WitcherMedallions_Items.Witcher_ViperMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_SPEED, "viper-swiftness", 0.02);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_ATTACK_SPEED, "viper-speed", 0.05);
            }
            //Manticore
            //+10 Max Toxicity/+2% Sign Intensity
            //+5% Adrenaline Gain
            else if(stack.isOf(WitcherMedallions_Items.Witcher_ManticoreMedallion)){
                //If TCOTS is loaded applies toxicity, in other case applies sign intensity
                if(FabricLoader.getInstance().isModLoaded("tcots-witcher")){
                    MiscUtil.addAdditionAttributeTrinket(modifiers, WITCHER_TOXICITY, "manticore-toxicity", 10);
                } else {
                    MiscUtil.addMultiplyAttributeTrinket(modifiers, SIGN_INTENSITY, "manticore-magic", 0.02);
                }

                MiscUtil.addMultiplyAttributeTrinket(modifiers, ADRENALINE_GAIN, "manticore-adrenaline", 0.05);
            }
        }
        //If ONLY TCOTS is loaded, applies only toxicity
        else if(FabricLoader.getInstance().isModLoaded("tcots-witcher")){
            //Manticore
            //+10 Max Toxicity
            if(stack.isOf(WitcherMedallions_Items.Witcher_ManticoreMedallion)){
                MiscUtil.addAdditionAttributeTrinket(modifiers, WITCHER_TOXICITY, "manticore-toxicity", 10);
            }
        }

        return modifiers;
    }
}
