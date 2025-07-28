package net.chilly.mistbornmod.item;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.item.custom.ChiselItem;
import net.chilly.mistbornmod.item.custom.VentureWineItem;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MistbornMod.MOD_ID);

//  PHYSICAL
//  Iron already exists
    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TIN_INGOT = ITEMS.register("tin_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> PEWTER_INGOT = ITEMS.register("pewter_ingot",
            () -> new Item(new Item.Properties()));
//  MENTAL
    public static final DeferredItem<Item> ZINC_INGOT = ITEMS.register("zinc_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BRASS_INGOT = ITEMS.register("brass_ingot",
            () -> new Item(new Item.Properties()));
//  Copper already exists
    public static final DeferredItem<Item> BRONZE_INGOT = ITEMS.register("bronze_ingot",
            () -> new Item(new Item.Properties()));
//  ENHANCEMENT
    public static final DeferredItem<Item> CHROMIUM_INGOT = ITEMS.register("chromium_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> NICROSIL_INGOT = ITEMS.register("nicrosil_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> DURALUMIN_INGOT = ITEMS.register("duralumin_ingot",
            () -> new Item(new Item.Properties()));
//  TEMPORAL
    public static final DeferredItem<Item> CADMIUM_INGOT = ITEMS.register("cadmium_ingot",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BENDALLOY_INGOT = ITEMS.register("bendalloy_ingot",
            () -> new Item(new Item.Properties()));
//  Gold already exists
    public static final DeferredItem<Item> ELECTRUM_INGOT = ITEMS.register("electrum_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> RAW_TIN = ITEMS.register("raw_tin",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ZINC = ITEMS.register("raw_zinc",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_CHROMIUM = ITEMS.register("raw_chromium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_ALUMINUM = ITEMS.register("raw_aluminum",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_CADMIUM = ITEMS.register("raw_cadmium",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));

//    Foods
    public static final DeferredItem<Item> WINE_BOTTLE = ITEMS.register("wine_bottle",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> VENTURE_WINE = ITEMS.register("venture_wine",
            () -> new VentureWineItem(new Item.Properties().food(ModFoodProperfies.VENTURE_WINE)));
    public static final DeferredItem<Item> BAYWRAP = ITEMS.register("baywrap",
            () -> new Item(new Item.Properties().food(ModFoodProperfies.BAYWRAP)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.mistborn.baywrap.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });


    public static final DeferredItem<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
