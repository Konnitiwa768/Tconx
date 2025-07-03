package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.LivingEntityContext;

public class GlacialBindModifier extends Modifier {

    public GlacialBindModifier() {
        super();
    }

    @Override
    public void onDamage(LivingEntityContext context, DamageSource source, float amount, float newAmount, int level) {
        LivingEntity target = context.getLivingEntity();
        if (target != null) {
            int durationTicks = 20 * 3 * level; // 3秒 × レベル分 (20tick=1秒)
            // Slowness III (効果レベル2 = III)
            MobEffectInstance slowness = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, durationTicks, 2);
            target.addEffect(slowness);
        }
    }

    @Override
    public int getPriority() {
        return 100;
    }
}
