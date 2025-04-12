package witcher_medallions;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.Minecraft;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.jarjar.nio.util.Lazy;
import net.minecraft.client.KeyMapping;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.settings.KeyConflictContext;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.glfw.GLFW;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.type.capability.ICuriosItemHandler;
import witcher_medallions.items.ActivatedMedallionBaseItem;

@Mod(value = WitcherMedallions_MainCommon.MOD_ID, dist = Dist.CLIENT)
public class WitcherMedallions_ClientNeoForge {

    @EventBusSubscriber(modid = WitcherMedallions_MainCommon.MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class KeyMappingClass {

        // Key mapping is lazily initialized so it doesn't exist until it is registered
        public static final Lazy<KeyMapping> MEDALLION_MAPPING = Lazy.of(() ->
                new KeyMapping(
                        Constants.KEY_ACTIVE_MEDALLION,
                        KeyConflictContext.IN_GAME,
                        InputConstants.Type.KEYSYM,
                        GLFW.GLFW_KEY_T,
                        Constants.KEY_CATEGORY_MEDALLIONS
                )
        );

        // Event is on the mod event bus only on the physical client
        @SubscribeEvent
        public static void registerBindings(@NotNull RegisterKeyMappingsEvent event) {
            event.register(MEDALLION_MAPPING.get());
        }
    }

    @Mod(value = WitcherMedallions_MainCommon.MOD_ID, dist = Dist.CLIENT)
    public static class KeyInputHandler{
        private static boolean cooldown = false;
        private static int ticks = 0;

        @SubscribeEvent
        // Event is on the NeoForge event bus only on the physical client
        public void onClientTick(ClientTickEvent.Post event) {
            while (KeyMappingClass.MEDALLION_MAPPING.get().consumeClick()) {
                if (!cooldown) {
                    if(Minecraft.getInstance().player!=null && hasMedallionEquipped(Minecraft.getInstance().player)){
                        Constants.outliningMonsters = true;
                        ticks = 200;
                        cooldown = true;
                        Minecraft.getInstance().player.playSound(WitcherMedallions_MainNeoForge.MEDALLION_ACTIVATE_SOUND.get(), 1, 1);
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
                        Minecraft.getInstance().player.playNotifySound(WitcherMedallions_MainNeoForge.MEDALLION_RESTART_COOLDOWN_SOUND.get(), SoundSource.PLAYERS, 1, 1);
                    }
                    cooldown=false;
                }
            }
        }


        //DetectsMedallions
        @SuppressWarnings("OptionalGetWithoutIsPresent")
        public static ICuriosItemHandler getCurios(LivingEntity entity) {
            return CuriosApi.getCuriosInventory(entity).get();
        }

        public static boolean hasMedallionEquipped(LivingEntity entity) {
            return getCurios(entity).isEquipped(stack-> stack.getItem() instanceof ActivatedMedallionBaseItem);
        }
    }
}
