package net.kjnine.promotionalitems;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import net.kjnine.promotionalitems.file.YAMLFile;

public class PromoPlugin extends JavaPlugin {
	
	private Logger log = getLogger();
	public static PromoPlugin instance;
	public YAMLFile itemsFile;
	public YAMLFile langFile;
	public YAMLFile claimsFile;
	
	@Override
	public void onEnable() {
		itemsFile = new YAMLFile("items.yml");
		langFile = new YAMLFile("messages.yml");
		claimsFile = new YAMLFile("claims.yml");
		instance = this;
		log.info("Successfully Enabled PromotionalItems by KJNine.");
	}
	
	@Override
	public void onDisable() {
		log.info("Successfully Disabled PromotionalItems by KJNine.");
	}
}
