package com.hitman.lockitem;

import org.bukkit.ChatColor;
import org.bukkit.block.Chest;
import org.bukkit.block.DoubleChest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LockItemListener implements Listener {

    public String translate(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().getItemMeta().getLore()
                .contains(ChatColor.translateAlternateColorCodes('&', "&c&lLocked"))) {
            e.setCancelled(true);
        }
    }


    @EventHandler
    public void onDrag(PlyaerDragItemEvent e) {
        if (!e.getInventory().getType().equals(InventoryType.PLAYER)) {
            if (e.getCurrentItem().getItemMeta().hasLore()) {
                if (e.getCurrentItem().getItemMeta().getLore()
                        .contains(ChatColor.translateAlternateColorCodes('&', "&c&lLocked"))) {
                    e.setCancelled(true);
                }
            }
        }
    }
}
