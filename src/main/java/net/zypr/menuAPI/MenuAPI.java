package net.zypr.menuAPI;

import net.zypr.menuAPI.listner.MenuListner;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main class for the MenuAPI plugin.
 * This class extends {@link JavaPlugin} and serves as the entry point for the plugin.
 * It handles the plugin's startup and shutdown logic.
 */
public final class MenuAPI extends JavaPlugin {

    /**
     * Called when the plugin is enabled.
     * Registers the {@link MenuListner} to handle menu-related events.
     */
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new MenuListner(), this);
    }

    /**
     * Called when the plugin is disabled.
     * Handles any necessary cleanup during plugin shutdown.
     */
    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
