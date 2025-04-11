package witcher_medallions.mixin.witcher_rpg;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import mod.azure.azurelibarmor.common.api.client.renderer.GeoArmorRenderer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.spell_engine.api.item.armor.Armor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import witcher_medallions.WitcherMedallions_MainCommon;
import witcher_medallions.items.MedallionBaseItem_Fabric;

import java.util.List;

@Mixin(GeoArmorRenderer.class)
public class DisableWitcherRPGArmorMedallionMixin {
    @Unique
    GeoArmorRenderer<?> THIS = (GeoArmorRenderer<?>)(Object) this;

    @ModifyArg(method = "renderToBuffer",
            at = @At(
    value = "INVOKE",
    target = "Lmod/azure/azurelibarmor/common/api/client/renderer/GeoArmorRenderer;getRenderType(Lnet/minecraft/world/item/Item;Lnet/minecraft/resources/ResourceLocation;Lnet/minecraft/client/renderer/MultiBufferSource;F)Lnet/minecraft/client/renderer/RenderType;"))
    private ResourceLocation changeTexture(ResourceLocation instance){
        if(THIS.getAnimatable() instanceof Armor.CustomItem armor
                && BuiltInRegistries.ITEM.getKey(THIS.getAnimatable()).getNamespace().contains("witcher_rpg")
                && THIS.getCurrentEntity() instanceof Player player){
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

                ResourceLocation textureId = armor.getFirstLayerId();
                return ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "textures/witcher_rpg-armor/" + textureId.getPath() + ".png");
            }
        }

        return instance;
    }
}
