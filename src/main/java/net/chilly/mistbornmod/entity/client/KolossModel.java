package net.chilly.mistbornmod.entity.client;// Made with Blockbench 4.12.6
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.entity.client.KolossAnimations;
import net.chilly.mistbornmod.entity.custom.KolossEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class KolossModel<T extends KolossEntity> extends HierarchicalModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "koloss"), "main");
	private final ModelPart body;
	private final ModelPart torso;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart sword;
	private final ModelPart head;
	private final ModelPart right_leg;
	private final ModelPart right_lower_leg;
	private final ModelPart right_foot;
	private final ModelPart left_leg;
	private final ModelPart left_lower_leg;
	private final ModelPart left_foot;

	public KolossModel(ModelPart root) {
		this.body = root.getChild("body");
		this.torso = this.body.getChild("torso");
		this.left_arm = this.body.getChild("left_arm");
		this.right_arm = this.body.getChild("right_arm");
		this.sword = this.right_arm.getChild("sword");
		this.head = this.body.getChild("head");
		this.right_leg = this.body.getChild("right_leg");
		this.right_lower_leg = this.right_leg.getChild("right_lower_leg");
		this.right_foot = this.right_lower_leg.getChild("right_foot");
		this.left_leg = this.body.getChild("left_leg");
		this.left_lower_leg = this.left_leg.getChild("left_lower_leg");
		this.left_foot = this.left_lower_leg.getChild("left_foot");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 23.0F, 0.0F));

		PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(84, 76).addBox(-8.0F, -29.0F, -2.0F, 16.0F, 10.0F, 6.0F, new CubeDeformation(0.0F))
				.texOffs(84, 54).addBox(-10.0F, -41.0F, -4.0F, 20.0F, 12.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_arm = body.addOrReplaceChild("left_arm", CubeListBuilder.create().texOffs(84, 92).addBox(-3.0F, -5.0F, -7.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(120, 112).addBox(-1.5F, 3.0F, -4.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(12.0F, -34.0F, 2.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r1 = left_arm.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(108, 28).addBox(-3.49F, -11.5914F, -2.1026F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(2.0F, 22.9358F, -4.9145F, -0.3054F, 0.0F, 0.0F));

		PartDefinition right_arm = body.addOrReplaceChild("right_arm", CubeListBuilder.create().texOffs(0, 104).addBox(-5.0F, -5.0F, -7.0F, 8.0F, 8.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 124).addBox(-4.5F, 3.0F, -4.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-12.0F, -34.0F, 2.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition cube_r2 = right_arm.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(72, 112).addBox(-2.49F, -11.5914F, -2.1026F, 6.0F, 12.0F, 6.0F, new CubeDeformation(0.01F)), PartPose.offsetAndRotation(-2.0F, 22.9358F, -4.9145F, -0.3054F, 0.0F, 0.0F));

		PartDefinition sword = right_arm.addOrReplaceChild("sword", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition cube_r3 = sword.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 54).addBox(-3.49F, -4.1288F, -47.1079F, 4.0F, 12.0F, 38.0F, new CubeDeformation(0.01F))
				.texOffs(0, 0).addBox(-3.5F, -0.1388F, -51.0979F, 4.0F, 4.0F, 50.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 20.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		PartDefinition head = body.addOrReplaceChild("head", CubeListBuilder.create().texOffs(40, 104).addBox(-4.0F, -6.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -39.0F, 0.0F, 0.0F, 0.0F, 0.0F));

		PartDefinition right_leg = body.addOrReplaceChild("right_leg", CubeListBuilder.create(), PartPose.offset(-6.0F, -18.0F, 0.0F));

		PartDefinition cube_r4 = right_leg.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(96, 112).addBox(-2.01F, -1.01F, -1.99F, 6.0F, 10.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -0.8658F, 0.0948F, -0.2182F, 0.0F, 0.0F));

		PartDefinition right_lower_leg = right_leg.addOrReplaceChild("right_lower_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition cube_r5 = right_lower_leg.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(40, 120).addBox(-4.0F, -9.0F, -4.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 7.6482F, 1.3062F, 0.1745F, 0.0F, 0.0F));

		PartDefinition right_foot = right_lower_leg.addOrReplaceChild("right_foot", CubeListBuilder.create().texOffs(108, 0).addBox(-1.99F, -2.99F, -6.01F, 6.0F, 4.0F, 10.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		PartDefinition left_leg = body.addOrReplaceChild("left_leg", CubeListBuilder.create(), PartPose.offset(6.0F, -18.0F, 0.0F));

		PartDefinition cube_r6 = left_leg.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(124, 92).addBox(-4.01F, -1.01F, -1.99F, 6.0F, 10.0F, 6.0F, new CubeDeformation(-0.01F)), PartPose.offsetAndRotation(0.0F, -0.8658F, 0.0948F, -0.2182F, 0.0F, 0.0F));

		PartDefinition left_lower_leg = left_leg.addOrReplaceChild("left_lower_leg", CubeListBuilder.create(), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition cube_r7 = left_lower_leg.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(128, 76).addBox(-2.0F, -9.0F, -4.0F, 6.0F, 10.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 7.6482F, 1.3062F, 0.1745F, 0.0F, 0.0F));

		PartDefinition left_foot = left_lower_leg.addOrReplaceChild("left_foot", CubeListBuilder.create().texOffs(108, 14).addBox(-3.99F, -2.99F, -6.01F, 6.0F, 4.0F, 10.0F, new CubeDeformation(0.01F)), PartPose.offset(0.0F, 10.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}



	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyHeadRotation(netHeadYaw, headPitch);

		this.animateWalk(KolossAnimations.ANIM_KOLOSS_WALK, limbSwing, limbSwingAmount, 2f, 1f);
	}

	private void applyHeadRotation(float headYaw, float headPitch) {
		headYaw = Mth.clamp(headYaw, -33f, 33f);
		headPitch = Mth.clamp(headPitch, -45f, 45f);

		this.head.yRot = headYaw * ((float) Math.PI / 180f);
		this.head.xRot = headPitch * ((float) Math.PI / 180f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, int color) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, color);
	}


	@Override
	public ModelPart root() {
		return body;
	}

}
