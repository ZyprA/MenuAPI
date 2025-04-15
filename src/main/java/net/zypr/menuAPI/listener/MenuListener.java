package net.zypr.menuAPI.listener;

import net.zypr.menuAPI.interfaces.ClosableMenu;
import net.zypr.menuAPI.interfaces.Menu;
import net.zypr.menuAPI.holder.MenuHolder;
import net.zypr.menuAPI.manager.MenuManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

/**
 * Listener class for handling menu-related events in the Bukkit API.
 * This class listens for inventory click and close events and delegates
 * the handling to the appropriate menu implementations.
 */
public class MenuListener implements Listener {

    /**
     * Handles inventory click events.
     * Delegates the event handling to the {@link MenuManager}.
     *
     * @param event the inventory click event
     */
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        MenuManager.handle(event);
    }

    /**
     * Handles inventory close events.
     * If the inventory belongs to a {@link MenuHolder}, it checks if the associated
     * menu is an instance of {@link ClosableMenu} and invokes its {@code onClose} method.
     *
     * @param event the inventory close event
     */
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getInventory().getHolder() instanceof MenuHolder holder) {
            Menu menu = holder.getMenu();
            if (menu instanceof ClosableMenu closable) {
                closable.onClose((Player) event.getPlayer());
            }
        }
    }
}
