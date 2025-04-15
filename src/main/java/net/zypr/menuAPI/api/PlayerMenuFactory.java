package net.zypr.menuAPI.api;

import org.bukkit.entity.Player;

/**
 * A factory interface for creating {@link Menu} instances for specific players.
 */
public interface PlayerMenuFactory {

    /**
     * Creates a new {@link Menu} instance for the specified player.
     *
     * @param player the player for whom the menu will be created
     * @return a new {@link Menu} instance
     */
    Menu create(Player player);
}
