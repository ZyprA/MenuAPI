package net.zypr.menuAPI.manager;

import net.zypr.menuAPI.api.Menu;
import net.zypr.menuAPI.context.MenuItemClickContext;
import net.zypr.menuAPI.holder.MenuHolder;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Manages menu-related events and interactions.
 * Provides utility methods to handle inventory click events and delegate
 * the actions to the appropriate {@link Menu} implementation.
 */
public class MenuManager {

    /**
     * Handles an {@link InventoryClickEvent} by delegating the click action
     * to the associated {@link Menu} instance.
     * Cancels the event to prevent default behavior and invokes the
     * {@code handleClick} method of the menu.
     *
     * @param event the inventory click event to handle
     */
    public static void handle(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof MenuHolder holder)) return;
        Player player = (Player) event.getWhoClicked();
        Menu menu = holder.getMenu();

        event.setCancelled(true);

        MenuItemClickContext context = new MenuItemClickContext(
                player,
                event.getCurrentItem(),
                event.getClick(),
                event.getSlot(),
                event
        );

        menu.handleClick(context);
    }
}