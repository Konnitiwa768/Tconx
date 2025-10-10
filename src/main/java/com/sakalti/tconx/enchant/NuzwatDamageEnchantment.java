package com.sakalti.tconx.enchant;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraftforge.registries.ObjectHolder;

public class ModEnchantments {

    @ObjectHolder("tconx:nuzwat_damage")
    public static final Enchantment NUZWAT_DAMAGE = null;

    @ObjectHolder("tconx:nuzwat_undead_bane")
    public static final Enchantment NUZWAT_UNDEAD_BANE = null;

    public static class NuzwatDamageEnchantment extends Enchantment {
        public NuzwatDamageEnchantment() {
            super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
        }
        @Override
        public boolean canApply(ItemStack stack) {
            return stack.getItem() instanceof com.sakalti.tconx.items.NuzwatItem;
        }
    }

    public static class NuzwatUndeadBaneEnchantment extends Enchantment {
        public NuzwatUndeadBaneEnchantment() {
            super(Rarity.UNCOMMON, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
        }
        @Override
        public boolean canApply(ItemStack stack) {
            return stack.getItem() instanceof com.sakalti.tconx.items.NuzwatItem;
        }
    }
}
