package witcher_medallions;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import witcher_medallions.items.WitcherMedallions_ItemsCommon;

import java.util.concurrent.CompletableFuture;

public class WitcherMedallions_DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack main = fabricDataGenerator.createPack();

        main.addProvider(ItemTagGenerator::new);
        main.addProvider(RecipesGenerator::new);
    }


    private static class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {

        public ItemTagGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
            super(output, completableFuture);
        }
        public static final TagKey<Item> TRINKET_TAG =
                TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("data/trinkets","chest/necklace"));

        @Override
        protected void addTags(HolderLookup.Provider arg) {
            this.getOrCreateTagBuilder(WitcherMedallions_ItemsCommon.BEAR_MEDALLION_INGREDIENT)
                    .addOptionalTag(ResourceLocation.fromNamespaceAndPath("more_rpg_classes", "polar_bear_fur"))
                    .add(Items.SALMON)
                    .add(Items.COOKED_SALMON);


            this.getOrCreateTagBuilder(WitcherMedallions_ItemsCommon.CAT_MEDALLION_INGREDIENT)
                    .add(Items.STRING)
                    .add(Items.COD)
                    .add(Items.PUFFERFISH)
                    .add(Items.TROPICAL_FISH);

            this.getOrCreateTagBuilder(WitcherMedallions_ItemsCommon.MANTICORE_MEDALLION_INGREDIENT)
                    .add(Items.BEEF)
                    .add(Items.PORKCHOP)
                    .add(Items.MUTTON)
                    .add(Items.RABBIT);

            this.getOrCreateTagBuilder(WitcherMedallions_ItemsCommon.MAGIC_CATALYST)
                    .add(Items.GOLD_INGOT)
                    .add(Items.LAPIS_LAZULI)
                    .add(Items.BLAZE_POWDER)
                    .add(Items.GHAST_TEAR)
                    .add(Items.AMETHYST_SHARD);


            this.getOrCreateTagBuilder(TRINKET_TAG)
                    .add(WitcherMedallions_ItemsCommon.Witcher_WolfMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_CatMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_BearMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_GriffinMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_ViperMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_ManticoreMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_AncientWolfMedallion)
                    .add(WitcherMedallions_ItemsCommon.Witcher_OffWolfMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_OffCatMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_OffBearMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_OffGriffinMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_OffViperMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_OffManticoreMedallion,
                            WitcherMedallions_ItemsCommon.Witcher_OffAncientWolfMedallion);
        }
    }

    private static class RecipesGenerator extends FabricRecipeProvider {

        public RecipesGenerator(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
            super(output,registriesFuture);
        }

        @Override
        public void buildRecipes(RecipeOutput exporter) {
            //Magic Nucleus
            {
                ShapedRecipeBuilder.shaped(RecipeCategory.MISC, WitcherMedallions_ItemsCommon.Witcher_MagicCore)
                        .pattern("LGL")
                        .pattern("GEG")
                        .pattern("LGL")
                        .define('L', Items.LAPIS_LAZULI)
                        .define('G', Items.GOLD_INGOT)
                        .define('E', Items.ENDER_PEARL)
                        .unlockedBy(FabricRecipeProvider.getHasName(Items.ENDER_PEARL), FabricRecipeProvider.has(Items.ENDER_PEARL))
                        .save(exporter);
            }

            //On
            {
                createMedallionRecipe(exporter, WitcherMedallions_ItemsCommon.Witcher_OffWolfMedallion, WitcherMedallions_ItemsCommon.Witcher_WolfMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_ItemsCommon.Witcher_OffCatMedallion, WitcherMedallions_ItemsCommon.Witcher_CatMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_ItemsCommon.Witcher_OffBearMedallion, WitcherMedallions_ItemsCommon.Witcher_BearMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_ItemsCommon.Witcher_OffGriffinMedallion, WitcherMedallions_ItemsCommon.Witcher_GriffinMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_ItemsCommon.Witcher_OffViperMedallion, WitcherMedallions_ItemsCommon.Witcher_ViperMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_ItemsCommon.Witcher_OffManticoreMedallion, WitcherMedallions_ItemsCommon.Witcher_ManticoreMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_ItemsCommon.Witcher_OffAncientWolfMedallion, WitcherMedallions_ItemsCommon.Witcher_AncientWolfMedallion);
            }
        }

        private void createMedallionRecipe(RecipeOutput exporter, Item OFF_Medallion, Item ON_Medallion){
            SmithingTransformRecipeBuilder.smithing(
                            //Template
                            Ingredient.of(WitcherMedallions_ItemsCommon.Witcher_MagicCore),
                            //Base
                            Ingredient.of(OFF_Medallion),
                            //Addition
                            Ingredient.of(WitcherMedallions_ItemsCommon.MAGIC_CATALYST),
                            //Category
                            RecipeCategory.COMBAT,
                            //Result
                            ON_Medallion
                    )
                    .unlocks(FabricRecipeProvider.getHasName(Items.CHAIN), FabricRecipeProvider.has(Items.CHAIN))
                    .save(exporter, RecipeProvider.getItemName(ON_Medallion));
        }
    }
}
