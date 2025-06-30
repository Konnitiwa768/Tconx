package com.sakalti.tconx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;

public class ModClient {
    public static final ResourceLocation TEXTURE = new ResourceLocation("tconx", "textures/item/hachilite.png");

    public static void registerTextures() {
        TextureManager textureManager = Minecraft.getInstance().getTextureManager();
        textureManager.bindForSetup(TEXTURE);
    }
}
