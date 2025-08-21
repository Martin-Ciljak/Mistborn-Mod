package net.chilly.mistbornmod.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.entity.GeckoVariant;
import net.chilly.mistbornmod.entity.KolossAgeState;
import net.chilly.mistbornmod.entity.custom.KolossEntity;
import net.minecraft.Util;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.Model;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

import java.util.EnumMap;
import java.util.Map;

public class KolossRenderer extends MobRenderer<KolossEntity, KolossModel<KolossEntity>> {

    private final Map<KolossAgeState, KolossModel<KolossEntity>> models = new EnumMap<>(KolossAgeState.class);
    private static final Map<KolossAgeState, ResourceLocation> TEXTURES = Util.make(Maps.newEnumMap(KolossAgeState.class), map -> {
        map.put(KolossAgeState.YOUNG,     ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "textures/entity/koloss/koloss.png"));
        map.put(KolossAgeState.MIDDLE,    ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "textures/entity/koloss/koloss.png"));
        map.put(KolossAgeState.OLD,       ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "textures/entity/koloss/koloss.png"));
        map.put(KolossAgeState.VERY_OLD,  ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "textures/entity/koloss/koloss.png"));
    });

    public KolossRenderer(EntityRendererProvider.Context context) {
        // Default to young as a fallback
        super(context, new KolossYoungModel<>(context.bakeLayer(KolossYoungModel.LAYER_LOCATION)), 1f);

        // Fill model map
        models.put(KolossAgeState.YOUNG,     new KolossYoungModel<>(context.bakeLayer(KolossYoungModel.LAYER_LOCATION)));
        models.put(KolossAgeState.MIDDLE,    new KolossMiddleModel<>(context.bakeLayer(KolossMiddleModel.LAYER_LOCATION)));
        models.put(KolossAgeState.OLD,       new KolossOldModel<>(context.bakeLayer(KolossOldModel.LAYER_LOCATION)));
        models.put(KolossAgeState.VERY_OLD,  new KolossVeryOldModel<>(context.bakeLayer(KolossVeryOldModel.LAYER_LOCATION)));
    }

    @Override
    public ResourceLocation getTextureLocation(KolossEntity entity) {
        return TEXTURES.get(entity.getAgeState());
    }


    @Override
    public void render(KolossEntity entity, float entityYaw, float partialTicks,
                       PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        this.model = models.get(entity.getAgeState());
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}