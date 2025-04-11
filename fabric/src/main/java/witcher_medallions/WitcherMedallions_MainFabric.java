package witcher_medallions;

import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import witcher_medallions.items.WitcherMedallions_ItemGroups;
import witcher_medallions.items.WitcherMedallions_Items;

public class WitcherMedallions_MainFabric implements ModInitializer {
	//Data initializer
	public static final witcher_medallions.WitcherMedallionsConfig CONFIG = witcher_medallions.WitcherMedallionsConfig.createAndLoad();

	@Override
	public void onInitialize() {
		WitcherMedallions_MainCommon.init();
		WitcherMedallions_Items.registerModItems();
		WitcherMedallions_ItemGroups.registerGroupItems();

		WitcherMedallions_MainCommon.WOLF_MEDALLION_OFF_RPG = create(Items.BONE, WitcherMedallions_Items.Witcher_OffWolfMedallion);
		WitcherMedallions_MainCommon.CAT_MEDALLION_OFF_RPG = create(WitcherMedallions_Items.CAT_MEDALLION_INGREDIENT, WitcherMedallions_Items.Witcher_OffCatMedallion);
		WitcherMedallions_MainCommon.BEAR_MEDALLION_OFF_RPG = create(WitcherMedallions_Items.BEAR_MEDALLION_INGREDIENT, WitcherMedallions_Items.Witcher_OffBearMedallion);
		WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_OFF_RPG = create(Items.FEATHER, WitcherMedallions_Items.Witcher_OffGriffinMedallion);
		WitcherMedallions_MainCommon.VIPER_MEDALLION_OFF_RPG = create(Items.FERMENTED_SPIDER_EYE, WitcherMedallions_Items.Witcher_OffViperMedallion);
		WitcherMedallions_MainCommon.MANTICORE_MEDALLION_OFF_RPG = create(WitcherMedallions_Items.MANTICORE_MEDALLION_INGREDIENT, WitcherMedallions_Items.Witcher_OffManticoreMedallion);
		WitcherMedallions_MainCommon.ANCIENT_WOLF_MEDALLION_OFF_RPG = create(Items.PAPER, WitcherMedallions_Items.Witcher_OffAncientWolfMedallion);

		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "wolf-medallion-off"), WitcherMedallions_MainCommon.WOLF_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "cat-medallion-off"), WitcherMedallions_MainCommon.CAT_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "bear-medallion-off"), WitcherMedallions_MainCommon.BEAR_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "griffin-medallion-off"), WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "viper-medallion-off"), WitcherMedallions_MainCommon.VIPER_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "manticore-medallion-off"), WitcherMedallions_MainCommon.MANTICORE_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "ancient-wolf-medallion-off"), WitcherMedallions_MainCommon.ANCIENT_WOLF_MEDALLION_OFF_RPG));
	}

	private JsonObject create(TagKey<Item> addition, Item medallion){
		return WitcherMedallions_MainCommon.create(addition.location().toString(), medallion, FabricLoader.getInstance().isModLoaded("witcher_rpg")? "witcher_rpg:silver_ingot": BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), true);
	}

	private JsonObject create(Item addition, Item medallion){
		return WitcherMedallions_MainCommon.create(BuiltInRegistries.ITEM.getKey(addition).toString(), medallion, FabricLoader.getInstance().isModLoaded("witcher_rpg")? "witcher_rpg:silver_ingot": BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), false);
	}

}