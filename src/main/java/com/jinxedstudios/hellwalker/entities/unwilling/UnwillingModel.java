package com.jinxedstudios.hellwalker.entities.unwilling;

import com.jinxedstudios.hellwalker.Hellwalker;
import com.jinxedstudios.hellwalker.entities.possessed_scientist.PossessedScientistEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.GeoRenderer;


public class UnwillingModel extends GeoModel<UnwillingEntity> {

    @Override
    public ResourceLocation getModelResource(UnwillingEntity animatable, @Nullable GeoRenderer<UnwillingEntity> renderer) {
        return ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "geo/entity/unwilling.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(UnwillingEntity animatable, @Nullable GeoRenderer<UnwillingEntity> renderer) {
        return ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "textures/entity/unwilling.png");
    }

    @Override
    public ResourceLocation getAnimationResource(UnwillingEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "animations/entity/unwilling.animation.json");
    }

    @Override
    public void setCustomAnimations(UnwillingEntity animatable, long instanceId, AnimationState<UnwillingEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}

