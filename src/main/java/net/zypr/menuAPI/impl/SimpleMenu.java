package net.zypr.menuAPI.impl;

import org.bukkit.inventory.ItemStack;

public class SimpleMenu extends AbstractMenu {
    public SimpleMenu(String title, int rows) {
        super(title, rows);
    }

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
