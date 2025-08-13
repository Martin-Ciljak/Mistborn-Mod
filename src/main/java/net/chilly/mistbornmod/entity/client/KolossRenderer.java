package net.chilly.mistbornmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.entity.custom.KolossEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class KolossRenderer extends MobRenderer<KolossEntity, KolossModel<KolossEntity>> {
    public KolossRenderer(EntityRendererProvider.Context context) {
        super(context, new KolossModel<>(context.bakeLayer(KolossModel.LAYER_LOCATION)), 1f);
    }


    @Override
    public ResourceLocation getTextureLocation(KolossEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "textures/entity/koloss/koloss.png");
    }

    @Override
    public void render(KolossEntity entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        poseStack.scale(1f, 1f, 1f);
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}
