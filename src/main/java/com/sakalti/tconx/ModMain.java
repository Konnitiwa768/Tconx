package com.sakalti.tconx;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.sakalti.tconx.material.hachilite.ModMaterials;
import com.sakalti.tconx.material.hachilite.ModFluids;

@Mod("tconx")
public class ModMain {

    public ModMain() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModMaterials.registerMaterials(bus);
        ModFluids.registerFluids();
    }
}
