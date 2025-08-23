package net.chilly.mistbornmod.item.custom;

import net.chilly.mistbornmod.entity.custom.TomahawkProjectileEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class TomahawkItem extends Item {
    public TomahawkItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand usedHand) {
        ItemStack itemStack = player.getItemInHand(usedHand);
        level.playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.SNOWBALL_THROW, SoundSource.NEUTRAL, 0.5f, 0.4f / (level.getRandom().nextFloat() * 0.4f + 0.8f));
        if (!level.isClientSide) {
            TomahawkProjectileEntity tomahawkProjectile = new TomahawkProjectileEntity(player, level);
            tomahawkProjectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0f, 1.5f, 0f);
            level.addFreshEntity(tomahawkProjectile);
        }

        player.awardStat(Stats.ITEM_USED.get(this));
        if (!player.getAbilities().instabuild) {
            itemStack.consume(1, player);
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide);
    }
}
