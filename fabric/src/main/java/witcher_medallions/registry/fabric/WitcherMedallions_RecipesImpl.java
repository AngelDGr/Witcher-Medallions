package witcher_medallions.registry.fabric;

import com.google.gson.JsonObject;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.registry.WitcherMedallions_Items;

@SuppressWarnings("unused")
public class WitcherMedallions_RecipesImpl {

    public static void initRecipes() {
        WitcherMedallions_Main.WOLF_MEDALLION_OFF_RPG = create(Items.BONE, WitcherMedallions_Items.Witcher_OffWolfMedallion());
        WitcherMedallions_Main.CAT_MEDALLION_OFF_RPG = create(WitcherMedallions_Items.CAT_MEDALLION_INGREDIENT, WitcherMedallions_Items.Witcher_OffCatMedallion());
        WitcherMedallions_Main.BEAR_MEDALLION_OFF_RPG = create(WitcherMedallions_Items.BEAR_MEDALLION_INGREDIENT, WitcherMedallions_Items.Witcher_OffBearMedallion());
        WitcherMedallions_Main.GRIFFIN_MEDALLION_OFF_RPG = create(Items.FEATHER, WitcherMedallions_Items.Witcher_OffGriffinMedallion());
        WitcherMedallions_Main.VIPER_MEDALLION_OFF_RPG = create(Items.FERMENTED_SPIDER_EYE, WitcherMedallions_Items.Witcher_OffViperMedallion());
        WitcherMedallions_Main.MANTICORE_MEDALLION_OFF_RPG = create(WitcherMedallions_Items.MANTICORE_MEDALLION_INGREDIENT, WitcherMedallions_Items.Witcher_OffManticoreMedallion());
        WitcherMedallions_Main.ANCIENT_WOLF_MEDALLION_OFF_RPG = create(Items.PAPER, WitcherMedallions_Items.Witcher_OffAncientWolfMedallion());

        WitcherMedallions_Main.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "wolf-medallion-off"), WitcherMedallions_Main.WOLF_MEDALLION_OFF_RPG));
        WitcherMedallions_Main.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "cat-medallion-off"), WitcherMedallions_Main.CAT_MEDALLION_OFF_RPG));
        WitcherMedallions_Main.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "bear-medallion-off"), WitcherMedallions_Main.BEAR_MEDALLION_OFF_RPG));
        WitcherMedallions_Main.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "griffin-medallion-off"), WitcherMedallions_Main.GRIFFIN_MEDALLION_OFF_RPG));
        WitcherMedallions_Main.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "viper-medallion-off"), WitcherMedallions_Main.VIPER_MEDALLION_OFF_RPG));
        WitcherMedallions_Main.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "manticore-medallion-off"), WitcherMedallions_Main.MANTICORE_MEDALLION_OFF_RPG));
        WitcherMedallions_Main.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "ancient-wolf-medallion-off"), WitcherMedallions_Main.ANCIENT_WOLF_MEDALLION_OFF_RPG));
    }

    private static JsonObject create(TagKey<Item> addition, Item medallion){
        return WitcherMedallions_Main.create(addition.location().toString(), medallion, FabricLoader.getInstance().isModLoaded("witcher_rpg")? "witcher_rpg:silver_ingot": BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), true);
    }

    private static JsonObject create(Item addition, Item medallion){
        return WitcherMedallions_Main.create(BuiltInRegistries.ITEM.getKey(addition).toString(), medallion, FabricLoader.getInstance().isModLoaded("witcher_rpg")? "witcher_rpg:silver_ingot": BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), false);
    }
}
