package witcher_medallions.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import net.minecraft.sounds.SoundEvent;

public class WitcherMedallions_Sounds {

    @ExpectPlatform
    public static void initSounds(){ throw new AssertionError();}

    @ExpectPlatform
    public static SoundEvent selectAnimalSound(String id, boolean strong){
        throw new AssertionError();
    }

    @ExpectPlatform
    public static SoundEvent MedallionActivatedSound(){throw new AssertionError();}

    @ExpectPlatform
    public static SoundEvent MedallionRestartCooldownSound(){throw new AssertionError();}

    public static SoundEvent selectAnimalSound(String id) {
        return selectAnimalSound(id, false);
    }
}
