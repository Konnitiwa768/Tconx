package com.sakalti.tconx.registry;

import com.sakalti.tconx.registry.ModMirzo;
import com.sakalti.tconx.registry.ModNuzwats;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {

    public static final CreativeModeTab ORIGINAL_WEAPONS = CreativeModeTab.builder()
            .title(Component.literal("Original Weapons")) // Component.literalで文字列をComponentに変換
            .icon(() -> new ItemStack(ModMirzo.DIAMOND_MIRZO.get()))
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
