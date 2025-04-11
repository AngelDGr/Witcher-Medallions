package witcher_medallions;

import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Tuple;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import witcher_medallions.items.ICurioRendererMedallion;
import witcher_medallions.items.WitcherMedallions_ItemsCommon;
import witcher_medallions.items.WitcherMedallions_ItemsNeoForge;

@Mod(WitcherMedallions_MainCommon.MOD_ID)
public class WitcherMedallions_MainNeoForge {

    public WitcherMedallions_MainNeoForge(IEventBus eventBus) {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.
        WitcherMedallions_MainCommon.init();
        WitcherMedallions_ItemsNeoForge.registerItems();

        WitcherMedallions_Registries.ITEMS.register(eventBus);
        WitcherMedallions_Registries.CREATIVE_MODE_TABS.register(eventBus);
        eventBus.addListener(this::clientSetup);


        WitcherMedallions_MainCommon.WOLF_MEDALLION_OFF_RPG = create(Items.BONE, "wolf-medallion-off");
        WitcherMedallions_MainCommon.CAT_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.CAT_MEDALLION_INGREDIENT, "cat-medallion-off");
        WitcherMedallions_MainCommon.BEAR_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.BEAR_MEDALLION_INGREDIENT, "bear-medallion-off");
        WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_OFF_RPG = create(Items.FEATHER, "griffin-medallion-off");
        WitcherMedallions_MainCommon.VIPER_MEDALLION_OFF_RPG = create(Items.FERMENTED_SPIDER_EYE, "viper-medallion-off");
        WitcherMedallions_MainCommon.MANTICORE_MEDALLION_OFF_RPG = create(WitcherMedallions_ItemsCommon.MANTICORE_MEDALLION_INGREDIENT, "manticore-medallion-off");
        WitcherMedallions_MainCommon.ANCIENT_WOLF_MEDALLION_OFF_RPG = create(Items.PAPER, "ancient-wolf-medallion-off");

        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "wolf-medallion-off"), WitcherMedallions_MainCommon.WOLF_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "cat-medallion-off"), WitcherMedallions_MainCommon.CAT_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "bear-medallion-off"), WitcherMedallions_MainCommon.BEAR_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "griffin-medallion-off"), WitcherMedallions_MainCommon.GRIFFIN_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "viper-medallion-off"), WitcherMedallions_MainCommon.VIPER_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "manticore-medallion-off"), WitcherMedallions_MainCommon.MANTICORE_MEDALLION_OFF_RPG));
        WitcherMedallions_MainCommon.recipes.add(new Tuple<>(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_MainCommon.MOD_ID, "ancient-wolf-medallion-off"), WitcherMedallions_MainCommon.ANCIENT_WOLF_MEDALLION_OFF_RPG));
    }

    private JsonObject create(TagKey<Item> addition, String medallion){
        return WitcherMedallions_MainCommon.create(addition.location().toString(), WitcherMedallions_MainCommon.MOD_ID+":"+medallion, BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), true);
    }

    private JsonObject create(Item addition, String medallion){
        return WitcherMedallions_MainCommon.create(BuiltInRegistries.ITEM.getKey(addition).toString(), WitcherMedallions_MainCommon.MOD_ID+":"+medallion, BuiltInRegistries.ITEM.getKey(Items.IRON_INGOT).toString(), false);
    }

    private void  clientSetup(final FMLClientSetupEvent evt) {
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_WolfMedallion_Sup.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffWolfMedallion_Sup.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_CatMedallion_Sup.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffCatMedallion_Sup.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_BearMedallion_Sup.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffBearMedallion_Sup.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_GriffinMedallion_Sup.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffGriffinMedallion_Sup.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_ViperMedallion_Sup.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffViperMedallion_Sup.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_ManticoreMedallion_Sup.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffManticoreMedallion_Sup.get(),
                ICurioRendererMedallion::new);

        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_AncientWolfMedallion_Sup.get(),
                ICurioRendererMedallion::new);
        CuriosRendererRegistry.register(WitcherMedallions_ItemsCommon.Witcher_OffAncientWolfMedallion_Sup.get(),
                ICurioRendererMedallion::new);
    }
}