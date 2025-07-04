package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.modules.armor.ConditionalArmorModule;
import slimeknights.tconstruct.library.modifiers.modules.armor.ConditionalEffectModule;
import slimeknights.tconstruct.library.tools.context.AttackContext;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class GlacialBindModifier extends Modifier {

    @Override
    public void afterEntityHit(ToolStack tool, AttackContext context, float damageDealt) {
        if (context.getTarget() instanceof LivingEntity target) {
            int level = tool.getModifierLevel(this);
            if (level > 0) {
                int durationTicks = 20 * 3 * level; // 3秒 × レベル
                MobEffectInstance slowness = new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, durationTicks, 2);
                target.addEffect(slowness);
            }
        }
    }
}
