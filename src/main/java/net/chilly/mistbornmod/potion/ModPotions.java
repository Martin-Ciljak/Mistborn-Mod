package net.chilly.mistbornmod.potion;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.effect.ModEffects;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(BuiltInRegistries.POTION, MistbornMod.MOD_ID);

    public static final Holder<Potion> ADMIN_POTION = POTIONS.register("admin_potion",
            () -> new Potion());
    public static final Holder<Potion> PEWTER_POTION = POTIONS.register("pewter_potion",
            () -> new Potion(new MobEffectInstance(ModEffects.PEWTER_EFFECT, 1200, 0)){});

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
