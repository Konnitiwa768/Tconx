package com.sakalti.tconx.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import java.util.List;

public class ModCreativeTabs {

    public static final CreativeModeTab ORIGINAL_WEAPONS = new CreativeModeTab("original_weapons") {
        @Override
        public void fillItemList(List<ItemStack> items) {
            // Mirzo 6種類
            items.add(new ItemStack(ModMirzo.WOODEN_MIRZO.get()));
            items.add(new ItemStack(ModMirzo.STONE_MIRZO.get()));
            items.add(new ItemStack(ModMirzo.IRON_MIRZO.get()));
            items.add(new ItemStack(ModMirzo.GOLDEN_MIRZO.get()));
            items.add(new ItemStack(ModMirzo.DIAMOND_MIRZO.get()));
            items.add(new ItemStack(ModMirzo.NETHERITE_MIRZO.get()));

            // Nuzwat 6種類
            items.add(new ItemStack(ModMirzo.WOODEN_NUZWAT.get()));
            items.add(new ItemStack(ModMirzo.STONE_NUZWAT.get()));
            items.add(new ItemStack(ModMirzo.IRON_NUZWAT.get()));
            items.add(new ItemStack(ModMirzo.GOLDEN_NUZWAT.get()));
            items.add(new ItemStack(ModMirzo.DIAMOND_NUZWAT.get()));
            items.add(new ItemStack(ModMirzo.NETHERITE_NUZWAT.get()));
        }
    };
}
