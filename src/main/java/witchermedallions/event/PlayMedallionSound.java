package witchermedallions.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import witchermedallions.items.ModItems;
import witchermedallions.witcherMod;

public class PlayMedallionSound {
    public static boolean cooldownSound = false;
    private static int ticks = 0;

    public static void registerSounds(){
        MedallionSounds();
    }

    public static void MedallionSounds(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> generalSound());
    }

    private  static void SelectSound(SoundEvent sound)
    {
        MinecraftClient.getInstance().player.playSound(sound, SoundCategory.PLAYERS, 1, 1);
    }

    private static void generalSound(){
        if(witcherMod.CONFIG.medallionSounds()){
        if(
             witcherMod.NearMob_Wolf || witcherMod.NearStrongMagic_Wolf

          || witcherMod.NearMob_Cat || witcherMod.NearStrongMagic_Cat

          || witcherMod.NearMob_Bear || witcherMod.NearStrongMagic_Bear

          || witcherMod.NearMob_Griffin || witcherMod.NearStrongMagic_Griffin

          || witcherMod.NearMob_Viper || witcherMod.NearStrongMagic_Viper

          || witcherMod.NearMob_Manticore || witcherMod.NearStrongMagic_Manticore
        ){
            if (!cooldownSound
            &&MinecraftClient.getInstance().player!=null){
                //Strong Sounds
                if (witcherMod.NearStrongMagic_Wolf){
                    SelectSound(ModItems.STRONGWOLFMEDALLION_SOUND);
                }
                else if (witcherMod.NearStrongMagic_Cat){
                    SelectSound(ModItems.STRONGCATMEDALLION_SOUND);
                }
                else if (witcherMod.NearStrongMagic_Bear){
                    SelectSound(ModItems.STRONGBEARMEDALLION_SOUND);
                }
                else if (witcherMod.NearStrongMagic_Griffin){
                    SelectSound(ModItems.STRONGGRIFFINMEDALLION_SOUND);
                }
                else if (witcherMod.NearStrongMagic_Viper){
                    SelectSound(ModItems.STRONGVIPERMEDALLION_SOUND);
                }
                else if (witcherMod.NearStrongMagic_Manticore){
                    SelectSound(ModItems.STRONGMANTICOREMEDALLION_SOUND);
                }

                //Normal Sounds
                else if (witcherMod.NearMob_Wolf ){
                    SelectSound(ModItems.WOLFMEDALLION_SOUND);
                }
                else if (witcherMod.NearMob_Cat){
                    SelectSound(ModItems.CATMEDALLION_SOUND);
                }
                else if (witcherMod.NearMob_Bear){
                    SelectSound(ModItems.BEARMEDALLION_SOUND);
                }
                else if (witcherMod.NearMob_Griffin){
                    SelectSound(ModItems.GRIFFINMEDALLION_SOUND);
                }
                else if (witcherMod.NearMob_Viper){
                    SelectSound(ModItems.VIPERMEDALLION_SOUND);
                }
                else {
                    SelectSound(ModItems.MANTICOREMEDALLION_SOUND);
                }
                //Time cooldown last
                ticks=200;
                cooldownSound = true;
                }
            else{
                if (--ticks==0)
            {
                cooldownSound =false;}}
        }else {if
        (--ticks>=0){
            if (ticks==0){
                cooldownSound =false;}}
            }
        }
    }
}
