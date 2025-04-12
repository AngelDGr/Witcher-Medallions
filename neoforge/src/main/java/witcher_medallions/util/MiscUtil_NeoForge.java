package witcher_medallions.util;

import net.minecraft.sounds.SoundEvent;
import witcher_medallions.WitcherMedallions_MainNeoForge;

public class MiscUtil_NeoForge {
    /**
     * Return the corresponding animal sound
     * @param id The id of the animal
     * @param strong Selects the strong sound if true
     */
    public static SoundEvent selectAnimalSound(String id, boolean strong){
        return switch (id){
            case "wolf" -> strong? WitcherMedallions_MainNeoForge.STRONG_WOLF_MEDALLION_SOUND.get() :WitcherMedallions_MainNeoForge.WOLF_MEDALLION_SOUND.get();
            case "cat" -> strong? WitcherMedallions_MainNeoForge.STRONG_CAT_MEDALLION_SOUND.get(): WitcherMedallions_MainNeoForge.CAT_MEDALLION_SOUND.get();
            case "bear" -> strong? WitcherMedallions_MainNeoForge.STRONG_BEAR_MEDALLION_SOUND.get(): WitcherMedallions_MainNeoForge.BEAR_MEDALLION_SOUND.get();
            case "griffin" -> strong? WitcherMedallions_MainNeoForge.STRONG_GRIFFIN_MEDALLION_SOUND.get(): WitcherMedallions_MainNeoForge.GRIFFIN_MEDALLION_SOUND.get();
            case "viper" -> strong? WitcherMedallions_MainNeoForge.STRONG_VIPER_MEDALLION_SOUND.get(): WitcherMedallions_MainNeoForge.VIPER_MEDALLION_SOUND.get();
            case "manticore" -> strong? WitcherMedallions_MainNeoForge.STRONG_MANTICORE_MEDALLION_SOUND.get(): WitcherMedallions_MainNeoForge.MANTICORE_MEDALLION_SOUND.get();
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
