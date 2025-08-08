package net.chilly.mistbornmod.worldgen.tree;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.worldgen.ModConfiguredFeatures;
import net.minecraft.world.level.block.grower.TreeGrower;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower ASPEN = new TreeGrower(MistbornMod.MOD_ID + ":aspen",
            Optional.empty(), Optional.of(ModConfiguredFeatures.ASPEN_KEY), Optional.empty());

}
