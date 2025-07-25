package com.jinxedstudios.hellwalker.entities.unwilling;

import com.jinxedstudios.hellwalker.Hellwalker;
import com.jinxedstudios.hellwalker.entities.possessed_scientist.PossessedScientistEntity;
import com.jinxedstudios.hellwalker.entities.possessed_scientist.PossessedScientistModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class UnwillingRenderer extends GeoEntityRenderer<UnwillingEntity> {
    public UnwillingRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new UnwillingModel());
    }

    @Override
    public ResourceLocation getTextureLocation(UnwillingEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "textures/entity/unwilling.png");
    }

    @Override
    public void renderFinal(PoseStack poseStack, UnwillingEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.renderFinal(poseStack, animatable, model, bufferSource, buffer, partialTick, packedLight, packedOverlay, colour); // Call to parent renderFinal
    }
}

