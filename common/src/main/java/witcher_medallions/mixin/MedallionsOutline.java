package witcher_medallions.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.OutlineBufferSource;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import witcher_medallions.Constants;
import witcher_medallions.utils.MiscUtil;
import witcher_medallions.WitcherMedallions_Main;

public class MedallionsOutline {
    @Mixin(LevelRenderer.class)
    public static class MixinWitcherSetOutlineColor {
        @Inject(method = "renderEntity", at = @At("HEAD"))
        private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, CallbackInfo ci) {
            if (Constants.outliningMonsters && vertexConsumers instanceof OutlineBufferSource outlineVertexConsumers) {
                outlineVertexConsumers.setColor(255, 81, 0, 255);
            }
        }
    }

    @Mixin(Minecraft.class)
    public static class MixinWitcherSetOutline {
        @Inject(method = "shouldEntityAppearGlowing", at = @At("HEAD"), cancellable = true)
        private void outlineEntities(Entity entity, CallbackInfoReturnable<Boolean> ci) {
            MiscUtil.setOutline(entity, WitcherMedallions_Main.CONFIG.MobList(), WitcherMedallions_Main.CONFIG.activeDetectionSize(), ci);
        }
    }
}



