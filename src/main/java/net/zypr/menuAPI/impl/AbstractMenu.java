package net.zypr.menuAPI.impl;

import net.zypr.menuAPI.api.Menu;
import net.zypr.menuAPI.context.MenuItemClickContext;
import net.zypr.menuAPI.handler.MenuItemClickHandler;
import net.zypr.menuAPI.handler.MenuToggleHandler;
import net.zypr.menuAPI.holder.MenuHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/**
 * An abstract implementation of the {@link Menu} interface.
 * Provides a base structure for creating custom menus with item click handling
 * and toggle item functionality.
 */
public abstract class AbstractMenu implements Menu {

    /**
     * The title of the menu.
     */
    protected final String title;

    /**
     * The number of rows in the menu.
     */
    protected final int rows;

    /**
     * The inventory associated with this menu.
     */
    protected final Inventory inventory;

    /**
     * A map of slot indices to their corresponding {@link MenuItemClickHandler}.
     */
    protected final Map<Integer, MenuItemClickHandler> handlers = new HashMap<>();

    /**
     * Constructs a new {@code AbstractMenu} with the specified title and number of rows.
     *
     * @param title the title of the menu
     * @param rows the number of rows in the menu
     */
    public AbstractMenu(String title, int rows) {
        this.title = title;
        this.rows = rows;
        this.inventory = Bukkit.createInventory(new MenuHolder(this), rows * 9, title);
    }

    /**
     * Sets an item in the specified slot with a click handler.
     *
     * @param slot the slot index to set the item
     * @param item the item to set in the slot
     * @param handler the click handler for the item
     */
    @Override
    public void setItem(int slot, ItemStack item, MenuItemClickHandler handler) {
        inventory.setItem(slot, item);
        handlers.put(slot, handler);
    }

    /**
     * Opens the menu for the specified player.
     *
     * @param player the player to open the menu for
     */
    @Override
    public void open(Player player) {
        player.openInventory(inventory);
    }

    /**
     * Gets the inventory associated with this menu.
     *
     * @return the inventory
     */
    @Override
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Gets the title of the menu.
     *
     * @return the title of the menu
     */
    @Override
    public String getTitle() {
        return title;
    }

    /**
     * Handles a click event in the menu.
     * Invokes the {@link MenuItemClickHandler} associated with the clicked slot, if any.
     *
     * @param context the context of the menu item click event
     */
    @Override
    public void handleClick(MenuItemClickContext context) {
        MenuItemClickHandler handler = handlers.get(context.getSlot());
        if (handler != null) {
            handler.handle(context);
        }
    }

    /**
     * Sets a toggleable item in the specified slot.
     * The item toggles between two states (on/off) based on player interaction.
     *
     * @param slot the slot index to set the toggle item
     * @param initialState the initial state of the toggle
     * @param onItem the item representing the "on" state
     * @param offItem the item representing the "off" state
     * @param handler the toggle handler to handle state changes
     */
    @Override
    public void setToggleItem(int slot, boolean initialState,
                              ItemStack onItem, ItemStack offItem,
                              MenuToggleHandler handler) {

        final boolean[] state = {initialState};
        AtomicReference<Runnable> updateRef = new AtomicReference<>();

        Runnable update = () -> {
            ItemStack currentItem = state[0] ? onItem : offItem;
            setItem(slot, currentItem, ctx -> {
                boolean attemptedState = !state[0];
                boolean accepted = handler.handle(ctx, attemptedState);

                if (accepted) {
                    state[0] = attemptedState;
                    updateRef.get().run(); // Redraw the item
                }
            });
        };

        updateRef.set(update);
        update.run();
    }
}