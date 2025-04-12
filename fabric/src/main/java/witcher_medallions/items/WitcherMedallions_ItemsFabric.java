package witcher_medallions.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import witcher_medallions.WitcherMedallions_MainCommon;
import witcher_medallions.items.medallions.*;

public class WitcherMedallions_ItemsFabric {

	//WolfMedallion
	//Wolf Medallion (wolf-medallion)
	public static Item Witcher_WolfMedallion;
	//Deactivated Wolf Medallion (wolf-medallion-off)
	public static Item Witcher_OffWolfMedallion;

	//CatMedallion
	//Cat Medallion (cat-medallion)
	public static Item Witcher_CatMedallion;
	//Deactivated Cat Medallion (cat-medallion-off)
	public static Item Witcher_OffCatMedallion;

	//BearMedallion
	//Bear Medallion (bear-medallion)
	public static Item Witcher_BearMedallion;
	//Deactivated Bear Medallion (bear-medallion-off)
	public static Item Witcher_OffBearMedallion;

	//GriffinMedallion
	//Griffin Medallion (griffin-medallion)
	public static Item Witcher_GriffinMedallion;
	//Deactivated Griffin Medallion (griffin-medallion-off)
	public static Item Witcher_OffGriffinMedallion;

	//ViperMedallion
	//Viper Medallion (viper-medallion)
	public static Item Witcher_ViperMedallion;
	//Deactivated Viper Medallion (viper-medallion-off)
	public static Item Witcher_OffViperMedallion;

	//OtherItems
	//Magic Core (magic-nucleus)
	public static Item Witcher_MagicCore;

	//ManticoreMedallion
	//Manticore Medallion (manticore-medallion)
	public static Item Witcher_ManticoreMedallion;
	//Deactivated Manticore Medallion (manticore-medallion-off)
	public static Item Witcher_OffManticoreMedallion;

	//AncientWolfMedallion
	//Ancient Wolf Medallion (ancient-wolf-medallion)
	public static Item Witcher_AncientWolfMedallion;
	//Deactivated Ancient Wolf Medallion (ancient-wolf-medallion-off)
	public static Item Witcher_OffAncientWolfMedallion;


	public static void registerFabricItems() {
		//WolfMedallion
		//Wolf Medallion (wolf-medallion)
		Witcher_WolfMedallion = registerItem("wolf-medallion",
				new WolfMedallionItem());

		//Deactivated Wolf Medallion (wolf-medallion-off)
		Witcher_OffWolfMedallion = registerItem("wolf-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 0));

		//CatMedallion
		//Cat Medallion (cat-medallion)
		Witcher_CatMedallion = registerItem("cat-medallion",
				new CatMedallionItem());

		//Deactivated Cat Medallion (cat-medallion-off)
		Witcher_OffCatMedallion = registerItem("cat-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 1));

		//BearMedallion
		//Bear Medallion (bear-medallion)
		Witcher_BearMedallion = registerItem("bear-medallion",
				new BearMedallionItem());

		//Deactivated Bear Medallion (bear-medallion-off)
		Witcher_OffBearMedallion = registerItem("bear-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 2));

		//GriffinMedallion
		//Griffin Medallion (griffin-medallion)
		Witcher_GriffinMedallion = registerItem("griffin-medallion",
				new GriffinMedallionItem());

		//Deactivated Griffin Medallion (griffin-medallion-off)
		Witcher_OffGriffinMedallion = registerItem("griffin-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 3));

		//ViperMedallion
		//Viper Medallion (viper-medallion)
		Witcher_ViperMedallion = registerItem("viper-medallion",
				new ViperMedallionItem());

		//Deactivated Viper Medallion (viper-medallion-off)
		Witcher_OffViperMedallion = registerItem("viper-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 4));

		//ManticoreMedallion
		//Manticore Medallion (manticore-medallion)
		Witcher_ManticoreMedallion = registerItem("manticore-medallion",
				new ManticoreMedallionItem());

		//Deactivated Manticore Medallion (manticore-medallion-off)
		Witcher_OffManticoreMedallion = registerItem("manticore-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 5));

		//AncientWolfMedallion
		//Ancient Wolf Medallion (ancient-wolf-medallion)
		Witcher_AncientWolfMedallion = registerItem("ancient-wolf-medallion",
				new AncientWolfMedallionItem());

		//Deactivated Ancient Wolf Medallion (ancient-wolf-medallion-off)
		Witcher_OffAncientWolfMedallion = registerItem("ancient-wolf-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 6));

		Witcher_MagicCore = registerItem("magic-nucleus",
				new Item(new Item.Properties().stacksTo(16)));
	}




	//ItemGroup
	@SuppressWarnings("unused")
	public static final CreativeModeTab WitcherMedallions = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
			ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "witcher_medallions"),
			FabricItemGroup.builder().title(Component.translatable("itemgroup."+WitcherMedallions_MainCommon.MOD_ID))
					.icon(() -> new ItemStack(Witcher_WolfMedallion))
					.displayItems((displayContext, entries) -> {
						//Medallions
						entries.accept(Witcher_WolfMedallion);
						entries.accept(Witcher_CatMedallion);
						entries.accept(Witcher_BearMedallion);
						entries.accept(Witcher_GriffinMedallion);
						entries.accept(Witcher_ViperMedallion);
						entries.accept(Witcher_ManticoreMedallion);
						entries.accept(Witcher_AncientWolfMedallion);

						//Medallions Off
						entries.accept(Witcher_OffWolfMedallion);
						entries.accept(Witcher_OffCatMedallion);
						entries.accept(Witcher_OffBearMedallion);
						entries.accept(Witcher_OffGriffinMedallion);
						entries.accept(Witcher_OffViperMedallion);
						entries.accept(Witcher_OffManticoreMedallion);
						entries.accept(Witcher_OffAncientWolfMedallion);

						//Magic Nucleus
						entries.accept(Witcher_MagicCore);
					}).build());

	/**
	 * Register an item
	 * @param name
	 * @param item
	 * @return
	 */
	public static Item registerItem(String name, Item item) {
		return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, name), item);
	}
}
