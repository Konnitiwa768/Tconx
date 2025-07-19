package com.sakalti.tconx.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.Random;

public class BerserkModifier extends Modifier {
    private static final Random RAND = new Random();

    public float tryApplyBerserkEffect(ToolStack tool, int level, LivingEntity attacker, float baseDamage) {
        if (tool.isBroken() || attacker == null || level <= 0) return baseDamage;

        if (RAND.nextFloat() < 0.33f) {
            int currentDamage = tool.getDamage();
            int maxDamage = tool.getStats().getMaxDurability();

            if (currentDamage + 2 >= maxDamage) {
                // 壊れるため消費不可
                return baseDamage;
            }

            tool.setDamage(currentDamage + 2);
            return baseDamage * 3f;
        }
        return baseDamage;
    }
}
