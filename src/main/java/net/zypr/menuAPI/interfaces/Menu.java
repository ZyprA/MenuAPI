package net.zypr.menuAPI.interfaces;

import net.zypr.menuAPI.context.MenuItemClickContext;
import net.zypr.menuAPI.handler.MenuItemClickHandler;
import net.zypr.menuAPI.handler.MenuToggleHandler;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Represents a menu interface that can be opened by a player and interacted with.
 */
public interface Menu {

    /**
     * Opens the menu for the specified player.
     *
     * @param player the player for whom the menu will be opened
     */
    void open(Player player);

    /**
     * Sets an item in the specified slot with a click handler.
     *
     * @param slot    the slot index where the item will be placed
     * @param item    the {@link ItemStack} to set in the slot
     * @param handler the handler to execute when the item is clicked
     */
    void setItem(int slot, ItemStack item, MenuItemClickHandler handler);

    /**
     * Sets a toggleable item in the specified slot.
     *
     * @param slot         the slot index where the toggle item will be placed
     * @param initialState the initial state of the toggle (true for "on", false for "off")
     * @param onItem       the {@link ItemStack} representing the "on" state
     * @param offItem      the {@link ItemStack} representing the "off" state
     * @param handler      the handler to execute when the toggle state changes
     */
    void setToggleItem(int slot, boolean initialState, ItemStack onItem, ItemStack offItem, MenuToggleHandler handler);

    /**
     * Gets the title of the menu.
     *
     * @return the title of the menu
     */
    String getTitle();

    /**
     * Gets the inventory associated with the menu.
     *
     * @return the {@link Inventory} of the menu
     */
    Inventory getInventory();

    /**
     * Handles a click event within the menu.
     *
     * @param context the context of the click event
     */
    void handleClick(MenuItemClickContext context);
}
