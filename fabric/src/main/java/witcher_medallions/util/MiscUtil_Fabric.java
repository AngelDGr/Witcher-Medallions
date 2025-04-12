package witcher_medallions.util;

import net.minecraft.sounds.SoundEvent;
import witcher_medallions.WitcherMedallions_MainFabric;

public class MiscUtil_Fabric {
    /**
     * Return the corresponding animal sound
     * @param id The id of the animal
     * @param strong Selects the strong sound if true
     */
    public static SoundEvent selectAnimalSound(String id, boolean strong){
        return switch (id){
            case "wolf" -> strong? WitcherMedallions_MainFabric.STRONG_WOLF_MEDALLION_SOUND : WitcherMedallions_MainFabric.WOLF_MEDALLION_SOUND;
            case "cat" -> strong? WitcherMedallions_MainFabric.STRONG_CAT_MEDALLION_SOUND: WitcherMedallions_MainFabric.CAT_MEDALLION_SOUND;
            case "bear" -> strong? WitcherMedallions_MainFabric.STRONG_BEAR_MEDALLION_SOUND: WitcherMedallions_MainFabric.BEAR_MEDALLION_SOUND;
            case "griffin" -> strong? WitcherMedallions_MainFabric.STRONG_GRIFFIN_MEDALLION_SOUND: WitcherMedallions_MainFabric.GRIFFIN_MEDALLION_SOUND;
            case "viper" -> strong? WitcherMedallions_MainFabric.STRONG_VIPER_MEDALLION_SOUND: WitcherMedallions_MainFabric.VIPER_MEDALLION_SOUND;
            case "manticore" -> strong? WitcherMedallions_MainFabric.STRONG_MANTICORE_MEDALLION_SOUND: WitcherMedallions_MainFabric.MANTICORE_MEDALLION_SOUND;
            default -> null;
        };
    }

    /**
     * Return the corresponding animal sound
     * @param id The id of the animal
     */
    public static SoundEvent selectAnimalSound(String id){
        return selectAnimalSound(id, false);
    }
}
