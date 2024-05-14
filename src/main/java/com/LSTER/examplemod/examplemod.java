package com.LSTER.examplemod;

import com.LSTER.examplemod.block.ModBlocks;
import com.LSTER.examplemod.item.ModCreativeModTabs;
import com.LSTER.examplemod.item.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

/**
 * Main class for the Example Mod. Handles mod initialization and event registration.
 */
@Mod(examplemod.MOD_ID)
public class examplemod {
    // Mod ID constant
    public static final String MOD_ID = "examplemod";

    // Logger for the mod
    private static final Logger LOGGER = LogUtils.getLogger();

    /**
     * Constructor for the mod. Registers items, blocks, and event listeners.
     */
    public examplemod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register creative mode tabs, items, and blocks
        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register common setup listener
        modEventBus.addListener(this::commonSetup);

        // Register the mod for server events
        MinecraftForge.EVENT_BUS.register(this);

        // Register addCreative listener
        modEventBus.addListener(this::addCreative);
    }

    /**
     * Event handler for adding contents to creative mode tabs.
     *
     * @param event The creative mode tab build event.
     */
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        // Implementation for adding items to creative mode tabs
    }

    /**
     * Common setup method for mod initialization.
     *
     * @param event The common setup event.
     */
    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common setup code
    }

    /**
     * Event handler for server starting events.
     *
     * @param event The server starting event.
     */
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Implementation for server starting events
    }


    /**
     * Static inner class for handling client-specific events.
     */
    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        }
        /**
         * Event handler for client setup events.
         *
         * @param event The client setup event.
         */
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            // Implementation for client setup events

        }
}

