package net.chilly.mistbornmod.worldgen;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.block.ModBlocks;
import net.chilly.mistbornmod.block.custom.FruitBushBlock;
import net.chilly.mistbornmod.worldgen.tree.custom.SpiralFoliagePlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_TIN = registerKey("ore_tin");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ZINC = registerKey("ore_zinc");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_ALUMINUM = registerKey("ore_aluminum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CHROMIUM = registerKey("ore_chromium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_CADMIUM = registerKey("ore_cadmium");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ORE_SILVER = registerKey("ore_silver");

    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_SILVER_ORE_KEY = registerKey("nether_silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_SILVER_ORE_KEY = registerKey("end_silver_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>> ASPEN_KEY = registerKey("aspen");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FRUIT_BUSH_KEY = registerKey("fruit_bush");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldTinOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.TIN_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_TIN_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> overworldZincOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ZINC_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> overworldAluminumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.ALUMINUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> overworldChromiumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.CHROMIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_CHROMIUM_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> overworldCadmiumOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.CADMIUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_CADMIUM_ORE.get().defaultBlockState())
        );
        List<OreConfiguration.TargetBlockState> overworldSilverOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.SILVER_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SILVER_ORE.get().defaultBlockState())
        );



        register(context, ORE_TIN, Feature.ORE, new OreConfiguration(overworldTinOres, 9));
        register(context, ORE_ZINC, Feature.ORE, new OreConfiguration(overworldZincOres, 6));
        register(context, ORE_ALUMINUM, Feature.ORE, new OreConfiguration(overworldAluminumOres, 3));
        register(context, ORE_CHROMIUM, Feature.ORE, new OreConfiguration(overworldChromiumOres, 6));
        register(context, ORE_CADMIUM, Feature.ORE, new OreConfiguration(overworldCadmiumOres, 4));
        register(context, ORE_SILVER, Feature.ORE, new OreConfiguration(overworldSilverOres, 4));
        register(context, NETHER_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.NETHER_SILVER_ORE.get().defaultBlockState(), 6));
        register(context, END_SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.END_SILVER_ORE.get().defaultBlockState(), 9));


        register(
                context, ASPEN_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                        BlockStateProvider.simple(Blocks.BIRCH_LOG), // Trunk (light, like aspen bark)
                        new StraightTrunkPlacer(5, 1, 1),             // Tall thin trunk
                        BlockStateProvider.simple(ModBlocks.ASPEN_LEAVES.get()), // Foliage (dry/sickly)
                        new SpiralFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), ConstantInt.of(5)),
                        new TwoLayersFeatureSize(2, 0, 1)
                )
                .dirt(BlockStateProvider.simple(Blocks.GRAVEL))
                .ignoreVines().build());
        register(
                context,
                FRUIT_BUSH_KEY,
                Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(
                                BlockStateProvider.simple(ModBlocks.FRUIT_BUSH.get().defaultBlockState().setValue(FruitBushBlock.AGE, 3))
                        ),
                        List.of(Blocks.GRASS_BLOCK)
                )
        );
    }





    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
