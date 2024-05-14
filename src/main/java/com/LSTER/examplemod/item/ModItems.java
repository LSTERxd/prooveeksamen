package com.LSTER.examplemod.item;

import com.LSTER.examplemod.examplemod;
import com.LSTER.examplemod.item.custom.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Provides a deferred register for items, including materials and weapons,
 * along with a metal detector item.
 */
public class ModItems {

    // Deferred register for items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, examplemod.MOD_ID);

    // Materials
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_STEEL = ITEMS.register("raw_steel",
            () -> new Item(new Item.Properties()));

    //WEAPONS
    public static final RegistryObject<Item> LONG_SWORD = ITEMS.register("long_sword",
            () -> new SwordItem(Tiers.IRON, 12,-1f,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> MESSER_SWORD = ITEMS.register("messer_sword",
            () -> new SwordItem(Tiers.IRON, 7,0f,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> ESTOC_SWORD = ITEMS.register("estoc_sword",
            () -> new SwordItem(Tiers.IRON, 7,0f,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> NOBLE_SWORD = ITEMS.register("noble_sword",
            () -> new SwordItem(Tiers.IRON, 3,0.5f,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> CLAYMORE_SWORD = ITEMS.register("claymore_sword",
            () -> new SwordItem(Tiers.IRON, 17,-3f,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> SHORT_SWORD = ITEMS.register("short_sword",
            () -> new SwordItem(Tiers.IRON, 7,0.5f,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> STILETTO_SWORD = ITEMS.register("stiletto_sword",
            () -> new SwordItem(Tiers.IRON, 2,2f,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> KATZBALGER_SWORD = ITEMS.register("katzbalger_sword",
            () -> new SwordItem(Tiers.IRON, 2,2f,
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(100)));





    /**
     * Registers the items with the mod's event bus.
     *
     * @param eventBus The mod's event bus.
     */
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
