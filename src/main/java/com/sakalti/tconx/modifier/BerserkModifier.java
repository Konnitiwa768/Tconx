package com.sakalti.tconx.modifier;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.damagesource.DamageSource;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.hook.AfterLivingHitModifierHook;
import slimeknights.tconstruct.library.tools.nbt.IToolStackView;
import java.util.Random;

public class BerserkModifier extends Modifier implements AfterLivingHitModifierHook {
  private static final Random RAND = new Random();

  @Override
  public float afterLivingHit(IToolStackView tool, int level, LivingEntity hitter, LivingEntity target, float damageDealt, boolean isCritical, boolean isOffhand) {
    if (hitter == null || target == null) return damageDealt;

    if (RAND.nextFloat() < 0.33f) {
      // 耐久2追加消費
      if (tool.damage(2, hitter, toolStack -> {})) {
        // 与ダメージを3倍にして返す
        return damageDealt * 3f;
      }
    }
    return damageDealt;
  }
}
