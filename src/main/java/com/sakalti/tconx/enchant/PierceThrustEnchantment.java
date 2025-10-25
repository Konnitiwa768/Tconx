package com.sakalti.tconx.enchant;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class PierceThrustEnchantment extends Enchantment {

    public PierceThrustEnchantment(Rarity rarity) {
        super(rarity, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    public int getMaxLevel() {
        return 2;
    }
}
