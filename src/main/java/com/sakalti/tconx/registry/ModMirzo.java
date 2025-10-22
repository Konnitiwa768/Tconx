package com.sakalti.tconx.registry;

import com.sakalti.tconx.Tconx;
import com.sakalti.tconx.item.MirzoItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMirzo {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tconx.MOD_ID);

    public static final RegistryObject<Item> MIRZO_WOOD =
            ITEMS.register("mirzo_wood", () -> new MirzoItem(2.9f, 2.0f, 360));
    public static final RegistryObject<Item> MIRZO_STONE =
            ITEMS.register("mirzo_stone", () -> new MirzoItem(4.4f, 1.63f, 300));
    public static final RegistryObject<Item> MIRZO_IRON =
            ITEMS.register("mirzo_iron", () -> new MirzoItem(5.4f, 1.11f, 240));
    public static final RegistryObject<Item> MIRZO_GOLD =
            ITEMS.register("mirzo_gold", () -> new MirzoItem(6.4f, 1.02f, 200));
    public static final RegistryObject<Item> MIRZO_DIAMOND =
            ITEMS.register("mirzo_diamond", () -> new MirzoItem(8.0f, 0.95f, 160));
    public static final RegistryObject<Item> MIRZO_NETHERITE =
            ITEMS.register("mirzo_netherite", () -> new MirzoItem(11.0f, 0.88f, 120));
}
