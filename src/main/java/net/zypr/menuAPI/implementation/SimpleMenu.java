package net.zypr.menuAPI.implementation;

import org.bukkit.inventory.ItemStack;

/**
 * A simple implementation of the {@link AbstractMenu} class.
 * Provides utility methods for creating menus with basic functionality,
 * such as filling the borders of the menu with specific items.
 */
public class SimpleMenu extends AbstractMenu {

    /**
     * Constructs a new {@code SimpleMenu} with the specified title and number of rows.
     *
     * @param title the title of the menu
     * @param rows the number of rows in the menu
     */
    public SimpleMenu(String title, int rows) {
        super(title, rows);
    }

    /**
     * Fills the borders of the menu with the specified item.
     * The borders include the first and last columns, as well as the first and last rows.
     *
     * @param filters the {@link ItemStack} to use for the border
     */
    public void fillBorders(ItemStack filters) {
        int size = inventory.getSize();
        for (int i = 0; i < size; i++) {
            if (i % 9 == 0 || i % 9 == 8 || i < 9 || i >= size - 9) {
                setItem(i, filters, ctx -> {
                });
            }
        }
    }
}