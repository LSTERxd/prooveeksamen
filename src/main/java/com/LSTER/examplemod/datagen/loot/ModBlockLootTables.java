package com.LSTER.examplemod.datagen.loot;

import com.LSTER.examplemod.block.ModBlocks;
import com.LSTER.examplemod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

/**
 * Custom loot table provider for mod blocks in the Minecraft Forge modding framework.
 * Handles loot table generation for specific blocks like steel ore and steel block.
 */
public class ModBlockLootTables extends BlockLootSubProvider {

    /**
     * Constructs a new ModBlockLootTables instance.
     */
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    /**
     * Generates loot tables for mod blocks such as steel ore and steel block.
     */
    @Override
    protected void generate() {
        // Loot table for steel ore when broken.
        this.dropSelf(ModBlocks.STEEL_ORE.get());

        // Loot table for steel block when broken.
        this.dropSelf(ModBlocks.STEEL_BLOCK.get());

        // Additional loot tables with custom drops for steel ore and steel block.
        this.add(ModBlocks.STEEL_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.STEEL_ORE.get(), ModItems.RAW_STEEL.get()));
        this.add(ModBlocks.STEEL_BLOCK.get(),
                block -> createCopperLikeOreDrops(ModBlocks.STEEL_BLOCK.get(), ModItems.STEEL_INGOT.get()));
    }

    /**
     * Creates a loot table for blocks similar to copper, with bonus counts and fortune enchantment.
     *
     * @param pBlock The block for which the loot table is generated.
     * @param item   The item dropped by the block.
     * @return       A LootTable.Builder representing the generated loot table.
     */
    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    /**
     * Retrieves an iterable of all known mod blocks for which loot tables are generated.
     *
     * @return An iterable containing mod blocks.
     */
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

