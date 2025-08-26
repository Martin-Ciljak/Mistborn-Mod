package net.chilly.mistbornmod.entity.custom;

import net.chilly.mistbornmod.MistbornMod;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.logging.Logger;

public class CoinProjectileEnity extends Projectile {
    public CoinProjectileEnity(EntityType<? extends Projectile> entityType, Level level) {
        super(entityType, level);
    }

    public CoinProjectileEnity(EntityType<? extends Projectile> coin, LivingEntity owner, Level level) {
        super(coin, level);
        this.setOwner(owner);
        this.setPos(
                owner.getX() - (double)(Mth.cos(owner.getYRot() * ((float)Math.PI / 180F)) * 0.16F),
                owner.getEyeY() - 0.1,
                owner.getZ() - (double)(Mth.sin(owner.getYRot() * ((float)Math.PI / 180F)) * 0.16F));
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        MistbornMod.LOGGER.debug(player.getName().toString(), hand.toString());
        return super.interact(player, hand);
    }

    @Override
    public void tick() {
        super.tick();

        this.move(MoverType.SELF, this.getDeltaMovement());

        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0, -0.1, 0));
        }

        HitResult hit = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hit.getType() != HitResult.Type.MISS && !this.onGround()) {
            onHit(hit);
        }

    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result); // call super so vanilla logic runs

        double speed = this.getDeltaMovement().length();
//        MistbornMod.LOGGER.debug("Hit block face: {}", result.getDirection());

        if (speed < 0.3) {
            this.setDeltaMovement(Vec3.ZERO);
            this.setOnGround(true);
            return;
        }

        switch (result.getDirection()) {
            case UP, DOWN -> this.setDeltaMovement(this.getDeltaMovement().scale(0.4).multiply(1, -1, 1));
            case EAST, WEST -> this.setDeltaMovement(this.getDeltaMovement().scale(0.8).multiply(-1, 1, 1));
            case NORTH, SOUTH -> this.setDeltaMovement(this.getDeltaMovement().scale(0.8).multiply(1, 1, -1));
        }
    }

    @Override
    public void checkDespawn() {
        super.checkDespawn();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }
}


