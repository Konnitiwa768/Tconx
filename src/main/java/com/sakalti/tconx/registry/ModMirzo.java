package com.sakalti.tconx.registry;

import com.sakalti.tconx.items.MirzoItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMirzo {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tconx.MOD_ID);

    // 木材ミルゾ
    public static final RegistryObject<Item> WOOD_MIRZO =
            ITEMS.register("wood_mirzo",
                    () -> new MirzoItem(2.9f, 2.0f, 360, 59)); // 耐久: 木の剣と同じ

    // 石材ミルゾ
    public static final RegistryObject<Item> STONE_MIRZO =
            ITEMS.register("stone_mirzo",
                    () -> new MirzoItem(4.4f, 1.63f, 300, 131)); // 石の剣と同じ

    // 鉄ミルゾ
    public static final RegistryObject<Item> IRON_MIRZO =
            ITEMS.register("iron_mirzo",
                    () -> new MirzoItem(5.4f, 1.11f, 240, 250)); // 鉄の剣と同じ

    // 金ミルゾ
    public static final RegistryObject<Item> GOLDEN_MIRZO =
            ITEMS.register("golden_mirzo",
                    () -> new MirzoItem(6.4f, 1.02f, 200, 32)); // 金の剣と同じ

    // ダイヤミルゾ
    public static final RegistryObject<Item> DIAMOND_MIRZO =
            ITEMS.register("diamond_mirzo",
                    () -> new MirzoItem(8.0f, 0.95f, 160, 1561)); // ダイヤの剣と同じ

    // ネザライトミルゾ
    public static final RegistryObject<Item> NETHERITE_MIRZO =
            ITEMS.register("netherite_mirzo",
                    () -> new MirzoItem(11.0f, 0.88f, 120, 2031)); // ネザライトの剣と同じ
}
