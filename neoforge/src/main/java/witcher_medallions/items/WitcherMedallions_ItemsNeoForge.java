package witcher_medallions.items;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import witcher_medallions.WitcherMedallions_MainCommon;
import witcher_medallions.WitcherMedallions_Registries;
import witcher_medallions.items.medallions.*;

import java.util.function.Supplier;

@Mod(WitcherMedallions_MainCommon.MOD_ID)
public class WitcherMedallions_ItemsNeoForge {

    public static void registerItems(){
        //WolfMedallion
        //Wolf Medallion (wolf-medallion)
        WitcherMedallions_ItemsCommon.Witcher_WolfMedallion_Sup = registerItem("wolf-medallion",
                WolfMedallionItem::new);

        //Deactivated Wolf Medallion (wolf-medallion-off)
        WitcherMedallions_ItemsCommon.Witcher_OffWolfMedallion_Sup = registerItem("wolf-medallion-off",
                ()-> new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 0));

        //CatMedallion
        //Cat Medallion (cat-medallion)
        WitcherMedallions_ItemsCommon.Witcher_CatMedallion_Sup = registerItem("cat-medallion",
                CatMedallionItem::new);

        //Deactivated Cat Medallion (cat-medallion-off)
        WitcherMedallions_ItemsCommon.Witcher_OffCatMedallion_Sup = registerItem("cat-medallion-off",
                ()-> new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 1));

        //BearMedallion
        //Bear Medallion (bear-medallion)
        WitcherMedallions_ItemsCommon.Witcher_BearMedallion_Sup = registerItem("bear-medallion",
                BearMedallionItem::new);

        //Deactivated Bear Medallion (bear-medallion-off)
        WitcherMedallions_ItemsCommon.Witcher_OffBearMedallion_Sup = registerItem("bear-medallion-off",
                ()-> new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 2));

        //GriffinMedallion
        //Griffin Medallion (griffin-medallion)
        WitcherMedallions_ItemsCommon.Witcher_GriffinMedallion_Sup = registerItem("griffin-medallion",
                GriffinMedallionItem::new);

        //Deactivated Griffin Medallion (griffin-medallion-off)
        WitcherMedallions_ItemsCommon.Witcher_OffGriffinMedallion_Sup = registerItem("griffin-medallion-off",
                ()-> new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 3));

        //ViperMedallion
        //Viper Medallion (viper-medallion)
        WitcherMedallions_ItemsCommon.Witcher_ViperMedallion_Sup = registerItem("viper-medallion",
                ViperMedallionItem::new);

        //Deactivated Viper Medallion (viper-medallion-off)
        WitcherMedallions_ItemsCommon.Witcher_OffViperMedallion_Sup = registerItem("viper-medallion-off",
                ()-> new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 4));

        //ManticoreMedallion
        //Manticore Medallion (manticore-medallion)
        WitcherMedallions_ItemsCommon.Witcher_ManticoreMedallion_Sup = registerItem("manticore-medallion",
                ManticoreMedallionItem::new);

        //Deactivated Manticore Medallion (manticore-medallion-off)
        WitcherMedallions_ItemsCommon.Witcher_OffManticoreMedallion_Sup = registerItem("manticore-medallion-off",
                ()-> new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 5));

        //AncientWolfMedallion
        //Ancient Wolf Medallion (ancient-wolf-medallion)
        WitcherMedallions_ItemsCommon.Witcher_AncientWolfMedallion_Sup = registerItem("ancient-wolf-medallion",
                AncientWolfMedallionItem::new);

        //Deactivated Ancient Wolf Medallion (ancient-wolf-medallion-off)
        WitcherMedallions_ItemsCommon.Witcher_OffAncientWolfMedallion_Sup = registerItem("ancient-wolf-medallion-off",
                ()-> new MedallionOffBaseItem(new Item.Properties().stacksTo(1), 6));


        WitcherMedallions_ItemsCommon.Witcher_MagicCore_Sup = registerItem("magic-nucleus",
                () -> new Item(new Item.Properties().stacksTo(16)));
    }

    //ItemGroup
    @SuppressWarnings("unused")
    public static final Supplier<CreativeModeTab> WitcherMedallions = WitcherMedallions_Registries.CREATIVE_MODE_TABS.register("example", () -> CreativeModeTab.builder()
                    //Set the title of the tab. Don't forget to add a translation!
                    .title(Component.translatable("itemgroup."+WitcherMedallions_MainCommon.MOD_ID))
                    //Set the icon of the tab.
                    .icon(() -> new ItemStack(WitcherMedallions_ItemsCommon.Witcher_WolfMedallion_Sup.get()))
                    //Add your items to the tab.
                    .displayItems((params, entries) -> {
                        //Medallions
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_WolfMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_CatMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_BearMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_GriffinMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_ViperMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_ManticoreMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_AncientWolfMedallion_Sup.get());

                        //Medallions Off
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffWolfMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffCatMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffBearMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffGriffinMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffViperMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffManticoreMedallion_Sup.get());
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_OffAncientWolfMedallion_Sup.get());

                        //Magic Nucleus
                        entries.accept(WitcherMedallions_ItemsCommon.Witcher_MagicCore_Sup.get());
                    }).build());

    /**
     * Register an item
     * @param name The item id
     * @param sup The supplier
     * @return An DeferredHolder of Item
     */
    public static DeferredHolder<Item, Item> registerItem(String name, Supplier<Item> sup) {
        return WitcherMedallions_Registries.ITEMS.register(name, sup);
    }
}
