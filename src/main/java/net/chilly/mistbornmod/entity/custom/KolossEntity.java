package net.chilly.mistbornmod.entity.custom;

import net.chilly.mistbornmod.entity.KolossAgeState;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public class KolossEntity extends Monster {
    public UUID leader = null;

    public static final EntityDataAccessor<Integer> AGE_STATE =
            SynchedEntityData.defineId(KolossEntity.class, EntityDataSerializers.INT);

    public KolossEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.6, true));
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Player.class, false));
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, AbstractVillager.class, false));
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Zombie.class, false));
        this.goalSelector.addGoal(3, new NearestAttackableTargetGoal<>(this, Skeleton.class, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1));
        this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, 32.0f));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
                .add(Attributes.FOLLOW_RANGE, 64.0)
                .add(Attributes.MOVEMENT_SPEED, 0.25d)
                .add(Attributes.ATTACK_DAMAGE, 45.0)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1.0)
                .add(Attributes.MAX_HEALTH, 1000.0)
                .add(Attributes.STEP_HEIGHT, 1.5)
                .add(Attributes.ENTITY_INTERACTION_RANGE, 10);
    }

    @Override
    public void checkDespawn() {
        super.checkDespawn();
    }

    @Override
    public boolean canAttack(LivingEntity target) {
        return super.canAttack(target);
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return false;
    }

    @Override
    public void tick() {
        super.tick();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(AGE_STATE, 0);
    }

    public int getTypeAgeState() {
        return this.entityData.get(AGE_STATE);
    }

    public KolossAgeState getAgeState() {
        return KolossAgeState.byId(this.getTypeAgeState() & 255);
    }

    private void setAgeState(KolossAgeState ageState) {
        this.entityData.set(AGE_STATE, ageState.getId() & 255);
        this.refreshDimensions();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("AgeState", this.getTypeAgeState());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.entityData.set(AGE_STATE, compound.getInt("AgeState"));
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        super.onSyncedDataUpdated(key);
        if (AGE_STATE.equals(key)) {
            this.refreshDimensions(); // client also updates hitbox
        }
    }


    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {

        KolossAgeState ageState = Util.getRandom(KolossAgeState.values(), this.random);
        this.setAgeState(ageState);


        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }
}
