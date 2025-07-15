package com.sakalti.tconx.modifier;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.StatusEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class JumpyModifier extends Modifier {

    // 常時効果を与える（毎tick呼び出される）
    @Override
    public void tick(ToolStack tool, int level, LivingEntity entity) {
        if (!tool.isBroken()) {
            MobEffectInstance jump = new MobEffectInstance(
                StatusEffects.JUMP_BOOST, // Mojmapではこちらを使う
                220,                      // 持続時間（チラつき防止）
                level - 1,                // レベル補正（0始まり）
                true,                     // ambient: HUDに薄く表示
                false                     // パーティクル非表示
            );
            entity.addEffect(jump);
        }
    }
}
