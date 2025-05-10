package com.sakalti.tconx.registry;

import com.sakalti.tconx.TconXMod;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.materials.stats.*;
import slimeknights.tconstruct.library.utils.TagUtil;

public class ModMaterialIntegration {

    public static void registerAll() {
        registerMaterial(ModMaterials.VIBERIUM, 0x8B0000, ModStats.VIBERIUM_HEAD, ModStats.VIBERIUM_HANDLE, ModStats.VIBERIUM_EXTRA);
        registerMaterial(ModMaterials.NEHILIUM, 0x9370DB, ModStats.NEHILIUM_HEAD, ModStats.NEHILIUM_HANDLE, ModStats.NEHILIUM_EXTRA);
    }

    private static void registerMaterial(MaterialId id, int color,
                                         HeadMaterialStats head, HandleMaterialStats handle, ExtraMaterialStats extra) {
        Material material = new Material(id, color, false); // false = not craftable in Part Builder

        MaterialRegistry.getInstance().addMaterial(material);
        MaterialRegistry.getInstance().addMaterialStats(id, head, handle, extra);

        // 代表アイテム（仮）: 後で ingot 登録する場合はこちら変更
        material.setRepresentativeItemTag(TagUtil.createItemTag(new Identifier(id.getNamespace(), "ingots/" + id.getPath())));
    }
}
