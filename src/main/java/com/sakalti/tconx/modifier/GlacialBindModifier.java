package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.LivingEntityContext;

public class GlacialBindModifier extends Modifier {

    public GlacialBindModifier() {
        super();
    }

    @Override
    public void afterEntityHit(LivingEntityContext context, LivingEntity target, float damage, float newDamage, int level, boolean isCritical) {
        if (target != null) {
            int durationTicks = 20 * 3 * level; // 3秒 × レベル
            // Slowness III（効果レベル2 = III）
            MobEffectInstance slowness = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, durationTicks, 2);
            target.addEffect(slowness);
        }
    }

    @Override
    public int getPriority() {
        return 100;
    }
}
