package com.deathswap.commands;

import com.deathswap.Main;
import com.deathswap.runnables.DeathSwapRunnable;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class DeathSwapCommandExecutor implements CommandExecutor {

    BukkitTask task;

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("deathswap")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                JavaPlugin plugin = Main.getPlugin(Main.class);
                int tps = 20;

                int countdown = 60;
                if(args.length > 0) {
                    countdown = Integer.parseInt(args[0]);
                }

                if(task != null) {
                    String msg = "[&cDEATH SWAP&r] - " + "Zatrzymano, let's &6chill";
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    task.cancel();
                    task = null;
                } else {
                    String msg = "[&cDEATH SWAP&r] - Rozpoczęto";
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    task = new DeathSwapRunnable(countdown).runTaskTimer(plugin, 0, tps);
                }
            }
        }
        return false;
    }
}
