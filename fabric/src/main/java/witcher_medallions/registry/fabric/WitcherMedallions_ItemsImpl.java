package witcher_medallions.registry.fabric;

import fabric.witcher_medallions.items.MedallionOffBaseItem;
import fabric.witcher_medallions.items.medallions.*;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import witcher_medallions.WitcherMedallions_Main;
import witcher_medallions.registry.WitcherMedallions_Items;

@SuppressWarnings("unused")
public class WitcherMedallions_ItemsImpl {

    public static Item Witcher_WolfMedallion;
    public static Item Witcher_OffWolfMedallion;

    public static Item Witcher_CatMedallion;
    public static Item Witcher_OffCatMedallion;

    public static Item Witcher_BearMedallion;
    public static Item Witcher_OffBearMedallion;

    public static Item Witcher_GriffinMedallion;
    public static Item Witcher_OffGriffinMedallion;

    public static Item Witcher_ViperMedallion;
    public static Item Witcher_OffViperMedallion;

    public static Item Witcher_ManticoreMedallion;
    public static Item Witcher_OffManticoreMedallion;

    public static Item Witcher_AncientWolfMedallion;
    public static Item Witcher_OffAncientWolfMedallion;

    public static Item Witcher_MagicCore;

    public static void initItems() {
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
    
    public static Item Witcher_WolfMedallion(){return Witcher_WolfMedallion;}
    public static Item Witcher_OffWolfMedallion(){return Witcher_OffWolfMedallion;}
    
    public static Item Witcher_CatMedallion(){return Witcher_CatMedallion;}
    public static Item Witcher_OffCatMedallion(){return Witcher_OffCatMedallion;}
    
    public static Item Witcher_BearMedallion(){return Witcher_BearMedallion;}
    public static Item Witcher_OffBearMedallion(){return Witcher_OffBearMedallion;}
    
    public static Item Witcher_GriffinMedallion(){return Witcher_GriffinMedallion;}
    public static Item Witcher_OffGriffinMedallion(){return Witcher_OffGriffinMedallion;}
    
    public static Item Witcher_ViperMedallion(){return Witcher_ViperMedallion;}
    public static Item Witcher_OffViperMedallion(){return Witcher_OffViperMedallion;}

    public static Item Witcher_ManticoreMedallion(){return Witcher_ManticoreMedallion;}
    public static Item Witcher_OffManticoreMedallion(){return Witcher_OffManticoreMedallion;}

    public static Item Witcher_AncientWolfMedallion(){return Witcher_AncientWolfMedallion;}
    public static Item Witcher_OffAncientWolfMedallion(){return Witcher_OffAncientWolfMedallion;}

    public static Item Witcher_MagicCore(){return Witcher_MagicCore;}

    public static OwoItemGroup owoItemGroup;

    public static void initItemGroups(){
        owoItemGroup =
                Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB,
                        ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "main"), WitcherMedallions_Items.createGroup());
    }

    /**
     * Register an item
     * @param name The name of the item
     * @param item The item to register
     * @return The registered item
     */
    public static Item registerItem(String name, Item item) {
        return Registry.register(BuiltInRegistries.ITEM, ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, name), item);
    }
}
