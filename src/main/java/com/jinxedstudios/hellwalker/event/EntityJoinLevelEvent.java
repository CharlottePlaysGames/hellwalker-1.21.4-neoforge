package com.jinxedstudios.hellwalker.event;

import com.jinxedstudios.hellwalker.Hellwalker;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

@EventBusSubscriber(modid = Hellwalker.MODID)
public class EntityJoinLevelEvent {

    @SubscribeEvent
    public static void onEntityJoinLevel(net.neoforged.neoforge.event.entity.EntityJoinLevelEvent event) {
        if (!(event.getEntity() instanceof PathfinderMob mob)) return;


        // Check for aquatic mob types
        if (mob.getType().equals(EntityType.SQUID) ||
                mob.getType().equals(EntityType.COD) ||
                mob.getType().equals(EntityType.SALMON) ||
                mob.getType().equals(EntityType.PUFFERFISH) ||
                mob.getType().equals(EntityType.TROPICAL_FISH) ||
                mob.getType().equals(EntityType.TURTLE) ||
                mob.getType().equals(EntityType.DOLPHIN) ||
                mob.getType().equals(EntityType.VILLAGER) ||
                mob.getType().equals(EntityType.WITCH) ||
                mob.getType().equals(EntityType.AXOLOTL)) {

          //  mob.goalSelector.addGoal(1, new AvoidEntityGoal<>(
            //        mob,
             //       PossessedScientistEntity.class,
         //           10.0F, // avoid distance
         //           1.2D,  // walk speed
         //           1.5D   // sprint speed
        //    ));
       //     if (mob.getType() == EntityType.VILLAGER) {
         //       mob.goalSelector.addGoal(1, new AvoidEntityGoal<>(
         //               mob,
           //             PossessedScientistEntity.class,
          //              12.0F, // avoid distance
           //             1.0D,
          //              1.3D
          //      ));
            }
        //    if (mob.getType() == EntityType.WANDERING_TRADER) {
        //        mob.goalSelector.addGoal(1, new AvoidEntityGoal<>(
        //                mob,
        //                PossessedScientistEntity.class,
         //               12.0F, // avoid distance
        //                1.0D,
         //               1.3D
        //        ));
            }
        }
    //}
//}
