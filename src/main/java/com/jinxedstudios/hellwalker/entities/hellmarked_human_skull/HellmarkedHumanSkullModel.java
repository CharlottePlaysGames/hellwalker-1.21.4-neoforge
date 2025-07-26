package com.jinxedstudios.hellwalker.entities.hellmarked_human_skull;

import com.jinxedstudios.hellwalker.Hellwalker;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animation.AnimationState;
import software.bernie.geckolib.cache.object.GeoBone;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;
import software.bernie.geckolib.renderer.GeoRenderer;


public class HellmarkedHumanSkullModel extends GeoModel<HellmarkedHumanSkullEntity> {

    @Override
    public ResourceLocation getModelResource(HellmarkedHumanSkullEntity animatable, @Nullable GeoRenderer<HellmarkedHumanSkullEntity> renderer) {
        return ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "geo/entity/hellmarked_human_skull.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HellmarkedHumanSkullEntity animatable, @Nullable GeoRenderer<HellmarkedHumanSkullEntity> renderer) {
        return ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "textures/entity/hellmarked_human_skull.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HellmarkedHumanSkullEntity animatable) {
        return ResourceLocation.fromNamespaceAndPath(Hellwalker.MODID, "animations/entity/hellmarked_human_skull.animation.json");
    }

    @Override
    public void setCustomAnimations(HellmarkedHumanSkullEntity animatable, long instanceId, AnimationState<HellmarkedHumanSkullEntity> animationState) {
        GeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}

