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

	public static void registerFabricItems() {
		//WolfMedallion
		//Wolf Medallion (wolf-medallion)
		WitcherMedallions_ItemsCommon.Witcher_WolfMedallion = registerItem("wolf-medallion",
				new WolfMedallionItem());

		//Deactivated Wolf Medallion (wolf-medallion-off)
		WitcherMedallions_ItemsCommon.Witcher_OffWolfMedallion = registerItem("wolf-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 0));

		//CatMedallion
		//Cat Medallion (cat-medallion)
		WitcherMedallions_ItemsCommon.Witcher_CatMedallion = registerItem("cat-medallion",
				new CatMedallionItem());

		//Deactivated Cat Medallion (cat-medallion-off)
		WitcherMedallions_ItemsCommon.Witcher_OffCatMedallion = registerItem("cat-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 1));

		//BearMedallion
		//Bear Medallion (bear-medallion)
		WitcherMedallions_ItemsCommon.Witcher_BearMedallion = registerItem("bear-medallion",
				new BearMedallionItem());

		//Deactivated Bear Medallion (bear-medallion-off)
		WitcherMedallions_ItemsCommon.Witcher_OffBearMedallion = registerItem("bear-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 2));

		//GriffinMedallion
		//Griffin Medallion (griffin-medallion)
		WitcherMedallions_ItemsCommon.Witcher_GriffinMedallion = registerItem("griffin-medallion",
				new GriffinMedallionItem());

		//Deactivated Griffin Medallion (griffin-medallion-off)
		WitcherMedallions_ItemsCommon.Witcher_OffGriffinMedallion = registerItem("griffin-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 3));

		//ViperMedallion
		//Viper Medallion (viper-medallion)
		WitcherMedallions_ItemsCommon.Witcher_ViperMedallion = registerItem("viper-medallion",
				new ViperMedallionItem());

		//Deactivated Viper Medallion (viper-medallion-off)
		WitcherMedallions_ItemsCommon.Witcher_OffViperMedallion = registerItem("viper-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 4));

		//ManticoreMedallion
		//Manticore Medallion (manticore-medallion)
		WitcherMedallions_ItemsCommon.Witcher_ManticoreMedallion = registerItem("manticore-medallion",
				new ManticoreMedallionItem());

		//Deactivated Manticore Medallion (manticore-medallion-off)
		WitcherMedallions_ItemsCommon.Witcher_OffManticoreMedallion = registerItem("manticore-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 5));

		//AncientWolfMedallion
		//Ancient Wolf Medallion (ancient-wolf-medallion)
		WitcherMedallions_ItemsCommon.Witcher_AncientWolfMedallion = registerItem("ancient-wolf-medallion",
				new AncientWolfMedallionItem());

		//Deactivated Ancient Wolf Medallion (ancient-wolf-medallion-off)
		WitcherMedallions_ItemsCommon.Witcher_OffAncientWolfMedallion = registerItem("ancient-wolf-medallion-off",
				new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 6));

		WitcherMedallions_ItemsCommon.Witcher_MagicCore = registerItem("magic-nucleus",
				new Item(new Item.Properties().stacksTo(16)));
	}

	//ItemGroup
	@SuppressWarnings("unused")
	public static final CreativeModeTab WitcherMedallions = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
			ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "witcher_medallions"),
			FabricItemGroup.builder().title(Component.translatable("itemgroup."+WitcherMedallions_MainCommon.MOD_ID))
					.icon(() -> new ItemStack(WitcherMedallions_ItemsCommon.Witcher_WolfMedallion))
					.displayItems((displayContext, entries) -> {
						//Medallions
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_WolfMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_CatMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_BearMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_GriffinMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_ViperMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_ManticoreMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_AncientWolfMedallion);

						//Medallions Off
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffWolfMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffCatMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffBearMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffGriffinMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffViperMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffManticoreMedallion);
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffAncientWolfMedallion);

						//Magic Nucleus
						entries.accept(WitcherMedallions_ItemsCommon.Witcher_MagicCore);
					}).build());


	public static Item registerItem(String name, Item item) {
		return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, name), item);
	}
}
