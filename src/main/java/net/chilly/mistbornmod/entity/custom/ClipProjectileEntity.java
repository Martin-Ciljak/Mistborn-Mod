package net.chilly.mistbornmod.entity.custom;

import net.chilly.mistbornmod.entity.ModEntities;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;

public class ClipProjectileEntity extends Projectile {
    public ClipProjectileEntity(EntityType<? extends Projectile> entityType, Level level) {
        super(entityType, level);
    }

    public ClipProjectileEntity(LivingEntity owner, Level level) {
        this(ModEntities.CLIP.get(), level);
        this.setOwner(owner);
        this.setPos(
                owner.getX() - (double)(Mth.cos(owner.getYRot() * ((float)Math.PI / 180F)) * 0.16F),
                owner.getEyeY() - 0.1,
                owner.getZ() - (double)(Mth.sin(owner.getYRot() * ((float)Math.PI / 180F)) * 0.16F));
    }

    @Override
    public void tick() {
        super.tick();

        this.move(MoverType.SELF, this.getDeltaMovement());

        if (!this.isNoGravity()) {
            this.setDeltaMovement(this.getDeltaMovement().add(0, -0.1, 0));
        }

        HitResult hit = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hit.getType() != HitResult.Type.MISS) {
            this.onHit(hit);
        }
    }

    @Override
    protected void onHit(HitResult result) {
        if (result.getType() == HitResult.Type.BLOCK) {
            this.setDeltaMovement(this.getDeltaMovement().scale(0).multiply(1, -1, 1));
        }
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {

    }
}


