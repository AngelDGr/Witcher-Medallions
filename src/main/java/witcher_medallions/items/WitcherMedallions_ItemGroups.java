package witcher_medallions.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import witcher_medallions.WitcherMedallions_Main;


public class WitcherMedallions_ItemGroups {
	//ItemGroup
	@SuppressWarnings("unused")
		public static final CreativeModeTab WitcherMedallions = Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
				ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "witcher_medallions"),
				FabricItemGroup.builder().title(Component.translatable("itemgroup.witcher-medallions"))
						.icon(() -> new ItemStack(WitcherMedallions_Items.Witcher_WolfMedallion))
						.displayItems((displayContext, entries) -> {
							//Medallions
							//Medallions
							entries.accept(WitcherMedallions_Items.Witcher_WolfMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_CatMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_BearMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_GriffinMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_ViperMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_ManticoreMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_AncientWolfMedallion);

							//Medallions Off
							entries.accept(WitcherMedallions_Items.Witcher_OffWolfMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_OffCatMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_OffBearMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_OffGriffinMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_OffViperMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_OffManticoreMedallion);
							entries.accept(WitcherMedallions_Items.Witcher_OffAncientWolfMedallion);

							//Magic Nucleus
							entries.accept(WitcherMedallions_Items.Witcher_MagicCore);

						}).build());

	public static void registerGroupItems() {
		WitcherMedallions_Main.LOGGER.info("Registering Item Groups for " + WitcherMedallions_Main.MOD_ID);
	}

}

