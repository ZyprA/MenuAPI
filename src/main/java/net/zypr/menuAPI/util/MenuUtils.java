package net.zypr.menuAPI.util;

import net.zypr.menuAPI.api.Menu;
import net.zypr.menuAPI.holder.MenuHolder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Optional;

public class MenuUtils {
    public static Optional<Menu> from(Player player) {
        Inventory inv = player.getOpenInventory().getTopInventory();
        if (inv.getHolder() instanceof MenuHolder holder) {
            return Optional.of(holder.getMenu());
        }
        return Optional.empty();
    }
}
