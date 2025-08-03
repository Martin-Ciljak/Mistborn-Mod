package net.chilly.mistbornmod.effect;

import net.chilly.mistbornmod.MistbornMod;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, MistbornMod.MOD_ID);


    public static final Holder<MobEffect> STEEL_EFFECT = MOB_EFFECTS.register("steel",
        () -> new SteelEffect(MobEffectCategory.BENEFICIAL, 0x36ebab));
    public static final Holder<MobEffect> TIN_EFFECT = MOB_EFFECTS.register("tin",
            () -> new TinEffect(MobEffectCategory.BENEFICIAL, 0x36ebab));
    public static final Holder<MobEffect> PEWTER_EFFECT = MOB_EFFECTS.register("pewter",
        () -> new PewterEffect(MobEffectCategory.BENEFICIAL, 0x36ebab)
                .addAttributeModifier(
                        Attributes.MOVEMENT_SPEED,
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "pewter"),
                        0.5f,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(
                        Attributes.ATTACK_DAMAGE,
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "pewter"),
                        1f,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(
                        Attributes.ATTACK_SPEED,
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "pewter"),
                        0.8f,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(
                        Attributes.ATTACK_KNOCKBACK,
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "pewter"),
                        1f,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(
                        Attributes.BLOCK_BREAK_SPEED,
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "pewter"),
                        0.9f,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(
                        Attributes.STEP_HEIGHT,
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "pewter"),
                        0.5f,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(
                        Attributes.JUMP_STRENGTH,
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "pewter"),
                        0.3f,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(
                        Attributes.MAX_HEALTH,
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "pewter"),
                        1f,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(
                        Attributes.WATER_MOVEMENT_EFFICIENCY,
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "pewter"),
                        1f,
                        AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL)
                .addAttributeModifier(
                        Attributes.SAFE_FALL_DISTANCE,
                        ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "pewter"),
                        1.5f,
                        AttributeModifier.Operation.ADD_VALUE)



    );




    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
