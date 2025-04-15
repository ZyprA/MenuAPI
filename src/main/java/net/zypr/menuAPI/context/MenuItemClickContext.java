package net.zypr.menuAPI.context;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuItemClickContext {
    private final Player player;
    private final ItemStack clickedItem;
    private final ClickType clickType;
    private final int slot;
    private final InventoryClickEvent event;

    public MenuItemClickContext(Player player, ItemStack clickedItem, ClickType clickType, int slot, InventoryClickEvent event) {
        this.player = player;
        this.clickedItem = clickedItem;
        this.clickType = clickType;
        this.slot = slot;
        this.event = event;
    }

    public Player getPlayer() {
        return player;
    }

    public ItemStack getClickedItem() {
        return clickedItem;
    }

    public ClickType getClickType() {
        return clickType;
    }

    public int getSlot() {
        return slot;
    }

    public InventoryClickEvent getEvent() {
        return event;
    }
}
