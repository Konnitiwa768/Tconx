package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class GlacialBindModifier extends Modifier {

    @Override
    public void afterEntityHit(ToolStack tool, LivingEntity attacker, LivingEntity target, float damage, boolean isCritical, int level) {
        if (target != null) {
            int durationTicks = 20 * 3 * level; // 3秒 × レベル
            target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, durationTicks, 2));
        }
    }
}
