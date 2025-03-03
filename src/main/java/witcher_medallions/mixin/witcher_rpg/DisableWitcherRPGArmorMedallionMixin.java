package witcher_medallions.mixin.witcher_rpg;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import mod.azure.azurelibarmor.renderer.GeoArmorRenderer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.Pair;
import net.witcher_rpg.item.armor.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.items.MedallionBaseItem;

import java.util.List;

@Mixin(GeoArmorRenderer.class)
public class DisableWitcherRPGArmorMedallionMixin {
    @Unique
    GeoArmorRenderer<?> THIS = (GeoArmorRenderer<?>)(Object) this;

    @ModifyArg(method = "render",
            at = @At(
    value = "INVOKE",
    target = "Lmod/azure/azurelibarmor/renderer/GeoArmorRenderer;getRenderType(Lnet/minecraft/item/Item;Lnet/minecraft/util/Identifier;Lnet/minecraft/client/render/VertexConsumerProvider;F)Lnet/minecraft/client/render/RenderLayer;"))
    private Identifier changeTexture(Identifier instance){
        if(THIS.getAnimatable() instanceof ModArmorItem armor
                && Registries.ITEM.getId(THIS.getAnimatable()).getNamespace().contains("witcher_rpg")
                && THIS.getCurrentEntity() instanceof PlayerEntity player){
            ItemStack medallionStackInTrinketSlot = ItemStack.EMPTY;
            //Checks if it has any Trinket equipped
            if(TrinketsApi.getTrinketComponent(player).isPresent()){

                //Get all the medallions equipped
                List<Pair<SlotReference, ItemStack>> equippedMedallions =
                        TrinketsApi.getTrinketComponent(player).get().getEquipped(stack -> stack.getItem() instanceof MedallionBaseItem);

                //Get the first medallion equipped if it has any, otherwise it's an empty stack
                medallionStackInTrinketSlot = equippedMedallions.stream().findFirst().isPresent()? equippedMedallions.stream().findFirst().get().getRight(): ItemStack.EMPTY;
            }

            if (!medallionStackInTrinketSlot.isEmpty()) {

                Identifier armorID = Registries.ITEM.getId(player.getInventory().armor.get(2).getItem());

                String textureId;
                switch (armorID.getPath()){
                    case "ursine_chest"-> textureId="ursine";
                    case "superior_ursine_chest"-> textureId="superior_ursine";
                    case "feline_chest"-> textureId="feline";
                    case "superior_feline_chest"-> textureId="superior_feline";
                    case "witcher_chest"-> textureId="witcher";
                    case "superior_witcher_chest"-> textureId="superior_witcher";
                    case "griffin_chest"-> textureId="griffin";
                    case "superior_griffin_chest"-> textureId="superior_griffin";
                    default-> textureId="";
                }

                return Identifier.of(WitcherMedallions_Main.MOD_ID, "textures/witcher_rpg-armor/" + textureId + ".png");
            }
        }

        return instance;
    }
}
