package net.kjnine.promotionalitems.file;

import org.bukkit.configuration.file.FileConfiguration;

public interface YAMLFile {
	
	public void saveConfig();
	
	public FileConfiguration getConfig();
	
	public void reloadConfig();
}
