package net.chilly.mistbornmod.entity;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.entity.custom.GeckoEntity;
import net.chilly.mistbornmod.entity.custom.KolossEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, MistbornMod.MOD_ID);

    public static final Supplier<EntityType<GeckoEntity>> GECKO =
            ENTITY_TYPES.register("gecko", () -> EntityType.Builder.of(GeckoEntity::new, MobCategory.CREATURE)
                    .sized(0.75f, 0.35f).build("gecko"));
    public static final Supplier<EntityType<KolossEntity>> KOLOSS =
            ENTITY_TYPES.register("koloss", () -> EntityType.Builder.of(KolossEntity::new, MobCategory.MONSTER)
                    .sized(1.2f, 3f).build("koloss"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
