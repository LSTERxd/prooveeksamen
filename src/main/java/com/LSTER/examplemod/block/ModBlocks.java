package com.LSTER.examplemod.block;

import com.LSTER.examplemod.examplemod;
import com.LSTER.examplemod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.sql.Driver;
import java.util.function.Supplier;

/**
 * Register your blocks here with names, different properties and behaviours
 * You can also add strengt and a block that your custom block should be represented by
 */

public class ModBlocks { //Register your blocks here and give them different properties like strenght, amount of xp, etc.
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, examplemod.MOD_ID);

public static final RegistryObject<Block> SMILEY_FACE = registerBlock("smiley_face",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                .strength(2f)));


    public static final RegistryObject<Block> STEEL_ORE = registerBlock("steel_ore", //<--- This is the name the JSON files reads
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));
    public static final RegistryObject<Block> STEEL_BLOCK = registerBlock("steel_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(3, 6)));


    /**
     *
     * @param name   The unique name identifier for the block.
     * @param block  A supplier providing an instance of the block to be registered.
     * @param <T>    The type of the block to be registered, must extend Block.
     * @return       A RegistryObject representing the registered block.
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        // Register the block with the specified name and supplier.
        RegistryObject<T> toReturn = BLOCKS.register(name, block);

        // Register the corresponding block item.
        registerBlockItem(name, toReturn);

        // Return the RegistryObject representing the registered block.
        return toReturn;
    }


    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        // Register a block item with the specified name, associated with the given block.
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
