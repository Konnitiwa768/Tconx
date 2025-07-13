package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.modifiers.modules.behavior.UpdateModifier;

public class FieldyModifier extends Modifier implements UpdateModifier {

    // 攻撃時の効果（発光 + 耐性）
    @Override
    public void afterEntityHit(ToolStack tool, int level, LivingEntity target, LivingEntity attacker, float damage, boolean isCritical) {
        if (attacker == null) return;

        int durationTicks = 20; // 1秒

        // Glowing V（amplifier=4）
        MobEffectInstance glow = new MobEffectInstance(MobEffects.GLOWING, durationTicks, 4);
        // Resistance V
        MobEffectInstance resistance = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, durationTicks, 4);

        attacker.addEffect(glow);
        attacker.addEffect(resistance);
    }

    // 毎tickごとに呼ばれる処理：暗視効果（AUROVISION）
    @Override
    public void applyLivingTick(ToolStack tool, int level, LivingEntity entity) {
        if (!tool.isBroken()) {
            // 220tickでチラつきを防ぐ（継続上書き）
            MobEffectInstance nightVision = new MobEffectInstance(
                MobEffects.NIGHT_VISION,
                220,
                0,
                true,   // ambient
                false   // showParticles
            );
            entity.addEffect(nightVision);
        }
    }
}
