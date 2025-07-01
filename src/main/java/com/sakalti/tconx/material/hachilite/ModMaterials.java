package com.sakalti.tconx.material.hachilite;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.materials.definition.MaterialDefinition;
import slimeknights.tconstruct.library.materials.definition.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.MaterialVariantId;

public class ModMaterials {

    public static final MaterialVariantId HACHILITE_ID = MaterialVariantId.create("tconx:hachilite");
    public static MaterialDefinition HACHILITE;

    public static void registerMaterials(IEventBus bus) {
        HACHILITE = MaterialRegistry.register(HACHILITE_ID, builder -> {
            builder.setCraftable(true);
            builder.setCastable(true);
            builder.setFluid(new ResourceLocation("tconx", "molten_hachilite"));
            builder.setTrait(new ResourceLocation("tconx", "hachilite_slow"));
            builder.setStats(ModStats::applyToolStats);
            builder.setArmorStats(ModStats::applyArmorStats);
        });
    }
}
