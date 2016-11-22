package net.kjnine.promotionalitems.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import net.kjnine.promotionalitems.PromoPlugin;
import net.md_5.bungee.api.ChatColor;

public class PromoCommand implements CommandExecutor {
	
	private PromoPlugin pl = PromoPlugin.instance;
	private FileConfiguration items = pl.itemsFile.get();
	private FileConfiguration lang = pl.langFile.get();

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
				if(pl.getConfig().getBoolean("promoGui") && pl.getConfig().getBoolean("listGui")) {
					// TODO Gui
				} else {
					if(!items.contains("promoList"))
						p.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("promoListNone")));
					List<String> promoList = items.getStringList("promoList");
					for(String lPromo : promoList) {
						String 
					}
				}
			}
		}
		return false;
	}

}
