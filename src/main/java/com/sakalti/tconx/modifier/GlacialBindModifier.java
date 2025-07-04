package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.AttackContext;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class GlacialBindModifier extends Modifier {

    @Override
    public void afterEntityHit(ToolStack tool, int level, LivingEntity target, LivingEntity attacker, float damageDealt, boolean isCritical, boolean fullyCharged, AttackContext context) {
        if (target != null && !target.level().isClientSide()) {
            int durationTicks = 20 * 3 * level; // 3秒 × レベル
            MobEffectInstance slowness = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, durationTicks, 2);
            target.addEffect(slowness);
        }
    }
}
