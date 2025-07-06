package com.sakalti.tconx;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.level.BiomeEvent.ModifyFeatures;
import net.minecraftforge.eventbus.api.IEventBus;
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

    // Herdyeen
    public static final RegistryObject<Block> HERDYEEN_ORE = BLOCKS.register("herdyeen_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HERDYEEN_BLOCK = BLOCKS.register("herdyeen_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> HERDYEEN_INGOT = ITEMS.register("herdyeen_ingot",
            () -> new Item(new Item.Properties()));

    // Ostlum
    public static final RegistryObject<Block> OSTLUM_ORE = BLOCKS.register("ostlum_ore",
            () -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> OSTLUM_BLOCK = BLOCKS.register("ostlum_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> OSTLUM_INGOT = ITEMS.register("ostlum_ingot",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        MinecraftForge.EVENT_BUS.addListener(ModMetals::addWorldgen);

        DistExecutor.safeRunWhenOn(Dist.CLIENT, ClientOnly::init);
    }

    private static void addWorldgen(ModifyFeatures event) {
        // Hachilite生成
        var hachiliteConfig = new OreConfiguration(
                OreConfiguration.commonOreReplaceables(),
                HACHILITE_ORE.get().defaultBlockState(),
                8);
        var hachiliteFeature = new ConfiguredFeature<>(Feature.ORE, hachiliteConfig);
        var hachilitePlaced = new PlacedFeature(
                BuiltInRegistries.CONFIGURED_FEATURE.getHolderOrThrow(hachiliteFeature),
                List.of(CountPlacement.of(10), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(64)),
                        BiomeFilter.biome()));
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, hachilitePlaced);

        // Kanilite生成
        var kaniliteConfig = new OreConfiguration(
                OreConfiguration.commonOreReplaceables(),
                KANILITE_ORE.get().defaultBlockState(),
                7);
        var kaniliteFeature = new ConfiguredFeature<>(Feature.ORE, kaniliteConfig);
        var kanilitePlaced = new PlacedFeature(
                BuiltInRegistries.CONFIGURED_FEATURE.getHolderOrThrow(kaniliteFeature),
                List.of(CountPlacement.of(2), InSquarePlacement.spread(),
                        HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16)),
                        BiomeFilter.biome()));
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, kanilitePlaced);

        // Herdyeen生成
        var herdyeenConfig = new OreConfiguration(
                OreConfiguration.commonOreReplaceables(),
                HERDYEEN_ORE.get().defaultBlockState(),
                6);
        var herdyeenFeature = new ConfiguredFeature<>(Feature.ORE, herdyeenConfig);
        var herdyeenPlaced = new PlacedFeature(
                BuiltInRegistries.CONFIGURED_FEATURE.getHolderOrThrow(herdyeenFeature),
                List.of(CountPlacement.of(4), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, herdyeenPlaced);

        // Ostlum生成
        var ostlumConfig = new OreConfiguration(
                OreConfiguration.commonOreReplaceables(),
                OSTLUM_ORE.get().defaultBlockState(),
                6);
        var ostlumFeature = new ConfiguredFeature<>(Feature.ORE, ostlumConfig);
        var ostlumPlaced = new PlacedFeature(
                BuiltInRegistries.CONFIGURED_FEATURE.getHolderOrThrow(ostlumFeature),
                List.of(CountPlacement.of(4), InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(50)),
                        BiomeFilter.biome()));
        event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ostlumPlaced);
    }

    @OnlyIn(Dist.CLIENT)
    private static class ClientOnly {
        static void init() {
            MinecraftForge.EVENT_BUS.addListener(ClientOnly::registerItemModels);
        }

        private static void registerItemModels(ModelEvent.RegisterAdditional event) {
            event.register(new ResourceLocation(MODID, "item/hachilite_ingot"));
            event.register(new ResourceLocation(MODID, "item/hachilite_raw"));
            event.register(new ResourceLocation(MODID, "item/kanilite_ingot"));
            event.register(new ResourceLocation(MODID, "item/kanilite_raw"));
            event.register(new ResourceLocation(MODID, "item/herdyeen_ingot"));
            event.register(new ResourceLocation(MODID, "item/ostlum_ingot"));
        }
    }
}
