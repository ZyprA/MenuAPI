package net.zypr.menuAPI.api;

import org.bukkit.entity.Player;

public interface ClosableMenu extends Menu {
    void onClose(Player player);
}
