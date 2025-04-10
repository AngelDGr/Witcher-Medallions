package witcher_medallions.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.OutlineBufferSource;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import witcher_medallions.event.KeyInputHandler;
import witcher_medallions.WitcherMedallions_Main;

@Environment(EnvType.CLIENT)
@Mixin(Minecraft.class)
public class MixinWitcherSetOutline {

    @Inject(method = "shouldEntityAppearGlowing", at = @At("HEAD"), cancellable = true)
    private void outlineEntities(Entity entity, CallbackInfoReturnable<Boolean> ci) {
        if (KeyInputHandler.outliningMonsters) {
            if (
            (entity.isAlive())
            //Specifies mobs
            && (WitcherMedallions_Main.CONFIG.MobList().
                    contains(entity.getType().getDescriptionId())
                    || WitcherMedallions_Main.CONFIG.MobList().contains(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString())
            )
            //Distance to the player
            && Minecraft.getInstance().player!=null && (entity.distanceTo(Minecraft.getInstance().player)) <= WitcherMedallions_Main.CONFIG.activeDetectionSize()) {
                    ci.setReturnValue(true);
            }
        }
    }

    //Color
    @Environment(EnvType.CLIENT)
    @SuppressWarnings("unused")
    @Mixin(LevelRenderer.class)
    private static class MixinWitcherSetOutlineColor {
        @Inject(method = "renderEntity", at = @At("HEAD"))
        private void renderEntity(Entity entity, double cameraX, double cameraY, double cameraZ, float tickDelta, PoseStack matrices, MultiBufferSource vertexConsumers, CallbackInfo ci) {
            if (KeyInputHandler.outliningMonsters
                    && vertexConsumers instanceof OutlineBufferSource outlineVertexConsumers) {
                outlineVertexConsumers.setColor(255, 81, 0, 255);
            }
        }
    }

}

