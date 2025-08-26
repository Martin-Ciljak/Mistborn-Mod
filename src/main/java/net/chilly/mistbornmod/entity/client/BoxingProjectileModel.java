package net.chilly.mistbornmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.entity.custom.CoinProjectileEnity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class BoxingProjectileModel extends EntityModel<CoinProjectileEnity> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "boxing"), "main");
    private final ModelPart body;

    public BoxingProjectileModel(ModelPart root) {
        this.body = root.getChild("body");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition body = partdefinition.addOrReplaceChild("body",
                CubeListBuilder.create()
                        .texOffs(-3, -2)
                        .addBox(-3.0F, -1.0F, -3.0F, 6.0F, 1.0F, 6.0F,
                                new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 1f /*24f*/, 0.0F));

        return LayerDefinition.create(meshdefinition, 16, 16);
    }
    @Override
    public void setupAnim(CoinProjectileEnity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
        body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
    }
}
