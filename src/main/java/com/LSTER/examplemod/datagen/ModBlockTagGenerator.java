package com.LSTER.examplemod.datagen;

import com.LSTER.examplemod.examplemod;
import com.LSTER.examplemod.block.ModBlocks;
import com.LSTER.examplemod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * Handles the generation of block tags for metal detector valuables, mineability with pickaxe, and tool requirements.
 */
public class ModBlockTagGenerator extends BlockTagsProvider {

    /**
     * Constructs a new ModBlockTagGenerator instance.
     *
     * @param output             The pack output for writing data.
     * @param lookupProvider     The lookup provider for obtaining data holders.
     * @param existingFileHelper The existing file helper for resolving existing files.
     */
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, examplemod.MOD_ID, existingFileHelper);
    }

    /**
     * Adds tags for mod blocks, defining properties like metal detector valuables, mineability, and tool requirements.
     *
     * @param pProvider The data provider for accessing data holders.
     */
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Tag for metal detector valuables
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.STEEL_ORE.get()).addTag(Tags.Blocks.ORES);

        // Tag for mineability with pickaxe
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.STEEL_ORE.get(),
                        ModBlocks.STEEL_BLOCK.get());

        // Tag for tool requirements (needs iron tool)
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.STEEL_ORE.get(),
                        ModBlocks.STEEL_BLOCK.get());
    }
}

