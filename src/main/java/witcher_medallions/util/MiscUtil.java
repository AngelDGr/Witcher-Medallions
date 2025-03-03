package witcher_medallions.util;

import com.google.common.collect.Multimap;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.registry.entry.RegistryEntry;
import java.util.UUID;

public class MiscUtil {

    public static void addMultiplyAttributeTrinket(Multimap<EntityAttribute,EntityAttributeModifier> modifiers,
                                                   RegistryEntry<EntityAttribute> attribute, UUID uuid,
                                                   double value){
        if(attribute!=null)
        {
            modifiers
                    .put(
                    attribute.value(),
                    new EntityAttributeModifier(uuid, "Medallion modifier", value, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }
    }

    public static void addAdditionAttributeTrinket(Multimap<EntityAttribute,EntityAttributeModifier> modifiers,
                                                   RegistryEntry<EntityAttribute> attribute, UUID uuid,
                                                   double value){
        if(attribute!=null)
        {
            modifiers
                    .put(
                    attribute.value(),
                    new EntityAttributeModifier(uuid, "Medallion modifier", value, EntityAttributeModifier.Operation.ADDITION));
        }
    }



}
