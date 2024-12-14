// Made with Blockbench 4.11.2
// Exported for Minecraft version 1.15 - 1.16 with MCP mappings
// Paste this class into your mod and generate all required imports


public class model_Converted extends EntityModel<Entity> {
	private final ModelRenderer arm;
	private final ModelRenderer left_arm;
	private final ModelRenderer left_sleeve;
	private final ModelRenderer ring;

	public model_Converted() {
		textureWidth = 16;
		textureHeight = 16;

		arm = new ModelRenderer(this);
		arm.setRotationPoint(8.0F, 24.0F, -8.0F);
		

		left_arm = new ModelRenderer(this);
		left_arm.setRotationPoint(5.0F, -22.0F, 0.0F);
		arm.addChild(left_arm);
		left_arm.setTextureOffset(32, 48).addBox(-15.0F, 9.0F, 6.0F, 3.0F, 12.0F, 4.0F, 0.0F, false);

		left_sleeve = new ModelRenderer(this);
		left_sleeve.setRotationPoint(5.0F, -22.0F, 0.0F);
		arm.addChild(left_sleeve);
		left_sleeve.setTextureOffset(48, 48).addBox(-15.0F, 9.0F, 6.0F, 3.0F, 12.0F, 4.0F, 0.25F, false);

		ring = new ModelRenderer(this);
		ring.setRotationPoint(4.0F, 18.0F, -2.0F);
		ring.setTextureOffset(0, -1).addBox(-2.745F, 0.0F, -0.375F, 0.0F, 4.75F, 4.75F, 0.0F, false);
		ring.setTextureOffset(4, 0).addBox(-6.3075F, 1.1875F, -0.375F, 0.0F, 2.375F, 4.75F, 0.0F, false);
		ring.setTextureOffset(7, 2).addBox(-6.3075F, 1.1875F, 4.375F, 3.5625F, 2.375F, 0.0F, 0.0F, false);
		ring.setTextureOffset(0, 0).addBox(-6.3075F, 1.1875F, -0.375F, 3.5625F, 2.375F, 0.0F, 0.0F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		arm.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
		ring.render(matrixStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}