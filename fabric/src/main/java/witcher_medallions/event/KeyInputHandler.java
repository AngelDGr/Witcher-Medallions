package witcher_medallions.event;

import com.mojang.blaze3d.platform.InputConstants;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import org.lwjgl.glfw.GLFW;
import witcher_medallions.Constants;
import witcher_medallions.WitcherMedallions_MainFabric;
import witcher_medallions.items.ActivatedMedallionBaseItem;

@Environment(EnvType.CLIENT)
public class KeyInputHandler {

    public static KeyMapping medallion_key;
    private static boolean cooldown = false;
    private static int ticks = 0;

    public static void registerKeyInputs(){
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
                while(medallion_key.consumeClick()) {
                    //DetectMedallion
                    if (!cooldown) {
                        if (Minecraft.getInstance().player!=null && hasMedallionEquipped(client.player)) {
                            Constants.outliningMonsters = true;
                            ticks = 200;
                            cooldown = true;
                            Minecraft.getInstance().player.playSound(WitcherMedallions_MainFabric.MEDALLION_ACTIVATE_SOUND, 1, 1);
                        }
                    }
                }
                if (cooldown) {
                    --ticks;
                    //Time that the effect shows up
                    if (ticks == 100) {
                        Constants.outliningMonsters= false;
                    }
                    //Time cooldown last
                    if (ticks==0) {
                        if(Minecraft.getInstance().player!=null){
                        Minecraft.getInstance().player.playNotifySound(WitcherMedallions_MainFabric.MEDALLION_RESTART_COOLDOWN_SOUND, SoundSource.PLAYERS, 1, 1);
                        }
                    cooldown=false;
                    }
                }
            });
    }

    public static void register(){
        medallion_key = KeyBindingHelper.registerKeyBinding(
                new KeyMapping(
                        Constants.KEY_ACTIVE_MEDALLION,
                        InputConstants.Type.KEYSYM,
                        GLFW.GLFW_KEY_T,
                        Constants.KEY_CATEGORY_MEDALLIONS
                ));
        registerKeyInputs();
    }

    //DetectsMedallions
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static TrinketComponent getTrinkets(LivingEntity entity) {
        return TrinketsApi.getTrinketComponent(entity).get();
    }

    public static boolean hasMedallionEquipped(LivingEntity entity) {
        return getTrinkets(entity).isEquipped(stack-> stack.getItem() instanceof ActivatedMedallionBaseItem);
    }

}
