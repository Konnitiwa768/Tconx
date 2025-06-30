package com.sakalti.tconx;

import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialId;
import slimeknights.tconstruct.library.materials.definition.MaterialManager;

public class ModMaterials {
    public static final MaterialId HACHILITE_ID = new MaterialId("hachilite");
    public static Material HACHILITE;

    public static void registerMaterials() {
        HACHILITE = MaterialManager.getInstance().register(
            new Material(HACHILITE_ID, Material.DisplayName.withTranslationKey("material.hachilite"))
                .setCraftable(true)
                .setCastable(true)
                .setFluid(new ResourceLocation("tconx", "molten_hachilite"))
        );
    }
}
