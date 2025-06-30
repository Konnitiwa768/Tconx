import os
from pathlib import Path
from PIL import Image

# 素材情報
MATERIAL_NAME = "hachilite"
MATERIAL_JP_NAME = "ハチライト"
COLOR_HEX = 0x4FC3F7  # 水色

# プロジェクトベースパス（現在のフォルダを想定）
BASE_PATH = Path("./output")

# Javaソース配置パス
JAVA_PATH = BASE_PATH / "src" / "main" / "java" / "com" / "example" / MATERIAL_NAME

# リソース配置パス
RESOURCES_PATH = BASE_PATH / "src" / "main" / "resources" / "assets" / MATERIAL_NAME

# JSON配置フォルダ
MATERIALS_JSON_PATH = RESOURCES_PATH / "materials"
LANG_JSON_PATH = RESOURCES_PATH / "lang"

# 画像配置フォルダ
TEXTURES_PATH = RESOURCES_PATH / "textures" / "items"


# Javaコードテンプレート
MOD_MATERIALS = f"""\
package com.example.{MATERIAL_NAME};

import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.materials.Material;
import slimeknights.tconstruct.library.materials.MaterialId;
import slimeknights.tconstruct.library.materials.definition.MaterialManager;

public class ModMaterials {{
    public static final MaterialId {MATERIAL_NAME.upper()}_ID = new MaterialId("{MATERIAL_NAME}");
    public static Material {MATERIAL_NAME.upper()};

    public static void registerMaterials() {{
        {MATERIAL_NAME.upper()} = MaterialManager.getInstance().register(
            new Material({MATERIAL_NAME.upper()}_ID, Material.DisplayName.withTranslationKey("material.{MATERIAL_NAME}"))
                .setCraftable(true)
                .setCastable(true)
                .setFluid(new ResourceLocation("tconstruct", "molten_{MATERIAL_NAME}"))
        );
    }}
}}
"""

MOD_STATS = f"""\
package com.example.{MATERIAL_NAME};

import slimeknights.tconstruct.library.materials.stats.*;

public class ModStats {{

    public static HeadMaterialStats {MATERIAL_NAME.upper()}_HEAD = new HeadMaterialStats(
        800, 6.5f, 3.2f, 4); // 耐久力, 掘削速度, 攻撃力, 精度

    public static HandleMaterialStats {MATERIAL_NAME.upper()}_HANDLE = new HandleMaterialStats(
        1.1f, 20); // 攻撃速度補正, 耐久増加

    public static ExtraMaterialStats {MATERIAL_NAME.upper()}_EXTRA = new ExtraMaterialStats(50); // 追加耐久力
}}
"""

MOD_CLIENT = f"""\
package com.example.{MATERIAL_NAME};

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;

public class ModClient {{
    public static final ResourceLocation TEXTURE = new ResourceLocation("{MATERIAL_NAME}", "textures/items/{MATERIAL_NAME}.png");

    public static void registerTextures() {{
        TextureManager textureManager = Minecraft.getInstance().getTextureManager();
        textureManager.bindForSetup(TEXTURE);
    }}
}}
"""

# JSON素材ファイル
MATERIAL_JSON = f"""{{
  "name": "{MATERIAL_NAME}",
  "fluid": "tconstruct:molten_{MATERIAL_NAME}",
  "color": {COLOR_HEX},
  "craftable": true,
  "castable": true,
  "hidden": false
}}
"""

# ローカライズファイル (ja_jp.json)
LOCALE_JSON = f"""{{
  "material.{MATERIAL_NAME}": "{MATERIAL_JP_NAME}",
  "material.{MATERIAL_NAME}.head": "{MATERIAL_JP_NAME}のヘッド",
  "material.{MATERIAL_NAME}.handle": "{MATERIAL_JP_NAME}の柄",
  "material.{MATERIAL_NAME}.extra": "{MATERIAL_JP_NAME}の追加"
}}
"""

def write_file(path: Path, content: str):
    path.parent.mkdir(parents=True, exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"Wrote {path}")

def generate_image(path: Path, color_hex: int, size=256):
    r = (color_hex >> 16) & 0xFF
    g = (color_hex >> 8) & 0xFF
    b = color_hex & 0xFF
    img = Image.new("RGBA", (size, size), (r, g, b, 255))
    path.parent.mkdir(parents=True, exist_ok=True)
    img.save(path)
    print(f"Saved image: {path}")

def main():
    # Javaコード書き出し
    write_file(JAVA_PATH / "ModMaterials.java", MOD_MATERIALS)
    write_file(JAVA_PATH / "ModStats.java", MOD_STATS)
    write_file(JAVA_PATH / "ModClient.java", MOD_CLIENT)

    # JSON書き出し
    write_file(MATERIALS_JSON_PATH / f"{MATERIAL_NAME}.json", MATERIAL_JSON)
    write_file(LANG_JSON_PATH / "ja_jp.json", LOCALE_JSON)

    # 256x256水色画像生成
    generate_image(TEXTURES_PATH / f"{MATERIAL_NAME}.png", COLOR_HEX)

if __name__ == "__main__":
    main()
