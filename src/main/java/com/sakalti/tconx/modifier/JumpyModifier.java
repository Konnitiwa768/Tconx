package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class JumpyModifier extends Modifier {

    // 常時効果を与える（毎tick呼び出される）
    public void tick(ToolStack tool, int level, LivingEntity entity) {
        if (!tool.isBroken()) {
            MobEffectInstance Jump = new MobEffectInstance(
                MobEffects.JUMP_BOOST,
                220,    // 長めのtickでチラつきを防止
                1,
                true,   // ambient（自然に見せる）
                false   // showParticles（パーティクル非表示）
            );
            entity.addEffect(Jump);
        }
    }
}
