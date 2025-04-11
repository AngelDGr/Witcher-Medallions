package witcher_medallions.items.medallions;

import com.google.common.collect.Multimap;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketEnums;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
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
import witcher_medallions.WitcherMedallions_MainFabric;
import witcher_medallions.items.MedallionBaseItem_Fabric;
import witcher_medallions.items.WitcherMedallions_Items;
import witcher_medallions.MiscUtil;

import java.util.List;
import java.util.function.Consumer;

public abstract class ActivatedMedallionBaseItem extends MedallionBaseItem_Fabric {
    protected final RawAnimation SWING_ANIMATION = RawAnimation.begin().thenLoop("medallion_animation");
    protected final RawAnimation IDLE = RawAnimation.begin().thenLoop("idle");
    protected final RawAnimation STRONG_ANIMATION = RawAnimation.begin().thenLoop("medallion_animation_strong");

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public ActivatedMedallionBaseItem(Properties settings) {
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
            public @Nullable BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                return (BlockEntityWithoutLevelRenderer)getRenderer();
            }
        });
    }

    //Trinkets
    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
                       PoseStack matrices, MultiBufferSource vertexConsumers, int light, LivingEntity entity,
                       float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
    }

    protected String getTooltip(){
        return "tooltip.witcher_medallions";
    }

    protected ChatFormatting getTooltipColor(){
        return ChatFormatting.GRAY;
    }

    @Override
    public void appendHoverText(@NotNull ItemStack stack, @NotNull TooltipContext context, List<Component> tooltip, @NotNull TooltipFlag type) {
        tooltip.add(Component.translatable(getTooltip()+"_1").withStyle(getTooltipColor()));
        tooltip.add(Component.translatable(getTooltip()+"_2").withStyle(getTooltipColor()));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    //Medallions with soul bound
    @Override
    public TrinketEnums.DropRule getDropRule(ItemStack stack, SlotReference slot, LivingEntity entity) {
        if(WitcherMedallions_MainFabric.CONFIG.medallionsHaveSoulbound())
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
        this.inventoryTick(stack, entity.level(), entity, slot.index(), true);
    }


    @Override
    public void inventoryTick(@NotNull ItemStack stack, @NotNull Level world, Entity entity, int slot, boolean selected) {
        if(entity.level().isClientSide){
            return;
        }

        if(entity instanceof Player player){
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
        this.triggerAnim(entity, GeoItem.getOrAssignId(stack, (ServerLevel) entity.level()), "mainController", animName);
    }


    //Attributes
    private final ResourceLocation SIGN_INTENSITY= ResourceLocation.fromNamespaceAndPath("witcher_rpg","sign_intensity");
    private final ResourceLocation GENERIC_ATTACK= ResourceLocation.withDefaultNamespace("generic.attack_damage");
    private final ResourceLocation ADRENALINE_GAIN = ResourceLocation.fromNamespaceAndPath("witcher_rpg", "adrenaline_modifier");
    private final ResourceLocation GENERIC_ATTACK_SPEED = ResourceLocation.withDefaultNamespace("generic.attack_speed");
    private final ResourceLocation KNOCKBACK_RESISTANCE = ResourceLocation.withDefaultNamespace("generic.knockback_resistance");
    private final ResourceLocation SPELL_HASTE = ResourceLocation.fromNamespaceAndPath("spell_power","haste");
    private final ResourceLocation GENERIC_SPEED = ResourceLocation.withDefaultNamespace("generic.movement_speed");
    private final ResourceLocation WITCHER_TOXICITY = ResourceLocation.fromNamespaceAndPath("tcots-witcher","generic.witcher_toxicity");
    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getModifiers(ItemStack stack, SlotReference slot, LivingEntity entity, ResourceLocation slotIdentifier) {
        var modifiers = super.getModifiers(stack, slot, entity, slotIdentifier);

        //If Witcher RPG its loaded applies attributes
        if(FabricLoader.getInstance().isModLoaded("witcher_rpg")){
            //Wolf / Ancient Wolf:
            //+5% Sign Intensity
            //+2% Attack Damage
            if(stack.is(WitcherMedallions_Items.Witcher_WolfMedallion) || stack.is(WitcherMedallions_Items.Witcher_AncientWolfMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, SIGN_INTENSITY,"wolf-sign", 0.05);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_ATTACK, "wolf-damage", 0.02);
            }
            //Cat:
            //+4% Adrenaline Gain
            //+2% Attack Speed
            else if(stack.is(WitcherMedallions_Items.Witcher_CatMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, ADRENALINE_GAIN, "cat-adrenaline", 0.04);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_ATTACK_SPEED, "cat-speed", 0.02);
            }
            //Bear
            //+5% Adrenaline Gain
            //+5% Knockback Resistance
            else if(stack.is(WitcherMedallions_Items.Witcher_BearMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, ADRENALINE_GAIN, "bear-adrenaline", 0.05);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, KNOCKBACK_RESISTANCE, "bear-resistance", 0.05);
            }
            //Griffin
            //+10% Sign Intensity
            //+2% Spell Haste
            else if(stack.is(WitcherMedallions_Items.Witcher_GriffinMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, SIGN_INTENSITY, "griffin-power", 0.10);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, SPELL_HASTE, "griffin-haste", 0.02);
            }
            //Viper
            //+2% Movement Speed
            //+5% Attack Speed
            else if(stack.is(WitcherMedallions_Items.Witcher_ViperMedallion)){
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_SPEED, "viper-swiftness", 0.02);
                MiscUtil.addMultiplyAttributeTrinket(modifiers, GENERIC_ATTACK_SPEED, "viper-speed", 0.05);
            }
            //Manticore
            //+10 Max Toxicity/+2% Sign Intensity
            //+5% Adrenaline Gain
            else if(stack.is(WitcherMedallions_Items.Witcher_ManticoreMedallion)){
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
            if(stack.is(WitcherMedallions_Items.Witcher_ManticoreMedallion)){
                MiscUtil.addAdditionAttributeTrinket(modifiers, WITCHER_TOXICITY, "manticore-toxicity", 10);
            }
        }

        return modifiers;
    }
}
