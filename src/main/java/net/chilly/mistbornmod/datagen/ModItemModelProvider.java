package net.chilly.mistbornmod.datagen;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.block.ModBlocks;
import net.chilly.mistbornmod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, MistbornMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.STEEL_INGOT.get());
        basicItem(ModItems.TIN_INGOT.get());
        basicItem(ModItems.PEWTER_INGOT.get());
        basicItem(ModItems.ZINC_INGOT.get());
        basicItem(ModItems.BRASS_INGOT.get());
        basicItem(ModItems.BRONZE_INGOT.get());
        basicItem(ModItems.CHROMIUM_INGOT.get());
        basicItem(ModItems.NICROSIL_INGOT.get());
        basicItem(ModItems.ALUMINUM_INGOT.get());
        basicItem(ModItems.DURALUMIN_INGOT.get());
        basicItem(ModItems.CADMIUM_INGOT.get());
        basicItem(ModItems.BENDALLOY_INGOT.get());
        basicItem(ModItems.ELECTRUM_INGOT.get());
        basicItem(ModItems.SILVER_INGOT.get());

        basicItem(ModItems.RAW_TIN.get());
        basicItem(ModItems.RAW_ZINC.get());
        basicItem(ModItems.RAW_CHROMIUM.get());
        basicItem(ModItems.RAW_ALUMINUM.get());
        basicItem(ModItems.RAW_CADMIUM.get());
        basicItem(ModItems.RAW_SILVER.get());


        buttonItem(ModBlocks.STEEL_BUTTON, ModBlocks.STEEL_BLOCK);
        fenceItem(ModBlocks.STEEL_FENCE, ModBlocks.STEEL_BLOCK);
        wallItem(ModBlocks.STEEL_WALL, ModBlocks.STEEL_BLOCK);
        basicItem(ModBlocks.STEEL_DOOR.asItem());

        basicItem(ModItems.BAYWRAP.get());
        basicItem(ModItems.VENTURE_WINE.get());

        basicItem(ModItems.WINE_BOTTLE.get());

        basicItem(ModItems.CHISEL.get());

        handheldItem(ModItems.GLASS_DAGGER);
        handheldItem(ModItems.INQUISITOR_AXE);



    }

    public void buttonItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void fenceItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(DeferredItem<?> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(MistbornMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
