package com.LSTER.examplemod.worldgen;

import com.LSTER.examplemod.examplemod;
import com.LSTER.examplemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

/**
 * Provides a configured feature for steel ore generation in the overworld.
 */
public class ModConfiguredFeatures {

    /**
     * Resource key for the configured feature representing steel ore generation in the overworld.
     */
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_STEEL_ORE_KEY = registerKey("steel_ore");

    /**
     * Initializes and registers custom configured features during mod bootstrap.
     *
     * @param context The bootstrap context for registering configured features.
     */
    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

        // Configuration for overworld steel ore generation
        List<OreConfiguration.TargetBlockState> overworldSteelOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.STEEL_ORE.get().defaultBlockState()));

        // Register the configured feature for overworld steel ore generation
        register(context, OVERWORLD_STEEL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldSteelOres, 9));
    }

    /**
     * Creates a resource key for a configured feature with the specified name.
     *
     * @param name The name of the configured feature.
     * @return The resource key for the configured feature.
     */
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(examplemod.MOD_ID, name));
    }

    /**
     * Registers a configured feature with the specified key, feature, and configuration.
     *
     * @param context      The bootstrap context for registering configured features.
     * @param key          The resource key for the configured feature.
     * @param feature      The feature type.
     * @param configuration The configuration for the feature.
     * @param <FC>         The feature configuration type.
     * @param <F>          The feature type.
     */
    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

