package net.chilly.mistbornmod.worldgen.tree.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.chilly.mistbornmod.worldgen.tree.ModFoliagePlacers;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class SpiralFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<SpiralFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> foliagePlacerParts(instance)
                    .and(IntProvider.CODEC.fieldOf("trunk_height").forGetter(p -> p.trunkHeight))
                    .apply(instance, SpiralFoliagePlacer::new)
    );

    private final IntProvider trunkHeight;

    public SpiralFoliagePlacer(IntProvider radius, IntProvider offset, IntProvider trunkHeight) {
        super(radius, offset);
        this.trunkHeight = trunkHeight;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.SPIRAL_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader level, FoliageSetter blockSetter,
                                 RandomSource random, TreeConfiguration config,
                                 int maxFreeTreeHeight, FoliageAttachment attachment,
                                 int foliageHeight, int foliageRadius, int offset) {

        BlockPos center = attachment.pos();
        int i = (random.nextInt(0, 2) == 0) ? 1 : -1;
        int j = (random.nextInt(0, 2) == 0) ? 1 : -1;



//        placeLeavesRow(level, blockSetter, random, config, center, 2, 0, false);
//        placeLeavesRow(level, blockSetter, random, config, center, 2, -1, false);
//        placeLeavesRow(level, blockSetter, random, config, center, 2, -2, false);
        tryPlaceLeaf(level, blockSetter, random, config, center);
        for (int layer = offset - 1; layer >= offset-foliageHeight; layer--) {
            if (i == -1 && j == -1) {
                j = 1;
            } else if (i == -1 && j == 1) {
                i = 1;
            } else if (i == 1 && j == 1) {
                j = -1;
            } else {
                i = -1;
            }

            if (random.nextInt(1, 11) <= 8) {tryPlaceLeaf(level, blockSetter, random, config, center.above(layer).north(1));}
            if (random.nextInt(1, 11) <= 8) {tryPlaceLeaf(level, blockSetter, random, config, center.above(layer).south(1));}
            if (random.nextInt(1, 11) <= 8) {tryPlaceLeaf(level, blockSetter, random, config, center.above(layer).east(1));}
            if (random.nextInt(1, 11) <= 8) {tryPlaceLeaf(level, blockSetter, random, config, center.above(layer).west(1));}
            if (random.nextInt(1, 11) <= 8) {tryPlaceLeaf(level, blockSetter, random, config, center.above(layer).north(i).east(j));}
        }


    }

    @Override
    public int foliageHeight(RandomSource random, int height, TreeConfiguration config) {
        int thisHeigh = this.trunkHeight.sample(random);
        return random.nextInt(thisHeigh - 2, thisHeigh + 1);

    }

    @Override
    protected boolean shouldSkipLocation(RandomSource random, int localX, int localY, int localZ, int range, boolean large) {
        return random.nextInt(1, 11) <= 2; // gives exactly 2/10 = 20%

    }


}
