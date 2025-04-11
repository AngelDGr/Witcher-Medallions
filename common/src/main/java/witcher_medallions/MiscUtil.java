package witcher_medallions;

import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;

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
                    new AttributeModifier(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, id), value,
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
                    new AttributeModifier(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, id), value,
                            AttributeModifier.Operation.ADD_VALUE));
        }
    }



}
