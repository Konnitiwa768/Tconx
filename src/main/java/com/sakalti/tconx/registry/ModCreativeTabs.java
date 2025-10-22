package com.sakalti.tconx.registry;

import com.sakalti.tconx.registry.ModMirzo;
import com.sakalti.tconx.registry.ModNuzwats;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import java.util.List;

public class ModCreativeTabs {

    public static final CreativeModeTab ORIGINAL_WEAPONS = CreativeModeTab.builder()
            .title("Original Weapons") // タブ名
            .icon(() -> new ItemStack(ModMirzo.DIAMOND_MIRZO.get())) // アイコン
            .displayItems((displayParams, items) -> {
                // Mirzo 6種類
                items.add(new ItemStack(ModMirzo.WOODEN_MIRZO.get()));
                items.add(new ItemStack(ModMirzo.STONE_MIRZO.get()));
                items.add(new ItemStack(ModMirzo.IRON_MIRZO.get()));
                items.add(new ItemStack(ModMirzo.GOLDEN_MIRZO.get()));
                items.add(new ItemStack(ModMirzo.DIAMOND_MIRZO.get()));
                items.add(new ItemStack(ModMirzo.NETHERITE_MIRZO.get()));

                // Nuzwat 6種類
                items.add(new ItemStack(ModNuzwats.WOODEN_NUZWAT.get()));
                items.add(new ItemStack(ModNuzwats.STONE_NUZWAT.get()));
                items.add(new ItemStack(ModNuzwats.IRON_NUZWAT.get()));
                items.add(new ItemStack(ModNuzwats.GOLDEN_NUZWAT.get()));
                items.add(new ItemStack(ModNuzwats.DIAMOND_NUZWAT.get()));
                items.add(new ItemStack(ModNuzwats.NETHERITE_NUZWAT.get()));
            })
            .build();
}
