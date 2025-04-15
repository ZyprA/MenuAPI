package net.zypr.menuAPI.api;

import net.zypr.menuAPI.context.MenuItemClickContext;
import net.zypr.menuAPI.handler.MenuItemClickHandler;
import net.zypr.menuAPI.handler.MenuToggleHandler;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public interface Menu {
    void open(Player player);

    void setItem(int slot, ItemStack item, MenuItemClickHandler handler);

    void setToggleItem(int slot, boolean initialState, ItemStack onItem, ItemStack offItem, MenuToggleHandler handler);


    String getTitle();

    Inventory getInventory();

    void handleClick(MenuItemClickContext context);
}
