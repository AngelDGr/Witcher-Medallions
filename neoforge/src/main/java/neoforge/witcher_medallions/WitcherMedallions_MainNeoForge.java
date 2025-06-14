package neoforge.witcher_medallions;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.registry.WitcherMedallions_Items;
import witcher_medallions.registry.WitcherMedallions_Recipes;
import witcher_medallions.registry.WitcherMedallions_Sounds;
import witcher_medallions.registry.neoforge.WitcherMedallions_ItemsImpl;

@EventBusSubscriber(modid = WitcherMedallions_Main.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
@Mod(value = WitcherMedallions_Main.MOD_ID)
public class WitcherMedallions_MainNeoForge {

    public WitcherMedallions_MainNeoForge(IEventBus eventBus) {
        WitcherMedallions_Main.init();
        WitcherMedallions_Items.initItems(); WitcherMedallions_Registries.ITEMS.register(eventBus);
        WitcherMedallions_Items.initItemGroups(); WitcherMedallions_Registries.CREATIVE_MODE_TABS.register(eventBus);
        WitcherMedallions_Sounds.initSounds(); WitcherMedallions_Registries.SOUND_EVENTS.register(eventBus);
        WitcherMedallions_Recipes.initRecipes();
    }

    @SubscribeEvent
    public static void registerCommonEvent(FMLCommonSetupEvent event){

        WitcherMedallions_ItemsImpl.owoItemGroup.get().initialize();
    }
}