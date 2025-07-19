package com.sakalti.tconx.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.context.AttackContext;

import java.util.Random;

public class BerserkModifier extends Modifier {
    private static final Random RAND = new Random();

    @Override
    public float onAttack(AttackContext context, int level) {
        LivingEntity attacker = context.getAttacker();
        ToolStack tool = context.getTool();

        if (attacker != null && tool != null && !tool.isBroken() && RAND.nextFloat() < 0.33f) {
            // 耐久2を消費
            if (tool.damage(2, attacker.level(), attacker)) {
                // ダメージを3倍に設定して返す
                return context.getBaseDamage() * 3f;
            }
        }
        // 通常のダメージをそのまま返す
        return context.getBaseDamage();
    }
}
