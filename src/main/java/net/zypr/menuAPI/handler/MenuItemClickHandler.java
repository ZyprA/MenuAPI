package net.zypr.menuAPI.handler;

import net.zypr.menuAPI.context.MenuItemClickContext;

/**
 * Functional interface for handling menu item click events.
 * Implementations of this interface define the behavior when a menu item is clicked.
 */
@FunctionalInterface
public interface MenuItemClickHandler {

    /**
     * Handles a menu item click event.
     *
     * @param context the context of the menu item click event
     */
    void handle(MenuItemClickContext context);
}
