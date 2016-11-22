package net.kjnine.promotionalitems;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import net.kjnine.promotionalitems.file.ItemsFile;

public class PromoPlugin extends JavaPlugin {
	
	private Logger log = getLogger();
	public static PromoPlugin instance;
	public ItemsFile itemsFile;
	
	@Override
	public void onEnable() {
		itemsFile = new ItemsFile();
		instance = this;
		log.info("Successfully Enabled PromotionalItems by KJNine.");
	}
	
	public void postInitEnable() {
		itemsFile.reloadConfig();
		itemsFile.saveConfig();
	}
	
	@Override
	public void onDisable() {
		log.info("Successfully Disabled PromotionalItems by KJNine.");
	}
}
