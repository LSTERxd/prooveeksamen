package com.LSTER.examplemod.datagen;

import com.LSTER.examplemod.datagen.loot.ModBlockLootTables;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

/**
 * This provider is used to generate loot tables for blocks.
 */
public class ModLootTableProvider {

    /**
     * Creates a new loot table provider for mod blocks.
     *
     * @param output The pack output for writing data.
     * @return A LootTableProvider instance for mod blocks.
     */
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}

