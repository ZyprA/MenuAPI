package net.zypr.menuAPI.handler;

import net.zypr.menuAPI.context.MenuItemClickContext;

@FunctionalInterface
public interface MenuToggleHandler {
    boolean handle(MenuItemClickContext context, boolean newState);
}
