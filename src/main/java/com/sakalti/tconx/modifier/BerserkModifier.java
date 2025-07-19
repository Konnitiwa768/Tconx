package com.sakalti.tconx.modifier;

import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.Random;

public class BerserkModifier extends Modifier {
    private static final Random RAND = new Random();

    /**
     * 攻撃時にツール側から呼び出すためのメソッド
     * @param tool ツールのToolStack
     * @param level Modifierレベル
     * @param attacker 攻撃者
     * @param baseDamage 元のダメージ
     * @return 修正後のダメージ（効果が発動しなければ baseDamage）
     */
    public float tryApplyBerserkEffect(ToolStack tool, int level, LivingEntity attacker, float baseDamage) {
        if (tool.isBroken() || attacker == null || level <= 0) return baseDamage;

        if (RAND.nextFloat() < 0.33f) {
            // 耐久2消費に成功したら
            if (tool.damage(2, attacker.level(), attacker)) {
                return baseDamage * 3f;
            }
        }
        return baseDamage;
    }
}
