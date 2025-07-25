package com.jinxedstudios.hellwalker.event;

import com.jinxedstudios.hellwalker.Hellwalker;
import com.jinxedstudios.hellwalker.entities.*;
import com.jinxedstudios.hellwalker.entities.possessed_scientist.PossessedScientistEntity;
import com.jinxedstudios.hellwalker.entities.possessed_scientist.PossessedScientistModel;
import com.jinxedstudios.hellwalker.entities.unwilling.UnwillingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;

@EventBusSubscriber(modid = Hellwalker.MODID)
public class HellwalkerEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
      //  event.registerLayerDefinition(PossessedScientistModel.LAYER_LOCATION, PossessedScientistModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(HellwalkerEntities.POSSESSED_SCIENTIST.get(), PossessedScientistEntity.createAttributes().build());
        event.put(HellwalkerEntities.UNWILLING.get(), UnwillingEntity.createAttributes().build());
    }

}