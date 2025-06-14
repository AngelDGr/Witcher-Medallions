package witcher_medallions.utils;

import com.google.common.collect.Multimap;
import net.minecraft.client.Minecraft;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import witcher_medallions.Constants;
import witcher_medallions.WitcherMedallions_Main;

import java.util.List;

@SuppressWarnings("all")
public class MiscUtil {

    public static void addMultiplyAttributeTrinket(Multimap<Holder<Attribute>, AttributeModifier> modifiers,
                                                   ResourceLocation attribute, String id,
                                                   double value){

        if(BuiltInRegistries.ATTRIBUTE.wrapAsHolder(BuiltInRegistries.ATTRIBUTE.get(attribute))!=null)
        {
            modifiers.put(
                    BuiltInRegistries.ATTRIBUTE.wrapAsHolder(
                            BuiltInRegistries.ATTRIBUTE.get(attribute)
                    ),
                    new AttributeModifier(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, id), value,
                            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
        }
    }

    public static void addAdditionAttributeTrinket(Multimap<Holder<Attribute>, AttributeModifier> modifiers,
                                                   ResourceLocation attribute, String id,
                                                   double value){
        if(BuiltInRegistries.ATTRIBUTE.wrapAsHolder(BuiltInRegistries.ATTRIBUTE.get(attribute))!=null)
        {
            modifiers.put(
                    BuiltInRegistries.ATTRIBUTE.wrapAsHolder(
                            BuiltInRegistries.ATTRIBUTE.get(attribute)
                    ),
                    new AttributeModifier(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, id), value,
                            AttributeModifier.Operation.ADD_VALUE));
        }
    }



    /**
    Set the outline to mobs inside a list, usable in mixins
     */
    public static void setOutline(Entity entity, List<String> mobList, int activeDetectionSize, CallbackInfoReturnable<Boolean> ci){
        if (Constants.outliningMonsters) {
            if (
                    (entity.isAlive())
                            //Specifies mobs
                            && (mobList.
                            contains(entity.getType().getDescriptionId())
                            || mobList.contains(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString())
                    )
                            //Distance to the player
                            && Minecraft.getInstance().player!=null && (entity.distanceTo(Minecraft.getInstance().player)) <= activeDetectionSize) {
                ci.setReturnValue(true);
            }
        }
    }
}
