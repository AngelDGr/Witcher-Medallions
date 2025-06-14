package witcher_medallions.registry;

import dev.architectury.injectables.annotations.ExpectPlatform;
import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;
import witcher_medallions.WitcherMedallions_Main;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class WitcherMedallions_Items {

    public static final TagKey<Item> BEAR_MEDALLION_INGREDIENT = of("bear_medallion_ingredient");
    public static final TagKey<Item> CAT_MEDALLION_INGREDIENT = of("cat_medallion_ingredient");
    public static final TagKey<Item> MANTICORE_MEDALLION_INGREDIENT = of("manticore_medallion_ingredient");
    public static final TagKey<Item> MAGIC_CATALYST = of("magic_catalyst");

    private static TagKey<Item> of(String id) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID,id));
    }

    @ExpectPlatform
    public static void initItems() { throw new AssertionError(); }

    @ExpectPlatform
    public static void initItemGroups(){  throw new AssertionError(); }

    public static OwoItemGroup createGroup(){
       return WitcherMedallions_Items.createOwOGroup(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "main"),
                owoItemGroup -> {


                    owoItemGroup.addCustomTab(Icon.of(Witcher_WolfMedallion()), "medallions", WitcherMedallions_Items::displayTab, true);


                    owoItemGroup.addButton(ItemGroupButton.curseforge(owoItemGroup, "https://www.curseforge.com/members/tenebris_mors/projects"));
                    owoItemGroup.addButton(ItemGroupButton.modrinth(owoItemGroup, "https://modrinth.com/user/Tenebris_Mors"));
                    owoItemGroup.addButton(ItemGroupButton.github(owoItemGroup, "https://github.com/AngelDGr/Witcher-Medallions"));
                },
                ()-> WitcherMedallions_Items.createIcon(ResourceLocation.fromNamespaceAndPath(WitcherMedallions_Main.MOD_ID, "textures/gui/tab_icon.png"), 0, 0, 400));
    }

    public static void displayTab(CreativeModeTab.ItemDisplayParameters itemDisplayParameters, CreativeModeTab.Output entries){
        //Medallions
        entries.accept(Witcher_WolfMedallion());
        entries.accept(Witcher_CatMedallion());
        entries.accept(Witcher_BearMedallion());
        entries.accept(Witcher_GriffinMedallion());
        entries.accept(Witcher_ViperMedallion());
        entries.accept(Witcher_ManticoreMedallion());
        entries.accept(Witcher_AncientWolfMedallion());

        //Medallions Off
        entries.accept(Witcher_OffWolfMedallion());
        entries.accept(Witcher_OffCatMedallion());
        entries.accept(Witcher_OffBearMedallion());
        entries.accept(Witcher_OffGriffinMedallion());
        entries.accept(Witcher_OffViperMedallion());
        entries.accept(Witcher_OffManticoreMedallion());
        entries.accept(Witcher_OffAncientWolfMedallion());

        //Magic Nucleus
        entries.accept(Witcher_MagicCore());
    }

    public static Icon createIcon(final ResourceLocation texture, final int u, final int v, final int textureSize) {
        return (context, x, y, mouseX, mouseY, delta) -> {
            context.getMatrixStack().pushPose();

            //Scales down to fit a 16x16 texture
            float scaleValue= (float) 16 /textureSize;

            //Moves the texture
            double translationX=x* ((1/scaleValue)-1);
            double translationY=y* ((1/scaleValue)-1);

            context.getMatrixStack().scale(scaleValue,scaleValue,1);

            context.getMatrixStack().translate(translationX,translationY,0);

            context.blit(texture,
                    //Pos
                    x, y,
                    //UV
                    u, v,
                    //Size
                    textureSize, textureSize,
                    //Texture Size
                    textureSize, textureSize
            );

            context.getMatrixStack().popPose();
        };
    }

    public static OwoItemGroup createOwOGroup(ResourceLocation id,
                                              Consumer<OwoItemGroup> initializer,
                                              Supplier<Icon> iconSupplier) {

        return createOwOGroup(id, initializer, iconSupplier, 4, 4, null, null, null, true, false, true);
    }

    public static OwoItemGroup createOwOGroup(ResourceLocation id,
                                              Consumer<OwoItemGroup> initializer,
                                              Supplier<Icon> iconSupplier,
                                              int tabStackHeight, int buttonStackHeight,
                                              @Nullable ResourceLocation backgroundTexture,
                                              @Nullable OwoItemGroup.ScrollerTextures scrollerTextures,
                                              @Nullable OwoItemGroup.TabTextures tabTextures,
                                              boolean useDynamicTitle,
                                              boolean displaySingleTab,
                                              boolean allowMultiSelect) {

        return new OwoItemGroup(id, initializer, iconSupplier, tabStackHeight, buttonStackHeight, backgroundTexture, scrollerTextures, tabTextures, useDynamicTitle, displaySingleTab, allowMultiSelect) {};
    }

    //WolfMedallion
    //Wolf Medallion (wolf-medallion)
    @ExpectPlatform
    public static Item Witcher_WolfMedallion(){throw new AssertionError();}
    @ExpectPlatform
    //Deactivated Wolf Medallion (wolf-medallion-off)
    public static Item Witcher_OffWolfMedallion(){throw new AssertionError();}

    //CatMedallion
    //Cat Medallion (cat-medallion)
    @ExpectPlatform
    public static Item Witcher_CatMedallion(){throw new AssertionError();}
    //Deactivated Cat Medallion (cat-medallion-off)
    @ExpectPlatform
    public static Item Witcher_OffCatMedallion(){throw new AssertionError();}

    //BearMedallion
    //Bear Medallion (bear-medallion)
    @ExpectPlatform
    public static Item Witcher_BearMedallion(){throw new AssertionError();}
    //Deactivated Bear Medallion (bear-medallion-off)
    @ExpectPlatform
    public static Item Witcher_OffBearMedallion(){throw new AssertionError();}

    //GriffinMedallion
    //Griffin Medallion (griffin-medallion)
    @ExpectPlatform
    public static Item Witcher_GriffinMedallion(){throw new AssertionError();}
    //Deactivated Griffin Medallion (griffin-medallion-off)
    @ExpectPlatform
    public static Item Witcher_OffGriffinMedallion(){throw new AssertionError();}

    //ViperMedallion
    //Viper Medallion (viper-medallion)
    @ExpectPlatform
    public static Item Witcher_ViperMedallion(){throw new AssertionError();}
    //Deactivated Viper Medallion (viper-medallion-off)
    @ExpectPlatform
    public static Item Witcher_OffViperMedallion(){throw new AssertionError();}

    //ManticoreMedallion
    //Manticore Medallion (manticore-medallion)
    @ExpectPlatform
    public static Item Witcher_ManticoreMedallion(){throw new AssertionError();}
    //Deactivated Manticore Medallion (manticore-medallion-off)
    @ExpectPlatform
    public static Item Witcher_OffManticoreMedallion(){throw new AssertionError();}

    //AncientWolfMedallion
    //Ancient Wolf Medallion (ancient-wolf-medallion)
    @ExpectPlatform
    public static Item Witcher_AncientWolfMedallion(){throw new AssertionError();}
    //Deactivated Ancient Wolf Medallion (ancient-wolf-medallion-off)
    @ExpectPlatform
    public static Item Witcher_OffAncientWolfMedallion(){throw new AssertionError();}

    //OtherItems
    //Magic Core (magic-nucleus)
    @ExpectPlatform
    public static Item Witcher_MagicCore(){throw new AssertionError();}

}
