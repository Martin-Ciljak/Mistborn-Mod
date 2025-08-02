package net.chilly.mistbornmod.datagen;

import net.chilly.mistbornmod.MistbornMod;
import net.chilly.mistbornmod.item.ModItems;
import net.chilly.mistbornmod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, blockTags, MistbornMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.ALLOMANTIC_METALS)
                .add(Items.IRON_INGOT)
                .add(ModItems.STEEL_INGOT.get())
                .add(ModItems.TIN_INGOT.get())
                .add(ModItems.PEWTER_INGOT.get())
                .add(ModItems.ZINC_INGOT.get())
                .add(ModItems.BRASS_INGOT.get())
                .add(Items.COPPER_INGOT)
                .add(ModItems.BRONZE_INGOT.get())
                .add(ModItems.CHROMIUM_INGOT.get())
                .add(ModItems.NICROSIL_INGOT.get())
                .add(ModItems.ALUMINUM_INGOT.get())
                .add(ModItems.DURALUMIN_INGOT.get())
                .add(ModItems.CADMIUM_INGOT.get())
                .add(ModItems.BENDALLOY_INGOT.get())
                .add(Items.GOLD_INGOT)
                .add(ModItems.ELECTRUM_INGOT.get());
        tag(ItemTags.SWORDS)
                .add(ModItems.GLASS_DAGGER.get());
        tag(ItemTags.AXES)
                .add(ModItems.INQUISITOR_AXE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ALUMINUM_HELMET.get());
    }
}
