package com.example.hachilite;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;

public class ModClient {
    public static final ResourceLocation TEXTURE = new ResourceLocation("hachilite", "textures/items/hachilite.png");

    public static void registerTextures() {
        TextureManager textureManager = Minecraft.getInstance().getTextureManager();
        textureManager.bindForSetup(TEXTURE);
    }
}
