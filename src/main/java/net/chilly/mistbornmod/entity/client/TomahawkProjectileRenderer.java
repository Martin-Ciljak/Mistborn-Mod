package net.chilly.mistbornmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.entity.custom.TomahawkProjectileEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TomahawkProjectileRenderer extends EntityRenderer<TomahawkProjectileEntity> {
    private TomahawkProjectileModel model;

    public TomahawkProjectileRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.model = new TomahawkProjectileModel(context.bakeLayer(TomahawkProjectileModel.LAYER_LOCATION));
    }

    @Override
    public void render(TomahawkProjectileEntity p_entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        poseStack.pushPose();
        if (!p_entity.isGrounded()) {
            poseStack.mulPose(Axis.YP.rotationDegrees(Mth.lerp(partialTick, p_entity.yRotO, p_entity.getYRot())));
            poseStack.mulPose(Axis.XP.rotationDegrees(p_entity.getRenderingRotation() * 5f));
            poseStack.translate(0, -0.5f, 0);
        } else {
            poseStack.mulPose(Axis.YP.rotationDegrees((float) p_entity.groundedOffset.y));
            poseStack.mulPose(Axis.XP.rotationDegrees((float) p_entity.groundedOffset.x));
            poseStack.translate(0, -0.5f, 0);
        }
        VertexConsumer vertexConsumer = ItemRenderer.getFoilBufferDirect(
                bufferSource, this.model.renderType(this.getTextureLocation(p_entity)), false, false);
        this.model.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY);
        poseStack.popPose();

        super.render(p_entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(TomahawkProjectileEntity entity) {
        return ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "textures/entity/tomahawk/tomahawk.png");
    }
}
