package net.kjnine.promotionalitems.commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import net.kjnine.promotionalitems.PromoPlugin;
import net.md_5.bungee.api.ChatColor;

public class PromoCommand implements CommandExecutor {
	
	private PromoPlugin pl = PromoPlugin.instance;
	private FileConfiguration items = pl.itemsFile.get();
	private FileConfiguration lang = pl.langFile.get();
	private FileConfiguration claims = pl.claimsFile.get();

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("promo")) {
			if(!(sender instanceof Player)) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("mustBePlayer")));
				return false;
			}
			Player p = (Player) sender;
			if(!p.hasPermission("promoitems.promo")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("noPermission")));
				return false;
			}
			if(args.length == 0 || args[0].equalsIgnoreCase("list") || args[0].equalsIgnoreCase("listall")) {
				boolean listall = args[0].equalsIgnoreCase("listall");
				if(!p.hasPermission("promoitems.promo.listall") && listall) {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("noPermission")));
					return false;
				}
				if(!items.contains("promoList")) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("promoListNone")));
					return false;
				}
				List<String> promoList = items.getStringList("promoList");
				if(listall)
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("promoListAll")));
				if(!listall)
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', lang.getString("promoList")));
				for(String lPromo : promoList) {
					String description = items.getString("promos."+lPromo+".description");
					boolean active = items.getBoolean("promos."+lPromo+".active");
					boolean claimed = (claims.contains("promos."+lPromo+"."+p.getUniqueId()) && claims.getBoolean("promos."+lPromo+"."+p.getUniqueId()));
					String status = "";
					if(!active && !claimed) {
						status = lang.getString("statusExpired");
					} else if(claimed) {
						status = lang.getString("statusClaimed");
					} else {
						status = lang.getString("statusUnclaimed");
					}
					if(!active && !listall)
						continue;
					String msg = lang.getString("promoListPromos");
					msg = msg.replaceAll("[name]", lPromo);
					msg = msg.replaceAll("[status]", status);
					msg = msg.replaceAll("[desc]", description);
					msg = ChatColor.translateAlternateColorCodes('&', msg);
					p.sendMessage(msg);
				}
			}
		}
		return false;
	}

}
