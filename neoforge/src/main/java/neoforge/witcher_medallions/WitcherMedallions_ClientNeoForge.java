package neoforge.witcher_medallions;

import com.mojang.blaze3d.platform.InputConstants;
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
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.jarjar.nio.util.Lazy;
import net.minecraft.client.KeyMapping;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import top.theillusivec4.curios.api.client.ICurioRenderer;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import neoforge.witcher_medallions.items.ActivatedMedallionBaseItem;
import witcher_medallions.Constants;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.registry.WitcherMedallions_Items;
import witcher_medallions.registry.WitcherMedallions_Sounds;

@EventBusSubscriber(modid = WitcherMedallions_Main.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
@Mod(value = WitcherMedallions_Main.MOD_ID, dist = Dist.CLIENT)
public class WitcherMedallions_ClientNeoForge {

    public WitcherMedallions_ClientNeoForge(IEventBus modEventBus){

        NeoForge.EVENT_BUS.register(
                new WitcherMedallions_ClientNeoForge.KeyInputHandler()
        );
    }

    @SubscribeEvent
    public static void registerClientEvent(FMLClientSetupEvent event){
        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_WolfMedallion(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_OffWolfMedallion(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_CatMedallion(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_OffCatMedallion(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_BearMedallion(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_OffBearMedallion(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_GriffinMedallion(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_OffGriffinMedallion(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_ViperMedallion(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_OffViperMedallion(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_ManticoreMedallion(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_OffManticoreMedallion(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_AncientWolfMedallion(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_Items.Witcher_OffAncientWolfMedallion(),
                ICurioRendererMedallion::new);
    }

    @EventBusSubscriber(modid = WitcherMedallions_Main.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class KeyMappingClass {

        // Key mapping is lazily initialized so it doesn't exist until it is registered
        public static final Lazy<KeyMapping> MEDALLION_MAPPING = Lazy.of(() ->
                new KeyMapping(
                        Constants.KEY_ACTIVE_MEDALLION,
                        KeyConflictContext.IN_GAME,
                        InputConstants.Type.KEYSYM,
                        GLFW.GLFW_KEY_T,
                        Constants.KEY_CATEGORY_MEDALLIONS
                )
        );

        // Event is on the mod event bus only on the physical client
        @SubscribeEvent
        public static void registerBindings(@NotNull RegisterKeyMappingsEvent event) {
            event.register(MEDALLION_MAPPING.get());
        }
    }

    @Mod(value = WitcherMedallions_Main.MOD_ID, dist = Dist.CLIENT)
    public static class KeyInputHandler{
        private static boolean cooldown = false;
        private static int ticks = 0;

        @SubscribeEvent
        // Event is on the NeoForge event bus only on the physical client
        public void onClientTick(ClientTickEvent.Post event) {
            while (KeyMappingClass.MEDALLION_MAPPING.get().consumeClick()) {
                if (!cooldown) {
                    if(Minecraft.getInstance().player!=null && hasMedallionEquipped(Minecraft.getInstance().player)){
                        Constants.outliningMonsters = true;
                        ticks = 200;
                        cooldown = true;
                        Minecraft.getInstance().player.playSound(WitcherMedallions_Sounds.MedallionActivatedSound(), 1, 1);
                    }
                }
            }

            if (cooldown) {
                --ticks;
                //Time that the effect shows up
                if (ticks == 100) {
                    Constants.outliningMonsters= false;
                }
                //Time cooldown last
                if (ticks==0) {
                    if(Minecraft.getInstance().player!=null){
                        Minecraft.getInstance().player.playNotifySound(WitcherMedallions_Sounds.MedallionRestartCooldownSound(), SoundSource.PLAYERS, 1, 1);
                    }
                    cooldown=false;
                }
            }
        }


        //DetectsMedallions
        @SuppressWarnings("OptionalGetWithoutIsPresent")
        public static ICuriosItemHandler getCurios(LivingEntity entity) {
            return CuriosApi.getCuriosInventory(entity).get();
        }

        public static boolean hasMedallionEquipped(LivingEntity entity) {
            return getCurios(entity).isEquipped(stack-> stack.getItem() instanceof ActivatedMedallionBaseItem);
        }
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
