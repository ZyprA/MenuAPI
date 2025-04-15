package net.zypr.menuAPI;

import net.zypr.menuAPI.listner.MenuListner;
import org.bukkit.plugin.java.JavaPlugin;

public final class MenuAPI extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new MenuListner(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
