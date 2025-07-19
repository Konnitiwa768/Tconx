// EMC値定義スクリプト
// 使用Mod: ProjectE + KubeJS（対応アドオン不要な場合もあり）

ServerEvents.recipes(event => {
  // アイテムとEMC値のマップ
  const emcMap = {
    'tconx:hachilite_raw': 768,
    'tconx:hachilite_ingot': 3456,
    'tconx:hachilite_block': 2048 * 9,
    'tconx:hachilite_ore': 7512,

    'tconx:kanilite_raw': 2000,
    'tconx:kanilite_ingot': 8000,
    'tconx:kanilite_block': 8000 * 9,
    'tconx:kanilite_ore': 12000,

    'tconx:igniz_raw': 4096,
    'tconx:igniz_ingot': 16384,
    'tconx:igniz_block': 16384 * 9,
    'tconx:igniz_ore': 24576,

    'tconx:chirite_raw': 3500,
    'tconx:chirite_ingot': 14000,
    'tconx:chirite_block': 14000 * 9,
    'tconx:chirite_ore': 21000,

    'tconx:momongaite_raw': 3200,
    'tconx:momongaite_ingot': 6400,
    'tconx:momongaite_block': 6400 * 9,
    'tconx:momongaite_ore': 9600,

    'tconx:herdyeen_ingot': 19000,
    'tconx:herdyeen_block': 19000 * 9,

    'tconx:hiroswari_ingot': 22000,
    'tconx:hiroswari_block': 22000 * 9,

    'tconx:marulite_ingot': 65536,
    'tconx:marulite_block': 131072 * 9,

    'tconx:proxia_ingot': 39800,
    'tconx:proxia_block': 39800 * 9,

    'tconx:ouswari_ingot': 22000,
    'tconx:ouswari_block': 22000 * 9,

    'tconx:aurostone_ingot': 8096,
    'tconx:aurostone_block': 16192 * 9,

    'tconx:deepsteel_ingot': 160000,
    'tconx:deepsteel_block': 160000 * 9,
    'tconx:deepchunk': 1048,

    'tconx:chiisteel_ingot': 33120,
    'tconx:chiisteel_block': 33120 * 9,

    'tconx:ioxium_ingot': 22024,
    'tconx:ioxium_block': 22024 * 9,

    'tconx:dilonite_ingot': 34336,
    'tconx:dilonite_block': 34336 * 9,

    'tconx:tiberite_ingot': 6144,
    'tconx:tiberite_block': 6144 * 9,

    'tconx:ostlum_ingot': 28192,
    'tconx:ostlum_block': 28192 * 9
  };

  // 一括登録
  for (const [id, emc] of Object.entries(emcMap)) {
    event.custom({
      type: 'projecte:emc',
      ingredient: { item: id },
      value: emc
    });
  }
});
