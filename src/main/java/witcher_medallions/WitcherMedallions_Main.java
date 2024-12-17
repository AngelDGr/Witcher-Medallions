package witcher_medallions;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import witcher_medallions.items.WitcherMedallions_ItemGroups;
import witcher_medallions.items.WitcherMedallions_Items;

public class WitcherMedallions_Main implements ModInitializer {
	//Data initializer
	public static final String MOD_ID = "witcher-medallions";
	public static final Logger LOGGER = LoggerFactory.getLogger("witcher-medallions");
	public static final witcher_medallions.WitcherMedallionsConfig CONFIG = witcher_medallions.WitcherMedallionsConfig.createAndLoad();

	@Override
	public void onInitialize() {
		WitcherMedallions_Items.registerModItems();
		WitcherMedallions_ItemGroups.registerGroupItems();
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