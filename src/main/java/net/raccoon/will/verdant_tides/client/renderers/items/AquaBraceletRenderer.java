package net.raccoon.will.verdant_tides.client.renderers.items;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.raccoon.will.verdant_tides.VerdantTides;
import net.raccoon.will.verdant_tides.client.CuriosLayerDefinitions;
import net.raccoon.will.verdant_tides.client.model.items.AquaBraceletModel;
import net.raccoon.will.verdant_tides.common.item.AquaBracelet;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.client.ICurioRenderer;

public class AquaBraceletRenderer implements ICurioRenderer {

    private static final ResourceLocation AQUA_BRACELET_TEXTURE = ResourceLocation.fromNamespaceAndPath(VerdantTides.MODID,
            "textures/models/items/aqua_bracelet.png");

    private final AquaBraceletModel model;
    private AquaBracelet AquaBracelet;

    public AquaBraceletRenderer() {
        this.model = new AquaBraceletModel(
                Minecraft.getInstance().getEntityModels().bakeLayer(CuriosLayerDefinitions.AQUA_BRACELET));
    }



    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(
            ItemStack stack,
            SlotContext slotContext,
            PoseStack matrixStack,
            RenderLayerParent<T, M> renderLayerParent,
            MultiBufferSource renderTypeBuffer,
            int light, float limbSwing,
            float limbSwingAmount,
            float partialTicks,
            float ageInTicks,
            float netHeadYaw,
            float headPitch) {


        LivingEntity entity = slotContext.entity();
        this.model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
        this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
        ICurioRenderer.followBodyRotations(entity, this.model);

        ModelPart headPart = this.model.head;
        headPart.visible = false;

        VertexConsumer vertexconsumer = ItemRenderer
                .getArmorFoilBuffer(renderTypeBuffer, RenderType.breezeEyes(AQUA_BRACELET_TEXTURE), stack.hasFoil());
        this.model.renderToBuffer(matrixStack, vertexconsumer, LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY);

    }
}


