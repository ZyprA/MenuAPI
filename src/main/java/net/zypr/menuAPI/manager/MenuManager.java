package net.zypr.menuAPI.manager;

import net.zypr.menuAPI.api.Menu;
import net.zypr.menuAPI.context.MenuItemClickContext;
import net.zypr.menuAPI.holder.MenuHolder;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuManager {
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
