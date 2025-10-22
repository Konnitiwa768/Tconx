package com.sakalti.tconx.registry;

import com.sakalti.tconx.items.MirzoItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModMirzo {

    // アイテム登録用のDeferredRegister
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "tconx");

    // ミルゾ各種
    public static final RegistryObject<Item> WOODEN_MIRZO =
            ITEMS.register("wooden_mirzo",
                    (Supplier<Item>) () -> new MirzoItem(2.9f, 2.0f, 360, 59, Tiers.WOOD));

    public static final RegistryObject<Item> STONE_MIRZO =
            ITEMS.register("stone_mirzo",
                    (Supplier<Item>) () -> new MirzoItem(4.4f, 1.63f, 300, 131, Tiers.STONE));

    public static final RegistryObject<Item> IRON_MIRZO =
            ITEMS.register("iron_mirzo",
                    (Supplier<Item>) () -> new MirzoItem(5.4f, 1.11f, 240, 250, Tiers.IRON));

    public static final RegistryObject<Item> GOLDEN_MIRZO =
            ITEMS.register("golden_mirzo",
                    (Supplier<Item>) () -> new MirzoItem(6.4f, 1.02f, 200, 32, Tiers.GOLD));

    public static final RegistryObject<Item> DIAMOND_MIRZO =
            ITEMS.register("diamond_mirzo",
                    (Supplier<Item>) () -> new MirzoItem(8.0f, 0.95f, 160, 1561, Tiers.DIAMOND));

    public static final RegistryObject<Item> NETHERITE_MIRZO =
            ITEMS.register("netherite_mirzo",
                    (Supplier<Item>) () -> new MirzoItem(11.0f, 0.88f, 120, 2031, Tiers.NETHERITE));
}
