package com.sakalti.tconx.modifier;

import com.sakalti.tconx.modifier.GlacialBindModifier;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.library.modifiers.Modifier;
import slimeknights.tconstruct.library.modifiers.ModifiersRegistry;

public class TconxModifiers {

    public static final DeferredRegister<Modifier> MODIFIERS =
            DeferredRegister.create(ModifiersRegistry.MODIFIER_REGISTRY_KEY, "tconx");

    public static final RegistryObject<Modifier> GLACIAL_BIND =
            MODIFIERS.register("glacial_bind", GlacialBindModifier::new);

    public static void register(IEventBus bus) {
        MODIFIERS.register(bus);
    }
}
