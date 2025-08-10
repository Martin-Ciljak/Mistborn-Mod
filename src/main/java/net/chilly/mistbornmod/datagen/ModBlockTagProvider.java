package net.chilly.mistbornmod.datagen;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.block.ModBlocks;
import net.chilly.mistbornmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MistbornMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.ZINC_ORE.get())
                .add(ModBlocks.ALUMINUM_ORE.get())
                .add(ModBlocks.CHROMIUM_ORE.get())
                .add(ModBlocks.CADMIUM_ORE.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_ZINC_ORE.get())
                .add(ModBlocks.DEEPSLATE_ALUMINUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_CHROMIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_CADMIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.NETHER_SILVER_ORE.get())
                .add(ModBlocks.END_SILVER_ORE.get())
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.PEWTER_BLOCK.get())
                .add(ModBlocks.ZINC_BLOCK.get())
                .add(ModBlocks.BRASS_BLOCK.get())
                .add(ModBlocks.BRONZE_BLOCK.get())
                .add(ModBlocks.ALUMINUM_BLOCK.get())
                .add(ModBlocks.DURALUMIN_BLOCK.get())
                .add(ModBlocks.CADMIUM_BLOCK.get())
                .add(ModBlocks.NICROSIL_BLOCK.get())
                .add(ModBlocks.ELECTRUM_BLOCK.get())
                .add(ModBlocks.CADMIUM_BLOCK.get())
                .add(ModBlocks.BENDALLOY_BLOCK.get())
                .add(ModBlocks.SILVER_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.TIN_ORE.get())
                .add(ModBlocks.ZINC_ORE.get())
                .add(ModBlocks.DEEPSLATE_TIN_ORE.get())
                .add(ModBlocks.DEEPSLATE_ZINC_ORE.get())
                .add(ModBlocks.STEEL_BLOCK.get())
                .add(ModBlocks.TIN_BLOCK.get())
                .add(ModBlocks.PEWTER_BLOCK.get())
                .add(ModBlocks.ZINC_BLOCK.get())
                .add(ModBlocks.BRASS_BLOCK.get())
                .add(ModBlocks.BRONZE_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ALUMINUM_ORE.get())
                .add(ModBlocks.CHROMIUM_ORE.get())
                .add(ModBlocks.CADMIUM_ORE.get())
                .add(ModBlocks.SILVER_ORE.get())
                .add(ModBlocks.DEEPSLATE_ALUMINUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_CHROMIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_CADMIUM_ORE.get())
                .add(ModBlocks.DEEPSLATE_SILVER_ORE.get())
                .add(ModBlocks.NETHER_SILVER_ORE.get())
                .add(ModBlocks.END_SILVER_ORE.get())
                .add(ModBlocks.ALUMINUM_BLOCK.get())
                .add(ModBlocks.DURALUMIN_BLOCK.get())
                .add(ModBlocks.CADMIUM_BLOCK.get())
                .add(ModBlocks.NICROSIL_BLOCK.get())
                .add(ModBlocks.ELECTRUM_BLOCK.get())
                .add(ModBlocks.CADMIUM_BLOCK.get())
                .add(ModBlocks.BENDALLOY_BLOCK.get())
                .add(ModBlocks.SILVER_BLOCK.get());

        tag(BlockTags.FENCES)
                .add(ModBlocks.STEEL_FENCE.get());
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.STEEL_FENCE_GATE.get());
        tag(BlockTags.WALLS)
                .add(ModBlocks.STEEL_WALL.get());
        tag(ModTags.Blocks.NEEDS_OBSIDIAN_TOOL)
                .addTag(BlockTags.NEEDS_STONE_TOOL);
        tag(ModTags.Blocks.INCORRECT_FOR_OBSIDIAN_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_STONE_TOOL)
                .remove(ModTags.Blocks.NEEDS_OBSIDIAN_TOOL);

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.ASPEN_LOG.get())
                .add(ModBlocks.ASPEN_WOOD.get())
                .add(ModBlocks.STRIPPED_ASPEN_LOG.get())
                .add(ModBlocks.STRIPPED_ASPEN_WOOD.get());
    }
}
