package net.kjnine.promotionalitems.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class PromoCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("promo")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.RED + "Please use this command as a player.");
				return false;
			}
			Player p = (Player) sender;
			if(!p.hasPermission("promoitems.promo")) {
				p.sendMessage(ChatColor.RED + "You do not have permission to use that command.");
				return false;
			}
			if(args.length == 0) {
				
			}
		}
		return false;
	}

}
