package witcher_medallions.event;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundCategory;
import org.lwjgl.glfw.GLFW;
import witcher_medallions.items.WitcherMedallions_Items;


public class KeyInputHandler {
    public static final String KEY_CATEGORY_MEDALLIONS = "key.category.witchermedallions.medallions";
    public static final String KEY_ACTIVE_MEDALLION = "key.witchermedallions.activemedallion";

    public static KeyBinding medallion_key;
    public static boolean outliningMonsters = false;
    private static boolean cooldown = false;
    private static int ticks = 0;

    @SuppressWarnings("all")
    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
                while(medallion_key.wasPressed()) {
                    //DetectMedallion
                    if (!cooldown) {
                        if (
                               (hasTrinketEquipped(client.player, WitcherMedallions_Items.Witcher_WolfMedallion))
                            || (hasTrinketEquipped(client.player, WitcherMedallions_Items.Witcher_CatMedallion))
                            || (hasTrinketEquipped(client.player, WitcherMedallions_Items.Witcher_BearMedallion))
                            || (hasTrinketEquipped(client.player, WitcherMedallions_Items.Witcher_GriffinMedallion))
                            || (hasTrinketEquipped(client.player, WitcherMedallions_Items.Witcher_ViperMedallion))
                            || (hasTrinketEquipped(client.player, WitcherMedallions_Items.Witcher_ManticoreMedallion))
                            || (hasTrinketEquipped(client.player, WitcherMedallions_Items.Witcher_AncientWolfMedallion))
                        ) {
                            outliningMonsters = true;
                            ticks = 200;
                            cooldown = true;
                            MinecraftClient.getInstance().player.playSound(WitcherMedallions_Items.MEDALLION_ACTIVATE_SOUND, 1, 1);
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
                    if (ticks==0) {
                        if(MinecraftClient.getInstance().player!=null){
                        MinecraftClient.getInstance().player.playSoundToPlayer(WitcherMedallions_Items.MEDALLION_RESTART_COOLDOWN_SOUND, SoundCategory.PLAYERS, 1, 1);
                        }
                    cooldown=false;
                    }
                }
            });
    }

    public static void register(){
        medallion_key = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        KEY_ACTIVE_MEDALLION,
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_T,
        KEY_CATEGORY_MEDALLIONS
        ));
        registerKeyInputs();
    }

    //DetectsMedallions
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static TrinketComponent getTrinkets(LivingEntity entity) {
        return TrinketsApi.getTrinketComponent(entity).get();
    }

    public static boolean hasTrinketEquipped(LivingEntity entity, Item trinket) {
        return getTrinkets(entity).isEquipped(trinket);
    }

}
