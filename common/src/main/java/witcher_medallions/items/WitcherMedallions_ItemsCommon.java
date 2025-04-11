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

    //WolfMedallion
    //Wolf Medallion (wolf-medallion)
    public static Item Witcher_WolfMedallion;
    public static Supplier<Item> Witcher_WolfMedallion_Sup;

    //Deactivated Wolf Medallion (wolf-medallion-off)
    public static Item Witcher_OffWolfMedallion;
    public static Supplier<Item> Witcher_OffWolfMedallion_Sup;

    //CatMedallion
    //Cat Medallion (cat-medallion)
    public static Item Witcher_CatMedallion;
    public static Supplier<Item> Witcher_CatMedallion_Sup;

    //Deactivated Cat Medallion (cat-medallion-off)
    public static Item Witcher_OffCatMedallion;
    public static Supplier<Item> Witcher_OffCatMedallion_Sup;

    //BearMedallion
    //Bear Medallion (bear-medallion)
    public static Item Witcher_BearMedallion;
    public static Supplier<Item> Witcher_BearMedallion_Sup;

    //Deactivated Bear Medallion (bear-medallion-off)
    public static Item Witcher_OffBearMedallion;
    public static Supplier<Item> Witcher_OffBearMedallion_Sup;

    //GriffinMedallion
    //Griffin Medallion (griffin-medallion)
    public static Item Witcher_GriffinMedallion;
    public static Supplier<Item> Witcher_GriffinMedallion_Sup;

    //Deactivated Griffin Medallion (griffin-medallion-off)
    public static Item Witcher_OffGriffinMedallion;
    public static Supplier<Item> Witcher_OffGriffinMedallion_Sup;

    //ViperMedallion
    //Viper Medallion (viper-medallion)
    public static Item Witcher_ViperMedallion;
    public static Supplier<Item> Witcher_ViperMedallion_Sup;

    //Deactivated Viper Medallion (viper-medallion-off)
    public static Item Witcher_OffViperMedallion;
    public static Supplier<Item> Witcher_OffViperMedallion_Sup;

    //ManticoreMedallion
    //Manticore Medallion (manticore-medallion)
    public static Item Witcher_ManticoreMedallion;
    public static Supplier<Item> Witcher_ManticoreMedallion_Sup;

    //Deactivated Manticore Medallion (manticore-medallion-off)
    public static Item Witcher_OffManticoreMedallion;
    public static Supplier<Item> Witcher_OffManticoreMedallion_Sup;

    //AncientWolfMedallion
    //Ancient Wolf Medallion (ancient-wolf-medallion)
    public static Item Witcher_AncientWolfMedallion;
    public static Supplier<Item> Witcher_AncientWolfMedallion_Sup;

    //Deactivated Ancient Wolf Medallion (ancient-wolf-medallion-off)
    public static Item Witcher_OffAncientWolfMedallion;
    public static Supplier<Item> Witcher_OffAncientWolfMedallion_Sup;

    //OtherItems
    //Magic Core (magic-nucleus)
    public static Item Witcher_MagicCore;
    public static Supplier<Item> Witcher_MagicCore_Sup;

    public static void registerItems() {
    }

}
