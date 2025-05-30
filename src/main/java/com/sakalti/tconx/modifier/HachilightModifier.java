package com.sakalti.tconx.registry.modifier;

import slimeknights.tconstruct.library.modifiers.Modifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import slimeknights.tconstruct.library.tools.context.AttackContext;

public class BurningBonusModifier extends Modifier {
    @Override
    public float getEntityDamage(ItemStack stack, int level, LivingEntity attacker, LivingEntity target, float baseDamage, AttackContext context) {
        // 対象が延焼状態なら追加ダメージ
        if (target.isOnFire()) {
            return baseDamage + 3.0F; // 追加ダメージ例。バランスに応じて調整
        }
        return baseDamage;
    }
}
