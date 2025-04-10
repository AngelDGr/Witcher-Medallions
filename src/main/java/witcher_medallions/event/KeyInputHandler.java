package witcher_medallions.event;

import com.mojang.blaze3d.platform.InputConstants;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import org.lwjgl.glfw.GLFW;
import witcher_medallions.items.WitcherMedallions_Items;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_MEDALLIONS = "key.category.witchermedallions.medallions";
    public static final String KEY_ACTIVE_MEDALLION = "key.witchermedallions.activemedallion";

    public static KeyMapping medallion_key;
    public static boolean outliningMonsters = false;
    private static boolean cooldown = false;
    private static int ticks = 0;

    @SuppressWarnings("all")
    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
                while(medallion_key.consumeClick()) {
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
                            Minecraft.getInstance().player.playSound(WitcherMedallions_Items.MEDALLION_ACTIVATE_SOUND, 1, 1);
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
                        if(Minecraft.getInstance().player!=null){
                        Minecraft.getInstance().player.playNotifySound(WitcherMedallions_Items.MEDALLION_RESTART_COOLDOWN_SOUND, SoundSource.PLAYERS, 1, 1);
                        }
                    cooldown=false;
                    }
                }
            });
    }

    public static void register(){
        medallion_key = KeyBindingHelper.registerKeyBinding(new KeyMapping(
        KEY_ACTIVE_MEDALLION,
        InputConstants.Type.KEYSYM,
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
