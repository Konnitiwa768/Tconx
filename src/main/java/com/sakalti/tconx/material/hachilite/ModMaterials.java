package com.sakalti.tconx.material.hachilite;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import slimeknights.tconstruct.library.materials.definition.MaterialDefinition;
import slimeknights.tconstruct.library.materials.definition.MaterialRegistry;
import slimeknights.tconstruct.library.materials.definition.MaterialId;

public class ModMaterials {

    public static final MaterialId HACHILITE_ID = new MaterialId("tconx:hachilite");
    public static MaterialDefinition HACHILITE;

    public static void registerMaterials(IEventBus bus) {
        HACHILITE = MaterialRegistry.register(HACHILITE_ID, def -> {
            def.setCraftable(true);
            def.setCastable(true);
            def.setFluid(new ResourceLocation("tconx", "molten_hachilite"));
            def.addTrait(new ResourceLocation("tconx", "hachilite_slow"));
        });
    }
}
