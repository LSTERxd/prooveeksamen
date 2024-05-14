package com.LSTER.examplemod.datagen;

import com.LSTER.examplemod.examplemod;
import com.LSTER.examplemod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * Handles the generation of block states and models for Steel Ore and Steel Block.
 */
public class ModBlockStateProvider extends BlockStateProvider {

    /**
     * Constructs a new ModBlockStateProvider instance.
     *
     * @param output       The pack output for writing data.
     * @param exFileHelper The existing file helper for resolving existing files.
     */
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, examplemod.MOD_ID, exFileHelper);
    }

    /**
     * Registers block states and models for mod blocks.
     */
    @Override
    protected void registerStatesAndModels() {
        // Generate block states and models for Steel Ore and Steel Block.
        blockWithItem(ModBlocks.STEEL_ORE);
        blockWithItem(ModBlocks.STEEL_BLOCK);
    }

    /**
     * Generates block states and models for a specific block.
     *
     * @param blockRegistryObject The RegistryObject representing the block.
     */
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

