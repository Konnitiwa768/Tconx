package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;
import slimeknights.tconstruct.library.tools.helper.ModifierUtil;

public class AuroVisionModifier extends Modifier {

    // 攻撃時の効果
    public void afterEntityHit(ToolStack tool, int level, LivingEntity target, LivingEntity attacker, float damage, boolean isCritical) {
        if (attacker == null) return;

        int durationTicks = 20; // 1秒

        // Glowing (amplifier 4 = Glowing V)
        MobEffectInstance glow = new MobEffectInstance(MobEffects.GLOWING, durationTicks, 4);
        // Resistance V
        MobEffectInstance resistance = new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, durationTicks, 4);

        attacker.addEffect(glow);
        attacker.addEffect(resistance);
    }

    // 常時効果を与える
    public void onUpdate(ToolStack tool, int level, LivingEntity entity, int slotType) {
        if (!tool.isBroken() && ModifierUtil.isEquipped(tool, slotType)) {
            // Night Vision I（効果1秒、毎tick更新）
            MobEffectInstance nightVision = new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, true, false);
            entity.addEffect(nightVision);
        }
    }
}
