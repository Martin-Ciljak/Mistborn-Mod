package net.chilly.mistbornmod.item;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.block.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
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
                        output.accept(Items.IRON_INGOT);
                        output.accept(ModItems.STEEL_INGOT);
                        output.accept(ModItems.TIN_INGOT);
                        output.accept(ModItems.PEWTER_INGOT);
                        output.accept(ModItems.ZINC_INGOT);
                        output.accept(ModItems.BRASS_INGOT);
                        output.accept(Items.COPPER_INGOT);
                        output.accept(ModItems.BRONZE_INGOT);
                        output.accept(ModItems.CHROMIUM_INGOT);
                        output.accept(ModItems.NICROSIL_INGOT);
                        output.accept(ModItems.ALUMINUM_INGOT);
                        output.accept(ModItems.DURALUMIN_INGOT);
                        output.accept(ModItems.CADMIUM_INGOT);
                        output.accept(ModItems.BENDALLOY_INGOT);
                        output.accept(Items.GOLD_INGOT);
                        output.accept(ModItems.ELECTRUM_INGOT);
                        output.accept(ModItems.SILVER_INGOT);

                        output.accept(Items.RAW_IRON);
                        output.accept(ModItems.RAW_TIN);
                        output.accept(ModItems.RAW_ZINC);
                        output.accept(Items.RAW_COPPER);
                        output.accept(ModItems.RAW_CHROMIUM);
                        output.accept(ModItems.RAW_ALUMINUM);
                        output.accept(ModItems.RAW_CADMIUM);
                        output.accept(Items.RAW_GOLD);
                        output.accept(ModItems.RAW_SILVER);

                        output.accept(ModBlocks.STEEL_BLOCK);
                        output.accept(ModBlocks.TIN_BLOCK);

                        output.accept(ModBlocks.TIN_ORE);
                        output.accept(ModBlocks.SILVER_ORE);
                        output.accept(ModBlocks.DEEPSLATE_TIN_ORE);

                        output.accept(ModBlocks.STEEL_STAIRS);
                        output.accept(ModBlocks.STEEL_SLAB);
                        output.accept(ModBlocks.STEEL_PRESSURE_PLATE);
                        output.accept(ModBlocks.STEEL_BUTTON);
                        output.accept(ModBlocks.STEEL_FENCE);
                        output.accept(ModBlocks.STEEL_FENCE_GATE);
                        output.accept(ModBlocks.STEEL_WALL);
                        output.accept(ModBlocks.STEEL_DOOR);
                        output.accept(ModBlocks.STEEL_TRAPDOOR);

                        output.accept(ModBlocks.STEEL_LAMP);
                        output.accept(ModItems.BAYWRAP);
                        output.accept(ModItems.VENTURE_WINE);

                        output.accept(ModItems.WINE_BOTTLE);
                    }).build());

    public static final Supplier<CreativeModeTab> TUTORIAL_ITEMS_TAB = CREATIVE_MOD_TAB.register("tutorial_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TIN_INGOT.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "mistborn_items_tab"))
                    .title(Component.translatable("creativetab.mistborn.tutorial_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CHISEL);
                        output.accept(ModBlocks.MAGIC_BLOCK);
                    }).build());



    public static void register(IEventBus eventBus) {
        CREATIVE_MOD_TAB.register(eventBus);
    }
}
