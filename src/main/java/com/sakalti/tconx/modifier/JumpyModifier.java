package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class JumpyModifier extends Modifier {

    // 常時効果を与える（毎tick呼び出される）
    @Override
    public void tick(ToolStack tool, int level, LivingEntity entity) {
        if (!tool.isBroken()) {
            MobEffectInstance jump = new MobEffectInstance(
                MobEffects.JUMP_BOOST, // 正確な名前は JUMP_BOOST
                220,                   // 11秒。チラつき防止
                level - 1,             // レベル補正（0から開始）
                true,                  // ambient: HUDで薄く表示
                false                  // showParticles: パーティクル非表示
            );
            entity.addEffect(jump);
        }
    }
}
