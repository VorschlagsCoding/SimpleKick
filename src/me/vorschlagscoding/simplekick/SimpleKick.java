package me.vorschlagscoding.simplekick;

import org.bukkit.plugin.java.JavaPlugin;

import me.vorschlagscoding.simplekick.commands.KickCommand;

public class SimpleKick extends JavaPlugin {
	
	public static String prefix = "§7[§6SimpleKick§7] ";
	
	@Override
	public void onEnable() {
		getCommand("kick").setExecutor(new KickCommand());
		System.out.println("[SimpleKick] Successfully started plugin!");
	}
	
	@Override
	public void onDisable() {
		System.out.println("[SimpleKick] Successfully stopped plugin!");
	}
	
}
