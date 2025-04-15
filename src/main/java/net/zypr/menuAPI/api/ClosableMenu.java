package net.zypr.menuAPI.api;

import org.bukkit.entity.Player;

/**
 * Represents a menu that can be closed by a player.
 * Extends the {@link Menu} interface to include a close event handler.
 */
public interface ClosableMenu extends Menu {

    /**
     * Called when the menu is closed by a player.
     *
     * @param player the player who closed the menu
     */
    void onClose(Player player);
}
