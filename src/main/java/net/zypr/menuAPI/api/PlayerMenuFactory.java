package net.zypr.menuAPI.api;

import org.bukkit.entity.Player;

public interface PlayerMenuFactory {
    Menu create(Player player);
}
