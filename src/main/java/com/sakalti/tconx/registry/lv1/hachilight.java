package com.sakalti.tconx.registry.material;

import slimeknights.tconstruct.library.materials.definition.MaterialDefinition;
import slimeknights.tconstruct.library.materials.stats.HeadMaterialStats;
import slimeknights.tconstruct.library.materials.stats.HandleMaterialStats;
import slimeknights.tconstruct.library.materials.stats.ExtraMaterialStats;

public class HachilightMaterial {
    public static final MaterialDefinition HACHILIGHT = new MaterialDefinition.Builder("hachilight")
        .addStats(new HeadMaterialStats(
            700,    // Durability: 鉄(250) < ハチライト(700) < ダイヤ(1561)
            8.0f,   // Mining Speed: 鉄(6.0) < ハチライト(8.0) < ダイヤ(8.0)
            2.5f,   // Attack: 鉄(2.0) < ハチライト(2.5) < ダイヤ(3.0)
            3       // Harvest Level: 鉄(2), ダイヤ(3)
        ))
        .addStats(new HandleMaterialStats(1.1f, 70))
        .addStats(new ExtraMaterialStats(100))
        .build();
}
