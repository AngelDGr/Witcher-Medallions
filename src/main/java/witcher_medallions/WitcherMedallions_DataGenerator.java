package witcher_medallions;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import witcher_medallions.items.WitcherMedallions_Items;

import java.util.concurrent.CompletableFuture;

public class WitcherMedallions_DataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack main = fabricDataGenerator.createPack();

        main.addProvider(ItemTagGenerator::new);
        main.addProvider(RecipesGenerator::new);
    }


    private static class ItemTagGenerator extends FabricTagProvider.ItemTagProvider {

        public ItemTagGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
            super(output, completableFuture);
        }
        public static final TagKey<Item> TRINKET_TAG =
                TagKey.of(RegistryKeys.ITEM, Identifier.of("trinkets","chest/necklace"));

        @Override
        protected void configure(RegistryWrapper.WrapperLookup arg) {
            this.getOrCreateTagBuilder(WitcherMedallions_Items.BEAR_MEDALLION_INGREDIENT)
                    .addOptionalTag(Identifier.of("more_rpg_classes", "polar_bear_fur"))
                    .add(Items.SALMON)
                    .add(Items.COOKED_SALMON);

            this.getOrCreateTagBuilder(WitcherMedallions_Items.CAT_MEDALLION_INGREDIENT)
                    .add(Items.STRING)
                    .add(Items.COD)
                    .add(Items.PUFFERFISH)
                    .add(Items.TROPICAL_FISH);

            this.getOrCreateTagBuilder(WitcherMedallions_Items.MANTICORE_MEDALLION_INGREDIENT)
                    .add(Items.BEEF)
                    .add(Items.PORKCHOP)
                    .add(Items.MUTTON)
                    .add(Items.RABBIT);

            this.getOrCreateTagBuilder(WitcherMedallions_Items.MAGIC_CATALYST)
                    .add(Items.GOLD_INGOT)
                    .add(Items.LAPIS_LAZULI)
                    .add(Items.BLAZE_POWDER)
                    .add(Items.GHAST_TEAR)
                    .add(Items.AMETHYST_SHARD);


            this.getOrCreateTagBuilder(TRINKET_TAG)
                    .add(WitcherMedallions_Items.Witcher_WolfMedallion,
                            WitcherMedallions_Items.Witcher_CatMedallion,
                            WitcherMedallions_Items.Witcher_BearMedallion,
                            WitcherMedallions_Items.Witcher_GriffinMedallion,
                            WitcherMedallions_Items.Witcher_ViperMedallion,
                            WitcherMedallions_Items.Witcher_ManticoreMedallion,
                            WitcherMedallions_Items.Witcher_AncientWolfMedallion)
                    .add(WitcherMedallions_Items.Witcher_OffWolfMedallion,
                            WitcherMedallions_Items.Witcher_OffCatMedallion,
                            WitcherMedallions_Items.Witcher_OffBearMedallion,
                            WitcherMedallions_Items.Witcher_OffGriffinMedallion,
                            WitcherMedallions_Items.Witcher_OffViperMedallion,
                            WitcherMedallions_Items.Witcher_OffManticoreMedallion,
                            WitcherMedallions_Items.Witcher_OffAncientWolfMedallion);
        }
    }

    private static class RecipesGenerator extends FabricRecipeProvider {

        public RecipesGenerator(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output,registriesFuture);
        }

        @Override
        public void generate(RecipeExporter exporter) {
            //Magic Nucleus
            {
                ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, WitcherMedallions_Items.Witcher_MagicCore)
                        .pattern("LGL")
                        .pattern("GEG")
                        .pattern("LGL")
                        .input('L', Items.LAPIS_LAZULI)
                        .input('G', Items.GOLD_INGOT)
                        .input('E', Items.ENDER_PEARL)
                        .criterion(FabricRecipeProvider.hasItem(Items.ENDER_PEARL), FabricRecipeProvider.conditionsFromItem(Items.ENDER_PEARL))
                        .offerTo(exporter);
            }

            //On
            {
                createMedallionRecipe(exporter, WitcherMedallions_Items.Witcher_OffWolfMedallion, WitcherMedallions_Items.Witcher_WolfMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_Items.Witcher_OffCatMedallion, WitcherMedallions_Items.Witcher_CatMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_Items.Witcher_OffBearMedallion, WitcherMedallions_Items.Witcher_BearMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_Items.Witcher_OffGriffinMedallion, WitcherMedallions_Items.Witcher_GriffinMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_Items.Witcher_OffViperMedallion, WitcherMedallions_Items.Witcher_ViperMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_Items.Witcher_OffManticoreMedallion, WitcherMedallions_Items.Witcher_ManticoreMedallion);
                createMedallionRecipe(exporter, WitcherMedallions_Items.Witcher_OffAncientWolfMedallion, WitcherMedallions_Items.Witcher_AncientWolfMedallion);
            }
        }

        private void createMedallionRecipe(RecipeExporter exporter, Item OFF_Medallion, Item ON_Medallion){
            SmithingTransformRecipeJsonBuilder.create(
                            //Template
                            Ingredient.ofItems(WitcherMedallions_Items.Witcher_MagicCore),
                            //Base
                            Ingredient.ofItems(OFF_Medallion),
                            //Addition
                            Ingredient.fromTag(WitcherMedallions_Items.MAGIC_CATALYST),
                            //Category
                            RecipeCategory.COMBAT,
                            //Result
                            ON_Medallion
                    )
                    .criterion(FabricRecipeProvider.hasItem(Items.CHAIN), FabricRecipeProvider.conditionsFromItem(Items.CHAIN))
                    .offerTo(exporter, RecipeProvider.getItemPath(ON_Medallion));
        }
    }
}
