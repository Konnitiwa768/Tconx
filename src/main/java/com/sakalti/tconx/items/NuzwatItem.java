package com.tconx.items;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightBlock;

public class NuzwatItem extends SwordItem {

    public NuzwatItem(Tier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, (int) attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 攻撃時に発光効果
        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0));
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, net.minecraft.world.entity.Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);
        if (!level.isClientSide() && entity instanceof Player player && selected) {
            BlockPos pos = player.blockPosition();
            // プレイヤーの頭上に光源ブロックを置く（光度14）
            level.setBlock(pos.above(), Blocks.LIGHT.defaultBlockState().setValue(LightBlock.LEVEL, 14), 3);
        }
    }
}
