package witchermedallions.items;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;


import witchermedallions.witcherMod;


import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;


public class ModGroups{

	//ItemGroup
	public static final ItemGroup WitcherMedallions = FabricItemGroupBuilder.build(new Identifier(witcherMod.MODID, "witcher_medallions"),() -> new ItemStack(ModItems.Witcher_WolfMedallion));

	public static void registerGroupItems() {
		witcherMod.LOGGER.info("Registering Mod Items for " + witcherMod.MODID);
	}

}

