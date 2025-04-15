---

## 📘 `README.md`

# MenuAPI - Spigot/Bukkit向けシンプルで拡張性のあるGUIメニューAPI

`MenuAPI` は、Bukkit/Spigot サーバー向けに作られた **直感的なインベントリGUI API** です。  
クリックハンドラ、ページング、トグルボタン、動的な項目生成など、よくあるユースケースを簡単に実現できます。

---

## 🚀 特徴

- インターフェースベースの柔軟な構成（`Menu`, `ClosableMenu` など）
- ラムダで書けるクリック処理
- 境界アイテム (`fillBorders`) やトグルボタンの標準実装
- `ItemBuilder` によるわかりやすいアイテム生成
- ページング不要の軽量な `SimpleMenu` から構築可能

---

## 📦 インストール

`MenuAPI.jar`をpluginsフォルダに入れてください。

**Gradle**
```
		repositories {
			maven { url 'https://jitpack.io' }
		}

    dependencies {
	        implementation 'com.github.ZyprA:MenuAPI:-SNAPSHOT'
	  }
```

Repository: [jitpack](https://jitpack.io/#ZyprA/MenuAPI/)

---

## 🧪 使用例 - `SimpleMenu` を使ったメニュー作成

```java
public class MyMenu extends SimpleMenu {
    public MyMenu(Player player) {
        super("§b設定メニュー", 5);

        fillBorders(new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE)
            .setName(" ").build());

        setToggleItem(20, "通知", true,
            new ItemBuilder(Material.LIME_DYE).setName("§a通知：ON").build(),
            new ItemBuilder(Material.GRAY_DYE).setName("§c通知：OFF").build(),
            (ctx, state) -> {
                ctx.getPlayer().sendMessage("通知は " + (state ? "§aON" : "§cOFF"));
                return true; // 状態変更を許可 (falseの場合は状態が変わりません)
            });

        setItem(40, new ItemBuilder(Material.BARRIER)
            .setName("§c閉じる")
            .setLore("§7クリックして閉じる")
            .build(), ctx -> ctx.getPlayer().closeInventory());

        open(player);
    }
}
```

---

## 🧱 `ItemBuilder` の使い方

アイテムの作成を簡単に行うユーティリティです。

```java
ItemStack item = new ItemBuilder(Material.DIAMOND_SWORD)
    .setName("§b神の剣")
    .setLore("§7右クリックで力を解放する")
    .addEnchant(Enchantment.DAMAGE_ALL, 5)
    .hideAttributes()
    .build();
```

---

## 🔄 トグルボタンAPIの詳細

```java
setToggleItem(
    int slot,
    String label,              // 表示用ラベル（必要ならトラッキング用にも）
    boolean initialState,      // 初期状態（true=ON）
    ItemStack onItem,          // ON状態の表示アイテム
    ItemStack offItem,         // OFF状態の表示アイテム
    MenuToggleHandler handler  // トグルが試行されたときに呼ばれる処理（戻り値が true なら反映）
);
```

### `MenuToggleHandler` インターフェース

```java
@FunctionalInterface
public interface MenuToggleHandler {
    boolean handle(MenuItemClickContext context, boolean newState);
}
```

---

## 📚 クラス構成（主なもの）

| クラス名 | 説明 |
|----------|------|
| `Menu` / `ClosableMenu` | メニューの基本インターフェース |
| `SimpleMenu` | 1ページ完結型の軽量メニュー |
| `MenuItemClickContext` | クリック時の情報（プレイヤー・アイテム・スロットなど） |
| `MenuItemClickHandler` | `void handle(context)` の関数型インターフェース |
| `MenuToggleHandler` | トグル時に呼ばれる関数型IF（`boolean` で状態更新可否を返す） |
| `ItemBuilder` | `ItemStack` を分かりやすく構築するビルダーパターン |
| `MenuHolder` | メニューと `Inventory` の紐付け |
| `MenuManager` / `MenuListner` | イベント処理のルート |


---

## 🧠 ドキュメント  
[javadoc](https://zypra.github.io/MenuAPI/)  

---

## 📄 ライセンス

MIT ライセンス

---
