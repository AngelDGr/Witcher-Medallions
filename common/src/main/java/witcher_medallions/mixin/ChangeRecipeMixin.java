package witcher_medallions.mixin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.Tuple;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.item.crafting.RecipeManager;
import witcher_medallions.WitcherMedallions_Main;

@Mixin(RecipeManager.class)
public class ChangeRecipeMixin {
    @SuppressWarnings("all")
    @Inject(method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V", at = @At("HEAD"))
    public void interceptApply(Map<ResourceLocation, JsonElement> map, ResourceManager resourceManager, ProfilerFiller profiler, CallbackInfo ci) {
        for(Tuple<ResourceLocation, JsonObject> recipePair: WitcherMedallions_Main.recipes){
            if(recipePair.getB()!=null && recipePair.getA()!=null){
             map.put(recipePair.getA(), recipePair.getB());
            }
        }
    }
}
