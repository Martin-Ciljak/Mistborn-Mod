package net.chilly.mistbornmod.item.custom;

import net.chilly.mistbornmod.item.ModItems;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.List;

public class VentureWineItem extends Item {

    public VentureWineItem(Properties properties) {
        super(properties);
    }

    @Override
    public int getMaxStackSize(ItemStack stack) {
        return 1;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            tooltipComponents.add(Component.translatable("tooltip.mistborn.venture_wine.shift_down"));
        } else {
            tooltipComponents.add(Component.translatable("tooltip.mistborn.venture_wine"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack stack) {
        return new ItemStack(ModItems.WINE_BOTTLE.get()); // returns an empty bucket
    }

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return true;
    }
    //    @Override
//    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity livingEntity) {
//        return super.finishUsingItem(stack, level, livingEntity);
//    }
}
