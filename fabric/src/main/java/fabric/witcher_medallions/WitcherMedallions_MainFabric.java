package fabric.witcher_medallions;

import net.fabricmc.api.ModInitializer;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.registry.WitcherMedallions_Items;
import witcher_medallions.registry.WitcherMedallions_Recipes;
import witcher_medallions.registry.WitcherMedallions_Sounds;
import witcher_medallions.registry.fabric.WitcherMedallions_ItemsImpl;

public class WitcherMedallions_MainFabric implements ModInitializer {


	@Override
	public void onInitialize() {
		WitcherMedallions_Main.init();
		WitcherMedallions_Items.initItems();
		WitcherMedallions_Items.initItemGroups();
		WitcherMedallions_Sounds.initSounds();
		WitcherMedallions_Recipes.initRecipes();

		registerCommonEvent();
	}

	public static void registerCommonEvent(){

		WitcherMedallions_ItemsImpl.owoItemGroup.initialize();
	}

}