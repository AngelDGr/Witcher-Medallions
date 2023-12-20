package witchermedallions.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;

import witchermedallions.items.gecko.item.*;
import witchermedallions.items.gecko.item.off.*;
import witchermedallions.witcherMod;

public class ModItems {
		// Register method
		public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(witcherMod.MODID, name), item);
    	}

		//Register sound
		public static SoundEvent registerSoundEvent(String name){
			Identifier id = new Identifier(witcherMod.MODID, name);
			return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
		}

		//Register items to group
		public static void	registerModItem(Item item){
			ItemGroupEvents.modifyEntriesEvent(WITCHERMEDALLIONSGROUP).register(entries -> entries.add(item));
		}
	private static final RegistryKey<ItemGroup> WITCHERMEDALLIONSGROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(witcherMod.MODID, "witcher-medallions"));

	public static SoundEvent MEDALLION_ACTIVATE_SOUND= registerSoundEvent("medallion_activate_sound");
		public static SoundEvent MEDALLION_RESTARTCOOLDOWN_SOUND= registerSoundEvent("medallion_restartcooldown_sound");
		public static SoundEvent WOLFMEDALLION_SOUND= registerSoundEvent("medallion-wolf_sound");
		public static SoundEvent CATMEDALLION_SOUND= registerSoundEvent("medallion-cat_sound");
		public static SoundEvent BEARMEDALLION_SOUND= registerSoundEvent("medallion-bear_sound");
		public static SoundEvent GRIFFINMEDALLION_SOUND= registerSoundEvent("medallion-griffin_sound");
		public static SoundEvent VIPERMEDALLION_SOUND= registerSoundEvent("medallion-viper_sound");
		public static SoundEvent MANTICOREMEDALLION_SOUND= registerSoundEvent("medallion-manticore_sound");
	
	//Items Creation

	//WolfMedallion
    	//Wolf Medallion (wolf-medallion)
		public static final Item Witcher_WolfMedallion = registerItem("wolf-medallion", 
		new WolfMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Wolf Medallion (wolf-medallion-off)
		public static final Item Witcher_OffWolfMedallion = registerItem("wolf-medallion-off",
			new WolfMedallionOffItem(new FabricItemSettings().maxCount(1)));


	//CatMedallion
		//Cat Medallion (cat-medallion)
		public static final Item Witcher_CatMedallion = registerItem("cat-medallion", 
		new CatMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Cat Medallion (cat-medallion-off)
		public static final Item Witcher_OffCatMedallion = registerItem("cat-medallion-off",
			new CatMedallionOffItem(new FabricItemSettings().maxCount(1)));

	//BearMedallion
		//Bear Medallion (bear-medallion)
		public static final Item Witcher_BearMedallion = registerItem("bear-medallion", 
		new BearMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Bear Medallion (bear-medallion-off)
		public static final Item Witcher_OffBearMedallion = registerItem("bear-medallion-off",
			new BearMedallionOffItem(new FabricItemSettings().maxCount(1)));

	//GriffinMedallion
		//Griffin Medallion (griffin-medallion)
		public static final Item Witcher_GriffinMedallion = registerItem("griffin-medallion", 
		new GriffinMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Griffin Medallion (griffin-medallion-off)
		public static final Item Witcher_OffGriffinMedallion = registerItem("griffin-medallion-off",
			new GriffinMedallionOffItem(new FabricItemSettings().maxCount(1)));

	//ViperMedallion
		//Viper Medallion (viper-medallion)
		public static final Item Witcher_ViperMedallion = registerItem("viper-medallion", 
		new ViperMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Viper Medallion (viper-medallion-off)
		public static final Item Witcher_OffViperMedallion = registerItem("viper-medallion-off",
			new ViperMedallionOffItem(new FabricItemSettings().maxCount(1)));

	//ManticoreMedallion
		//Manticore Medallion (manticore-medallion)
		public static final Item Witcher_ManticoreMedallion = registerItem("manticore-medallion", 
		new ManticoreMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Manticore Medallion (manticore-medallion-off)
		public static final Item Witcher_OffManticoreMedallion = registerItem("manticore-medallion-off",
			new ManticoreMedallionOffItem(new FabricItemSettings().maxCount(1)));

	//AncientWolfMedallion
		//Ancient Wolf Medallion (ancient-wolf-medallion)
		public static final Item Witcher_AncientWolfMedallion = registerItem("ancient-wolf-medallion", 
		new AncientWolfMedallionItem(new FabricItemSettings().maxCount(1)));

		//Deactivated Ancient Wolf Medallion (ancient-wolf-medallion-off)
		public static final Item Witcher_OffAncientWolfMedallion = registerItem("ancient-wolf-medallion-off",
			new AncientWolfMedallionOffItem(new FabricItemSettings().maxCount(1)));

	//OtherItems
		//Magic Core (magic-nucleus)
		@SuppressWarnings("all")
		public static final Item Witcher_MagicCore = registerItem("magic-nucleus",
		new Item(new FabricItemSettings().maxCount(16)));

	public static void registerModItems() {

		witcherMod.LOGGER.info("Registering Mod Items for " + witcherMod.MODID);
	}

}
