package net.dkcraft.hidestatus;

import net.dkcraft.hidestatus.Login;
import net.dkcraft.hidestatus.Logout;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public void loadConfiguration() {
		this.getConfig().options().copyDefaults(true);
		saveDefaultConfig();
	}

	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Listeners(this), this);
		this.getCommand("login").setExecutor(new Login(this));
		this.getCommand("logout").setExecutor(new Logout(this));
		
		loadConfiguration();
		reloadConfig();
	}

	public void onDisable() {
	}
}
