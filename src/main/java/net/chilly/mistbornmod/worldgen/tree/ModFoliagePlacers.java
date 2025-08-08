package net.chilly.mistbornmod.worldgen.tree;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.worldgen.tree.custom.SpiralFoliagePlacer;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFoliagePlacers {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS =
            DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, MistbornMod.MOD_ID);

    public static final DeferredHolder<FoliagePlacerType<?>, FoliagePlacerType<SpiralFoliagePlacer>> SPIRAL_FOLIAGE_PLACER =
            FOLIAGE_PLACERS.register("spiral_foliage_placer", () -> new FoliagePlacerType<>(SpiralFoliagePlacer.CODEC));


    public static void register(IEventBus eventBus) {
        FOLIAGE_PLACERS.register(eventBus);
    }
}
