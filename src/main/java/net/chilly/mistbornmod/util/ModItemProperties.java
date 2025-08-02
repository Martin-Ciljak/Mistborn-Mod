package net.chilly.mistbornmod.util;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.component.ModDataComponents;
import net.chilly.mistbornmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "used"),
                (stack, level, entity, seed) -> stack.get(ModDataComponents.COORDINATES) != null ? 1f : 0f);
        MistbornMod.LOGGER.error("ADD CUSTOM ITEM PROPERTIES TRIGGERED");
    }
}
