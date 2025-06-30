package com.sakalti.tconx;

import com.sakalti.tconx.registry.ModRegistryLv1;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TconX.MODID)
public class TconX {

    public static final String MODID = "tconx";

    public TconX() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModRegistryLv1.register(bus);
    }
}
