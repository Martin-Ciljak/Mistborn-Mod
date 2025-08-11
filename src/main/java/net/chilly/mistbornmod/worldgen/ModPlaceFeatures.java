package net.chilly.mistbornmod.worldgen;


import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.block.ModBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlaceFeatures {

    public static final ResourceKey<PlacedFeature> TIN_ORE_TOP_PLACED_KEY = registerKey("tin_ore_top_placed");
    public static final ResourceKey<PlacedFeature> TIN_ORE_BOTTOM_PLACED_KEY = registerKey("tin_ore_bottom_placed");
    public static final ResourceKey<PlacedFeature> ZINC_ORE_PLACED_KEY = registerKey("zinc_ore_placed");
    public static final ResourceKey<PlacedFeature> ALUMINUM_ORE_PLACED_KEY = registerKey("aluminum_ore_placed");
    public static final ResourceKey<PlacedFeature> CHROMIUM_ORE_PLACED_KEY = registerKey("chromium_ore_placed");
    public static final ResourceKey<PlacedFeature> CADMIUM_ORE_PLACED_KEY = registerKey("cadmium_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_SILVER_ORE_PLACED_KEY = registerKey("nether_silver_ore_placed");
    public static final ResourceKey<PlacedFeature> END_SILVER_ORE_PLACED_KEY = registerKey("end_silver_ore_placed");

    public static final ResourceKey<PlacedFeature> ASPEN_PLACED_KEY = registerKey("aspen_placed_key");
    public static final ResourceKey<PlacedFeature> FRUIT_BUSH_PLACED_KEY = registerKey("fruit_bush_placed_key");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, TIN_ORE_TOP_PLACED_KEY, configuredFeatures.getOrThrow(
                ModConfiguredFeatures.ORE_TIN),
                ModOrePlacement.commonOrePlacement(
                        80, HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(30),
                                VerticalAnchor.absolute(200))));
        register(context, TIN_ORE_BOTTOM_PLACED_KEY, configuredFeatures.getOrThrow(
                ModConfiguredFeatures.ORE_TIN),
                ModOrePlacement.commonOrePlacement(
                        24, HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(-0))));
        register(context, ZINC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(
                ModConfiguredFeatures.ORE_ZINC),
                ModOrePlacement.commonOrePlacement(
                        16, HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-30),
                                VerticalAnchor.absolute(40))));
        register(context, ALUMINUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.ORE_ALUMINUM),
                ModOrePlacement.commonOrePlacement(
                        10, HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-6),
                                VerticalAnchor.absolute(6))));
        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(
                ModConfiguredFeatures.ORE_SILVER),
                ModOrePlacement.commonOrePlacement(
                        12, HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(12))));
        register(context, NETHER_SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.NETHER_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(
                        12, HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(12))));
        register(context, END_SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(
                        ModConfiguredFeatures.END_SILVER_ORE_KEY),
                ModOrePlacement.commonOrePlacement(
                        12, HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(50))));

        register(context, ASPEN_PLACED_KEY, configuredFeatures.getOrThrow(
                ModConfiguredFeatures.ASPEN_KEY),
                VegetationPlacements.treePlacement(PlacementUtils.countExtra(1, 0.1f, 2),
//                VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(100),
                        ModBlocks.ASPEN_SAPLING.get())
        );
        register(context, FRUIT_BUSH_PLACED_KEY, configuredFeatures.getOrThrow(
                ModConfiguredFeatures.FRUIT_BUSH_KEY),
                List.of(RarityFilter.onAverageOnceEvery(64), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())
        );

    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

}
