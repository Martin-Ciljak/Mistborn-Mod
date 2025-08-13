package net.chilly.mistbornmod.event;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.entity.ModEntities;
import net.chilly.mistbornmod.entity.client.GeckoModel;
import net.chilly.mistbornmod.entity.client.KolossModel;
import net.chilly.mistbornmod.entity.custom.GeckoEntity;
import net.chilly.mistbornmod.entity.custom.KolossEntity;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = MistbornMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(GeckoModel.LAYER_LOCATION, GeckoModel::createBodyLayer);
        event.registerLayerDefinition(KolossModel.LAYER_LOCATION, KolossModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.GECKO.get(), GeckoEntity.createAttributes().build());
        event.put(ModEntities.KOLOSS.get(), KolossEntity.createAttributes().build());
    }
}
