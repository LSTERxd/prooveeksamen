package com.LSTER.examplemod.datagen;

import com.LSTER.examplemod.examplemod;
import com.LSTER.examplemod.block.ModBlocks;
import com.LSTER.examplemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

/**
 * Handles the generation of crafting and smelting recipes for mod-specific items and blocks.
 */
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    // List of items that can be smelted to produce steel ingots.
    private static final List<ItemLike> STEEL_SMELTABLES = List.of(ModItems.RAW_STEEL.get());

    /**
     * Constructs a new ModRecipeProvider instance.
     *
     * @param pOutput The pack output for writing data.
     */
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    /**
     * Builds crafting and smelting recipes for mod items and blocks.
     *
     * @param pWriter The consumer for finished recipes.
     */
    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        // Smelting and blasting recipes for steel ingots.
        oreSmelting(pWriter, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 0.25f, 200, "sapphire");
        oreBlasting(pWriter, STEEL_SMELTABLES, RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 0.25f, 100, "sapphire");

        // Crafting recipe for steel block.
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STEEL_BLOCK.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.STEEL_INGOT.get())
                .unlockedBy(getHasName(ModItems.STEEL_INGOT.get()), has(ModItems.STEEL_INGOT.get()))
                .save(pWriter);

        // Shapeless recipe for turning steel block back into steel ingots.
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
                .requires(ModBlocks.STEEL_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.STEEL_BLOCK.get()), has(ModBlocks.STEEL_BLOCK.get()))
                .save(pWriter);
    }

    /**
     * Creates a smelting recipe for the specified ingredients to produce steel ingots.
     *
     * @param pFinishedRecipeConsumer The consumer for finished recipes.
     * @param pIngredients            The list of items that can be smelted.
     * @param pCategory               The recipe category.
     * @param pResult                 The resulting item.
     * @param pExperience             The experience gained from smelting.
     * @param pCookingTime            The cooking time in ticks.
     * @param pGroup                  The recipe group.
     */
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    /**
     * Creates a blasting recipe for the specified ingredients to produce steel ingots.
     *
     * @param pFinishedRecipeConsumer The consumer for finished recipes.
     * @param pIngredients            The list of items that can be blasted.
     * @param pCategory               The recipe category.
     * @param pResult                 The resulting item.
     * @param pExperience             The experience gained from blasting.
     * @param pCookingTime            The cooking time in ticks.
     * @param pGroup                  The recipe group.
     */
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    /**
     * Creates a cooking recipe for the specified ingredients to produce steel ingots.
     *
     * @param pFinishedRecipeConsumer The consumer for finished recipes.
     * @param pCookingSerializer      The cooking recipe serializer.
     * @param pIngredients            The list of items that can be cooked.
     * @param pCategory               The recipe category.
     * @param pResult                 The resulting item.
     * @param pExperience             The experience gained from cooking.
     * @param pCookingTime            The cooking time in ticks.
     * @param pGroup                  The recipe group.
     * @param pRecipeName             The name of the recipe.
     */
    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, examplemod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}

