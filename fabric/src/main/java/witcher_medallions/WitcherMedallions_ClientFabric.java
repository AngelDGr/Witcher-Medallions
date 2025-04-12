package witcher_medallions;

import com.mojang.blaze3d.vertex.PoseStack;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import witcher_medallions.event.KeyInputHandler;
import witcher_medallions.items.WitcherMedallions_ItemsFabric;


@Environment(EnvType.CLIENT)
public class WitcherMedallions_ClientFabric implements ClientModInitializer {

    public static void registerClient() {
        WitcherMedallions_MainCommon.LOGGER.info("Registering Client for " + WitcherMedallions_MainCommon.MOD_ID);
    }

    @Override
    public void onInitializeClient() {
        //Registers con Client
        KeyInputHandler.register();
        registerClient();

        //Medallions
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_WolfMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_CatMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_BearMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_GriffinMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_ViperMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_ManticoreMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_AncientWolfMedallion);

        //Medallions off
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_OffWolfMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_OffCatMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_OffBearMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_OffGriffinMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_OffViperMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_OffManticoreMedallion);
        WitcherMedallions_ClientFabric.RegisterTrinketRender(WitcherMedallions_ItemsFabric.Witcher_OffAncientWolfMedallion);
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
                .equals(ResourceLocation.fromNamespaceAndPath("tcots-witcher", armorID))) {
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

}