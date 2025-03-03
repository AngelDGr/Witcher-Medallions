package witcher_medallions;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import witcher_medallions.event.KeyInputHandler;
import witcher_medallions.items.WitcherMedallions_Items;


@Environment(EnvType.CLIENT)
public class WitcherMedallions_Client implements ClientModInitializer {

    public static void registerClient() {
        WitcherMedallions_Main.LOGGER.info("Registering Client for " + WitcherMedallions_Main.MOD_ID);
    }

    @Override
	public void onInitializeClient() {
        //Registers con Client
        KeyInputHandler.register();
        registerClient();

        //Medallions
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_WolfMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_CatMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_BearMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_GriffinMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_ViperMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_ManticoreMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_AncientWolfMedallion);

        //Medallions off
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffWolfMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffCatMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffBearMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffGriffinMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffViperMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffManticoreMedallion);
        WitcherMedallions_Client.RegisterTrinketRender(WitcherMedallions_Items.Witcher_OffAncientWolfMedallion);
	}

    @SuppressWarnings("unused")
    public static void medallionTrinketRender(MatrixStack matrices, EntityModel<? extends LivingEntity> model, LivingEntity entity, float headYaw, float headPitch) {
    }

    private static void moveMedallionWhenArmor(PlayerEntity player, MatrixStack matrices, String armorID, float ZValue, float YValue){
        if(Registries.ITEM.getId(player.getEquippedStack(EquipmentSlot.CHEST).getItem())
                .equals(Identifier.of("tcots-witcher", armorID))){
            matrices.translate(0F, -YValue, -ZValue);
        } else {
            matrices.translate(0F, 0F, 0F);
        }
    }

    private static void moveMedallionWhenArmorWitcher(PlayerEntity player, MatrixStack matrices, float ZValue, float YValue){
        if(Registries.ITEM.getId(player.getEquippedStack(EquipmentSlot.CHEST).getItem()).getNamespace()
                .equals("witcher_rpg")){
            matrices.translate(0F, -YValue, -ZValue);
        } else {
            matrices.translate(0F, 0F, 0F);
        }
    }



    @SuppressWarnings("unchecked")
    public static void RegisterTrinketRender(Item medallion){
        TrinketRendererRegistry.registerRenderer(medallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta,
                 animationProgress, headYaw, headPitch) -> {

                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);


                        moveMedallionWhenArmor(player, matrices, "warriors_leather_jacket", 0.04f, 0.035f);
                        moveMedallionWhenArmor(player, matrices, "ravens_armor", 0.025f, 0.025f);
                        moveMedallionWhenArmor(player, matrices, "manticore_armor", 0.05f, 0.025f);

                        moveMedallionWhenArmorWitcher(player, matrices, 0.05f, 0.035f);

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformationMode.HEAD, light, OverlayTexture.DEFAULT_UV,
                                        matrices, vertexConsumers,null, 0);
                    }
                });
    }

}