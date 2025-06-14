package witcher_medallions.registry.neoforge;


import io.wispforest.owo.itemgroup.OwoItemGroup;
import neoforge.witcher_medallions.WitcherMedallions_Registries;
import neoforge.witcher_medallions.items.medallions.*;
import net.minecraft.world.item.*;
import net.neoforged.neoforge.registries.DeferredHolder;
import witcher_medallions.registry.WitcherMedallions_Items;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class WitcherMedallions_ItemsImpl {


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

    public static void initItems(){
        //WolfMedallion
        //Wolf Medallion (wolf-medallion)
        Witcher_WolfMedallion = registerItem("wolf-medallion",
                WolfMedallionItem::new);

        //Deactivated Wolf Medallion (wolf-medallion-off)
        Witcher_OffWolfMedallion = registerItem("wolf-medallion-off",
                ()-> new neoforge.witcher_medallions.items.MedallionOffBaseItem(new Item.Properties().stacksTo(1), 0));

        //CatMedallion
        //Cat Medallion (cat-medallion)
        Witcher_CatMedallion = registerItem("cat-medallion",
                CatMedallionItem::new);

        //Deactivated Cat Medallion (cat-medallion-off)
        Witcher_OffCatMedallion = registerItem("cat-medallion-off",
                ()-> new neoforge.witcher_medallions.items.MedallionOffBaseItem(new Item.Properties().stacksTo(1), 1));

        //BearMedallion
        //Bear Medallion (bear-medallion)
        Witcher_BearMedallion = registerItem("bear-medallion",
                BearMedallionItem::new);

        //Deactivated Bear Medallion (bear-medallion-off)
        Witcher_OffBearMedallion = registerItem("bear-medallion-off",
                ()-> new neoforge.witcher_medallions.items.MedallionOffBaseItem(new Item.Properties().stacksTo(1), 2));

        //GriffinMedallion
        //Griffin Medallion (griffin-medallion)
        Witcher_GriffinMedallion = registerItem("griffin-medallion",
                GriffinMedallionItem::new);

        //Deactivated Griffin Medallion (griffin-medallion-off)
        Witcher_OffGriffinMedallion = registerItem("griffin-medallion-off",
                ()-> new neoforge.witcher_medallions.items.MedallionOffBaseItem(new Item.Properties().stacksTo(1), 3));

        //ViperMedallion
        //Viper Medallion (viper-medallion)
        Witcher_ViperMedallion = registerItem("viper-medallion",
                ViperMedallionItem::new);

        //Deactivated Viper Medallion (viper-medallion-off)
        Witcher_OffViperMedallion = registerItem("viper-medallion-off",
                ()-> new neoforge.witcher_medallions.items.MedallionOffBaseItem(new Item.Properties().stacksTo(1), 4));

        //ManticoreMedallion
        //Manticore Medallion (manticore-medallion)
        Witcher_ManticoreMedallion = registerItem("manticore-medallion",
                ManticoreMedallionItem::new);

        //Deactivated Manticore Medallion (manticore-medallion-off)
        Witcher_OffManticoreMedallion = registerItem("manticore-medallion-off",
                ()-> new neoforge.witcher_medallions.items.MedallionOffBaseItem(new Item.Properties().stacksTo(1), 5));

        //AncientWolfMedallion
        //Ancient Wolf Medallion (ancient-wolf-medallion)
        Witcher_AncientWolfMedallion = registerItem("ancient-wolf-medallion",
                AncientWolfMedallionItem::new);

        //Deactivated Ancient Wolf Medallion (ancient-wolf-medallion-off)
        Witcher_OffAncientWolfMedallion = registerItem("ancient-wolf-medallion-off",
                ()-> new neoforge.witcher_medallions.items.MedallionOffBaseItem(new Item.Properties().stacksTo(1), 6));


        Witcher_MagicCore = registerItem("magic-nucleus",
                () -> new Item(new Item.Properties().stacksTo(16)));
    }

    public static Item Witcher_WolfMedallion(){return Witcher_WolfMedallion.get();}
    public static Item Witcher_OffWolfMedallion(){return Witcher_OffWolfMedallion.get();}

    public static Item Witcher_CatMedallion(){return Witcher_CatMedallion.get();}
    public static Item Witcher_OffCatMedallion(){return Witcher_OffCatMedallion.get();}

    public static Item Witcher_BearMedallion(){return Witcher_BearMedallion.get();}
    public static Item Witcher_OffBearMedallion(){return Witcher_OffBearMedallion.get();}

    public static Item Witcher_GriffinMedallion(){return Witcher_GriffinMedallion.get();}
    public static Item Witcher_OffGriffinMedallion(){return Witcher_OffGriffinMedallion.get();}

    public static Item Witcher_ViperMedallion(){return Witcher_ViperMedallion.get();}
    public static Item Witcher_OffViperMedallion(){return Witcher_OffViperMedallion.get();}

    public static Item Witcher_ManticoreMedallion(){return Witcher_ManticoreMedallion.get();}
    public static Item Witcher_OffManticoreMedallion(){return Witcher_OffManticoreMedallion.get();}

    public static Item Witcher_AncientWolfMedallion(){return Witcher_AncientWolfMedallion.get();}
    public static Item Witcher_OffAncientWolfMedallion(){return Witcher_OffAncientWolfMedallion.get();}

    public static Item Witcher_MagicCore(){return Witcher_MagicCore.get();}

    public static DeferredHolder<CreativeModeTab, OwoItemGroup> owoItemGroup;

    public static void initItemGroups(){

        owoItemGroup =
                WitcherMedallions_Registries.CREATIVE_MODE_TABS.register(
                        "main", WitcherMedallions_Items::createGroup);

    }

    /**
     * Register an item
     * @param name The item id
     * @param sup The supplier
     * @return A DeferredHolder of Item
     */
    public static DeferredHolder<Item, Item> registerItem(String name, Supplier<Item> sup) {
        return WitcherMedallions_Registries.ITEMS.register(name, sup);
    }
}
