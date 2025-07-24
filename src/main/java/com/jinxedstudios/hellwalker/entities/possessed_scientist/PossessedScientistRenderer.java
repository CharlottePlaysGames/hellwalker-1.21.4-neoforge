package com.jinxedstudios.hellwalker.entities.possessed_scientist;

import com.jinxedstudios.hellwalker.Hellwalker;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PossessedScientistRenderer extends GeoEntityRenderer<PossessedScientistEntity> {
    public PossessedScientistRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new PossessedScientistModel());
    }

    @Override
    public ResourceLocation getTextureLocation(PossessedScientistEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "textures/entity/possessed_scientist.png");
    }

    @Override
    public void renderFinal(PoseStack poseStack, PossessedScientistEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.renderFinal(poseStack, animatable, model, bufferSource, buffer, partialTick, packedLight, packedOverlay, colour); // Call to parent renderFinal
    }
}

