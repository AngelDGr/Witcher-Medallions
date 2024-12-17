package witcher_medallions.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.items.medallions.*;

public class WitcherMedallions_Items {
	// Register method
	public static Item registerItem(String name, Item item) {
		return Registry.register(Registries.ITEM, new Identifier(WitcherMedallions_Main.MOD_ID, name), item);
	}

	//Register sound
	public static SoundEvent registerSoundEvent(String name){
		Identifier id = new Identifier(WitcherMedallions_Main.MOD_ID, name);
		return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
	}

	public static final TagKey<Item> BEAR_MEDALLION_INGREDIENT = of("bear_medallion_ingredient");
	public static final TagKey<Item> CAT_MEDALLION_INGREDIENT = of("cat_medallion_ingredient");
	public static final TagKey<Item> MANTICORE_MEDALLION_INGREDIENT = of("manticore_medallion_ingredient");
	public static final TagKey<Item> MAGIC_CATALYST = of("magic_catalyst");
	public static final TagKey<Item> METAL_BASE_MEDALLIONS = of("metal_base_medallion");

	private static TagKey<Item> of(String id) {
		return TagKey.of(RegistryKeys.ITEM, new Identifier(WitcherMedallions_Main.MOD_ID,id));
	}

	public static SoundEvent MEDALLION_ACTIVATE_SOUND= registerSoundEvent("medallion_activate_sound");
	public static SoundEvent MEDALLION_RESTART_COOLDOWN_SOUND = registerSoundEvent("medallion_restartcooldown_sound");
	public static SoundEvent WOLF_MEDALLION_SOUND = registerSoundEvent("medallion-wolf_sound");
	public static SoundEvent CAT_MEDALLION_SOUND = registerSoundEvent("medallion-cat_sound");
	public static SoundEvent BEAR_MEDALLION_SOUND = registerSoundEvent("medallion-bear_sound");
	public static SoundEvent GRIFFIN_MEDALLION_SOUND = registerSoundEvent("medallion-griffin_sound");
	public static SoundEvent VIPER_MEDALLION_SOUND = registerSoundEvent("medallion-viper_sound");
	public static SoundEvent MANTICORE_MEDALLION_SOUND = registerSoundEvent("medallion-manticore_sound");

	public static SoundEvent STRONG_WOLF_MEDALLION_SOUND = registerSoundEvent("medallion-wolf-strong_sound");
	public static SoundEvent STRONG_CAT_MEDALLION_SOUND = registerSoundEvent("medallion-cat-strong_sound");
	public static SoundEvent STRONG_BEAR_MEDALLION_SOUND = registerSoundEvent("medallion-bear-strong_sound");
	public static SoundEvent STRONG_GRIFFIN_MEDALLION_SOUND = registerSoundEvent("medallion-griffin-strong_sound");
	public static SoundEvent STRONG_VIPER_MEDALLION_SOUND = registerSoundEvent("medallion-viper-strong_sound");
	public static SoundEvent STRONG_MANTICORE_MEDALLION_SOUND = registerSoundEvent("medallion-manticore-strong_sound");


	//WolfMedallion
    	//Wolf Medallion (wolf-medallion)
		public static final Item Witcher_WolfMedallion = registerItem("wolf-medallion", 
		new WolfMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Wolf Medallion (wolf-medallion-off)
		public static final Item Witcher_OffWolfMedallion = registerItem("wolf-medallion-off",
				new MedallionOffBaseItem(new FabricItemSettings().maxCount(1), 0));

	//CatMedallion
		//Cat Medallion (cat-medallion)
		public static final Item Witcher_CatMedallion = registerItem("cat-medallion",
			new CatMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Cat Medallion (cat-medallion-off)
		public static final Item Witcher_OffCatMedallion = registerItem("cat-medallion-off",
				new MedallionOffBaseItem(new FabricItemSettings().maxCount(1), 1));

	//BearMedallion
		//Bear Medallion (bear-medallion)
		public static final Item Witcher_BearMedallion = registerItem("bear-medallion", 
		new BearMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Bear Medallion (bear-medallion-off)
		public static final Item Witcher_OffBearMedallion = registerItem("bear-medallion-off",
				new MedallionOffBaseItem(new FabricItemSettings().maxCount(1), 2));

	//GriffinMedallion
		//Griffin Medallion (griffin-medallion)
		public static final Item Witcher_GriffinMedallion = registerItem("griffin-medallion", 
		new GriffinMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Griffin Medallion (griffin-medallion-off)
		public static final Item Witcher_OffGriffinMedallion = registerItem("griffin-medallion-off",
				new MedallionOffBaseItem(new FabricItemSettings().maxCount(1), 3));

	//ViperMedallion
		//Viper Medallion (viper-medallion)
		public static final Item Witcher_ViperMedallion = registerItem("viper-medallion", 
		new ViperMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Viper Medallion (viper-medallion-off)
		public static final Item Witcher_OffViperMedallion = registerItem("viper-medallion-off",
				new MedallionOffBaseItem(new FabricItemSettings().maxCount(1), 4));

	//ManticoreMedallion
		//Manticore Medallion (manticore-medallion)
		public static final Item Witcher_ManticoreMedallion = registerItem("manticore-medallion",
			new ManticoreMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Manticore Medallion (manticore-medallion-off)
		public static final Item Witcher_OffManticoreMedallion = registerItem("manticore-medallion-off",
				new MedallionOffBaseItem(new FabricItemSettings().maxCount(1), 5));

	//AncientWolfMedallion
		//Ancient Wolf Medallion (ancient-wolf-medallion)
		public static final Item Witcher_AncientWolfMedallion = registerItem("ancient-wolf-medallion",
			new AncientWolfMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Ancient Wolf Medallion (ancient-wolf-medallion-off)
		public static final Item Witcher_OffAncientWolfMedallion = registerItem("ancient-wolf-medallion-off",
				new MedallionOffBaseItem(new FabricItemSettings().maxCount(1), 6));

	//OtherItems
		//Magic Core (magic-nucleus)
		@SuppressWarnings("all")
		public static final Item Witcher_MagicCore = registerItem("magic-nucleus",
			new Item(new FabricItemSettings().maxCount(16)));

	public static void registerModItems() {
		WitcherMedallions_Main.LOGGER.info("Registering Mod Items for " + WitcherMedallions_Main.MOD_ID);
	}

}
