package witchermedallions.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.sound.SoundCategory;
import witchermedallions.items.ModItems;
import witchermedallions.witcherMod;

public class PlayMedallionSound {
    public static boolean cooldown = false;
    private static int ticks = 0;

    public static void registerSounds(){
        MedallionSounds();
    }

    public static void MedallionSounds(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> generalSound());
    }

    private static void generalSound(){
        if(witcherMod.CONFIG.medallionSounds()){
        if(
             witcherMod.NearMob_Wolf
          || witcherMod.NearMob_Cat
          || witcherMod.NearMob_Bear
          || witcherMod.NearMob_Griffin
          || witcherMod.NearMob_Viper
          || witcherMod.NearMob_Manticore
        ){
            if (!cooldown
            &&MinecraftClient.getInstance().player!=null){

                if (witcherMod.NearMob_Wolf){
                    MinecraftClient.getInstance().player.playSound(ModItems.WOLFMEDALLION_SOUND, SoundCategory.PLAYERS, 1, 1);
                }
                else if (witcherMod.NearMob_Cat){
                    MinecraftClient.getInstance().player.playSound(ModItems.CATMEDALLION_SOUND, SoundCategory.PLAYERS, 1, 1);
                }
                else if (witcherMod.NearMob_Bear){
                    MinecraftClient.getInstance().player.playSound(ModItems.BEARMEDALLION_SOUND, SoundCategory.PLAYERS, 1, 1);
                }
                else if (witcherMod.NearMob_Griffin){
                    MinecraftClient.getInstance().player.playSound(ModItems.GRIFFINMEDALLION_SOUND, SoundCategory.PLAYERS, 1, 1);
                }
                else if (witcherMod.NearMob_Viper){
                    MinecraftClient.getInstance().player.playSound(ModItems.VIPERMEDALLION_SOUND, SoundCategory.PLAYERS, 1, 1);
                }
                else {
                    MinecraftClient.getInstance().player.playSound(ModItems.MANTICOREMEDALLION_SOUND, SoundCategory.PLAYERS, 1, 1);
                }
                //Time cooldown last
                ticks=200;
                cooldown = true;
                }
            else{
                if (--ticks==0)
            {cooldown=false;}}
        }else {if
        (--ticks>=0){
            if (ticks==0){cooldown=false;}}
            }
        }
    }
}
