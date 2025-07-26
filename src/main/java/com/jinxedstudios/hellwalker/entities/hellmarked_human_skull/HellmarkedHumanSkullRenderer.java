package com.jinxedstudios.hellwalker.entities.hellmarked_human_skull;

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

public class HellmarkedHumanSkullRenderer extends GeoEntityRenderer<HellmarkedHumanSkullEntity> {
    public HellmarkedHumanSkullRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HellmarkedHumanSkullModel());
    }

    @Override
    public ResourceLocation getTextureLocation(HellmarkedHumanSkullEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "textures/entity/hellmarked_human_skull.png");
    }

    @Override
    public void renderFinal(PoseStack poseStack, HellmarkedHumanSkullEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, float partialTick, int packedLight, int packedOverlay, int colour) {
        super.renderFinal(poseStack, animatable, model, bufferSource, buffer, partialTick, packedLight, packedOverlay, colour); // Call to parent renderFinal
    }
}

