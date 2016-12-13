package me.vorschlagscoding.simplekick.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.vorschlagscoding.simplekick.SimpleKick;
import me.vorschlagscoding.simplekick.utils.Util;

public class KickCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			System.out.println("You must be a player to execute this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(p.isOp() || p.hasPermission("simplekick.kick")) {
			if(args.length > 2) {
				String name = args[0];
				String reason = Util.toString(1, args);
				Player target = Bukkit.getPlayer(name);
				
				if(target.isOnline()) {
					if(!(target.hasPermission("simplekick.bypass"))) {
						target.kickPlayer(reason);
						p.sendMessage(SimpleKick.prefix + ChatColor.GREEN + "Succesfully kicked player " + ChatColor.YELLOW + target.getName());
					} else {
						p.sendMessage(SimpleKick.prefix + ChatColor.RED + "This player cannot be kicked!");
					}
				} else {
					p.sendMessage(SimpleKick.prefix + ChatColor.RED + "This player is not " + ChatColor.YELLOW + "online" + ChatColor.RED + "!");
				}
			} else {
				p.sendMessage(SimpleKick.prefix + ChatColor.YELLOW + "Usage" + ChatColor.DARK_GRAY + ": " + ChatColor.RED + "/kick " + ChatColor.GRAY + "<" + ChatColor.RED + "Player" + ChatColor.GRAY + "> (" + ChatColor.RED + "Reason" + ChatColor.GRAY + ")");
			}
		} else {
			p.sendMessage(SimpleKick.prefix + ChatColor.RED + "You don´t have enough " + ChatColor.YELLOW + "permissions " + ChatColor.RED + "to execute this command!");
		}
		return true;
	}

}
