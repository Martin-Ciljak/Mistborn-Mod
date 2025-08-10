package net.chilly.mistbornmod.datagen;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.block.ModBlocks;
import net.chilly.mistbornmod.block.custom.BarleyCropBlock;
import net.chilly.mistbornmod.block.custom.FruitBushBlock;
import net.chilly.mistbornmod.block.custom.SteelLampBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

import java.util.function.Function;


public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MistbornMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.ZINC_ORE);
        blockWithItem(ModBlocks.ALUMINUM_ORE);
        blockWithItem(ModBlocks.CHROMIUM_ORE);
        blockWithItem(ModBlocks.CADMIUM_ORE);
        blockWithItem(ModBlocks.SILVER_ORE);

        blockWithItem(ModBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ZINC_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ALUMINUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CHROMIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CADMIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE);

        blockWithItem(ModBlocks.NETHER_SILVER_ORE);
        blockWithItem(ModBlocks.END_SILVER_ORE);


        blockWithItem(ModBlocks.STEEL_BLOCK);
        blockWithItem(ModBlocks.TIN_BLOCK);
        blockWithItem(ModBlocks.PEWTER_BLOCK);
        blockWithItem(ModBlocks.ZINC_BLOCK);
        blockWithItem(ModBlocks.BRASS_BLOCK);
        blockWithItem(ModBlocks.BRONZE_BLOCK);
        blockWithItem(ModBlocks.ALUMINUM_BLOCK);
        blockWithItem(ModBlocks.DURALUMIN_BLOCK);
        blockWithItem(ModBlocks.CHROMIUM_BLOCK);
        blockWithItem(ModBlocks.NICROSIL_BLOCK);
        blockWithItem(ModBlocks.ELECTRUM_BLOCK);
        blockWithItem(ModBlocks.CADMIUM_BLOCK);
        blockWithItem(ModBlocks.BENDALLOY_BLOCK);
        blockWithItem(ModBlocks.SILVER_BLOCK);


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

        makeCrop(((CropBlock) ModBlocks.BARLEY_CROP.get()), "barley_crop_stage", "barley_crop_stage");
        makeBush((SweetBerryBushBlock)ModBlocks.FRUIT_BUSH.get(), "fruit_bush_stage", "fruit_bush_stage");

        logBlock((RotatedPillarBlock) ModBlocks.ASPEN_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.ASPEN_WOOD.get(), blockTexture(ModBlocks.ASPEN_LOG.get()), blockTexture(ModBlocks.ASPEN_LOG.get()));
        logBlock((RotatedPillarBlock) ModBlocks.STRIPPED_ASPEN_LOG.get());
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_ASPEN_WOOD.get(), blockTexture(ModBlocks.STRIPPED_ASPEN_LOG.get()), blockTexture(ModBlocks.STRIPPED_ASPEN_LOG.get()));

        blockItem(ModBlocks.ASPEN_LOG);
        blockItem(ModBlocks.ASPEN_WOOD);
        blockItem(ModBlocks.STRIPPED_ASPEN_LOG);
        blockItem(ModBlocks.STRIPPED_ASPEN_WOOD);

        blockWithItem(ModBlocks.ASPEN_PLANS);

        leavesBlock(ModBlocks.ASPEN_LEAVES);
        saplingBlock(ModBlocks.ASPEN_SAPLING);


    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> fruit_states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] fruit_states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(FruitBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "block/" + textureName + state.getValue(FruitBushBlock.AGE))).renderType("cutout"));

        return models;
    }

    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> barley_states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] barley_states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((BarleyCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "block/" + textureName + state.getValue(((BarleyCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
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
