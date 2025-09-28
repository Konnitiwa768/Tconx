package com.tconx.registry;

import com.tconx.items.NuzwatItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModNuzwats {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "tconx");

    public static final RegistryObject<Item> WOODEN_NUZWAT = ITEMS.register("wooden_nuzwat",
        () -> new NuzwatItem(Tiers.WOOD, 1.9f, 3.5f, new Item.Properties().tab(CreativeModeTab.COMBAT)));

    public static final RegistryObject<Item> STONE_NUZWAT = ITEMS.register("stone_nuzwat",
        () -> new NuzwatItem(Tiers.STONE, 2.0f, 4.2f, new Item.Properties().tab(CreativeModeTab.COMBAT)));

    public static final RegistryObject<Item> IRON_NUZWAT = ITEMS.register("iron_nuzwat",
        () -> new NuzwatItem(Tiers.IRON, 2.1f, 4.9f, new Item.Properties().tab(CreativeModeTab.COMBAT)));

    public static final RegistryObject<Item> GOLDEN_NUZWAT = ITEMS.register("golden_nuzwat",
        () -> new NuzwatItem(Tiers.GOLD, 2.7f, 3.5f, new Item.Properties().tab(CreativeModeTab.COMBAT)));

    public static final RegistryObject<Item> DIAMOND_NUZWAT = ITEMS.register("diamond_nuzwat",
        () -> new NuzwatItem(Tiers.DIAMOND, 2.2f, 5.6f, new Item.Properties().tab(CreativeModeTab.COMBAT)));

    public static final RegistryObject<Item> NETHERITE_NUZWAT = ITEMS.register("netherite_nuzwat",
        () -> new NuzwatItem(Tiers.NETHERITE, 2.3f, 6.3f, new Item.Properties().tab(CreativeModeTab.COMBAT)));
}
