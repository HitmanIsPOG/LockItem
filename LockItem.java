package com.hitman.lockitem;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class LockItem extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Works");
        getCommand("lockitem").setExecutor(new LockItemCommand());
        Bukkit.getPluginManager().registerEvents(new LockItemListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
