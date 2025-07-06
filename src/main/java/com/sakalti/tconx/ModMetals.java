package com.sakalti.tconx;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import net.minecraftforge.common.ToolType;

import java.util.List;

public class ModMetals {

    public static final String MODID = "tconx";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Hachilite鉱石（採掘レベル2＝鉄ツルハシ以上必要）
    public static final RegistryObject<Block> HACHILITE_ORE = BLOCKS.register("hachilite_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f)
                    .requiresCorrectToolForDrops()
                    .harvestLevel(2)   // 採掘レベル指定
                    .harvestTool(ToolType.PICKAXE)
            ));
    public static final RegistryObject<Block> HACHILITE_BLOCK = BLOCKS.register("hachilite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .harvestLevel(2)
                    .harvestTool(ToolType.PICKAXE)
            ));
    public static final RegistryObject<Item> HACHILITE_RAW = ITEMS.register("hachilite_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HACHILITE_INGOT = ITEMS.register("hachilite_ingot",
            () -> new Item(new Item.Properties()));

    // Kanilite鉱石（採掘レベル3＝ダイヤツルハシ以上）
    public static final RegistryObject<Block> KANILITE_ORE = BLOCKS.register("kanilite_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f)
                    .requiresCorrectToolForDrops()
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
            ));
    public static final RegistryObject<Block> KANILITE_BLOCK = BLOCKS.register("kanilite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(6f)
                    .requiresCorrectToolForDrops()
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
            ));
    public static final RegistryObject<Item> KANILITE_RAW = ITEMS.register("kanilite_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KANILITE_INGOT = ITEMS.register("kanilite_ingot",
            () -> new Item(new Item.Properties()));

    // Herdyeen（自然生成なし）
    public static final RegistryObject<Block> HERDYEEN_ORE = BLOCKS.register("herdyeen_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
            ));
    public static final RegistryObject<Block> HERDYEEN_BLOCK = BLOCKS.register("herdyeen_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(7f)
                    .requiresCorrectToolForDrops()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
            ));
    public static final RegistryObject<Item> HERDYEEN_INGOT = ITEMS.register("herdyeen_ingot",
            () -> new Item(new Item.Properties()));

    // Ostlum（自然生成なし）
    public static final RegistryObject<Block> OSTLUM_ORE = BLOCKS.register("ostlum_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(5f)
                    .requiresCorrectToolForDrops()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
            ));
    public static final RegistryObject<Block> OSTLUM_BLOCK = BLOCKS.register("ostlum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(7f)
                    .requiresCorrectToolForDrops()
                    .harvestLevel(4)
                    .harvestTool(ToolType.PICKAXE)
            ));
    public static final RegistryObject<Item> OSTLUM_INGOT = ITEMS.register("ostlum_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientOnly::init);
    }

    @OnlyIn(Dist.CLIENT)
    private static class ClientOnly {
        static void init() {
            MinecraftForge.EVENT_BUS.addListener(ClientOnly::registerItemModels);
        }

        private static void registerItemModels(ModelEvent.RegisterAdditional event) {
            for (String name : List.of(
                    "hachilite_ingot", "hachilite_raw",
                    "kanilite_ingot", "kanilite_raw",
                    "herdyeen_ingot", "ostlum_ingot")) {
                event.register(new ResourceLocation(MODID, "item/" + name));
            }
        }
    }
}
