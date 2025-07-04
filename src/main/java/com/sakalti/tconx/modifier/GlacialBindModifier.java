package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class GlacialBindModifier extends Modifier {

    @Override
    public void onHit(ToolStack tool, LivingEntity livingTarget, LivingEntity attacker, float damage, boolean isCritical, int level) {
        if (livingTarget != null) {
            int durationTicks = 20 * 3 * level; // 3秒 × レベル（20tick=1秒）
            // スロー効果（Movement Slowdown）、強さは2（Potionレベル3相当）
            MobEffectInstance slowness = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, durationTicks, 2);
            livingTarget.addEffect(slowness);
        }
    }
}
