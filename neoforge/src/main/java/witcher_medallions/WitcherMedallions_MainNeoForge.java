package witcher_medallions;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(WitcherMedallions_MainCommon.MOD_ID)
public class WitcherMedallions_MainNeoForge {

    public WitcherMedallions_MainNeoForge(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        Constants.LOG.info("Hello NeoForge world!");
        WitcherMedallions_MainCommon.init();

    }
}