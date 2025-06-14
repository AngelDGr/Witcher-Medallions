package witcher_medallions.registry.fabric;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import witcher_medallions.WitcherMedallions_Main;

@SuppressWarnings("unused")
public class WitcherMedallions_SoundsImpl {
    public static SoundEvent WOLF_MEDALLION_SOUND;
    public static SoundEvent CAT_MEDALLION_SOUND;
    public static SoundEvent BEAR_MEDALLION_SOUND;
    public static SoundEvent GRIFFIN_MEDALLION_SOUND;
    public static SoundEvent VIPER_MEDALLION_SOUND;
    public static SoundEvent MANTICORE_MEDALLION_SOUND;
    public static SoundEvent STRONG_WOLF_MEDALLION_SOUND;
    public static SoundEvent STRONG_CAT_MEDALLION_SOUND;
    public static SoundEvent STRONG_BEAR_MEDALLION_SOUND;
    public static SoundEvent STRONG_GRIFFIN_MEDALLION_SOUND;
    public static SoundEvent STRONG_VIPER_MEDALLION_SOUND;
    public static SoundEvent STRONG_MANTICORE_MEDALLION_SOUND;

    public static SoundEvent MEDALLION_ACTIVATE_SOUND;
    public static SoundEvent MEDALLION_RESTART_COOLDOWN_SOUND;
    
    public static void initSounds() {
        MEDALLION_ACTIVATE_SOUND= registerSound("medallion_activate_sound");
        MEDALLION_RESTART_COOLDOWN_SOUND = registerSound("medallion_restartcooldown_sound");
        WOLF_MEDALLION_SOUND = registerSound("medallion-wolf_sound");
        CAT_MEDALLION_SOUND = registerSound("medallion-cat_sound");
        BEAR_MEDALLION_SOUND = registerSound("medallion-bear_sound");
        GRIFFIN_MEDALLION_SOUND = registerSound("medallion-griffin_sound");
        VIPER_MEDALLION_SOUND = registerSound("medallion-viper_sound");
        MANTICORE_MEDALLION_SOUND = registerSound("medallion-manticore_sound");

        STRONG_WOLF_MEDALLION_SOUND = registerSound("medallion-wolf-strong_sound");
        STRONG_CAT_MEDALLION_SOUND = registerSound("medallion-cat-strong_sound");
        STRONG_BEAR_MEDALLION_SOUND = registerSound("medallion-bear-strong_sound");
        STRONG_GRIFFIN_MEDALLION_SOUND = registerSound("medallion-griffin-strong_sound");
        STRONG_VIPER_MEDALLION_SOUND = registerSound("medallion-viper-strong_sound");
        STRONG_MANTICORE_MEDALLION_SOUND = registerSound("medallion-manticore-strong_sound");
    }

    //Register sound
    public static SoundEvent registerSound(String name){
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, name);
        return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
    }

    public static SoundEvent selectAnimalSound(String id, boolean strong) {
        return switch (id){
            case "wolf" -> strong? STRONG_WOLF_MEDALLION_SOUND : WOLF_MEDALLION_SOUND;
            case "cat" -> strong? STRONG_CAT_MEDALLION_SOUND: CAT_MEDALLION_SOUND;
            case "bear" -> strong? STRONG_BEAR_MEDALLION_SOUND: BEAR_MEDALLION_SOUND;
            case "griffin" -> strong? STRONG_GRIFFIN_MEDALLION_SOUND: GRIFFIN_MEDALLION_SOUND;
            case "viper" -> strong? STRONG_VIPER_MEDALLION_SOUND: VIPER_MEDALLION_SOUND;
            case "manticore" -> strong? STRONG_MANTICORE_MEDALLION_SOUND: MANTICORE_MEDALLION_SOUND;
            default -> null;
        };
    }

    public static SoundEvent MedallionActivatedSound() {
        return MEDALLION_ACTIVATE_SOUND;
    }
    public static SoundEvent MedallionRestartCooldownSound() {
        return MEDALLION_RESTART_COOLDOWN_SOUND;
    }

}
