package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class GlacialBindModifier extends Modifier {

    @Override
    public void onHit(ToolStack tool, LivingEntity target, LivingEntity attacker, float damage, boolean isCritical, int level) {
        if (target != null) {
            int duration = 20 * 3 * level;  // 3秒 × レベル（20tick=1秒）
            // スロー効果（MOVEMENT_SLOWDOWN）、効果レベル2（スローIII相当）
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, duration, 2));
        }
    }
}
