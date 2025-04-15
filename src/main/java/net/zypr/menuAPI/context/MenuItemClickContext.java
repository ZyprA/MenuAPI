package net.zypr.menuAPI.context;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Represents the context of a menu item click event.
 * Provides information about the player, the clicked item, the type of click,
 * the slot clicked, and the original {@link InventoryClickEvent}.
 */
public class MenuItemClickContext {

    /**
     * The player who clicked the menu item.
     */
    private final Player player;

    /**
     * The item that was clicked.
     */
    private final ItemStack clickedItem;

    /**
     * The type of click performed by the player.
     */
    private final ClickType clickType;

    /**
     * The slot index of the clicked item.
     */
    private final int slot;

    /**
     * The original {@link InventoryClickEvent} associated with this context.
     */
    private final InventoryClickEvent event;

    /**
     * Constructs a new {@code MenuItemClickContext}.
     *
     * @param player the player who clicked the menu item
     * @param clickedItem the item that was clicked
     * @param clickType the type of click performed
     * @param slot the slot index of the clicked item
     * @param event the original {@link InventoryClickEvent}
     */
    public MenuItemClickContext(Player player, ItemStack clickedItem, ClickType clickType, int slot, InventoryClickEvent event) {
        this.player = player;
        this.clickedItem = clickedItem;
        this.clickType = clickType;
        this.slot = slot;
        this.event = event;
    }

    /**
     * Gets the player who clicked the menu item.
     *
     * @return the player
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gets the item that was clicked.
     *
     * @return the clicked item
     */
    public ItemStack getClickedItem() {
        return clickedItem;
    }

    /**
     * Gets the type of click performed by the player.
     *
     * @return the click type
     */
    public ClickType getClickType() {
        return clickType;
    }

    /**
     * Gets the slot index of the clicked item.
     *
     * @return the slot index
     */
    public int getSlot() {
        return slot;
    }

    /**
     * Gets the original {@link InventoryClickEvent} associated with this context.
     *
     * @return the inventory click event
     */
    public InventoryClickEvent getEvent() {
        return event;
    }
}
