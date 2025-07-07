package com.sakalti.tconx.modifier;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolContext;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.List;

public class FireWallModifier extends Modifier {

    private static final String TAG_FIREWALL_COOLDOWN = "fire_wall_cooldown";
    private static final int COOLDOWN_TICKS = 30; // 1.5秒 (20ticks = 1秒)

    public void inventoryTick(ToolStack tool, int level, Level world, LivingEntity holder, int slot, boolean isSelected) {
        if (world.isClientSide || holder == null || level <= 0) return;

        CompoundTag persistentData = tool.getPersistentData();
        int cooldown = persistentData.getInt(TAG_FIREWALL_COOLDOWN);

        if (cooldown > 0) {
            persistentData.putInt(TAG_FIREWALL_COOLDOWN, cooldown - 1);
            return;
        }

        // 範囲とダメージ計算
        double radius = 2.0D + level; // 基本2ブロック＋レベルごとに1ブロック
        float damage = 2.0F * level;  // レベルごとに2ダメージ

        List<LivingEntity> nearbyEntities = world.getEntitiesOfClass(LivingEntity.class,
                holder.getBoundingBox().inflate(radius),
                entity -> entity != holder && entity.isAlive());

        for (LivingEntity target : nearbyEntities) {
            target.hurt(DamageSource.ON_FIRE, damage);
        }

        persistentData.putInt(TAG_FIREWALL_COOLDOWN, COOLDOWN_TICKS);
    }
}
