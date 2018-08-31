package de.scrap.bridgebuilders.managers;

import java.io.File;  

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public class LocationManager {

	//Erklärt sich glaube von selbst
	
	public static void save(Location loc, String name) {
				
		FileManager fm = new FileManager();
		
		FileConfiguration saves = fm.getConfigFileConfiguration();
		
		saves.set("location." + name + ".worldname", loc.getWorld().getName());
		saves.set("location." + name + ".x", loc.getBlockX() + 0.500);
		saves.set("location." + name + ".y", loc.getBlockY() + 0.500);
		saves.set("location." + name + ".z", loc.getBlockZ() + 0.500);
		saves.set("location." + name + ".yaw", loc.getYaw());
		saves.set("location." + name + ".pitch", loc.getPitch());
		
		File savesfile = fm.getConfigFile();
		
		try {
			saves.save(savesfile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Location get(String name) {
		
		try {
			FileManager fm = new FileManager();

			FileConfiguration saves = fm.getConfigFileConfiguration();

			World worldname = Bukkit.getWorld(saves.getString("location." + name + ".worldname"));
			double x = saves.getDouble("location." + name + ".x");
			double y = saves.getDouble("location." + name + ".y");
			double z = saves.getDouble("location." + name + ".z");
			double yaw = saves.getDouble("location." + name + ".yaw");
			double pitch = saves.getDouble("location." + name + ".pitch");

			Location loc = new Location(worldname, x, y, z, (float) yaw, (float) pitch);

			return loc;
		} catch (NullPointerException e) {
			return null;
		}
		
	}
	
}
