package de.scrap.bridgebuilders.managers;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;

import de.orochimaruu.bridgebuilders.Main;

public class FileManager {

	public String prefix;
	
	public File getConfigFile(){
	    return new File("plugins/BridgeBuilders", "config.yml");
	}
	  
	public FileConfiguration getConfigFileConfiguration() {
	    return org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(getConfigFile());
	}
	
	public File getMySQLFile() {
	    return new File("plugins/BridgeBuilders", "mysql.yml");
	}
	
	public FileConfiguration getMySQLFileConfiguration() {
		return org.bukkit.configuration.file.YamlConfiguration.loadConfiguration(getMySQLFile());
	}
	
	public void setConfigFile() {
		
		FileConfiguration config = getConfigFileConfiguration();
		
		Bukkit.getServer().getConsoleSender().sendMessage(config.getString("prefix") + "§r§7| §aDie config.yml wurde erstellt!");
		
		config.set("prefix", "§6BridgeBuilders §7| ");
		
	    try{
	    	config.save(getConfigFile());
	    } catch (Exception e) {
	    	Bukkit.getServer().getConsoleSender().sendMessage(config.getString("prefix") + "§r§7| §cEin schwerwiegender Fehler ist während des Sicherns von der CONFIG.YML aufgetreten!");
	    	e.printStackTrace();
	    }
	}
	
	public void setMySQLFile() {
		FileConfiguration mysql = getMySQLFileConfiguration();
	    
		mysql.set("username", "root");
		mysql.set("password", "pw");
		mysql.set("database", "db");
		mysql.set("host", "locahost");
		mysql.set("port", "3306");
	    
		Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "§aDie mysql.yml wurde erstellt!");
		
	    try{
	    	mysql.save(getMySQLFile());
	    } catch (Exception e) {
	    	Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "§cEin schwerwiegender Fehler ist während des Sicherns von der CONFIG.YML aufgetreten!");
	    	e.printStackTrace();
	    }
	}
	
	public void setFiles() {
		
		if (!getConfigFile().exists()) {
			setConfigFile();
			this.prefix = getConfigFileConfiguration().getString("prefix");
		}else {
			this.prefix = getConfigFileConfiguration().getString("prefix");
			Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "§7Die config.yml wurde schon erstellt. [UEBERSPRINGEN]");
		}
		
		if (!getMySQLFile().exists()) {
			setMySQLFile();
		}else {
			Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "§7Die mysql.yml wurde schon erstellt. [UEBERSPRINGEN]");
		}
	}
	
}
