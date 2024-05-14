package com.LSTER.examplemod.datagen;

import com.LSTER.examplemod.examplemod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

/**
 * Handles the generation of item tags for various purposes.
 */
public class ModItemTagGenerator extends ItemTagsProvider {

    /**
     * Constructs a new ModItemTagGenerator instance.
     *
     * @param output             The pack output for writing data.
     * @param lookupProvider     The lookup provider for obtaining data holders.
     * @param tagLookupBlock     The tag lookup for blocks.
     * @param existingFileHelper The existing file helper for resolving existing files.
     */
    public ModItemTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                               CompletableFuture<TagLookup<Block>> tagLookupBlock, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, tagLookupBlock, examplemod.MOD_ID, existingFileHelper);
    }

    /**
     * Adds tags for mod items, defining their properties and usage.
     *
     * @param pProvider The data provider for accessing data holders.
     */
    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Tags for mod items can be added here as needed.
    }
}

