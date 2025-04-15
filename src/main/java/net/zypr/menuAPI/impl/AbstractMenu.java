package net.zypr.menuAPI.impl;

import net.zypr.menuAPI.api.Menu;
import net.zypr.menuAPI.context.MenuItemClickContext;
import net.zypr.menuAPI.handler.MenuItemClickHandler;
import net.zypr.menuAPI.handler.MenuToggleHandler;
import net.zypr.menuAPI.holder.MenuHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AbstractMenu implements Menu {
    protected final String title;
    protected final int rows;
    protected final Inventory inventory;
    protected final Map<Integer, MenuItemClickHandler> handlers = new HashMap<>();

    public AbstractMenu(String title, int rows) {
        this.title = title;
        this.rows = rows;
        this.inventory = Bukkit.createInventory(new MenuHolder(this), rows * 9, title);
    }

    @Override
    public void setItem(int slot, ItemStack item, MenuItemClickHandler handler) {
        inventory.setItem(slot, item);
        handlers.put(slot, handler);
    }

    @Override
    public void open(Player player) {
        player.openInventory(inventory);
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void handleClick(MenuItemClickContext context) {
        MenuItemClickHandler handler = handlers.get(context.getSlot());
        if (handler != null) {
            handler.handle(context);
        }
    }

    @Override
    public void setToggleItem(int slot, boolean initialState,
                              ItemStack onItem, ItemStack offItem,
                              MenuToggleHandler handler) {

        final boolean[] state = {initialState};
        AtomicReference<Runnable> updateRef = new AtomicReference<>();

        Runnable update = () -> {
            ItemStack currentItem = state[0] ? onItem : offItem;
            setItem(slot, currentItem, ctx -> {
                boolean attemptedState = !state[0];
                boolean accepted = handler.handle(ctx, attemptedState);

                if (accepted) {
                    state[0] = attemptedState;
                    updateRef.get().run(); // 再描画
                }
            });
        };

        updateRef.set(update);
        update.run();
    }

}