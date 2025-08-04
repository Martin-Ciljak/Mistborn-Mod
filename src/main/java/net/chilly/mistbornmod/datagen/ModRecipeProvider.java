package net.chilly.mistbornmod.datagen;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.block.ModBlocks;
import net.chilly.mistbornmod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
//      List of smeltable items
        List<ItemLike> TIN_SMELTABLES =  List.of(ModItems.RAW_TIN, ModBlocks.TIN_ORE, ModBlocks.DEEPSLATE_TIN_ORE);
        List<ItemLike> ZINC_SMELTABLES = List.of(ModItems.RAW_ZINC);
        List<ItemLike> CHROMIUM_SMELTABLES = List.of(ModItems.RAW_CHROMIUM);
        List<ItemLike> ALUMINUM_SMELTABLES = List.of(ModItems.RAW_ALUMINUM);
        List<ItemLike> CADMIUM_SMELTABLES = List.of(ModItems.RAW_CADMIUM);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT)).save(recipeOutput);

//      INGOTS FROM BLOCKS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 9)
                .requires(ModBlocks.TIN_BLOCK)
                .unlockedBy("has_tin_block", has(ModBlocks.TIN_BLOCK)).save(recipeOutput, "mistborn:tin_ingot_from_tin_block");

//      ALLOYS
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.STEEL_INGOT.get(), 9)
                .requires(Items.IRON_INGOT, 8)
                .requires(Items.COAL)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).save(recipeOutput, "mistborn:steel_ingot_from_iron_and_coal");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PEWTER_INGOT.get(), 4)
                .requires(ModItems.TIN_INGOT, 3)
                .requires(Items.COPPER_INGOT)
                .unlockedBy("has_tin_ingot", has(ModItems.TIN_INGOT)).save(recipeOutput, "mistborn:pewter_ingot_from_tin_and_copper");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRASS_INGOT.get(), 3)
                .requires(ModItems.ZINC_INGOT)
                .requires(Items.COPPER_INGOT, 2)
                .unlockedBy("has_zinc_ingot", has(ModItems.ZINC_INGOT)).save(recipeOutput, "mistborn:brass_ingot_from_zinc_and_copper");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BRONZE_INGOT.get(), 4)
                .requires(Items.COPPER_INGOT, 3)
                .requires(ModItems.TIN_INGOT)
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT)).save(recipeOutput, "mistborn:bronze_ingot_from_copper_and_tin");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.NICROSIL_INGOT.get(), 4)
                .requires(ModItems.CHROMIUM_INGOT, 1)
                .requires(Items.BARRIER, 3)// replace with Nickel
                .unlockedBy("has_chromium_ingot", has(ModItems.CHROMIUM_INGOT)).save(recipeOutput, "mistborn:nicrosil_ingot_from_chromium_and_nickel");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.DURALUMIN_INGOT.get(), 9)
                .requires(ModItems.ALUMINUM_INGOT, 8)
                .requires(Items.COPPER_INGOT)
                .unlockedBy("has_aluminum_ingot", has(ModItems.ALUMINUM_INGOT)).save(recipeOutput, "mistborn:duralumin_ingot_from_aluminum_and_copper");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BENDALLOY_INGOT.get(), 2) // maybe add bismuth later
                .requires(ModItems.CADMIUM_INGOT)
                .requires(ModItems.TIN_INGOT)
                .unlockedBy("has_cadmium_ingot", has(ModItems.CADMIUM_INGOT)).save(recipeOutput,"mistborn:bendalloy_ingot_from_cadmium_and_tin");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ELECTRUM_INGOT.get(), 2)
                .requires(Items.GOLD_INGOT)
                .requires(ModItems.SILVER_INGOT)
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT)).save(recipeOutput, "mistborn:electrum_ingot_from_gold_and_silver");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BAYWRAP.get(), 1)
                .requires(Items.BREAD)
                .requires(ModItems.COOKED_BARLEY)
                .requires(Items.CARROT)
                .unlockedBy("has_cooked_barley", has(ModItems.COOKED_BARLEY.get())).save(recipeOutput);


        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ModItems.BARLEY.get()), RecipeCategory.MISC, ModItems.COOKED_BARLEY.get(), 0.35f, 200)
                .unlockedBy("has_barley", has(ModItems.BARLEY)).save(recipeOutput);
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ModItems.BARLEY.get()), RecipeCategory.MISC, ModItems.COOKED_BARLEY.get(), 0.35f, 100)
                .unlockedBy("has_barley", has(ModItems.BARLEY)).save(recipeOutput, "mistborn:cooked_barley_from_smoking");
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ModItems.BARLEY.get()), RecipeCategory.MISC, ModItems.COOKED_BARLEY.get(), 0.1f, 600)
                .unlockedBy("has_barley", has(ModItems.BARLEY)).save(recipeOutput, "mistborn:cooked_barley_from_campfire_cooking");

        oreSmelting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.25f, 200, "tin");
        oreBlasting(recipeOutput, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.25f, 100, "tin");
        oreSmelting(recipeOutput, ZINC_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_INGOT.get(), 0.25f, 200, "zinc");
        oreBlasting(recipeOutput, ZINC_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_INGOT.get(), 0.25f, 100, "zinc");
        oreSmelting(recipeOutput, CHROMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CHROMIUM_INGOT.get(), 0.25f, 200, "chromium");
        oreBlasting(recipeOutput, CHROMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CHROMIUM_INGOT.get(), 0.25f, 100, "chromium");
        oreSmelting(recipeOutput, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.25f, 200, "aluminum");
        oreBlasting(recipeOutput, ALUMINUM_SMELTABLES, RecipeCategory.MISC, ModItems.ALUMINUM_INGOT.get(), 0.25f, 100, "aluminum");
        oreSmelting(recipeOutput, CADMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CADMIUM_INGOT.get(), 0.25f, 200, "cadmium");
        oreBlasting(recipeOutput, CADMIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CADMIUM_INGOT.get(), 0.25f, 100, "cadmium");

        stairBuilder(ModBlocks.STEEL_STAIRS.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel").unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_SLAB.get(), ModItems.STEEL_INGOT.get());
        buttonBuilder(ModBlocks.STEEL_BUTTON.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel").unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT)).save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.STEEL_PRESSURE_PLATE.get(), ModItems.STEEL_INGOT.get());
        fenceBuilder(ModBlocks.STEEL_FENCE.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel").unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT)).save(recipeOutput);
        fenceGateBuilder(ModBlocks.STEEL_FENCE_GATE.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel").unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT)).save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STEEL_WALL.get(), ModItems.STEEL_INGOT.get());
        doorBuilder(ModBlocks.STEEL_DOOR.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel").unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT)).save(recipeOutput);
        trapdoorBuilder(ModBlocks.STEEL_TRAPDOOR.get(), Ingredient.of(ModItems.STEEL_INGOT.get())).group("steel").unlockedBy("has_steel_ingot", has(ModItems.STEEL_INGOT)).save(recipeOutput);


    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, MistbornMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
