package com.sakalti.tconx;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.sakalti.tconx.registry.ModMaterialIntegration;

@Mod(TConX.MOD_ID)
public class TConXMod {
    public static final String MOD_ID = "tconx";

    public TConXMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // MODのセットアップイベント登録
        modEventBus.addListener(this::setup);

        // 必要ならここでアイテムやツール登録の初期処理を呼び出し
    }

    private void setup(final FMLCommonSetupEvent event) {
        // Tinkers' Construct APIとの連携や、初期化処理を書く場所
        // 例: TinkerRegistryにレシピ追加など
        ModMaterialIntegration.registerMaterials();
    }
}
