package witchermedallions.event;

import org.lwjgl.glfw.GLFW;

import net.minecraft.client.MinecraftClient;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;


import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.sound.SoundCategory;


import witchermedallions.witcherMod;
import witchermedallions.items.ModItems;


public class KeyInputHandler {
    public static final String KEY_CATEGORY_MEDALLIONS = "key.category.witchermedallions.medallions";
    public static final String KEY_ACTIVE_MEDALLION = "key.witchermedallions.activemedallion";

    public static KeyBinding medallionkey;
    
    public static boolean outliningMonsters = false;
    private static boolean cooldown = false;
    private static int ticks = 0;

    @SuppressWarnings("all")
    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
                while(medallionkey.wasPressed()) {
                    //DetectMedallion
                    if (!cooldown) {
                        if (
                               (witcherMod.hasTrinket(client.player, ModItems.Witcher_WolfMedallion))
                            || (witcherMod.hasTrinket(client.player, ModItems.Witcher_CatMedallion))
                            || (witcherMod.hasTrinket(client.player, ModItems.Witcher_BearMedallion))
                            || (witcherMod.hasTrinket(client.player, ModItems.Witcher_GriffinMedallion))
                            || (witcherMod.hasTrinket(client.player, ModItems.Witcher_ViperMedallion))
                            || (witcherMod.hasTrinket(client.player, ModItems.Witcher_ManticoreMedallion))
                            || (witcherMod.hasTrinket(client.player, ModItems.Witcher_AncientWolfMedallion))
                        ) {
                            outliningMonsters = true;
                            ticks = 200;
                            cooldown = true;
                            MinecraftClient.getInstance().player.playSound(ModItems.MEDALLION_ACTIVATE_SOUND, SoundCategory.PLAYERS, 2, 1);
                        }
                    }
                }
                if (cooldown) {
                    --ticks;
                    //Time that the effect shows up
                    if (ticks == 100) {
                        outliningMonsters= false;
                    }
                    //Time cooldown last
                    if (ticks==0)
                    {
                    MinecraftClient.getInstance().player.playSound(ModItems.MEDALLION_RESTARTCOOLDOWN_SOUND, SoundCategory.PLAYERS, 2, 1);
                    cooldown=false;
                    }
                }
            });
    }

    public static void register(){
        medallionkey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        KEY_ACTIVE_MEDALLION,
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_T,
        KEY_CATEGORY_MEDALLIONS
        ));
        registerKeyInputs();
    }

}
