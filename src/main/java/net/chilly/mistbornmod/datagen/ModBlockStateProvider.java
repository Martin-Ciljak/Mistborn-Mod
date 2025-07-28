package net.chilly.mistbornmod.datagen;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.block.ModBlocks;
import net.chilly.mistbornmod.block.custom.SteelLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MistbornMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TIN_BLOCK);
        blockWithItem(ModBlocks.STEEL_BLOCK);


        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.SILVER_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TIN_ORE);

        stairsBlock(ModBlocks.STEEL_STAIRS.get(), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        slabBlock(ModBlocks.STEEL_SLAB.get(), blockTexture(ModBlocks.STEEL_BLOCK.get()), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        pressurePlateBlock(ModBlocks.STEEL_PRESSURE_PLATE.get(), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        buttonBlock(ModBlocks.STEEL_BUTTON.get(), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        fenceBlock(ModBlocks.STEEL_FENCE.get(), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        fenceGateBlock(ModBlocks.STEEL_FENCE_GATE.get(), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        wallBlock(ModBlocks.STEEL_WALL.get(), blockTexture(ModBlocks.STEEL_BLOCK.get()));
        doorBlockWithRenderType(ModBlocks.STEEL_DOOR.get(), modLoc("block/steel_door_bottom"), modLoc("block/steel_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.STEEL_TRAPDOOR.get(), modLoc("block/steel_trapdoor"), true ,"cutout");



        blockItem(ModBlocks.STEEL_STAIRS);
        blockItem(ModBlocks.STEEL_SLAB);
        blockItem(ModBlocks.STEEL_PRESSURE_PLATE);
        blockItem(ModBlocks.STEEL_FENCE_GATE);
        blockItem(ModBlocks.STEEL_TRAPDOOR, "_bottom");

        customLamp();
        blockWithItem(ModBlocks.MAGIC_BLOCK);
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.STEEL_LAMP.get()).forAllStates(state -> {
            if (state.getValue(SteelLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("steel_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "block/" + "steel_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("steel_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "block/" + "steel_lamp_off")))};

            }
        });

        simpleBlockItem(ModBlocks.STEEL_LAMP.get(), models().cubeAll("steel_lamp_on",
                ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "block/" + "steel_lamp_on")));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("mistborn:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("mistborn:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
