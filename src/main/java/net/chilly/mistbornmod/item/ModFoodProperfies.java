package net.chilly.mistbornmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

public class ModFoodProperfies {
    public static final FoodProperties BAYWRAP = new FoodProperties.Builder().nutrition(6).saturationModifier(0.7f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 40), 0.2f).build();
    public static final FoodProperties VENTURE_WINE = new FoodProperties.Builder().nutrition(2).saturationModifier(0.1f)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 800), 0.2f).alwaysEdible().usingConvertsTo(ModItems.WINE_BOTTLE).build();
    public static final FoodProperties BARLEY = new FoodProperties.Builder().nutrition(1).saturationModifier(0.1f).build();
    public static final FoodProperties COOKED_BARLEY = new FoodProperties.Builder().nutrition(3).saturationModifier(0.3f).build();
}
