package net.kjnine.promotionalitems.file;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import net.kjnine.promotionalitems.PromoPlugin;

public class YAMLFile {
	
	protected String fileName;
	
	public YAMLFile(String fileName) {
		this.fileName = fileName;
	}
	
	protected PromoPlugin pl = PromoPlugin.instance;
	protected File file;
	protected FileConfiguration config;
	
	public void init() {
		reload();
		save();
	}

	public void reload() {
		if(file == null) {
			file = new File(pl.getDataFolder(), fileName);
		}
		config = YamlConfiguration.loadConfiguration(file);
		
		Reader defConfigStream = null;
		try {
			defConfigStream = new InputStreamReader(pl.getResource(fileName), "UTF8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if(defConfigStream != null) {
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			config.setDefaults(defConfig);
		}
	}
	
	public FileConfiguration get() {
		if(config == null) {
			reload();
		}
		return config;
	}
	
	public void save() {
		if(config == null || file == null) {
			return;
		}
		try {
			get().save(file);
		} catch (IOException ex) {
			pl.getLogger().log(Level.SEVERE, "Could not save config to " + file, ex);
		}
	}
}
