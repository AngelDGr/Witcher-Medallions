package witchermedallions;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import software.bernie.geckolib3.renderers.geo.GeoItemRenderer;
import witchermedallions.event.KeyInputHandler;
import witchermedallions.event.PlayMedallionSound;
import witchermedallions.items.ModItems;
import witchermedallions.items.gecko.renderer.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.MinecraftClient;
import witchermedallions.items.gecko.renderer.heads.*;
import witchermedallions.items.gecko.renderer.off.*;


public class witcherMod_client implements ClientModInitializer {


    public static void registerClient() {
        witcherMod.LOGGER.info("Registering Client for " + witcherMod.MODID);
    }

    @SuppressWarnings({"unchecked" })
	@Override
	public void onInitializeClient() {
                
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		
		//WolfMedallion
		     GeoItemRenderer.registerItemRenderer(ModItems.Witcher_WolfMedallion, new WolfMedallionRenderer());

		    TrinketRendererRegistry.registerRenderer(ModItems.Witcher_WolfMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);
						
                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

                //CatMedallion
		GeoItemRenderer.registerItemRenderer(ModItems.Witcher_CatMedallion, new CatMedallionRenderer());

		    TrinketRendererRegistry.registerRenderer(ModItems.Witcher_CatMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);
						
                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

                //BearMedallion
                GeoItemRenderer.registerItemRenderer(ModItems.Witcher_BearMedallion, new BearMedallionRenderer());

		    TrinketRendererRegistry.registerRenderer(ModItems.Witcher_BearMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);
						
                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

                //GriffinMedallion
                GeoItemRenderer.registerItemRenderer(ModItems.Witcher_GriffinMedallion, new GriffinMedallionRenderer());

		    TrinketRendererRegistry.registerRenderer(ModItems.Witcher_GriffinMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);
						
                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

                //ViperMedallion
                GeoItemRenderer.registerItemRenderer(ModItems.Witcher_ViperMedallion, new ViperMedallionRenderer());

		    TrinketRendererRegistry.registerRenderer(ModItems.Witcher_ViperMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);
						
                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });


                //ManticoreMedallion
                GeoItemRenderer.registerItemRenderer(ModItems.Witcher_ManticoreMedallion, new ManticoreMedallionRenderer());

		    TrinketRendererRegistry.registerRenderer(ModItems.Witcher_ManticoreMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);
						
                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });
                

                //AncientWolfMedallion
		     GeoItemRenderer.registerItemRenderer(ModItems.Witcher_AncientWolfMedallion, new AncientWolfMedallionRenderer());

		    TrinketRendererRegistry.registerRenderer(ModItems.Witcher_AncientWolfMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);
						
                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });
        //MedallionHeads
            //WolfHead
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_WolfHead, new WolfHeadRenderer());
            //CatHead
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_CatHead, new CatHeadRenderer());
            //BearHead
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_BearHead, new BearHeadRenderer());
            //GriffinHead
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_GriffinHead, new GriffinHeadRenderer());
            //ViperHead
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_ViperHead, new ViperHeadRenderer());
            //ManticoreHead
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_ManticoreHead, new ManticoreHeadRenderer());
            //AncientWolfCoin
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_AncientWolfHead, new AncientWolfHeadRenderer());

        //OffMedallions
            //WolfMedallionOff
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_OffWolfMedallion, new WolfMedallionOffRenderer());

            TrinketRendererRegistry.registerRenderer(ModItems.Witcher_OffWolfMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

            //CatMedallionOff
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_OffCatMedallion, new CatMedallionOffRenderer());

            TrinketRendererRegistry.registerRenderer(ModItems.Witcher_OffCatMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

            //BearMedallionOff
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_OffBearMedallion, new BearMedallionOffRenderer());

            TrinketRendererRegistry.registerRenderer(ModItems.Witcher_OffBearMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

            //GriffinMedallionOff
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_OffGriffinMedallion, new GriffinMedallionOffRenderer());

            TrinketRendererRegistry.registerRenderer(ModItems.Witcher_OffGriffinMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

            //ViperMedallionOff
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_OffViperMedallion, new ViperMedallionOffRenderer());

            TrinketRendererRegistry.registerRenderer(ModItems.Witcher_OffViperMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

            //ManticoreMedallionOff
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_OffManticoreMedallion, new ManticoreMedallionOffRenderer());

            TrinketRendererRegistry.registerRenderer(ModItems.Witcher_OffManticoreMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

             //AncientWolfMedallionOff
            GeoItemRenderer.registerItemRenderer(ModItems.Witcher_OffAncientWolfMedallion, new AncientWolfMedallionOffRenderer());

            TrinketRendererRegistry.registerRenderer(ModItems.Witcher_OffAncientWolfMedallion,
                (stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch) -> {
                    if (entity instanceof AbstractClientPlayerEntity player) {
                        TrinketRenderer.translateToChest(matrices,
                                (PlayerEntityModel<AbstractClientPlayerEntity>) contextModel, player);
                        matrices.scale(1.0F, 1.0F, 1.0F);
                        matrices.translate(0F, 0F, 0F);

                        MinecraftClient.getInstance().getItemRenderer()
                                .renderItem(stack, ModelTransformation.Mode.HEAD, light, OverlayTexture.DEFAULT_UV, matrices,
                                        vertexConsumers, 0);
                    }
                });

            //Registers con Client
                KeyInputHandler.register();
                registerClient();
                PlayMedallionSound.registerSounds();
	}



}