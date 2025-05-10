package com.sakalti.tconx.modifier;

import net.minecraft.util.Identifier;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

public class ViberiumModifier extends Modifier {
    private static final float MAX_BONUS = 0.35f;

    @Override
    public float getAttackDamage(ToolStack tool, int level, float baseDamage, float scaledDamage) {
        float ratio = 1.0f - ((float) tool.getDamage() / tool.getCurrentDurability());
        return scaledDamage + (MAX_BONUS * (1.0f - ratio)); // 少ないほど上昇
    }

    @Override
    public float getMiningSpeedMultiplier(ToolStack tool, int level, float speed) {
        float ratio = 1.0f - ((float) tool.getDamage() / tool.getCurrentDurability());
        return speed + (MAX_BONUS * (1.0f - ratio));
    }
}
