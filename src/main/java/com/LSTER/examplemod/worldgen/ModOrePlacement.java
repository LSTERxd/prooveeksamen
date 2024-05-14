package com.LSTER.examplemod.worldgen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

/**
 * Provides methods for common and rare ore placement configurations.
 */
public class ModOrePlacement {

    /**
     * Combines placement modifiers for ore generation.
     *
     * @param p_195347_ The first placement modifier.
     * @param p_195348_ The second placement modifier.
     * @return A list of placement modifiers for ore generation.
     */
    public static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    /**
     * Configures common ore placement with a specified count and height range.
     *
     * @param pCount       The count of ore to generate.
     * @param pHeightRange The height range for ore generation.
     * @return A list of placement modifiers for common ore generation.
     */
    public static List<PlacementModifier> commonOrePlacement(int pCount, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(pCount), pHeightRange);
    }

    /**
     * Configures rare ore placement with a specified chance and height range.
     *
     * @param pChance      The chance of ore generation.
     * @param pHeightRange The height range for ore generation.
     * @return A list of placement modifiers for rare ore generation.
     */
    public static List<PlacementModifier> rareOrePlacement(int pChance, PlacementModifier pHeightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange);
    }
}

