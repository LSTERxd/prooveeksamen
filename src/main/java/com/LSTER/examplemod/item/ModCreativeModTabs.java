package com.LSTER.examplemod.item;

import com.LSTER.examplemod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import com.LSTER.examplemod.examplemod;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, examplemod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXAMPLE_TAB = CREATIVE_MODE_TABS.register("example_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.LONG_SWORD.get()))
                    .title(Component.translatable("creativetab.example_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        //MATERIALS
                        pOutput.accept(ModItems.STEEL_INGOT.get());
                        pOutput.accept(ModItems.RAW_STEEL.get());

                        //SWORD
                        pOutput.accept(ModItems.LONG_SWORD.get());
                        pOutput.accept(ModItems.MESSER_SWORD.get());
                        pOutput.accept(ModItems.ESTOC_SWORD.get());
                        pOutput.accept(ModItems.NOBLE_SWORD.get());
                        pOutput.accept(ModItems.CLAYMORE_SWORD.get());
                        pOutput.accept(ModItems.SHORT_SWORD.get());
                        pOutput.accept(ModItems.STILETTO_SWORD.get());
                        pOutput.accept(ModItems.KATZBALGER_SWORD.get());

                        //BLOCKS
                        pOutput.accept(ModBlocks.STEEL_ORE.get());
                        pOutput.accept(ModBlocks.STEEL_BLOCK.get());
                        pOutput.accept(ModBlocks.SMILEY_FACE.get());

                        //ITEMS
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
