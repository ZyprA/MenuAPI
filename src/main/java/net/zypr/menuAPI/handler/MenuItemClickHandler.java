package net.zypr.menuAPI.handler;

import net.zypr.menuAPI.context.MenuItemClickContext;

@FunctionalInterface
public interface MenuItemClickHandler {
    void handle(MenuItemClickContext context);
}
