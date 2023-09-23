package witchermedallions.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.client.render.OutlineVertexConsumerProvider;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;

import net.minecraft.entity.Entity;

import witchermedallions.event.KeyInputHandler;

//OutlineColor
@Mixin(WorldRenderer.class)
public class MixinWitcherMonstersWorld {

    @Inject(method = "renderEntity", at = @At("HEAD"))
    private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, CallbackInfo ci) {
        if (KeyInputHandler.outliningMonsters
            && vertexConsumers instanceof OutlineVertexConsumerProvider outlineVertexConsumers) {
            outlineVertexConsumers.setColor(255, 81, 0, 255);

        }
    }
}
