package fabric.witcher_medallions;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.vertex.PoseStack;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import fabric.witcher_medallions.items.ActivatedMedallionBaseItem;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import org.lwjgl.glfw.GLFW;
import witcher_medallions.Constants;
import witcher_medallions.registry.WitcherMedallions_Items;
import witcher_medallions.registry.WitcherMedallions_Sounds;


@Environment(EnvType.CLIENT)
public class WitcherMedallions_ClientFabric implements ClientModInitializer {

    public static void registerClient() {
//        WitcherMedallions_Main.LOGGER.info("Registering Client for " + WitcherMedallions_Main.MOD_ID);
    }

    @Override
    public void onInitializeClient() {
        //Registers con Client
        KeyInputHandler.register();
        registerClient();

        //Medallions
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_WolfMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_CatMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_BearMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_GriffinMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_ViperMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_ManticoreMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_AncientWolfMedallion());

        //Medallions off
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffWolfMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffCatMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffBearMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffGriffinMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffViperMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffManticoreMedallion());
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffAncientWolfMedallion());
    }

    @SuppressWarnings("unchecked")
    public static void RegisterTrinketRender(Item medallion){
        TrinketRendererRegistry.registerRenderer(medallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta,
                 animationProgress, headYaw, headPitch) -> {

                    if (entity instanceof AbstractClientPlayer player) {
                        TrinketRenderer.translateToChest(matrices, (PlayerModel<AbstractClientPlayer>) contextModel, player);


                        moveMedallionWhenArmor(player, matrices, "warriors_leather_jacket", 0.04f, 0.035f);
                        moveMedallionWhenArmor(player, matrices, "ravens_armor", 0.025f, 0.025f);
                        moveMedallionWhenArmor(player, matrices, "manticore_armor", 0.05f, 0.025f);

                        moveMedallionWhenArmorWitcherRPG(player, matrices, 0.05f, 0.035f);

                        Minecraft.getInstance().getItemRenderer()
                                .renderStatic(stack, ItemDisplayContext.HEAD, light, OverlayTexture.NO_OVERLAY,
                                        matrices, vertexConsumers,null, 0);
                    }
                });
    }

    private static void moveMedallionWhenArmor(Player player, PoseStack matrices, String armorID, float ZValue, float YValue) {
        if (BuiltInRegistries.ITEM.getKey(player.getItemBySlot(EquipmentSlot.CHEST).getItem())
                .equals(ResourceLocation.fromNamespaceAndPath("tcots_witcher", armorID))) {
            matrices.translate(0F, -YValue, -ZValue);
        } else {
            matrices.translate(0F, 0F, 0F);
        }
    }

    @SuppressWarnings("all")
    private static void moveMedallionWhenArmorWitcherRPG(Player player, PoseStack matrices, float ZValue, float YValue){
        if(BuiltInRegistries.ITEM.getKey(player.getItemBySlot(EquipmentSlot.CHEST).getItem()).getNamespace()
                .equals("witcher_rpg")){
            matrices.translate(0F, -YValue, -ZValue);
        } else {
            matrices.translate(0F, 0F, 0F);
        }
    }

    @Environment(EnvType.CLIENT)
    public static class KeyInputHandler {

        public static KeyMapping medallion_key;
        private static boolean cooldown = false;
        private static int ticks = 0;

        public static void registerKeyInputs(){
            ClientTickEvents.END_CLIENT_TICK.register(client -> {
                while(medallion_key.consumeClick()) {
                    //DetectMedallion
                    if (!cooldown) {
                        if (Minecraft.getInstance().player!=null && hasMedallionEquipped(client.player)) {
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
            });
        }

        public static void register(){
            medallion_key = KeyBindingHelper.registerKeyBinding(
                    new KeyMapping(
                            Constants.KEY_ACTIVE_MEDALLION,
                            InputConstants.Type.KEYSYM,
                            GLFW.GLFW_KEY_T,
                            Constants.KEY_CATEGORY_MEDALLIONS
                    ));
            registerKeyInputs();
        }

        //DetectsMedallions
        @SuppressWarnings("OptionalGetWithoutIsPresent")
        public static TrinketComponent getTrinkets(LivingEntity entity) {
            return TrinketsApi.getTrinketComponent(entity).get();
        }

        public static boolean hasMedallionEquipped(LivingEntity entity) {
            return getTrinkets(entity).isEquipped(stack-> stack.getItem() instanceof ActivatedMedallionBaseItem);
        }

    }


}