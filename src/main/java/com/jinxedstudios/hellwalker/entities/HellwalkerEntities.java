package com.jinxedstudios.hellwalker.entities;

import com.jinxedstudios.hellwalker.Hellwalker;
import com.jinxedstudios.hellwalker.entities.hellmarked_human_skull.HellmarkedHumanSkullEntity;
import com.jinxedstudios.hellwalker.entities.possessed_scientist.PossessedScientistEntity;
import com.jinxedstudios.hellwalker.entities.unwilling.UnwillingEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class HellwalkerEntities {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, Hellwalker.MODID);
    public static ResourceKey<EntityType<?>> POSSESSED_SCIENTIST_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("possessed_scientist"));

     public static final Supplier<EntityType<PossessedScientistEntity>> POSSESSED_SCIENTIST =
            ENTITY_TYPES.register("possessed_scientist", () -> EntityType.Builder.of(PossessedScientistEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.98f)
                    .build(POSSESSED_SCIENTIST_KEY));

    public static ResourceKey<EntityType<?>> UNWILLING_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("unwilling"));

    public static final Supplier<EntityType<UnwillingEntity>> UNWILLING =
            ENTITY_TYPES.register("unwilling", () -> EntityType.Builder.of(UnwillingEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.98f)
                    .build(UNWILLING_KEY));
    public static ResourceKey<EntityType<?>> HELLMARKED_HUMAN_SKULL_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("hellmarked_human_skull"));

    public static final Supplier<EntityType<HellmarkedHumanSkullEntity>> HELLMARKED_HUMAN_SKULL =
            ENTITY_TYPES.register("hellmarked_human_skull", () -> EntityType.Builder.of(HellmarkedHumanSkullEntity::new, MobCategory.MISC)
                    .sized(0.5f, 0.5f)
                    .build(HELLMARKED_HUMAN_SKULL_KEY));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);

    }
}