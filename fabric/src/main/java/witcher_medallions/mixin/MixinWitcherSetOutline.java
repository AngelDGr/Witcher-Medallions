package witcher_medallions.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import witcher_medallions.event.KeyInputHandler;
import witcher_medallions.WitcherMedallions_MainFabric;

@Mixin(Minecraft.class)
public class MixinWitcherSetOutline {
    @Inject(method = "shouldEntityAppearGlowing", at = @At("HEAD"), cancellable = true)
    private void outlineEntities(Entity entity, CallbackInfoReturnable<Boolean> ci) {
        if (KeyInputHandler.outliningMonsters) {
            if (
            (entity.isAlive())
            //Specifies mobs
            && (WitcherMedallions_MainFabric.CONFIG.MobList().
                    contains(entity.getType().getDescriptionId())
                    || WitcherMedallions_MainFabric.CONFIG.MobList().contains(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString())
            )
            //Distance to the player
            && Minecraft.getInstance().player!=null && (entity.distanceTo(Minecraft.getInstance().player)) <= WitcherMedallions_MainFabric.CONFIG.activeDetectionSize()) {
                    ci.setReturnValue(true);
            }
        }
    }

}

