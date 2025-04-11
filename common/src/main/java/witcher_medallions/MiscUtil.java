package witcher_medallions;

import com.google.common.collect.Multimap;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
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

    /**
     * Return the corresponding animal sound
     * @param id The id of the animal
     * @param strong Selects the strong sound if true
     * @return
     */
    public static SoundEvent selectAnimalSound(String id, boolean strong){
        return switch (id){
            case "wolf" -> strong? WitcherMedallions_MainCommon.STRONG_WOLF_MEDALLION_SOUND :WitcherMedallions_MainCommon.WOLF_MEDALLION_SOUND;
            case "cat" -> strong? WitcherMedallions_MainCommon.STRONG_CAT_MEDALLION_SOUND: WitcherMedallions_MainCommon.CAT_MEDALLION_SOUND;
            case "bear" -> strong? WitcherMedallions_MainCommon.STRONG_BEAR_MEDALLION_SOUND: WitcherMedallions_MainCommon.BEAR_MEDALLION_SOUND;
            case "griffin" -> strong? WitcherMedallions_MainCommon.STRONG_GRIFFIN_MEDALLION_SOUND: WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_SOUND;
            case "viper" -> strong? WitcherMedallions_MainCommon.STRONG_VIPER_MEDALLION_SOUND: WitcherMedallions_MainCommon.VIPER_MEDALLION_SOUND;
            case "manticore" -> strong? WitcherMedallions_MainCommon.STRONG_MANTICORE_MEDALLION_SOUND: WitcherMedallions_MainCommon.MANTICORE_MEDALLION_SOUND;
            default -> null;
        };
    }

    /**
     * Return the corresponding animal sound
     * @param id The id of the animal
     * @return
     */
    public static SoundEvent selectAnimalSound(String id){
        return selectAnimalSound(id, false);
    }
}
