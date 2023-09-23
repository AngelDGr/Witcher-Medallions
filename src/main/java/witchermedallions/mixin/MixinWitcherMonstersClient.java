package witchermedallions.mixin;

import net.minecraft.entity.Entity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import witchermedallions.event.KeyInputHandler;

import net.minecraft.client.MinecraftClient;
import witchermedallions.witcherMod;


@Mixin(MinecraftClient.class)
public class MixinWitcherMonstersClient {

    @Inject(method = "hasOutline", at = @At("HEAD"), cancellable = true)
    private void outlineEntities(Entity entity, CallbackInfoReturnable<Boolean> ci) {
        if (KeyInputHandler.outliningMonsters ) {   
            if (
            //Condition
            (entity.isAlive())

            //Specifies mobs
            && witcherMod.CONFIG.MobList().
                    contains(entity.getType().getTranslationKey())
            //Distance to the player
            && (entity.distanceTo(MinecraftClient.getInstance().player)) <= witcherMod.CONFIG.activeDetectionSize()
            
            ) {
                    ci.setReturnValue(true);
                } 
            }
    }

}

