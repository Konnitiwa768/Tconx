package com.sakalti.tconx.material.hachilite;

import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.fluids.TinkerFluids;
import slimeknights.tconstruct.library.fluid.FluidAttributes;
import slimeknights.tconstruct.library.fluid.FluidTank;
import slimeknights.tconstruct.library.fluid.FluidRegistry;
import slimeknights.tconstruct.library.fluid.FluidVariantHolder;
import slimeknights.tconstruct.library.fluid.FluidVolume;

public class ModFluids {

    public static final ResourceLocation MOLTEN_HACHILITE_ID = new ResourceLocation("tconx", "molten_hachilite");

    public static FluidVariantHolder MOLTEN_HACHILITE;

    public static void registerFluids() {
        MOLTEN_HACHILITE = FluidRegistry.registerMoltenMetal(MOLTEN_HACHILITE_ID, 0x00FFDD, 1000);
    }
}
