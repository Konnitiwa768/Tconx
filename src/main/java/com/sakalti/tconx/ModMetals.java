package com.sakalti.tconx;

import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
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
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModMetals {

    public static final String MODID = "tconx";
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // ---- Block & Item 登録 ----
    public static final RegistryObject<Block> HACHILITE_ORE = BLOCKS.register("hachilite_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HACHILITE_BLOCK = BLOCKS.register("hachilite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> HACHILITE_RAW = ITEMS.register("hachilite_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HACHILITE_INGOT = ITEMS.register("hachilite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Block> KANILITE_ORE = BLOCKS.register("kanilite_ore",
            () -> new Block(BlockBehaviour.Properties.of().strength(4f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> KANILITE_BLOCK = BLOCKS.register("kanilite_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(6f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> KANILITE_RAW = ITEMS.register("kanilite_raw",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KANILITE_INGOT = ITEMS.register("kanilite_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Block> HERDYEEN_BLOCK = BLOCKS.register("herdyeen_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> HERDYEEN_INGOT = ITEMS.register("herdyeen_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Block> OSTLUM_BLOCK = BLOCKS.register("ostlum_block",
            () -> new Block(BlockBehaviour.Properties.of().strength(7f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Item> OSTLUM_INGOT = ITEMS.register("ostlum_ingot",
            () -> new Item(new Item.Properties()));

    // ---- 初期化 ----
    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        ITEMS.register(modEventBus);
        MinecraftForge.EVENT_BUS.addListener(ModMetals::onBiomeLoading);
        DistExecutor.safeRunWhenOn(Dist.CLIENT, () -> ClientOnly::init);
    }

    // ---- 鉱石生成処理 ----
    private static void onBiomeLoading(BiomeLoadingEvent event) {
        registerOre(event, HACHILITE_ORE, 8, 10, VerticalAnchor.absolute(0), VerticalAnchor.absolute(64));
        registerOre(event, KANILITE_ORE, 7, 2, VerticalAnchor.absolute(-64), VerticalAnchor.absolute(16));
    }

    private static void registerOre(BiomeLoadingEvent event,
                                    RegistryObject<Block> block, int size, int count,
                                    VerticalAnchor minY, VerticalAnchor maxY) {

        OreConfiguration config = new OreConfiguration(
                getStoneReplaceTargets(block),
                size
        );

        ConfiguredFeature<?, ?> feature = new ConfiguredFeature<>(Feature.ORE, config);
        PlacedFeature placed = new PlacedFeature(
                Holder.direct(feature),
                List.of(
                        CountPlacement.of(count),
                        InSquarePlacement.spread(),
                        HeightRangePlacement.uniform(minY, maxY),
                        BiomeFilter.biome()
                )
        );

        event.getGeneration().addFeature(
                net.minecraft.world.level.levelgen.GenerationStep.Decoration.UNDERGROUND_ORES,
                placed
        );
    }

    /** 鉱石置き換え対象を返す（将来他鉱石にも再利用可能） */
    private static List<OreConfiguration.TargetBlockState> getStoneReplaceTargets(RegistryObject<Block> block) {
        return List.of(OreConfiguration.target(
                OreConfiguration.STONE_ORE_REPLACEABLES,
                block.get().defaultBlockState()
        ));
    }

    // ---- クライアント専用 ----
    @OnlyIn(Dist.CLIENT)
    private static class ClientOnly {
        static void init() {
            MinecraftForge.EVENT_BUS.addListener(ClientOnly::onRegisterModels);
        }

        private static void onRegisterModels(ModelEvent.RegisterAdditional event) {
            for (String name : List.of(
                    "hachilite_ingot", "hachilite_raw",
                    "kanilite_ingot", "kanilite_raw",
                    "herdyeen_ingot", "ostlum_ingot")) {
                event.register(new ResourceLocation(MODID, "item/" + name));
            }
        }
    }
}
