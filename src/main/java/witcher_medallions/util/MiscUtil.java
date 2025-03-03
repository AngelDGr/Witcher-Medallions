package witcher_medallions.util;

import com.google.common.collect.Multimap;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import witcher_medallions.WitcherMedallions_Main;

import java.util.UUID;

public class MiscUtil {

    public static void addMultiplyAttributeTrinket(Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifiers,
                                                   Identifier attribute, UUID uuid,
                                                   double value){

        if(Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(attribute))!=null)
        {
            modifiers.put(
                    Registries.ATTRIBUTE.getEntry(
                            Registries.ATTRIBUTE.get(attribute)
                    ),
                    new EntityAttributeModifier(uuid, "Medallion modifier", value, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
        }
    }

    public static void addAdditionAttributeTrinket(Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifiers,
                                                   Identifier attribute, UUID uuid,
                                                   double value){
        if(Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(attribute))!=null)
        {
            modifiers.put(
                    Registries.ATTRIBUTE.getEntry(
                            Registries.ATTRIBUTE.get(attribute)
                    ),
                    new EntityAttributeModifier(uuid, "Medallion modifier", value, EntityAttributeModifier.Operation.ADDITION));
        }
    }



}
