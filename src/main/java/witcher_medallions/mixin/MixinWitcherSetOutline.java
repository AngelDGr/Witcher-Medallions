package witcher_medallions.mixin;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OutlineVertexConsumerProvider;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import witcher_medallions.event.KeyInputHandler;

import net.minecraft.client.MinecraftClient;
import witcher_medallions.WitcherMedallions_Main;


@Environment(EnvType.CLIENT)
@Mixin(MinecraftClient.class)
public class MixinWitcherSetOutline {

    @Inject(method = "hasOutline", at = @At("HEAD"), cancellable = true)
    private void outlineEntities(Entity entity, CallbackInfoReturnable<Boolean> ci) {
        if (KeyInputHandler.outliningMonsters) {
            if (
            (entity.isAlive())

            //Specifies mobs
            && (WitcherMedallions_Main.CONFIG.MobList().
                    contains(entity.getType().getTranslationKey())
                    || WitcherMedallions_Main.CONFIG.MobList().contains(Registries.ENTITY_TYPE.getId(entity.getType()).toString())
            )
            //Distance to the player
            && (entity.distanceTo(MinecraftClient.getInstance().player)) <= WitcherMedallions_Main.CONFIG.activeDetectionSize()) {
                    ci.setReturnValue(true);
                } 
        }
    }

    //Color
    @Environment(EnvType.CLIENT)
    @SuppressWarnings("unused")
    @Mixin(WorldRenderer.class)
    private static class MixinWitcherSetOutlineColor {
        @Inject(method = "renderEntity", at = @At("HEAD"))
        private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo ci) {
            if (KeyInputHandler.outliningMonsters
                    && vertexConsumers instanceof OutlineVertexConsumerProvider outlineVertexConsumers) {
                outlineVertexConsumers.setColor(255, 81, 0, 255);
            }
        }
    }

}

