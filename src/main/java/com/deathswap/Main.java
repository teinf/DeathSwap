package com.deathswap;

import com.deathswap.commands.DeathSwapCommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("[DeathSwap] enabled");

        getCommand("deathswap").setExecutor(new DeathSwapCommandExecutor());
    }

    @Override
    public void onDisable() {
        getLogger().info("[DeathSwap] disabled");
    }
}
