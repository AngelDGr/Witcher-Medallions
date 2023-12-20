package witchermedallions;

import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import software.bernie.geckolib.renderer.GeoItemRenderer;
import witchermedallions.event.KeyInputHandler;
import witchermedallions.event.PlayMedallionSound;
import witchermedallions.items.ModItems;
import witchermedallions.items.gecko.renderer.*;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.MinecraftClient;
import witchermedallions.items.gecko.renderer.off.*;


public class witcherMod_client implements ClientModInitializer {

    public static void registerClient() {
        witcherMod.LOGGER.info("Registering Client for " + witcherMod.MODID);
    }

    @SuppressWarnings({"unchecked" })
	@Override
	public void onInitializeClient() {
            //Registers con Client
                KeyInputHandler.register();
                registerClient();
                PlayMedallionSound.registerSounds();
	}



}