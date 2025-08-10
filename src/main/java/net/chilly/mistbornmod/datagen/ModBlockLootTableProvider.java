package net.chilly.mistbornmod.datagen;

import net.chilly.mistbornmod.block.ModBlocks;
import net.chilly.mistbornmod.block.custom.BarleyCropBlock;
import net.chilly.mistbornmod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.TIN_BLOCK.get());
        dropSelf(ModBlocks.STEEL_BLOCK.get());
        dropSelf(ModBlocks.STEEL_STAIRS.get());
        add(ModBlocks.STEEL_SLAB.get(), block -> createSlabItemTable(ModBlocks.STEEL_SLAB.get()));
        dropSelf(ModBlocks.STEEL_PRESSURE_PLATE.get());
        dropSelf(ModBlocks.STEEL_BUTTON.get());
        dropSelf(ModBlocks.STEEL_FENCE.get());
        dropSelf(ModBlocks.STEEL_FENCE_GATE.get());
        dropSelf(ModBlocks.STEEL_WALL.get());
        add(ModBlocks.STEEL_DOOR.get(), block -> createDoorTable(ModBlocks.STEEL_DOOR.get()));
        dropSelf(ModBlocks.STEEL_TRAPDOOR.get());
        dropSelf(ModBlocks.STEEL_LAMP.get());


        add(ModBlocks.TIN_ORE.get(),
                block -> createMultipleDrops(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get(), 2, 4));
        add(ModBlocks.ZINC_ORE.get(),
                block -> createOreDrop(ModBlocks.ZINC_ORE.get(), ModItems.RAW_ZINC.get()));
        add(ModBlocks.ALUMINUM_ORE.get(),
                block -> createOreDrop(ModBlocks.ALUMINUM_ORE.get(), ModItems.RAW_ALUMINUM.get()));
        add(ModBlocks.CHROMIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        add(ModBlocks.CADMIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.CADMIUM_ORE.get(), ModItems.RAW_CADMIUM.get()));
        add(ModBlocks.SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));

        add(ModBlocks.DEEPSLATE_TIN_ORE.get(),
                block -> createMultipleDrops(ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get(), 2, 4));
        add(ModBlocks.DEEPSLATE_ZINC_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_ZINC_ORE.get(), ModItems.RAW_ZINC.get()));
        add(ModBlocks.DEEPSLATE_ALUMINUM_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_ALUMINUM_ORE.get(), ModItems.RAW_ALUMINUM.get()));
        add(ModBlocks.DEEPSLATE_CHROMIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        add(ModBlocks.DEEPSLATE_CADMIUM_ORE.get(),
                block -> createOreDrop(ModBlocks.DEEPSLATE_CADMIUM_ORE.get(), ModItems.RAW_CADMIUM.get()));
        add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));

        add(ModBlocks.NETHER_SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));
        add(ModBlocks.END_SILVER_ORE.get(),
                block -> createOreDrop(ModBlocks.SILVER_ORE.get(), ModItems.RAW_SILVER.get()));

        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.BARLEY_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BarleyCropBlock.AGE, 3));
        this.add(ModBlocks.BARLEY_CROP.get(), this.createCropDrops(ModBlocks.BARLEY_CROP.get(), ModItems.BARLEY.get(), ModItems.BARLEY.get(), lootItemConditionBuilder));

        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        this.add(ModBlocks.FRUIT_BUSH.get(), block -> this.applyExplosionDecay(
                block, LootTable.lootTable()
                        .withPool(
                                LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.FRUIT_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                        )
                                        .add(LootItem.lootTableItem(ModItems.FRUITS.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 3.0f)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))
                        )
                        .withPool(
                                LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.FRUIT_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                        )
                                        .add(LootItem.lootTableItem(ModItems.FRUITS.get()))
                                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0f, 2.0f)))
                                        .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))
                        )
                )
        );

        this.dropSelf(ModBlocks.ASPEN_LOG.get());
        this.dropSelf(ModBlocks.ASPEN_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_ASPEN_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_ASPEN_WOOD.get());
        this.dropSelf(ModBlocks.ASPEN_PLANS.get());
        this.dropSelf(ModBlocks.ASPEN_SAPLING.get());

        this.add(ModBlocks.ASPEN_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.ASPEN_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }



    protected LootTable.Builder createMultipleDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
