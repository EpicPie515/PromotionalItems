package net.kjnine.promotionalitems;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class PromoPlugin extends JavaPlugin {
	
	private Logger log = getLogger();
	public static PromoPlugin instance;
	
	@Override
	public void onEnable() {
		instance = this;
		log.info("Successfully Enabled PromotionalItems by KJNine.");
	}
	
	@Override
	public void onDisable() {
		log.info("Successfully Disabled PromotionalItems by KJNine.");
	}
}
