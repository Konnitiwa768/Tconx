package tconx.modifiers;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.tools.context.ToolAttackContext;
import slimeknights.tconstruct.library.tools.nbt.ToolStack;

import java.util.Random;

public class UriModifier extends Modifier {
    private static final float CHANCE = 0.5f; // 50%の確率
    private static final int SLOWNESS_DURATION = 60; // 3秒（20ticks * 3）
    private static final int SLOWNESS_LEVEL = 4; // Slowness I

    @Override
    public void afterEntityHit(ToolStack tool, int level, ToolAttackContext context, float damageDealt) {
        LivingEntity target = context.getLivingTarget();
        if (target != null && context.getAttacker() != null) {
            if (new Random().nextFloat() < CHANCE) {
                target.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, SLOWNESS_DURATION, SLOWNESS_LEVEL));
            }
        }
    }

    @Override
    public String getDisplayName(int level) {
        return "Uri";
    }

    @Override
    public String getDescription(int level) {
        return "Occasionally slows down enemies on hit.";
    }
}
