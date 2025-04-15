package net.zypr.menuAPI.util;

import net.zypr.menuAPI.interfaces.Menu;
import net.zypr.menuAPI.handler.MenuItemClickHandler;
import net.zypr.menuAPI.implementation.SimpleMenu;
import org.bukkit.inventory.ItemStack;

/**
 * A utility class for building {@link Menu} instances with a fluent API.
 * Provides methods to configure menu items and their click handlers.
 */
public class MenuBuilder {

    /**
     * The {@link SimpleMenu} instance being built.
     */
    private final SimpleMenu menu;

    /**
     * Constructs a new {@code MenuBuilder} with the specified title and number of rows.
     *
     * @param title the title of the menu
     * @param rows the number of rows in the menu
     */
    private MenuBuilder(String title, int rows) {
        this.menu = new SimpleMenu(title, rows);
    }

    /**
     * Creates a new {@code MenuBuilder} instance with the specified title and number of rows.
     *
     * @param title the title of the menu
     * @param rows the number of rows in the menu
     * @return a new {@code MenuBuilder} instance
     */
    public static MenuBuilder of(String title, int rows) {
        return new MenuBuilder(title, rows);
    }

    /**
     * Sets an item in the specified slot with a click handler.
     *
     * @param slot the slot index to set the item
     * @param item the {@link ItemStack} to set in the slot
     * @param handler the {@link MenuItemClickHandler} for the item
     * @return the current {@code MenuBuilder} instance
     */
    public MenuBuilder set(int slot, ItemStack item, MenuItemClickHandler handler) {
        menu.setItem(slot, item, handler);
        return this;
    }

    /**
     * Builds and returns the {@link Menu} instance.
     *
     * @return the built {@link Menu} instance
     */
    public Menu build() {
        return menu;
    }
}
