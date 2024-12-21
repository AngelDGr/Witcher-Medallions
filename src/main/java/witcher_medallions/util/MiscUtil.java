package witcher_medallions.util;

import com.google.common.collect.Multimap;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import witcher_medallions.WitcherMedallions_Main;

public class MiscUtil {

    public static void addMultiplyAttributeTrinket(Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifiers,
                                                   Identifier attribute, String id,
                                                   double value){

        if(Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(attribute))!=null)
        {
            modifiers.put(
                    Registries.ATTRIBUTE.getEntry(
                            Registries.ATTRIBUTE.get(attribute)
                    ),
                    new EntityAttributeModifier(Identifier.of(WitcherMedallions_Main.MOD_ID, id), value,
                            EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL));
        }
    }

    public static void addAdditionAttributeTrinket(Multimap<RegistryEntry<EntityAttribute>, EntityAttributeModifier> modifiers,
                                                   Identifier attribute, String id,
                                                   double value){
        if(Registries.ATTRIBUTE.getEntry(Registries.ATTRIBUTE.get(attribute))!=null)
        {
            modifiers.put(
                    Registries.ATTRIBUTE.getEntry(
                            Registries.ATTRIBUTE.get(attribute)
                    ),
                    new EntityAttributeModifier(Identifier.of(WitcherMedallions_Main.MOD_ID, id), value,
                            EntityAttributeModifier.Operation.ADD_VALUE));
        }
    }



}
