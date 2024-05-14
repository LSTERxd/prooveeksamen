package com.LSTER.examplemod.worldgen;

import com.LSTER.examplemod.examplemod;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

/**
 * Provides a placed feature for steel ore generation in the overworld.
 */
public class ModPlacedFeatures {

    /**
     * Resource key for the placed feature representing steel ore generation.
     */
    public static final ResourceKey<PlacedFeature> STEEL_ORE_PLACED_KEY = registerKey("steel_ore_placed");

    /**
     * Initializes and registers custom placed features during mod bootstrap.
     *
     * @param context The bootstrap context for registering placed features.
     */
    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        // Register the placed feature for steel ore generation
        register(context, STEEL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_STEEL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
    }

    /**
     * Creates a resource key for a placed feature with the specified name.
     *
     * @param name The name of the placed feature.
     * @return The resource key for the placed feature.
     */
    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(examplemod.MOD_ID, name));
    }

    /**
     * Registers a placed feature with the specified key, configuration, and modifiers.
     *
     * @param context      The bootstrap context for registering placed features.
     * @param key          The resource key for the placed feature.
     * @param configuration The configuration for the placed feature.
     * @param modifiers    The list of placement modifiers for the placed feature.
     */
    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> configuration, List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}

