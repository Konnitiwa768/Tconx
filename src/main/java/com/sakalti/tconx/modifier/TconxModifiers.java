package com.sakalti.tconx;

import com.sakalti.tconx.modifier.GlacialBindModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.util.ModifierDeferredRegister;
import slimeknights.tconstruct.library.modifiers.util.ModifierRegistryObject;

public class TconxModifiers {

    public static final ModifierDeferredRegister MODIFIERS =
            ModifierDeferredRegister.create("tconx");

    public static final ModifierRegistryObject<Modifier> GLACIAL_BIND =
            MODIFIERS.register("glacial_bind", GlacialBindModifier::new);

    public static void register(IEventBus bus) {
        MODIFIERS.register(bus);
    }
}
