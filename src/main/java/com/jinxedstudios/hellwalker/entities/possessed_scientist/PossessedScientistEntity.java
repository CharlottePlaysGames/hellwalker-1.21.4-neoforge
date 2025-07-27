package com.jinxedstudios.hellwalker.entities.possessed_scientist;

import com.jinxedstudios.hellwalker.sounds.HellwalkerSounds;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import java.util.Random;

public class PossessedScientistEntity extends Monster implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private GeoBlockEntity entity;

    private boolean swinging;
    private boolean lastloop;
    private long lastSwing;
    private long attackTriggerTick = -1;

    public PossessedScientistEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 150D)
                .add(Attributes.ATTACK_DAMAGE, 20f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.2f)
                .add(Attributes.FOLLOW_RANGE, 32);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));


        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, IronGolem.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
    }

    private void performAttack() {
        LivingEntity target = this.getTarget(); // Assumes you have a target set (like a Player)

        if (target != null && this.distanceToSqr(target) < 4.0D) { // within 2 blocks
            target.hurt(this.damageSources().mobAttack(this), 6.0F); // Replace 6.0F with your desired damage
        }
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "movementController", 0, this::movementPredicate).transitionLength(4));

        controllerRegistrar.add(new AnimationController<>(this, "attackController", 0, this::attackPredicate).transitionLength(2));

        controllerRegistrar.add(new AnimationController<>(this, "landingController", 0, this::landingPredicate).transitionLength(2));
        }
    private <T extends GeoAnimatable> PlayState movementPredicate(AnimationState<T> state) {
        double dx = this.getX() - this.xOld;
        double dz = this.getZ() - this.zOld;
        float velocity = (float) Math.sqrt(dx * dx + dz * dz);

        if (!this.swinging) {
            if (velocity > 0.05F && this.onGround()) {
                state.getController().setAnimation(
                        RawAnimation.begin()
                                .thenLoop("animation.possessed_scientist.walk")

                );
            } else {
                state.getController().setAnimation(
                        RawAnimation.begin()
                                .thenLoop("animation.possessed_scientist.idle")

                );
            }
        }

        return PlayState.CONTINUE;
    }

    private <T extends GeoAnimatable> PlayState attackPredicate(AnimationState<T> state) {
        if (this.getAttackAnim(state.getPartialTick()) > 0.0F && !this.swinging) {
            this.swinging = true;
            this.lastSwing = this.level().getGameTime();
            this.attackTriggerTick = this.lastSwing + 6; // Delay of 8 ticks

            // ✅ Force controller reset so it can replay the animation
            state.getController().forceAnimationReset();

            state.getController().setAnimation(
                    RawAnimation.begin()
                            .then("animation.possessed_scientist.attack", Animation.LoopType.PLAY_ONCE)
            );

            return PlayState.CONTINUE;
        }

        // ✅ Reset swinging after the attack animation is done playing
        if (this.swinging && state.getController().getAnimationState() == AnimationController.State.STOPPED) {
            this.swinging = false;
        }

        return PlayState.CONTINUE;
    }
    private <T extends GeoAnimatable> PlayState landingPredicate(AnimationState<T> state) {
        if (this.justLanded) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(
                    RawAnimation.begin().then("animation.possessed_scientist.land", Animation.LoopType.PLAY_ONCE)
            );
            this.justLanded = false; // Reset after animation plays
            return PlayState.CONTINUE;
        }


        return PlayState.CONTINUE;
    }
    private boolean justLanded = false;
    @Override
    public void aiStep() {
        super.aiStep();

        if (this.swinging && this.attackTriggerTick > 0 && this.level().getGameTime() >= this.attackTriggerTick) {
            this.performAttack(); // Your actual damage-dealing code here
            this.attackTriggerTick = -1; // Prevent multiple triggers per attack
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return HellwalkerSounds.POSSESSED_SCIENTIST_SAY.get();
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damageSource) {
        return HellwalkerSounds.POSSESSED_SCIENTIST_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return HellwalkerSounds.POSSESSED_SCIENTIST_DEATH.get();
    }
    @Override
    public boolean isAffectedByFluids() {
        return false;  // Prevents slowing and damage from fluids like water.
    }
    @Override
    public float maxUpStep() {
        return 2.0f;
    }
    @Override
    public boolean isPushable() {
        return false;
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    @Override
    public void tick() {
        super.tick();

    }

}

