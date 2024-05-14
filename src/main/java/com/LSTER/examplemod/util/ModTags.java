package com.LSTER.examplemod.util;

import com.LSTER.examplemod.examplemod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

/**
 * Provides tags for blocks and items related to the mod.
 */
public class ModTags {

    /**
     * Class for block tags related to the mod.
     */
    public static class Blocks {
        /**
         * Tag for valuable blocks detected by the metal detector.
         */
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(examplemod.MOD_ID, name));
        }
    }

    /**
     * Class for item tags related to the mod.
     */
    public static class Items {

        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(examplemod.MOD_ID, name));
        }
    }
}

