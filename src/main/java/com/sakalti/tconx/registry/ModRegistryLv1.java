package com.sakalti.tconx.registry;

import com.sakalti.tconx.TconX;
import com.sakalti.tconx.modifier.HaciliteModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.RegistryObject;
import slimeknights.tconstruct.library.materials.MaterialRegistryEvent;
import slimeknights.tconstruct.library.materials.stats.MaterialStatsManager;
import slimeknights.tconstruct.library.materials.definition.MaterialId;
import slimeknights.tconstruct.library.materials.stats.*;
import slimeknights.tconstruct.library.modifiers.ModifierId;
import slimeknights.tconstruct.library.modifiers.ModifierRegistryEvent;

public class ModRegistryLv1 {

    // ■ 素材
    public static final MaterialId HACILITE = new MaterialId(TconX.MODID, "hacilite");

    public static final HeadMaterialStats HACILITE_HEAD = new HeadMaterialStats(950, 7.0f, 3.0f, 3);
    public static final HandleMaterialStats HACILITE_HANDLE = new HandleMaterialStats(1.1f, 70);
    public static final ExtraMaterialStats HACILITE_EXTRA = new ExtraMaterialStats(100);
    public static final BowMaterialStats HACILITE_BOW = new BowMaterialStats(0.7f, 1.2f, 4.0f);

    public static final ModifierId HACILITE_MODIFIER_ID = new ModifierId(TconX.MODID, "hacilite_modifier");

    // ■ Fluid
    public static final DeferredRegister<FluidType> FLUIDS = DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, TconX.MODID);

    public static final RegistryObject<FluidType> MOLTEN_HACILITE = FLUIDS.register("molten_hacilite", () ->
            new FluidType(FluidType.Properties.create().viscosity(1200).density(2000).temperature(1000)) {}
    );

    public static void register(IEventBus bus) {
        FLUIDS.register(bus);

        bus.addListener(ModRegistryLv1::onMaterialRegister);
        bus.addListener(ModRegistryLv1::onStatsRegister);
        bus.addListener(ModRegistryLv1::onModifierRegister);
    }

    private static void onMaterialRegister(MaterialRegistryEvent.Materials event) {
        event.registerMaterial(HACILITE);
    }

    private static void onStatsRegister(MaterialRegistryEvent.MaterialStats event) {
        event.register(HACILITE, HACILITE_HEAD);
        event.register(HACILITE, HACILITE_HANDLE);
        event.register(HACILITE, HACILITE_EXTRA);
        event.register(HACILITE, HACILITE_BOW);
    }

    private static void onModifierRegister(ModifierRegistryEvent event) {
        event.register(HACILITE_MODIFIER_ID, new HaciliteModifier());
    }
}
