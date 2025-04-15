package net.zypr.menuAPI.holder;

import net.zypr.menuAPI.api.Menu;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.jetbrains.annotations.NotNull;

/**
 * Represents a holder for a {@link Menu} instance.
 * Implements {@link InventoryHolder} to provide access to the associated inventory.
 */
public class MenuHolder implements InventoryHolder {

    /**
     * The menu associated with this holder.
     */
    private final Menu menu;

    /**
     * Constructs a new {@code MenuHolder} with the specified menu.
     *
     * @param menu the menu to associate with this holder
     */
    public MenuHolder(Menu menu) {
        this.menu = menu;
    }

    /**
     * Gets the inventory associated with the menu.
     * This method is used by the Bukkit API to retrieve the inventory.
     *
     * @return the inventory associated with the menu
     */
    @Override
    @NotNull
    public Inventory getInventory() {
        return menu.getInventory();
    }

    /**
     * Gets the menu associated with this holder.
     *
     * @return the associated menu
     */
    public Menu getMenu() {
        return menu;
    }
}
