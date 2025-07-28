package net.chilly.mistbornmod.item;

import net.chilly.mistbornmod.util.ModTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModToolTiers {
    public static final Tier OBSIDIAN = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_OBSIDIAN_TOOL,
            16, 13f, 3f, 12, () -> Ingredient.of(Items.OBSIDIAN));
}
