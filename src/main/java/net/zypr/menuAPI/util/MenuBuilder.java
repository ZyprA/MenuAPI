package net.zypr.menuAPI.util;

import net.zypr.menuAPI.api.Menu;
import net.zypr.menuAPI.handler.MenuItemClickHandler;
import net.zypr.menuAPI.impl.SimpleMenu;
import org.bukkit.inventory.ItemStack;

public class MenuBuilder {
    private final SimpleMenu menu;

    private MenuBuilder(String title, int rows) {
        this.menu = new SimpleMenu(title, rows);
    }

    public static MenuBuilder of(String title, int rows) {
        return new MenuBuilder(title, rows);
    }

    public MenuBuilder set(int slot, ItemStack item, MenuItemClickHandler handler) {
        menu.setItem(slot, item, handler);
        return this;
    }

    public Menu build() {
        return menu;
    }
}
