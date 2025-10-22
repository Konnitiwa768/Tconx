package com.sakalti.tconx.registry;

import com.sakalti.tconx.registry.ModMirzo;
import com.sakalti.tconx.registry.ModNuzwats;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.NonNullList;

public class ModCreativeTabs {

    public static final CreativeModeTab ORIGINAL_WEAPONS = CreativeModeTab.builder()
            .title(Component.literal("Original Weapons"))
            .icon(() -> new ItemStack(ModMirzo.DIAMOND_MIRZO.get()))
            .displayItems((displayParams, items) -> {
                NonNullList<ItemStack> list = NonNullList.create();

                // Mirzo 6種類
                list.add(new ItemStack(ModMirzo.WOODEN_MIRZO.get()));
                list.add(new ItemStack(ModMirzo.STONE_MIRZO.get()));
                list.add(new ItemStack(ModMirzo.IRON_MIRZO.get()));
                list.add(new ItemStack(ModMirzo.GOLDEN_MIRZO.get()));
                list.add(new ItemStack(ModMirzo.DIAMOND_MIRZO.get()));
                list.add(new ItemStack(ModMirzo.NETHERITE_MIRZO.get()));

                // Nuzwat 6種類
                list.add(new ItemStack(ModNuzwats.WOODEN_NUZWAT.get()));
                list.add(new ItemStack(ModNuzwats.STONE_NUZWAT.get()));
                list.add(new ItemStack(ModNuzwats.IRON_NUZWAT.get()));
                list.add(new ItemStack(ModNuzwats.GOLDEN_NUZWAT.get()));
                list.add(new ItemStack(ModNuzwats.DIAMOND_NUZWAT.get()));
                list.add(new ItemStack(ModNuzwats.NETHERITE_NUZWAT.get()));

                items.addAll(list); // ← こうしてまとめて追加
            })
            .build();
}
