package com.sakalti.tconx.modifier;

import com.sakalti.tconx.modifier.GlacialBindModifier;
import com.sakalti.tconx.modifier.SuperMagnetModifier;
import slimeknights.tconstruct.library.modifiers.Modifier;

public class TconxModifiers {

    public static final Modifier GLACIAL_BIND = new GlacialBindModifier();
    public static final Modifier SUPERMAGNET = new SuperMagnetModifier();

    
    
    public static void init() {
        // 何も登録しない、自前インスタンス保持のみ
    }
}
