package com.sakalti.tconx.material.hachilite;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.fluids.FluidType.Properties;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.sakalti.tconx.Tconx;

public class ModFluids {

    public static final DeferredRegister<ForgeFlowingFluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, Tconx.MODID);
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, Tconx.MODID);

    // Molten Hachilite流体のプロパティ
    public static final Lazy<ForgeFlowingFluid.Properties> MOLTEN_HACHILITE_PROPERTIES = Lazy.of(() -> new ForgeFlowingFluid.Properties(
            () -> ModFluids.MOLTEN_HACHILITE_TYPE.get(), 
            () -> ModFluids.MOLTEN_HACHILITE_SOURCE.get(), 
            () -> ModFluids.MOLTEN_HACHILITE_FLOWING.get())
            .block(ModBlocks.MOLTEN_HACHILITE_BLOCK.get())
            .bucket(ModItems.MOLTEN_HACHILITE_BUCKET.get())
    );

    // Molten Hachilite流体タイプ
    public static final RegistryObject<FluidType> MOLTEN_HACHILITE_TYPE = FLUID_TYPES.register("molten_hachilite",
            () -> new FluidType(Properties.create()
                    .temperature(1000)
                    .viscosity(6000)
                    .density(2000)
                    .lightLevel(8)
            ) {
            });

    // Molten Hachilite流体ソース
    public static final RegistryObject<ForgeFlowingFluid> MOLTEN_HACHILITE_SOURCE = FLUIDS.register("molten_hachilite",
            () -> new ForgeFlowingFluid.Source(ModFluids.MOLTEN_HACHILITE_PROPERTIES.get()));

    // Molten Hachilite流体フローイング
    public static final RegistryObject<ForgeFlowingFluid> MOLTEN_HACHILITE_FLOWING = FLUIDS.register("molten_hachilite_flowing",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.MOLTEN_HACHILITE_PROPERTIES.get()));

}
