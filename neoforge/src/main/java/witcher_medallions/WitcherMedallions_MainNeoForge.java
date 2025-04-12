package witcher_medallions;

import com.google.gson.JsonObject;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforgespi.Environment;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.theillusivec4.curios.api.client.ICurioRenderer;
import witcher_medallions.items.WitcherMedallions_ItemsCommon;
import witcher_medallions.items.WitcherMedallions_ItemsNeoForge;

import java.util.function.Supplier;

@Mod(value = WitcherMedallions_MainCommon.MOD_ID)
public class WitcherMedallions_MainNeoForge {

    public static final witcher_medallions.WitcherMedallionsConfig CONFIG = witcher_medallions.WitcherMedallionsConfig.createAndLoad();

    public static DeferredHolder<SoundEvent, SoundEvent> MEDALLION_ACTIVATE_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> MEDALLION_RESTART_COOLDOWN_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> WOLF_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> CAT_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> BEAR_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> GRIFFIN_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> VIPER_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> MANTICORE_MEDALLION_SOUND;

    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_WOLF_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_CAT_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_BEAR_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_GRIFFIN_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_VIPER_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_MANTICORE_MEDALLION_SOUND;

    public WitcherMedallions_MainNeoForge(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.
        WitcherMedallions_MainCommon.init();
        WitcherMedallions_ItemsNeoForge.registerItems();


        WitcherMedallions_MainCommon.WOLF_MEDALLION_OFF_RPG = create(Items.BONE, "wolf-medallion-off");
        WitcherMedallions_MainCommon.CAT_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.CAT_MEDALLION_INGREDIENT, "cat-medallion-off");
        WitcherMedallions_MainCommon.BEAR_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.BEAR_MEDALLION_INGREDIENT, "bear-medallion-off");
        WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_OFF_RPG = create(Items.FEATHER, "griffin-medallion-off");
        WitcherMedallions_MainCommon.VIPER_MEDALLION_OFF_RPG = create(Items.FERMENTED_SPIDER_EYE, "viper-medallion-off");
        WitcherMedallions_MainCommon.MANTICORE_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.MANTICORE_MEDALLION_INGREDIENT, "manticore-medallion-off");
        WitcherMedallions_MainCommon.ANCIENT_WOLF_MEDALLION_OFF_RPG = create(Items.PAPER, "ancient-wolf-medallion-off");

        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "wolf-medallion-off"), WitcherMedallions_MainCommon.WOLF_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "cat-medallion-off"), WitcherMedallions_MainCommon.CAT_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "bear-medallion-off"), WitcherMedallions_MainCommon.BEAR_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "griffin-medallion-off"), WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "viper-medallion-off"), WitcherMedallions_MainCommon.VIPER_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "manticore-medallion-off"), WitcherMedallions_MainCommon.MANTICORE_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "ancient-wolf-medallion-off"), WitcherMedallions_MainCommon.ANCIENT_WOLF_MEDALLION_OFF_RPG));

        MEDALLION_ACTIVATE_SOUND= registerSound("medallion_activate_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion_activate_sound")));
        MEDALLION_RESTART_COOLDOWN_SOUND = registerSound("medallion_restartcooldown_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion_restartcooldown_sound")));

        WOLF_MEDALLION_SOUND = registerSound("medallion-wolf_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-wolf_sound")));
        CAT_MEDALLION_SOUND = registerSound("medallion-cat_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-cat_sound")));
        BEAR_MEDALLION_SOUND = registerSound("medallion-bear_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-bear_sound")));
        GRIFFIN_MEDALLION_SOUND = registerSound("medallion-griffin_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-griffin_sound")));
        VIPER_MEDALLION_SOUND = registerSound("medallion-viper_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-viper_sound")));
        MANTICORE_MEDALLION_SOUND = registerSound("medallion-manticore_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-manticore_sound")));

        STRONG_WOLF_MEDALLION_SOUND = registerSound("medallion-wolf-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-wolf-strong_sound")));
        STRONG_CAT_MEDALLION_SOUND = registerSound("medallion-cat-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-cat-strong_sound")));
        STRONG_BEAR_MEDALLION_SOUND = registerSound("medallion-bear-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-bear-strong_sound")));
        STRONG_GRIFFIN_MEDALLION_SOUND = registerSound("medallion-griffin-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-griffin-strong_sound")));
        STRONG_VIPER_MEDALLION_SOUND = registerSound("medallion-viper-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-viper-strong_sound")));
        STRONG_MANTICORE_MEDALLION_SOUND = registerSound("medallion-manticore-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "medallion-manticore-strong_sound")));

        WitcherMedallions_Registries.ITEMS.register(eventBus);
        WitcherMedallions_Registries.CREATIVE_MODE_TABS.register(eventBus);
        WitcherMedallions_Registries.SOUND_EVENTS.register(eventBus);
        if(Environment.get().getDist().isClient()) NeoForge.EVENT_BUS.register(new WitcherMedallions_ClientNeoForge.KeyInputHandler());
        eventBus.addListener(this::clientSetup);
    }

    /**
     * Register a sound
     * @param name The item id
     * @param sup The supplier
     * @return An DeferredHolder of Item
     */
    public static DeferredHolder<SoundEvent, SoundEvent> registerSound(String name, Supplier<SoundEvent> sup) {
        return WitcherMedallions_Registries.SOUND_EVENTS.register(name, sup);
    }

    private JsonObject create(TagKey<Item> addition, String medallion){
        return WitcherMedallions_MainCommon.create(addition.location().toString(), WitcherMedallions_MainCommon.MOD_ID+":"+medallion, BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), true);
    }

    private JsonObject create(Item addition, String medallion){
        return WitcherMedallions_MainCommon.create(BuiltInRegistries.ITEM.getKey(addition).toString(), WitcherMedallions_MainCommon.MOD_ID+":"+medallion, BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), false);
    }

    private void  clientSetup(final FMLClientSetupEvent evt) {
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_WolfMedallion.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffWolfMedallion.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_CatMedallion.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffCatMedallion.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_BearMedallion.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffBearMedallion.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_GriffinMedallion.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffGriffinMedallion.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_ViperMedallion.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffViperMedallion.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_ManticoreMedallion.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffManticoreMedallion.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_AncientWolfMedallion.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffAncientWolfMedallion.get(),
                ICurioRendererMedallion::new);
    }

    public static class ICurioRendererMedallion implements ICurioRenderer {
        @Override
        public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack,
                                                                              SlotContext slotReference,
                                                                              PoseStack matrices,
                                                                              RenderLayerParent<T, M> parent,
                                                                              MultiBufferSource vertexConsumers,
                                                                              int light,
                                                                              float limbSwing,
                                                                              float limbSwingAmount,
                                                                              float partialTicks,
                                                                              float ageInTicks,
                                                                              float headYaw,
                                                                              float headPitch) {
            if (slotReference.entity() instanceof LivingEntity player && parent.getModel() instanceof HumanoidModel<?> model) {
                matrices.pushPose();

                translateToChest(matrices, (PlayerModel<?>) parent.getModel());

                moveMedallionWhenArmor(player, matrices, "warriors_leather_jacket", 0.04f, 0.035f);
                moveMedallionWhenArmor(player, matrices, "ravens_armor", 0.025f, 0.025f);
                moveMedallionWhenArmor(player, matrices, "manticore_armor", 0.05f, 0.025f);
                //            moveMedallionWhenArmorWitcherRPG(player, matrices, 0.05f, 0.035f);


                Minecraft.getInstance().getItemRenderer()
                        .renderStatic(stack, ItemDisplayContext.HEAD, light, OverlayTexture.NO_OVERLAY,
                                matrices, vertexConsumers,null, 0);

                matrices.popPose();
            }
        }

        static void translateToChest(PoseStack matrices, HumanoidModel<?> model) {
            if (model.crouching && !model.riding && model.swimAmount == 0.0F) {
                matrices.translate(0.0F, 0.2F, 0.0F);
                matrices.mulPose(Axis.XP.rotation(model.body.xRot));
            }
            matrices.mulPose(Axis.YP.rotation(model.body.yRot));
            matrices.translate(0.0F, 0.4F, -0.16F);
        }

        private static void moveMedallionWhenArmor(LivingEntity player, PoseStack matrices, String armorID, float ZValue, float YValue) {
            moveMedallionWhenArmor(player, matrices, "tcots_witcher", armorID, ZValue, YValue );
        }

        @SuppressWarnings("all")
        private static void moveMedallionWhenArmor(LivingEntity player, PoseStack matrices, String modID, String armorID, float ZValue, float YValue) {
            if (BuiltInRegistries.ITEM.getKey(player.getItemBySlot(EquipmentSlot.CHEST).getItem())
                    .equals(ResourceLocation.fromNamespaceAndPath(modID, armorID))) {
                matrices.translate(0F, -YValue, -ZValue);
            } else {
                matrices.translate(0F, 0F, 0F);
            }
        }
    }

}