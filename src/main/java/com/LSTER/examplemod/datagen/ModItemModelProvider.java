package com.LSTER.examplemod.datagen;

import com.LSTER.examplemod.examplemod;
import com.LSTER.examplemod.item.ModItems;
import com.LSTER.examplemod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * Handles the generation of item models for various swords and ingots.
 */
public class ModItemModelProvider extends ItemModelProvider {

    /**
     * Constructs a new ModItemModelProvider instance.
     *
     * @param output             The pack output for writing data.
     * @param existingFileHelper The existing file helper for resolving existing files.
     */
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, examplemod.MOD_ID, existingFileHelper);
    }

    /**
     * Registers item models for various mod items such as swords and ingots.
     */
    @Override
    protected void registerModels() {
        // Register item models for various swords and ingots
        simpleItem(ModItems.METAL_DETECTOR);
        simpleItem(ModItems.CLAYMORE_SWORD);
        simpleItem(ModItems.ESTOC_SWORD);
        simpleItem(ModItems.KATZBALGER_SWORD);
        simpleItem(ModItems.LONG_SWORD);
        simpleItem(ModItems.MESSER_SWORD);
        simpleItem(ModItems.NOBLE_SWORD);
        simpleItem(ModItems.SHORT_SWORD);
        simpleItem(ModItems.STILETTO_SWORD);
        simpleItem(ModItems.STEEL_INGOT);
        simpleItem(ModItems.RAW_STEEL);
    }

    /**
     * Generates a simple item model for a given item.
     *
     * @param item The RegistryObject representing the item.
     * @return An ItemModelBuilder for the specified item.
     */
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(examplemod.MOD_ID, "item/" + item.getId().getPath()));
    }
}
