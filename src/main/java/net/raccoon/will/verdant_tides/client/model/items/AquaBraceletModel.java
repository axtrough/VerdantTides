package net.raccoon.will.verdant_tides.client.model.items;


import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.LivingEntity;

import javax.annotation.Nonnull;

public class AquaBraceletModel extends HumanoidModel<LivingEntity>{


	public AquaBraceletModel(ModelPart part) {
		super(part);
	}

	public static LayerDefinition createLayer() {
		CubeDeformation cube = new CubeDeformation(0.4F);
		MeshDefinition mesh = HumanoidModel.createMesh(cube, 0.0F);
		PartDefinition part = mesh.getRoot();
			part.addOrReplaceChild("left_arm",
					CubeListBuilder.create().texOffs(0, 0).addBox(-0.9F, 6F, -1.9F, 3.0F, 0.45F, 4.0F, cube),
					PartPose.offset(0.0F, 21.0F, -0.5F));

		return LayerDefinition.create(mesh, 16, 16);

		}

	@Override
	@Nonnull
	protected Iterable<ModelPart> bodyParts() {
		return ImmutableList
				.of(this.leftArm);
	}
}
