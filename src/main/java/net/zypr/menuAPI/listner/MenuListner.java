package net.zypr.menuAPI.listner;

import net.zypr.menuAPI.api.ClosableMenu;
import net.zypr.menuAPI.api.Menu;
import net.zypr.menuAPI.holder.MenuHolder;
import net.zypr.menuAPI.manager.MenuManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class MenuListner implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        MenuManager.handle(event);
    }

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
