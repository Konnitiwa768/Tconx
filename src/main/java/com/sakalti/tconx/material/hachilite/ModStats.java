package com.sakalti.tconx.material.hachilite;

import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.library.tools.stat.ModifierStatsBuilder;
import slimeknights.tconstruct.library.tools.stat.ArmorStatsBuilder;

public class ModStats {

    // ツールステータス
    public static final float DURABILITY = 950f;
    public static final float MINING_SPEED = 6.5f;
    public static final float ATTACK_DAMAGE = 3.2f;
    public static final int HARVEST_TIER = 4;
    public static final float HANDLE_MODIFIER = 1.5f;
    public static final int EXTRA_DURABILITY = 50;

    // 弓ステータス
    public static final float BOW_SPEED = 0.8f;
    public static final float BOW_PULL = 1.0f;
    public static final float BOW_ACCURACY = 0.05f;

    // 防具ステータス
    public static final float ARMOR_DURABILITY = 18.0f; // 防具耐久倍率（通常15〜20ぐらい）
    public static final float ARMOR_TOUGHNESS = 2.0f;
    public static final float ARMOR_DEFENSE = 7.0f;
    public static final float ARMOR_KNOCKBACK_RESISTANCE = 0.1f;

    public static void applyToolStats(ModifierStatsBuilder builder) {
        builder.set(ToolStats.DURABILITY, DURABILITY);
        builder.set(ToolStats.MINING_SPEED, MINING_SPEED);
        builder.set(ToolStats.ATTACK_DAMAGE, ATTACK_DAMAGE);
        builder.set(ToolStats.HARVEST_TIER, HARVEST_TIER);
        builder.set(ToolStats.HANDLE_MODIFIER, HANDLE_MODIFIER);
        builder.set(ToolStats.EXTRA_DURABILITY, EXTRA_DURABILITY);
        builder.set(ToolStats.BOW_VELOCITY, BOW_SPEED);
        builder.set(ToolStats.BOW_DRAW_SPEED, BOW_PULL);
        builder.set(ToolStats.ACCURACY, BOW_ACCURACY);
    }

    public static void applyArmorStats(ArmorStatsBuilder builder) {
        builder.set(ArmorStatsBuilder.DURABILITY, ARMOR_DURABILITY);
        builder.set(ArmorStatsBuilder.TOUGHNESS, ARMOR_TOUGHNESS);
        builder.set(ArmorStatsBuilder.DEFENSE, ARMOR_DEFENSE);
        builder.set(ArmorStatsBuilder.KNOCKBACK_RESISTANCE, ARMOR_KNOCKBACK_RESISTANCE);
    }
}
