package witchermedallions.items;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import witchermedallions.witcherMod;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class ModGroups{

	public static void registerModItem(ItemGroup.Entries entries,Item item){
		entries.add(item);
	}

	//ItemGroup
		public static final ItemGroup WitcherMedallions = Registry.register(Registries.ITEM_GROUP,
				new Identifier(witcherMod.MODID, "witcher_medallions"),
				FabricItemGroup.builder().displayName(Text.translatable("itemgroup.witcher-medallions"))
						.icon(() -> new ItemStack(ModItems.Witcher_WolfMedallion))
						.entries((displayContext, entries) -> {
							//Medallions
							//Medallions
							registerModItem(entries,ModItems.Witcher_WolfMedallion);
							registerModItem(entries,ModItems.Witcher_CatMedallion);
							registerModItem(entries,ModItems.Witcher_BearMedallion);
							registerModItem(entries,ModItems.Witcher_GriffinMedallion);
							registerModItem(entries,ModItems.Witcher_ViperMedallion);
							registerModItem(entries,ModItems.Witcher_ManticoreMedallion);
							registerModItem(entries,ModItems.Witcher_AncientWolfMedallion);

							//Medallions Off
							registerModItem(entries,ModItems.Witcher_OffWolfMedallion);
							registerModItem(entries,ModItems.Witcher_OffCatMedallion);
							registerModItem(entries,ModItems.Witcher_OffBearMedallion);
							registerModItem(entries,ModItems.Witcher_OffGriffinMedallion);
							registerModItem(entries,ModItems.Witcher_OffViperMedallion);
							registerModItem(entries,ModItems.Witcher_OffManticoreMedallion);
							registerModItem(entries,ModItems.Witcher_OffAncientWolfMedallion);

							//Magic Nucleus
							registerModItem(entries,ModItems.Witcher_MagicCore);

						}).build());

	public static void registerGroupItems() {
		witcherMod.LOGGER.info("Registering Item Groups for " + witcherMod.MODID);
	}

}

