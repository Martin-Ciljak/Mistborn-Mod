package net.chilly.mistbornmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.entity.custom.ClipProjectileEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import org.checkerframework.checker.units.qual.C;

public class ClipProjectileRenderer extends EntityRenderer<ClipProjectileEntity> {
    private ClipProjectileModel model;

    public ClipProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new ClipProjectileModel(context.bakeLayer(ClipProjectileModel.LAYER_LOCATION));
    }

    @Override
    public void render(ClipProjectileEntity p_entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();

        // Center & rotate
        poseStack.translate(0.0f, 0.0f, 0.0f); // adjust if needed

        // Get the texture buffer
        VertexConsumer vertexconsumer = bufferSource.getBuffer(this.model.renderType(getTextureLocation(p_entity)));

        // Render model
        this.model.renderToBuffer(
                poseStack,
                vertexconsumer,
                packedLight,
                OverlayTexture.NO_OVERLAY
        );

        poseStack.popPose();

        super.render(p_entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(ClipProjectileEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "textures/entity/clip/clip.png");
    }
}
