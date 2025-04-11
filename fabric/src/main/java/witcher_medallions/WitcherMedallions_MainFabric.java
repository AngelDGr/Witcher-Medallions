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
import witcher_medallions.items.WitcherMedallions_ItemsFabric;
import witcher_medallions.items.WitcherMedallions_ItemsCommon;

import static witcher_medallions.WitcherMedallions_MainCommon.registerSoundEventFabric;

public class WitcherMedallions_MainFabric implements ModInitializer {
	//Data initializer
	public static final witcher_medallions.WitcherMedallionsConfig CONFIG = witcher_medallions.WitcherMedallionsConfig.createAndLoad();

	@Override
	public void onInitialize() {
		WitcherMedallions_MainCommon.init();
		WitcherMedallions_ItemsFabric.registerFabricItems();

		WitcherMedallions_MainCommon.WOLF_MEDALLION_OFF_RPG = create(Items.BONE, WitcherMedallions_ItemsCommon.Witcher_OffWolfMedallion);
		WitcherMedallions_MainCommon.CAT_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.CAT_MEDALLION_INGREDIENT, WitcherMedallions_ItemsCommon.Witcher_OffCatMedallion);
		WitcherMedallions_MainCommon.BEAR_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.BEAR_MEDALLION_INGREDIENT, WitcherMedallions_ItemsCommon.Witcher_OffBearMedallion);
		WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_OFF_RPG = create(Items.FEATHER, WitcherMedallions_ItemsCommon.Witcher_OffGriffinMedallion);
		WitcherMedallions_MainCommon.VIPER_MEDALLION_OFF_RPG = create(Items.FERMENTED_SPIDER_EYE, WitcherMedallions_ItemsCommon.Witcher_OffViperMedallion);
		WitcherMedallions_MainCommon.MANTICORE_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.MANTICORE_MEDALLION_INGREDIENT, WitcherMedallions_ItemsCommon.Witcher_OffManticoreMedallion);
		WitcherMedallions_MainCommon.ANCIENT_WOLF_MEDALLION_OFF_RPG = create(Items.PAPER, WitcherMedallions_ItemsCommon.Witcher_OffAncientWolfMedallion);

		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "wolf-medallion-off"), WitcherMedallions_MainCommon.WOLF_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "cat-medallion-off"), WitcherMedallions_MainCommon.CAT_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "bear-medallion-off"), WitcherMedallions_MainCommon.BEAR_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "griffin-medallion-off"), WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "viper-medallion-off"), WitcherMedallions_MainCommon.VIPER_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "manticore-medallion-off"), WitcherMedallions_MainCommon.MANTICORE_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "ancient-wolf-medallion-off"), WitcherMedallions_MainCommon.ANCIENT_WOLF_MEDALLION_OFF_RPG));

		WitcherMedallions_MainCommon.MEDALLION_ACTIVATE_SOUND= registerSoundEventFabric("medallion_activate_sound");
		WitcherMedallions_MainCommon.MEDALLION_RESTART_COOLDOWN_SOUND = registerSoundEventFabric("medallion_restartcooldown_sound");
		WitcherMedallions_MainCommon.WOLF_MEDALLION_SOUND = registerSoundEventFabric("medallion-wolf_sound");
		WitcherMedallions_MainCommon.CAT_MEDALLION_SOUND = registerSoundEventFabric("medallion-cat_sound");
		WitcherMedallions_MainCommon.BEAR_MEDALLION_SOUND = registerSoundEventFabric("medallion-bear_sound");
		WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_SOUND = registerSoundEventFabric("medallion-griffin_sound");
		WitcherMedallions_MainCommon.VIPER_MEDALLION_SOUND = registerSoundEventFabric("medallion-viper_sound");
		WitcherMedallions_MainCommon.MANTICORE_MEDALLION_SOUND = registerSoundEventFabric("medallion-manticore_sound");

		WitcherMedallions_MainCommon.STRONG_WOLF_MEDALLION_SOUND = registerSoundEventFabric("medallion-wolf-strong_sound");
		WitcherMedallions_MainCommon.STRONG_CAT_MEDALLION_SOUND = registerSoundEventFabric("medallion-cat-strong_sound");
		WitcherMedallions_MainCommon.STRONG_BEAR_MEDALLION_SOUND = registerSoundEventFabric("medallion-bear-strong_sound");
		WitcherMedallions_MainCommon.STRONG_GRIFFIN_MEDALLION_SOUND = registerSoundEventFabric("medallion-griffin-strong_sound");
		WitcherMedallions_MainCommon.STRONG_VIPER_MEDALLION_SOUND = registerSoundEventFabric("medallion-viper-strong_sound");
		WitcherMedallions_MainCommon.STRONG_MANTICORE_MEDALLION_SOUND = registerSoundEventFabric("medallion-manticore-strong_sound");
	}

	private JsonObject create(TagKey<Item> addition, Item medallion){
		return WitcherMedallions_MainCommon.create(addition.location().toString(), medallion, FabricLoader.getInstance().isModLoaded("witcher_rpg")? "witcher_rpg:silver_ingot": BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), true);
	}

	private JsonObject create(Item addition, Item medallion){
		return WitcherMedallions_MainCommon.create(BuiltInRegistries.ITEM.getKey(addition).toString(), medallion, FabricLoader.getInstance().isModLoaded("witcher_rpg")? "witcher_rpg:silver_ingot": BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), false);
	}

}