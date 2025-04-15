package net.zypr.menuAPI.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A utility class for building {@link ItemStack} instances with custom properties.
 * Provides a fluent API for setting item meta, such as name, lore, enchantments, and flags.
 */
public class ItemBuilder {

    /**
     * The {@link ItemStack} being built.
     */
    private final ItemStack item;

    /**
     * The {@link ItemMeta} of the item being built.
     */
    private final ItemMeta meta;

    /**
     * The lore (description) of the item.
     */
    private final List<String> lore = new ArrayList<>();

    /**
     * Constructs a new {@code ItemBuilder} for the specified material.
     *
     * @param material the material of the item
     */
    public ItemBuilder(Material material) {
        this.item = new ItemStack(material);
        this.meta = item.getItemMeta();
    }

    /**
     * Sets the display name of the item.
     *
     * @param name the display name to set
     * @return the current {@code ItemBuilder} instance
     */
    public ItemBuilder setName(String name) {
        meta.setDisplayName(name);
        return this;
    }

    /**
     * Sets the lore (description) of the item.
     *
     * @param lines the lines of lore to set
     * @return the current {@code ItemBuilder} instance
     */
    public ItemBuilder setLore(String... lines) {
        lore.clear();
        Collections.addAll(lore, lines);
        meta.setLore(lore);
        return this;
    }

    /**
     * Adds an enchantment to the item.
     *
     * @param ench  the enchantment to add
     * @param level the level of the enchantment
     * @return the current {@code ItemBuilder} instance
     */
    public ItemBuilder addEnchant(Enchantment ench, int level) {
        meta.addEnchant(ench, level, true);
        return this;
    }

    /**
     * Adds an {@link ItemFlag} to the item.
     *
     * @param flag the item flag to add
     * @return the current {@code ItemBuilder} instance
     */
    public ItemBuilder addItemFlag(ItemFlag flag) {
        meta.addItemFlags(flag);
        return this;
    }

    /**
     * Hides the attributes of the item (e.g., attack damage, armor).
     *
     * @return the current {@code ItemBuilder} instance
     */
    public ItemBuilder hideAttributes() {
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        return this;
    }

    /**
     * Hides the enchantments of the item.
     *
     * @return the current {@code ItemBuilder} instance
     */
    public ItemBuilder hideEnchants() {
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }

    /**
     * Builds and returns the {@link ItemStack} with the specified properties.
     *
     * @return the built {@link ItemStack}
     */
    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }
}

