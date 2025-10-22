package com.sakalti.tconx.items;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class MirzoItem extends Item {

    private final float baseDamage;
    private final float attackSpeed;
    private final int maxChargeTicks;

    public MirzoItem(float baseDamage, float attackSpeed, int maxChargeTicks) {
        super(new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT));
        this.baseDamage = baseDamage;
        this.attackSpeed = attackSpeed;
        this.maxChargeTicks = maxChargeTicks;
    }

    @Override
    public int getUseDuration(ItemStack stack) {
        return maxChargeTicks;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        player.startUsingItem(hand);
        player.getPersistentData().putDouble("mirzo_lastX", player.getX());
        player.getPersistentData().putDouble("mirzo_lastZ", player.getZ());
        player.getPersistentData().putDouble("mirzo_totalMove", 0.0);
        return InteractionResultHolder.consume(stack);
    }

    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (!(entity instanceof Player player)) return;

        int used = this.getUseDuration(stack) - timeLeft;
        float progress = Math.min(1.0f, used / (float) maxChargeTicks);

        // 移動距離でダメージボーナス
        double prevX = player.getPersistentData().getDouble("mirzo_lastX");
        double prevZ = player.getPersistentData().getDouble("mirzo_lastZ");
        double dx = player.getX() - prevX;
        double dz = player.getZ() - prevZ;
        double distance = Math.sqrt(dx*dx + dz*dz);
        double totalMove = player.getPersistentData().getDouble("mirzo_totalMove") + distance;
        player.getPersistentData().putDouble("mirzo_totalMove", totalMove);
        double speedBonus = 1.0 + totalMove * 0.05;

        // 4mリーチで最短距離の敵を取得
        Vec3 start = player.getEyePosition(1.0f);
        Vec3 look = player.getLookAngle();
        AABB box = player.getBoundingBox().expandTowards(look.scale(4.0)).inflate(1.0);
        List<LivingEntity> targets = level.getEntitiesOfClass(LivingEntity.class, box,
                e -> e != player && e.isAlive() && !e.isSpectator());

        LivingEntity target = null;
        double minDist = 4.0;
        for (LivingEntity e : targets) {
            Vec3 center = e.position().add(0, e.getBbHeight()/2, 0);
            double dist = start.distanceTo(center);
            if (dist < minDist) {
                minDist = dist;
                target = e;
            }
        }

        if (target != null) {
            float finalDamage = (float)(baseDamage * (0.6 + 0.4 * progress) * speedBonus);
            target.hurt(level.damageSources().playerAttack(player), finalDamage);
        }
    }

    @Override
    public void appendHoverText(ItemStack stack, Level level, List<Component> tooltip, TooltipFlag flag) {
        tooltip.add(Component.literal("§7長槍・突き専用"));
        tooltip.add(Component.literal("§bリーチ: 4m"));
        tooltip.add(Component.literal("§e左クリック: 通常突き / 右クリック長押し: セミオート突き"));
        tooltip.add(Component.literal(String.format("§f攻撃力: %.1f / 攻撃速度: %.2f", baseDamage, attackSpeed)));
        tooltip.add(Component.literal(String.format("§8チャージ時間: %.1f秒", maxChargeTicks/20.0)));
    }
}
