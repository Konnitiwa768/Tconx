package com.sakalti.tconx.registry;

import com.sakalti.tconx.TconXMod;
import com.sakalti.tconx.modifier.*;
import com.sakalti.sakaplus.tconx.registry.lv1.Hachilight;
import net.minecraft.util.Identifier;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.materials.stats.*;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.modifiers.ModifierRegistry;

public class ModMaterialIntegration {

    public static void registerAll() {
        registerMaterial(ModMaterials.VIBERIUM, 0x8B0000, ModStats.VIBERIUM_HEAD, ModStats.VIBERIUM_HANDLE, ModStats.VIBERIUM_EXTRA);
        registerMaterial(ModMaterials.NEHILIUM, 0x9370DB, ModStats.NEHILIUM_HEAD, ModStats.NEHILIUM_HANDLE, ModStats.NEHILIUM_EXTRA);
        registerMaterial(ModMaterials.KERIUM, 0x44ee44, ModStats.KERIUM_HEAD, ModStats.KERIUM_HANDLE, ModStats.KERIUM_EXTRA);
        registerMaterial(ModMaterials.URI, 0xFFD700, ModStats.URI_HEAD, ModStats.URI_HANDLE, ModStats.URI_EXTRA);
        registerMaterial(Hachilight:HACILIGHT, 0xFFD700, Hachilight.HACILIGHT_HEAD, ModStats.HACILIGHT_HANDLE, ModStats.HACILIGHT_EXTRA);

        ModifierRegistry.register(new Identifier("tconx", "viberium_modifier"), new ViberiumModifier());
        ModifierRegistry.register(new Identifier("tconx", "nehilium_modifier"), new NehiliumModifier());
        ModifierRegistry.register(new Identifier("tconx", "kerium_modifier"), new KeriumModifier());
        ModifierRegistry.register(new Identifier("tconx", "uri_modifier"), new UriModifier());
        ModifierRegistry.register(new Identifier("tconx", "hachilight_modifier"), new HachilightModifier());
    }

    private static void registerMaterial(MaterialId id, int color,
                                         HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra) {
        Material material = new Material(id, color, false); // false = not craftable in Part Builder

        MaterialRegistry.getInstance().addMaterial(material);
        MaterialRegistry.getInstance().addMaterialStats(id, head, handle, extra);

        material.setRepresentativeItemTag(TagUtil.createItemTag(new Identifier(id.getNamespace(), "ingots/" + id.getPath())));
    }
}
