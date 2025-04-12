package witcher_medallions.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import witcher_medallions.MiscUtil_Common;
import witcher_medallions.WitcherMedallions_MainNeoForge;

@Mixin(Minecraft.class)
public class MixinWitcherSetOutline {
    @Inject(method = "shouldEntityAppearGlowing", at = @At("HEAD"), cancellable = true)
    private void outlineEntities(Entity entity, CallbackInfoReturnable<Boolean> ci) {
        MiscUtil_Common.setOutline(entity, WitcherMedallions_MainNeoForge.CONFIG.MobList(), WitcherMedallions_MainNeoForge.CONFIG.activeDetectionSize(), ci);
    }
}

