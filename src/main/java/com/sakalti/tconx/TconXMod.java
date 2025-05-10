package com.sakalti.tconx;

import com.sakalti.tconx.registry.ModMaterialIntegration;
import net.fabricmc.api.ModInitializer;

public class TconXMod implements ModInitializer {
    public static final String MOD_ID = "tconx";

    @Override
    public void onInitialize() {
        ModMaterialIntegration.registerAll();
    }
}
