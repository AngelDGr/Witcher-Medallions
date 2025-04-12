package witcher_medallions;

import com.google.gson.JsonObject;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import witcher_medallions.items.WitcherMedallions_ItemsFabric;
import witcher_medallions.items.WitcherMedallions_ItemsCommon;

public class WitcherMedallions_MainFabric implements ModInitializer {
	//Data initializer
	public static final witcher_medallions.WitcherMedallionsConfig CONFIG = witcher_medallions.WitcherMedallionsConfig.createAndLoad();
	public static SoundEvent MEDALLION_ACTIVATE_SOUND;
	public static SoundEvent MEDALLION_RESTART_COOLDOWN_SOUND;
	public static SoundEvent WOLF_MEDALLION_SOUND;
	public static SoundEvent CAT_MEDALLION_SOUND;
	public static SoundEvent BEAR_MEDALLION_SOUND;
	public static SoundEvent GRIFFIN_MEDALLION_SOUND;
	public static SoundEvent VIPER_MEDALLION_SOUND;
	public static SoundEvent MANTICORE_MEDALLION_SOUND;
	public static SoundEvent STRONG_WOLF_MEDALLION_SOUND;
	public static SoundEvent STRONG_CAT_MEDALLION_SOUND;
	public static SoundEvent STRONG_BEAR_MEDALLION_SOUND;
	public static SoundEvent STRONG_GRIFFIN_MEDALLION_SOUND;
	public static SoundEvent STRONG_VIPER_MEDALLION_SOUND;
	public static SoundEvent STRONG_MANTICORE_MEDALLION_SOUND;

	//Register sound
	public static SoundEvent registerSound(String name){
		ResourceLocation id = ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, name);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(id));
	}

	@Override
	public void onInitialize() {
		WitcherMedallions_MainCommon.init();
		WitcherMedallions_ItemsFabric.registerFabricItems();

		WitcherMedallions_MainCommon.WOLF_MEDALLION_OFF_RPG = create(Items.BONE, WitcherMedallions_ItemsFabric.Witcher_OffWolfMedallion);
		WitcherMedallions_MainCommon.CAT_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.CAT_MEDALLION_INGREDIENT, WitcherMedallions_ItemsFabric.Witcher_OffCatMedallion);
		WitcherMedallions_MainCommon.BEAR_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.BEAR_MEDALLION_INGREDIENT, WitcherMedallions_ItemsFabric.Witcher_OffBearMedallion);
		WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_OFF_RPG = create(Items.FEATHER, WitcherMedallions_ItemsFabric.Witcher_OffGriffinMedallion);
		WitcherMedallions_MainCommon.VIPER_MEDALLION_OFF_RPG = create(Items.FERMENTED_SPIDER_EYE, WitcherMedallions_ItemsFabric.Witcher_OffViperMedallion);
		WitcherMedallions_MainCommon.MANTICORE_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.MANTICORE_MEDALLION_INGREDIENT, WitcherMedallions_ItemsFabric.Witcher_OffManticoreMedallion);
		WitcherMedallions_MainCommon.ANCIENT_WOLF_MEDALLION_OFF_RPG = create(Items.PAPER, WitcherMedallions_ItemsFabric.Witcher_OffAncientWolfMedallion);

		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "wolf-medallion-off"), WitcherMedallions_MainCommon.WOLF_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "cat-medallion-off"), WitcherMedallions_MainCommon.CAT_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "bear-medallion-off"), WitcherMedallions_MainCommon.BEAR_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "griffin-medallion-off"), WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "viper-medallion-off"), WitcherMedallions_MainCommon.VIPER_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "manticore-medallion-off"), WitcherMedallions_MainCommon.MANTICORE_MEDALLION_OFF_RPG));
		WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "ancient-wolf-medallion-off"), WitcherMedallions_MainCommon.ANCIENT_WOLF_MEDALLION_OFF_RPG));

		MEDALLION_ACTIVATE_SOUND= registerSound("medallion_activate_sound");
		MEDALLION_RESTART_COOLDOWN_SOUND = registerSound("medallion_restartcooldown_sound");
		WOLF_MEDALLION_SOUND = registerSound("medallion-wolf_sound");
		CAT_MEDALLION_SOUND = registerSound("medallion-cat_sound");
		BEAR_MEDALLION_SOUND = registerSound("medallion-bear_sound");
		GRIFFIN_MEDALLION_SOUND = registerSound("medallion-griffin_sound");
		VIPER_MEDALLION_SOUND = registerSound("medallion-viper_sound");
		MANTICORE_MEDALLION_SOUND = registerSound("medallion-manticore_sound");

		STRONG_WOLF_MEDALLION_SOUND = registerSound("medallion-wolf-strong_sound");
		STRONG_CAT_MEDALLION_SOUND = registerSound("medallion-cat-strong_sound");
		STRONG_BEAR_MEDALLION_SOUND = registerSound("medallion-bear-strong_sound");
		STRONG_GRIFFIN_MEDALLION_SOUND = registerSound("medallion-griffin-strong_sound");
		STRONG_VIPER_MEDALLION_SOUND = registerSound("medallion-viper-strong_sound");
		STRONG_MANTICORE_MEDALLION_SOUND = registerSound("medallion-manticore-strong_sound");
	}

	private JsonObject create(TagKey<Item> addition, Item medallion){
		return WitcherMedallions_MainCommon.create(addition.location().toString(), medallion, FabricLoader.getInstance().isModLoaded("witcher_rpg")? "witcher_rpg:silver_ingot": BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), true);
	}

	private JsonObject create(Item addition, Item medallion){
		return WitcherMedallions_MainCommon.create(BuiltInRegistries.ITEM.getKey(addition).toString(), medallion, FabricLoader.getInstance().isModLoaded("witcher_rpg")? "witcher_rpg:silver_ingot": BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), false);
	}

}