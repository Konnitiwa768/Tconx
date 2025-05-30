package com.sakalti.tconx.registry;

import slimeknights.tconstruct.library.materials.stats.*;

public class ModStats {

    public static final HeadMaterialStats VIBERIUM_HEAD = new HeadMaterialStats(1320, 10.5f, 3.5f, 5);
    public static final HandleMaterialStats VIBERIUM_HANDLE = new HandleMaterialStats(1.60f, 0);
    public static final ExtraMaterialStats VIBERIUM_EXTRA = new ExtraMaterialStats(1.85f);

    public static final HeadMaterialStats NEHILIUM_HEAD = new HeadMaterialStats(1136, 11.5f, 3.25f, 6);
    public static final HandleMaterialStats NEHILIUM_HANDLE = new HandleMaterialStats(1.75f, 0);
    public static final ExtraMaterialStats NEHILIUM_EXTRA = new ExtraMaterialStats(1.75f);
        // 緑色Keriumのヘッドパーツ (耐久, 掘る速度, harvestレベル, 基本攻撃力)
    HeadMaterialStats keriumHead = new HeadMaterialStats(
        742,
        7.5f,
        4,
        3.45f
    );

    // ハンドルパーツ (倍率, 追加耐久)
    HandleMaterialStats KeriumHandle = new HandleMaterialStats(
        1.88f,
    );

    // エクストラパーツ (倍率)
    ExtraMaterialStats keriumExtra = new ExtraMaterialStats(
        1.45f
    );
    public static final HeadMaterialStats URI_HEAD = new HeadMaterialStats(1450, 9.5f, 7, 4f);
    public static final HandleMaterialStats URI_HANDLE = new HandleMaterialStats(1.75f, 0);
    public static final ExtraMaterialStats URI_EXTRA = new ExtraMaterialStats(1.75f);
}
