package com.LSTER.examplemod.datagen;

import com.LSTER.examplemod.examplemod;
import com.LSTER.examplemod.worldgen.ModBiomeModifiers;
import com.LSTER.examplemod.worldgen.ModConfiguredFeatures;
import com.LSTER.examplemod.worldgen.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * Handles the registration of configured features, placed features, and biome modifiers for the mod.
 */
public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {

    // Builder for registering configured features, placed features, and biome modifiers.
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    /**
     * Constructs a new ModWorldGenProvider instance.
     *
     * @param output     The pack output for writing data.
     * @param registries The CompletableFuture for obtaining data holders.
     */
    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(examplemod.MOD_ID));
    }
}

