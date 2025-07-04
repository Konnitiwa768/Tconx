package com.sakalti.tconx;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import com.sakalti.tconx.material.hachilite.ModMaterials;
import slimeknights.tconstruct.library.modifiers.ModifierEntry;
import slimeknights.tconstruct.library.modifiers.Modifier;
import com.sakalti.tconx.modifier.GlacialBindModifier;

@Mod("tconx")
public class ModMain {
    public static ModifierEntry GLACIAL_BIND;
    
    public ModMain() {
        GLACIAL_BIND = Modifiers.register("glacial_bind", new GlacialBindModifier());
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModMaterials.registerMaterials();
    }
}
