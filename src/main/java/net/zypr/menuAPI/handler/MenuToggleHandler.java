package net.zypr.menuAPI.handler;

import net.zypr.menuAPI.context.MenuItemClickContext;

/**
 * Functional interface for handling toggle events in a menu.
 * Implementations of this interface define the behavior when a toggle action is performed.
 */
@FunctionalInterface
public interface MenuToggleHandler {

    /**
     * Handles a toggle event in the menu.
     *
     * @param context the context of the menu item click event
     * @param newState the new state of the toggle
     * @return {@code true} if the toggle action was successful, {@code false} otherwise
     */
    boolean handle(MenuItemClickContext context, boolean newState);
}
