package witcher_medallions.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import witcher_medallions.WitcherMedallions_MainCommon;

import java.util.function.Supplier;

public class WitcherMedallions_ItemsCommon {

    public static final TagKey<Item> BEAR_MEDALLION_INGREDIENT = of("bear_medallion_ingredient");
    public static final TagKey<Item> CAT_MEDALLION_INGREDIENT = of("cat_medallion_ingredient");
    public static final TagKey<Item> MANTICORE_MEDALLION_INGREDIENT = of("manticore_medallion_ingredient");
    public static final TagKey<Item> MAGIC_CATALYST = of("magic_catalyst");

    private static TagKey<Item> of(String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID,id));
    }

    public static Supplier<Item> Witcher_WolfMedallion;

    public static Supplier<Item> Witcher_OffWolfMedallion;

    public static Supplier<Item> Witcher_CatMedallion;

    public static Supplier<Item> Witcher_OffCatMedallion;

    public static Supplier<Item> Witcher_BearMedallion;

    public static Supplier<Item> Witcher_OffBearMedallion;

    public static Supplier<Item> Witcher_GriffinMedallion;

    public static Supplier<Item> Witcher_OffGriffinMedallion;

    public static Supplier<Item> Witcher_ViperMedallion;

    public static Supplier<Item> Witcher_OffViperMedallion;

    public static Supplier<Item> Witcher_ManticoreMedallion;

    public static Supplier<Item> Witcher_OffManticoreMedallion;

    public static Supplier<Item> Witcher_AncientWolfMedallion;

    public static Supplier<Item> Witcher_OffAncientWolfMedallion;

    public static Supplier<Item> Witcher_MagicCore;

    public static void registerItems() {
    }

}
