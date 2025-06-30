import os
from pathlib import Path
from PIL import Image

# 素材情報
MATERIAL_NAME = "hachilite"
MATERIAL_JP_NAME = "ハチライト"
MOD_ID = "tconx"
COLOR_HEX = 0x4FC3F7  # 水色

# ベースパス（現状カレントディレクトリ直下）
BASE_PATH = Path(".")

# Javaソースパス
JAVA_PATH = BASE_PATH / "src" / "main" / "java" / "com" / "sakalti" / "tconx"

# リソースパス
RESOURCES_PATH = BASE_PATH / "src" / "main" / "resources" / "assets" / MOD_ID

# 各種リソースディレクトリ
MATERIALS_JSON_PATH = RESOURCES_PATH / "materials"
LANG_JSON_PATH = RESOURCES_PATH / "lang"
TEXTURES_INGOT_PATH = RESOURCES_PATH / "textures" / "item"
TEXTURES_BLOCK_PATH = RESOURCES_PATH / "textures" / "block"
MODELS_ITEM_PATH = RESOURCES_PATH / "models" / "item"
MODELS_BLOCK_PATH = RESOURCES_PATH / "models" / "block"
BLOCKSTATES_PATH = RESOURCES_PATH / "blockstates"

# ======= Javaコード =======
MOD_MATERIALS = f"""\
package com.sakalti.tconx;

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
                .setFluid(new ResourceLocation("{MOD_ID}", "molten_{MATERIAL_NAME}"))
        );
    }}
}}
"""

MOD_STATS = f"""\
package com.sakalti.tconx;

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
package com.sakalti.tconx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.resources.ResourceLocation;

public class ModClient {{
    public static final ResourceLocation TEXTURE = new ResourceLocation("{MOD_ID}", "textures/item/{MATERIAL_NAME}.png");

    public static void registerTextures() {{
        TextureManager textureManager = Minecraft.getInstance().getTextureManager();
        textureManager.bindForSetup(TEXTURE);
    }}
}}
"""

# ======= JSONファイル =======

# materials/hachilite.json
MATERIAL_JSON = f"""{{
  "name": "{MATERIAL_NAME}",
  "fluid": "{MOD_ID}:molten_{MATERIAL_NAME}",
  "color": {COLOR_HEX},
  "craftable": true,
  "castable": true,
  "hidden": false
}}
"""

# lang/ja_jp.json （ローカライズ）
LOCALE_JSON = f"""{{
  "material.{MATERIAL_NAME}": "{MATERIAL_JP_NAME}",
  "material.{MATERIAL_NAME}.head": "{MATERIAL_JP_NAME}のヘッド",
  "material.{MATERIAL_NAME}.handle": "{MATERIAL_JP_NAME}の柄",
  "material.{MATERIAL_NAME}.extra": "{MATERIAL_JP_NAME}の追加"
}}
"""

# blockstates/hachilite_block.json
BLOCKSTATE_JSON = f"""{{
  "variants": {{
    "": {{ "model": "{MOD_ID}:block/hachilite_block" }}
  }}
}}
"""

# models/block/hachilite_block.json
BLOCK_MODEL_JSON = f"""{{
  "parent": "block/cube_all",
  "textures": {{
    "all": "{MOD_ID}:block/hachilite_block"
  }}
}}
"""

# models/item/hachilite_block.json
ITEM_MODEL_BLOCK_JSON = f"""{{
  "parent": "{MOD_ID}:block/hachilite_block"
}}
"""

# models/item/hachilite.json (インゴットモデル)
ITEM_MODEL_INGOT_JSON = f"""{{
  "parent": "item/generated",
  "textures": {{
    "layer0": "{MOD_ID}:item/hachilite"
  }}
}}
"""

# ======== 画像自動生成関数 ========
from PIL import Image

def generate_solid_color_image(path: Path, color_hex: int, size=256):
    r = (color_hex >> 16) & 0xFF
    g = (color_hex >> 8) & 0xFF
    b = color_hex & 0xFF
    img = Image.new("RGBA", (size, size), (r, g, b, 255))
    path.parent.mkdir(parents=True, exist_ok=True)
    img.save(path)
    print(f"Saved image: {path}")

# ======== ファイル書き込み関数 ========
def write_file(path: Path, content: str):
    path.parent.mkdir(parents=True, exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        f.write(content)
    print(f"Wrote {path}")

# ======== メイン処理 ========
def main():
    # Javaコード
    write_file(JAVA_PATH / "ModMaterials.java", MOD_MATERIALS)
    write_file(JAVA_PATH / "ModStats.java", MOD_STATS)
    write_file(JAVA_PATH / "ModClient.java", MOD_CLIENT)

    # JSON
    write_file(MATERIALS_JSON_PATH / f"{MATERIAL_NAME}.json", MATERIAL_JSON)
    write_file(LANG_JSON_PATH / "ja_jp.json", LOCALE_JSON)
    write_file(BLOCKSTATES_PATH / f"{MATERIAL_NAME}_block.json", BLOCKSTATE_JSON)
    write_file(MODELS_BLOCK_PATH / f"{MATERIAL_NAME}_block.json", BLOCK_MODEL_JSON)
    write_file(MODELS_ITEM_PATH / f"{MATERIAL_NAME}_block.json", ITEM_MODEL_BLOCK_JSON)
    write_file(MODELS_ITEM_PATH / f"{MATERIAL_NAME}.json", ITEM_MODEL_INGOT_JSON)

    # 画像生成（水色256×256）
    generate_solid_color_image(TEXTURES_INGOT_PATH / f"{MATERIAL_NAME}.png", COLOR_HEX)
    generate_solid_color_image(TEXTURES_BLOCK_PATH / f"{MATERIAL_NAME}_block.png", COLOR_HEX)

if __name__ == "__main__":
    main()
