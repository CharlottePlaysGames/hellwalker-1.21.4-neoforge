package com.jinxedstudios.hellwalker.entities.hellmarked_human_skull;

import com.jinxedstudios.hellwalker.sounds.HellwalkerSounds;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
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
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;

import java.util.UUID;

public class HellmarkedHumanSkullEntity extends PathfinderMob implements GeoEntity {
    private AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private GeoBlockEntity entity;

    public HellmarkedHumanSkullEntity(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);
        this.setSilent(true);
        this.setNoGravity(true);
        this.setNoAi(true);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return PathfinderMob.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 9000D)
                .add(Attributes.MOVEMENT_SPEED, 0f)
                .add(Attributes.FOLLOW_RANGE, 0f)
                .add(Attributes.KNOCKBACK_RESISTANCE, 999f);

    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

        }
    private @Nullable UUID summonerId;
    public void setSummoner(Player player) {
        this.summonerId = player.getUUID();
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        if (summonerId != null) {
            tag.putUUID("Summoner", summonerId);
        }
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        if (tag.hasUUID("Summoner")) {
            summonerId = tag.getUUID("Summoner");
        }
    }
    @Override
    public void onAddedToLevel() {
        super.onAddedToLevel();

        if (level().isClientSide || summonerId == null) return;

        Player summoner = level().getPlayerByUUID(summonerId);
        if (summoner != null) {
            double dx = summoner.getX() - this.getX();
            double dz = summoner.getZ() - this.getZ();
            double dy = summoner.getEyeY() - this.getEyeY();

            float yaw = (float)(Mth.atan2(dx, dz) * (180F / Math.PI));
            float pitch = (float)(-Mth.atan2(dy, Math.sqrt(dx * dx + dz * dz)) * (180F / Math.PI));

            this.setYRot(yaw);
            this.setXRot(pitch);
            this.yBodyRot = yaw;
            this.yHeadRot = yaw;
        }
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
}
