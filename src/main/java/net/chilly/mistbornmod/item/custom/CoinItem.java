package net.chilly.mistbornmod.item.custom;

import net.chilly.mistbornmod.entity.custom.CoinProjectileEnity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CoinItem extends Item {
    private final EntityType<? extends Projectile> coin;

    public CoinItem(EntityType<? extends Projectile> coin, Properties properties) {
        super(properties);
        this.coin = coin;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.IRON_DOOR_OPEN, SoundSource.NEUTRAL, 0.5f, 0.4f / (level.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!level.isClientSide) {
            CoinProjectileEnity coinProjectile = new CoinProjectileEnity(this.coin, player, level);
            coinProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1f, 0.5f);
            level.addFreshEntity(coinProjectile);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemStack.consume(1, player);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide);
    }
}
