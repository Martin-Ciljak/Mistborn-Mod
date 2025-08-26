package net.chilly.mistbornmod.event;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.entity.ModEntities;
import net.chilly.mistbornmod.entity.client.*;
import net.chilly.mistbornmod.entity.custom.GeckoEntity;
import net.chilly.mistbornmod.entity.custom.KolossEntity;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.SpawnPlacementType;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

@EventBusSubscriber(modid = MistbornMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GeckoModel.LAYER_LOCATION, GeckoModel::createBodyLayer);
        event.registerLayerDefinition(KolossYoungModel.LAYER_LOCATION, KolossYoungModel::createBodyLayer);
        event.registerLayerDefinition(KolossMiddleModel.LAYER_LOCATION, KolossMiddleModel::createBodyLayer);
        event.registerLayerDefinition(KolossOldModel.LAYER_LOCATION, KolossOldModel::createBodyLayer);
        event.registerLayerDefinition(KolossVeryOldModel.LAYER_LOCATION, KolossVeryOldModel::createBodyLayer);
        event.registerLayerDefinition(TomahawkProjectileModel.LAYER_LOCATION, TomahawkProjectileModel::createBodyLayer);
        event.registerLayerDefinition(ClipProjectileModel.LAYER_LOCATION, ClipProjectileModel::createBodyLayer);
        event.registerLayerDefinition(BoxingProjectileModel.LAYER_LOCATION, BoxingProjectileModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GECKO.get(), GeckoEntity.createAttributes().build());
        event.put(ModEntities.KOLOSS.get(), KolossEntity.createAttributes().build());
    }

    @SubscribeEvent
    public static void registerSpawnPlacements(RegisterSpawnPlacementsEvent event) {
        event.register(ModEntities.GECKO.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
    }


}
