package witcher_medallions.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import witcher_medallions.WitcherMedallions_Main;


public class WitcherMedallions_ItemGroups {
	//ItemGroup
	@SuppressWarnings("unused")
		public static final ItemGroup WitcherMedallions = Registry.register(Registries.ITEM_GROUP,
				Identifier.of(WitcherMedallions_Main.MOD_ID, "witcher_medallions"),
				FabricItemGroup.builder().displayName(Text.translatable("itemgroup.witcher-medallions"))
						.icon(() -> new ItemStack(WitcherMedallions_Items.Witcher_WolfMedallion))
						.entries((displayContext, entries) -> {
							//Medallions
							//Medallions
							entries.add(WitcherMedallions_Items.Witcher_WolfMedallion);
							entries.add(WitcherMedallions_Items.Witcher_CatMedallion);
							entries.add(WitcherMedallions_Items.Witcher_BearMedallion);
							entries.add(WitcherMedallions_Items.Witcher_GriffinMedallion);
							entries.add(WitcherMedallions_Items.Witcher_ViperMedallion);
							entries.add(WitcherMedallions_Items.Witcher_ManticoreMedallion);
							entries.add(WitcherMedallions_Items.Witcher_AncientWolfMedallion);

							//Medallions Off
							entries.add(WitcherMedallions_Items.Witcher_OffWolfMedallion);
							entries.add(WitcherMedallions_Items.Witcher_OffCatMedallion);
							entries.add(WitcherMedallions_Items.Witcher_OffBearMedallion);
							entries.add(WitcherMedallions_Items.Witcher_OffGriffinMedallion);
							entries.add(WitcherMedallions_Items.Witcher_OffViperMedallion);
							entries.add(WitcherMedallions_Items.Witcher_OffManticoreMedallion);
							entries.add(WitcherMedallions_Items.Witcher_OffAncientWolfMedallion);

							//Magic Nucleus
							entries.add(WitcherMedallions_Items.Witcher_MagicCore);

						}).build());

	public static void registerGroupItems() {
		WitcherMedallions_Main.LOGGER.info("Registering Item Groups for " + WitcherMedallions_Main.MOD_ID);
	}

}

