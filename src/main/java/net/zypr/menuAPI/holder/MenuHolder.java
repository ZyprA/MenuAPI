package net.zypr.menuAPI.holder;

import net.zypr.menuAPI.api.Menu;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

public class MenuHolder implements InventoryHolder {
    private final Menu menu;

    public MenuHolder(Menu menu) {
        this.menu = menu;
    }

    @Override
    @NotNull
    public Inventory getInventory() {
        return menu.getInventory();
    }

    public Menu getMenu() {
        return menu;
    }
}
