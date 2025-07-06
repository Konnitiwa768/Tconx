package com.sakalti.tconx;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BiomeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModMetals {

    public static final String MODID = "tconx";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Hachilite
    public static final RegistryObject<Block> HACHILITE_ORE = BLOCKS.register("hachilite_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HACHILITE_BLOCK = BLOCKS.register("hachilite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> HACHILITE_RAW = ITEMS.register("hachilite_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HACHILITE_INGOT = ITEMS.register("hachilite_ingot",
            () -> new Item(new Item.Properties()));

    // Kanilite
    public static final RegistryObject<Block> KANILITE_ORE = BLOCKS.register("kanilite_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> KANILITE_BLOCK = BLOCKS.register("kanilite_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> KANILITE_RAW = ITEMS.register("kanilite_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KANILITE_INGOT = ITEMS.register("kanilite_ingot",
            () -> new Item(new Item.Properties()));

    // Herdyeen（自然生成しない）
    public static final RegistryObject<Block> HERDYEEN_ORE = BLOCKS.register("herdyeen_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HERDYEEN_BLOCK = BLOCKS.register("herdyeen_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> HERDYEEN_INGOT = ITEMS.register("herdyeen_ingot",
            () -> new Item(new Item.Properties()));

    // Ostlum（自然生成しない）
    public static final RegistryObject<Block> OSTLUM_ORE = BLOCKS.register("ostlum_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSTLUM_BLOCK = BLOCKS.register("ostlum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> OSTLUM_INGOT = ITEMS.register("ostlum_ingot",
            () -> new Item(new Item.Properties()));

    /** モッド初期化時に呼び出し */
    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.addListener(ModMetals::addWorldgen);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientOnly::init);
    }

    /** 鉱石の自然生成追加：herdyeen, ostlum は除外 */
    private static void addWorldgen(BiomeEvent.ModifyFeatures event) {
        // Hachilite
        registerOre(event, HACHILITE_ORE, 8, 10, VerticalAnchor.absolute(0), VerticalAnchor.absolute(64));
        // Kanilite
        registerOre(event, KANILITE_ORE, 7, 2, VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16));
    }

    private static void registerOre(BiomeEvent.ModifyFeatures event, RegistryObject<Block> block, int size, int count,
                                    VerticalAnchor minY, VerticalAnchor maxY) {
        OreConfiguration config = new OreConfiguration(
            List.of(OreConfiguration.target(OreConfiguration.commonOreReplaceables(), block.get().defaultBlockState())),
            size);
        ConfiguredFeature<?, ?> feature = new ConfiguredFeature<>(Feature.ORE, config);
        PlacedFeature placed = new PlacedFeature(
            Holder.direct(feature),
            List.of(
                CountPlacement.of(count),
                InSquarePlacement.spread(),
                HeightRangePlacement.uniform(minY, maxY),
                BiomeFilter.biome()
            ));
        event.getFeatures().add(BiomeEvent.Decoration.UNDERGROUND_ORES, placed);
    }

    @OnlyIn(Dist.CLIENT)
    private static class ClientOnly {
        static void init() {
            MinecraftForge.EVENT_BUS.addListener(ClientOnly::registerItemModels);
        }

        private static void registerItemModels(ModelEvent.RegisterAdditional event) {
            for (String name : List.of("hachilite_ingot", "hachilite_raw", "kanilite_ingot", "kanilite_raw", "herdyeen_ingot", "ostlum_ingot")) {
                event.register(new ResourceLocation(MODID, "item/" + name));
            }
        }
    }
}
