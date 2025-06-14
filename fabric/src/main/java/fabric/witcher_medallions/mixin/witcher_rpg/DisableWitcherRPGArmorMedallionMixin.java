package fabric.witcher_medallions.mixin.witcher_rpg;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import fabric.witcher_medallions.items.MedallionBaseItem_Fabric;
import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorModel;
import mod.azure.azurelibarmor.rewrite.render.armor.AzArmorRendererPipeline;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import witcher_medallions.WitcherMedallions_Main;

import java.util.List;

@Mixin(AzArmorModel.class)
public class DisableWitcherRPGArmorMedallionMixin {

    @Shadow @Final private AzArmorRendererPipeline rendererPipeline;

    @ModifyArg(method = "renderToBuffer", at = @At(value = "INVOKE",
            target = "Lmod/azure/azurelibarmor/rewrite/render/armor/AzArmorRendererPipelineContext;getDefaultRenderType(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/client/renderer/MultiBufferSource;F)Lnet/minecraft/client/renderer/RenderType;")
    ,index = 1)
    private ResourceLocation changeTexture(ResourceLocation texture){
        if(texture.getNamespace().equals("witcher_rpg")
                && this.rendererPipeline.context().currentEntity() instanceof Player player){
            ItemStack medallionStackInTrinketSlot = ItemStack.EMPTY;
            //Checks if it has any Trinket equipped
            if(TrinketsApi.getTrinketComponent(player).isPresent()){
                //Get all the medallions equipped
                List<Tuple<SlotReference, ItemStack>> equippedMedallions =
                        TrinketsApi.getTrinketComponent(player).get().getEquipped(stack -> stack.getItem() instanceof MedallionBaseItem_Fabric);

                //Get the first medallion equipped if it has any, otherwise it's an empty stack
                medallionStackInTrinketSlot = equippedMedallions.stream().findFirst().isPresent()? equippedMedallions.stream().findFirst().get().getB(): ItemStack.EMPTY;
            }

            if (!medallionStackInTrinketSlot.isEmpty()) {

                return ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, texture.getPath());
            }
        }

        return texture;
    }
}
