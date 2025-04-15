package net.zypr.menuAPI.util;

import net.zypr.menuAPI.api.Menu;
import net.zypr.menuAPI.holder.MenuHolder;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.Optional;

/**
 * Utility class for working with {@link Menu} instances.
 * Provides methods to retrieve menus associated with players.
 */
public class MenuUtils {

    /**
     * Retrieves the {@link Menu} instance associated with the specified player.
     * If the player has an open inventory and its holder is a {@link MenuHolder},
     * the associated menu is returned.
     *
     * @param player the player whose menu is to be retrieved
     * @return an {@link Optional} containing the {@link Menu} if present, or an empty {@link Optional} otherwise
     */
    public static Optional<Menu> from(Player player) {
        Inventory inv = player.getOpenInventory().getTopInventory();
        if (inv.getHolder() instanceof MenuHolder holder) {
            return Optional.of(holder.getMenu());
        }
        return Optional.empty();
    }
}
