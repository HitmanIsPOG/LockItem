package com.hitman.lockitem;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class LockItemCommand implements CommandExecutor {

    public String translate (String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.getMainHand() != null || player.getMainHand().equals(Material.AIR)) {
                ItemStack itemStack = player.getItemInHand();
                ItemMeta meta = itemStack.getItemMeta();
                List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();

                if (lore.contains(ChatColor.translateAlternateColorCodes('&', "&c&lLocked"))) {
                    player.sendMessage(translate("&e&lLockItem &aUnLocked The Item"));
                    lore.remove(ChatColor.translateAlternateColorCodes('&', "&c&lLocked"));
                    meta.setLore(lore);
                } else {
                    player.sendMessage(translate("&e&lLockItem &aLocked The Item"));
                    lore.add(ChatColor.translateAlternateColorCodes('&', "&c&lLocked"));
                    meta.setLore(lore);
                }
                itemStack.setItemMeta(meta);
            }
        } else {

        }




        return false;
    }
}
