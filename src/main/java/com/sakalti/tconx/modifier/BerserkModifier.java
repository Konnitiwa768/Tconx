package com.sakalti.tconx.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.Random;

public class BerserkModifier extends Modifier {
    private static final Random RANDOM = new Random();

    /**
     * 攻撃時に呼び出す想定のメソッド。
     * @param tool ツールの ToolStack
     * @param level Modifierレベル
     * @param attacker 攻撃者
     * @param baseDamage 元のダメージ
     * @return 修正後のダメージ（33%の確率で耐久+2消費して3倍ダメージ）
     */
    public float tryApplyBerserkEffect(ToolStack tool, int level, LivingEntity attacker, float baseDamage) {
        if (tool.isBroken() || attacker == null || level <= 0) {
            return baseDamage;
        }

        if (RANDOM.nextFloat() < 0.33f) {
            int currentDamage = tool.getDamage();

            // 耐久超過で壊れる場合は発動させない
            if (currentDamage + 2 >= Integer.MAX_VALUE) {
                return baseDamage;
            }

            // 耐久2消費
            tool.setDamage(currentDamage + 2);

            // 3倍ダメージに変更して返す
            return baseDamage * 3f;
        }
        return baseDamage;
    }
}
