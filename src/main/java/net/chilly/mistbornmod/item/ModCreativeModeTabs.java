package net.chilly.mistbornmod.item;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import javax.swing.*;
import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MistbornMod.MOD_ID);

    public static final Supplier<CreativeModeTab> MISTBORN_ITEMS_TAB = CREATIVE_MOD_TAB.register("mistborn_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN_INGOT.get()))
                    .title(Component.translatable("creativetab.mistborn.mistborn_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TIN_INGOT);
                        output.accept(ModItems.RAW_TIN);
                        output.accept(ModBlocks.TIN_BLOCK);
                        output.accept(ModBlocks.TIN_ORE);
                        output.accept(ModBlocks.SILVER_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TIN_ORE);
                    }).build());

    public static final Supplier<CreativeModeTab> TUTORIAL_ITEMS_TAB = CREATIVE_MOD_TAB.register("tutorial_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN_INGOT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "mistborn_items_tab"))
                    .title(Component.translatable("creativetab.mistborn.tutorial_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CHISEL);
                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TAB.register(eventBus);
    }
}
