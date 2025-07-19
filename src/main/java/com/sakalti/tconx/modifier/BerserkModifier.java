package com.sakalti.tconx.modifier;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.helper.ToolDamageUtil;
import slimeknights.tconstruct.library.tools.context.AttackContext;

import java.util.Random;

public class BerserkModifier extends Modifier {

    private static final Random RANDOM = new Random();

    @Override
    public void beforeEntityAttack(ToolStack tool, int level, LivingEntity attacker, LivingEntity target, AttackContext context) {
        if (tool.isBroken() || target == null || attacker == null) return;

        // 33%の確率
        if (RANDOM.nextFloat() < 0.33f) {
            // 耐久を2消費（耐久チェック込み）
            if (ToolDamageUtil.damage(tool, 2, attacker)) {
                // 攻撃の直前にダメージを3倍にブースト
                float baseDamage = context.getBaseDamage();
                context.setBaseDamage(baseDamage * 3.0f);
            }
        }
    }
}
