package com.sakalti.tconx.items;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LightBlock;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import com.sakalti.tconx.enchant.ModEnchantments;

public class NuzwatItem extends SwordItem {

    public NuzwatItem(Tier tier, float attackDamage, float attackSpeed, Item.Properties properties) {
        super(tier, (int) attackDamage, attackSpeed, properties);
    }

    // 剣系エンチャント禁止・独自エンチャントのみ許可
    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        ResourceLocation enchKey = ForgeRegistries.ENCHANTMENTS.getKey(enchantment);
        if (enchKey != null) {
            String key = enchKey.toString();
            if (key.contains("sharpness") || key.contains("smite") ||
                key.contains("bane_of_arthropods") || key.contains("sweeping") ||
                key.contains("looting")) {
                return false;
            }
            // 独自エンチャントはOK
            if (key.contains("nuzwat_damage") || key.contains("nuzwat_undead_bane")) {
                return true;
            }
        }
        return super.canApplyAtEnchantingTable(stack, enchantment);
    }

    // 本によるエンチャント禁止
    @Override
    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 攻撃時に発光
        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0));

        // 独自エンチャント効果（nuzwat_damage, nuzwat_undead_bane）
        int damageLevel = stack.getEnchantmentLevel(ModEnchantments.NUZWAT_DAMAGE.get());
        if (damageLevel > 0) {
            float extra = (float)(0.35 * (damageLevel * 0.35));
            target.hurt(target.damageSources().playerAttack((Player)attacker), extra);
        }
        int undeadLevel = stack.getEnchantmentLevel(ModEnchantments.NUZWAT_UNDEAD_BANE.get());
        if (undeadLevel > 0 && target.getMobType() == net.minecraft.world.entity.MobType.UNDEAD) {
            float extra = undeadLevel * 2.0F;
            target.hurt(target.damageSources().playerAttack((Player)attacker), extra);
        }
        return super.hurtEnemy(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, net.minecraft.world.entity.Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);
        if (!level.isClientSide() && entity instanceof Player player && selected) {
            BlockPos pos = player.blockPosition();
            // 頭上に光源ブロック（光度14）
            level.setBlock(pos.above(), Blocks.LIGHT.defaultBlockState().setValue(LightBlock.LEVEL, 14), 3);
        }
    }
}    public boolean isEnchantable(ItemStack stack) {
        return false;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // 攻撃時に発光効果
        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 100, 0));
        // 独自エンチャント効果（例:ヌズワトダメ増加/アンデット特効）
        if (stack.isEnchanted()) {
            // 独自エンチャント取得仮定（ModEnchantments参照）
            int damageLevel = stack.getEnchantmentLevel(ModEnchantments.NUZWAT_DAMAGE.get());
            if (damageLevel > 0) {
                float extra = (float)(0.35 * (damageLevel * 0.35));
                target.hurt(target.damageSources().playerAttack((Player)attacker), extra);
            }
            int undeadLevel = stack.getEnchantmentLevel(ModEnchantments.NUZWAT_UNDEAD_BANE.get());
            if (undeadLevel > 0 && target.getMobType() == net.minecraft.world.entity.MobType.UNDEAD) {
                float extra = undeadLevel * 2.0F;
                target.hurt(target.damageSources().playerAttack((Player)attacker), extra);
            }
        }
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
