package net.dkcraft.hidestatus;

import net.dkcraft.hidestatus.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Login implements CommandExecutor {

	private Main plugin;

	public Login(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("login")) {
			if (args.length == 0) {
				String playerName = cs.getName();
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("fake-login").replace("%player%", playerName)));
			} else {
				cs.sendMessage(ChatColor.RED + "Incorrect syntax. Usage: /login");
			}
		}
		return true;
	}
}
