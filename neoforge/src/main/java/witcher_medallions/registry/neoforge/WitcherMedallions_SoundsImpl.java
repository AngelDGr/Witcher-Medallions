package witcher_medallions.registry.neoforge;

import neoforge.witcher_medallions.WitcherMedallions_Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import witcher_medallions.WitcherMedallions_Main;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class WitcherMedallions_SoundsImpl {
    public static DeferredHolder<SoundEvent, SoundEvent> WOLF_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> CAT_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> BEAR_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> GRIFFIN_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> VIPER_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> MANTICORE_MEDALLION_SOUND;

    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_WOLF_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_CAT_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_BEAR_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_GRIFFIN_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_VIPER_MEDALLION_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> STRONG_MANTICORE_MEDALLION_SOUND;

    public static DeferredHolder<SoundEvent, SoundEvent> MEDALLION_ACTIVATE_SOUND;
    public static DeferredHolder<SoundEvent, SoundEvent> MEDALLION_RESTART_COOLDOWN_SOUND;

    
    public static void initSounds() {
        MEDALLION_ACTIVATE_SOUND= registerSound("medallion_activate_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion_activate_sound")));
        MEDALLION_RESTART_COOLDOWN_SOUND = registerSound("medallion_restartcooldown_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion_restartcooldown_sound")));

        WOLF_MEDALLION_SOUND = registerSound("medallion-wolf_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-wolf_sound")));
        CAT_MEDALLION_SOUND = registerSound("medallion-cat_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-cat_sound")));
        BEAR_MEDALLION_SOUND = registerSound("medallion-bear_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-bear_sound")));
        GRIFFIN_MEDALLION_SOUND = registerSound("medallion-griffin_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-griffin_sound")));
        VIPER_MEDALLION_SOUND = registerSound("medallion-viper_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-viper_sound")));
        MANTICORE_MEDALLION_SOUND = registerSound("medallion-manticore_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-manticore_sound")));

        STRONG_WOLF_MEDALLION_SOUND = registerSound("medallion-wolf-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-wolf-strong_sound")));
        STRONG_CAT_MEDALLION_SOUND = registerSound("medallion-cat-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-cat-strong_sound")));
        STRONG_BEAR_MEDALLION_SOUND = registerSound("medallion-bear-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-bear-strong_sound")));
        STRONG_GRIFFIN_MEDALLION_SOUND = registerSound("medallion-griffin-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-griffin-strong_sound")));
        STRONG_VIPER_MEDALLION_SOUND = registerSound("medallion-viper-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-viper-strong_sound")));
        STRONG_MANTICORE_MEDALLION_SOUND = registerSound("medallion-manticore-strong_sound",
                ()-> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "medallion-manticore-strong_sound")));
    }

    public static SoundEvent selectAnimalSound(String id, boolean strong){
        return switch (id){
            case "wolf" -> strong? STRONG_WOLF_MEDALLION_SOUND.get() :WOLF_MEDALLION_SOUND.get();
            case "cat" -> strong? STRONG_CAT_MEDALLION_SOUND.get(): CAT_MEDALLION_SOUND.get();
            case "bear" -> strong? STRONG_BEAR_MEDALLION_SOUND.get(): BEAR_MEDALLION_SOUND.get();
            case "griffin" -> strong? STRONG_GRIFFIN_MEDALLION_SOUND.get(): GRIFFIN_MEDALLION_SOUND.get();
            case "viper" -> strong? STRONG_VIPER_MEDALLION_SOUND.get(): VIPER_MEDALLION_SOUND.get();
            case "manticore" -> strong? STRONG_MANTICORE_MEDALLION_SOUND.get(): MANTICORE_MEDALLION_SOUND.get();
            default -> null;
        };
    }

    public static SoundEvent MedallionActivatedSound() {
        return MEDALLION_ACTIVATE_SOUND.get();
    }
    public static SoundEvent MedallionRestartCooldownSound() {
        return MEDALLION_RESTART_COOLDOWN_SOUND.get();
    }

    /**
     * Register a sound
     * @param name The item id
     * @param sup The supplier
     * @return An DeferredHolder of Item
     */
    public static DeferredHolder<SoundEvent, SoundEvent> registerSound(String name, Supplier<SoundEvent> sup) {
        return WitcherMedallions_Registries.SOUND_EVENTS.register(name, sup);
    }
}
