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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import witcher_medallions.items.WitcherMedallions_ItemGroups;
import witcher_medallions.items.WitcherMedallions_Items;

import java.util.ArrayList;
import java.util.List;

public class WitcherMedallions_Main implements ModInitializer {
	//Data initializer
	public static final String MOD_ID = "witcher-medallions";
	public static final Logger LOGGER = LoggerFactory.getLogger("witcher-medallions");
	public static final witcher_medallions.WitcherMedallionsConfig CONFIG = witcher_medallions.WitcherMedallionsConfig.createAndLoad();


	//Dynamic Recipes
	public static JsonObject WOLF_MEDALLION_OFF_RPG=null;
	public static JsonObject CAT_MEDALLION_OFF_RPG=null;
	public static JsonObject BEAR_MEDALLION_OFF_RPG=null;
	public static JsonObject GRIFFIN_MEDALLION_OFF_RPG=null;
	public static JsonObject VIPER_MEDALLION_OFF_RPG=null;
	public static JsonObject MANTICORE_MEDALLION_OFF_RPG=null;
	public static JsonObject ANCIENT_WOLF_MEDALLION_OFF_RPG=null;
	public static List<Tuple<ResourceLocation, JsonObject>> recipes= new ArrayList<>();

	@Override
	public void onInitialize() {
		WitcherMedallions_Items.registerModItems();
		WitcherMedallions_ItemGroups.registerGroupItems();

		WOLF_MEDALLION_OFF_RPG = create(Items.BONE, WitcherMedallions_Items.Witcher_OffWolfMedallion);
		CAT_MEDALLION_OFF_RPG = create(WitcherMedallions_Items.CAT_MEDALLION_INGREDIENT, WitcherMedallions_Items.Witcher_OffCatMedallion);
		BEAR_MEDALLION_OFF_RPG = create(WitcherMedallions_Items.BEAR_MEDALLION_INGREDIENT, WitcherMedallions_Items.Witcher_OffBearMedallion);
		GRIFFIN_MEDALLION_OFF_RPG = create(Items.FEATHER, WitcherMedallions_Items.Witcher_OffGriffinMedallion);
		VIPER_MEDALLION_OFF_RPG = create(Items.FERMENTED_SPIDER_EYE, WitcherMedallions_Items.Witcher_OffViperMedallion);
		MANTICORE_MEDALLION_OFF_RPG = create(WitcherMedallions_Items.MANTICORE_MEDALLION_INGREDIENT, WitcherMedallions_Items.Witcher_OffManticoreMedallion);
		ANCIENT_WOLF_MEDALLION_OFF_RPG = create(Items.PAPER, WitcherMedallions_Items.Witcher_OffAncientWolfMedallion);

		recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "wolf-medallion-off"), WOLF_MEDALLION_OFF_RPG));
		recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "cat-medallion-off"), CAT_MEDALLION_OFF_RPG));
		recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "bear-medallion-off"), BEAR_MEDALLION_OFF_RPG));
		recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "griffin-medallion-off"), GRIFFIN_MEDALLION_OFF_RPG));
		recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "viper-medallion-off"), VIPER_MEDALLION_OFF_RPG));
		recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "manticore-medallion-off"), MANTICORE_MEDALLION_OFF_RPG));
		recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "ancient-wolf-medallion-off"), ANCIENT_WOLF_MEDALLION_OFF_RPG));
	}

	private JsonObject create(TagKey<Item> addition, Item medallion){
		return create(addition.location().toString(), medallion, true);
	}

	private JsonObject create(Item addition, Item medallion){
		return create(BuiltInRegistries.ITEM.getKey(addition).toString(), medallion, false);
	}

	private JsonObject create(String addition, Item medallion, boolean isTag){
		JsonObject mainJson = new JsonObject();

		//Type
		mainJson.addProperty("type", "minecraft:smithing_transform");

		//Addition
		JsonObject additionJson = new JsonObject();
		additionJson.addProperty(isTag?"tag": "item", addition);
		mainJson.add("addition", additionJson);

		//Base
		JsonObject baseJson = new JsonObject();
		baseJson.addProperty("item", FabricLoader.getInstance().isModLoaded("witcher_rpg")? "witcher_rpg:silver_ingot": BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString());
		mainJson.add("base", baseJson);

		//Result
		JsonObject jsonobject = new JsonObject();
		jsonobject.addProperty("id", BuiltInRegistries.ITEM.getKey(medallion).toString());
		jsonobject.addProperty("count", 1);
		mainJson.add("result", jsonobject);

		//Template
		JsonObject templateJson = new JsonObject();
		templateJson.addProperty("item", BuiltInRegistries.ITEM.getKey(Items.CHAIN).toString());
		mainJson.add("template", templateJson);

		return mainJson;
	}

}