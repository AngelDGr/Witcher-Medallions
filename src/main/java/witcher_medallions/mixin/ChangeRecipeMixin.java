package witcher_medallions.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.minecraft.util.profiler.Profiler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import witcher_medallions.WitcherMedallions_Main;

import java.util.Map;

@Mixin(RecipeManager.class)
public class ChangeRecipeMixin {
    @Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/resource/ResourceManager;Lnet/minecraft/util/profiler/Profiler;)V", at = @At("HEAD"))
    public void interceptApply(Map<Identifier, JsonElement> map, ResourceManager resourceManager, Profiler profiler, CallbackInfo ci) {
        for(Pair<Identifier, JsonObject> recipePair: WitcherMedallions_Main.recipes){
            if(recipePair.getRight()!=null){
                map.put(recipePair.getLeft(), recipePair.getRight());
            }
        }
    }
}
