package com.LSTER.examplemod.worldgen;

import com.LSTER.examplemod.examplemod;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * Provides a biome modifier for adding steel ore features to overworld biomes.
 */
public class ModBiomeModifiers {

    /**
     * Resource key for the biome modifier that adds steel ore features.
     */
    public static final ResourceKey<BiomeModifier> ADD_STEEL_ORE = registerKey("add_steel_ore");

    /**
     * Initializes and registers custom biome modifiers during mod bootstrap.
     *
     * @param context The bootstrap context for registering biome modifiers.
     */
    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        // Register the biome modifier to add steel ore features to overworld biomes
        context.register(ADD_STEEL_ORE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.STEEL_ORE_PLACED_KEY)),
                GenerationStep.Decoration.UNDERGROUND_ORES));
    }

    /**
     * Creates a resource key for a biome modifier with the specified name.
     *
     * @param name The name of the biome modifier.
     * @return The resource key for the biome modifier.
     */
    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(examplemod.MOD_ID, name));
    }
}

