package de.orochimaruu.bridgebuilders;

import java.util.ArrayList; 

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;

import de.orochimaruu.bridgebuilders.listener.AsyncChatListener;
import de.orochimaruu.bridgebuilders.listener.CancelDropMoveListener;
import de.orochimaruu.bridgebuilders.listener.InteractListener;
import de.orochimaruu.bridgebuilders.listener.PlayerJoinListener;
import de.scrap.bridgebuilders.commands.SetupCommand;
import de.scrap.bridgebuilders.commands.WhitelistCommand;
import de.scrap.bridgebuilders.managers.FileManager;
import de.scrap.bridgebuilders.managers.LocationManager;
import de.scrap.bridgebuilders.managers.MapManager;
import de.scrap.bridgebuilders.managers.MySQLManager;

public class Main extends JavaPlugin{
	
	public static Main instance;
	ArrayList<Player> inmap = new ArrayList<>();
	ArrayList<Player> inlobby = new ArrayList<>();
	
	public static String prefix;
	public static MySQLManager msm;
		
	public static Boolean setup = false;
	public static ArrayList<Player> whitelist = new ArrayList<Player>();
	
	@Override 
	public void onEnable() {
		instance = this;
		
		FileManager fm = new FileManager();
		FileConfiguration mysql = fm.getMySQLFileConfiguration();
		fm.setFiles();
		
		try {
			msm = new MySQLManager(this, mysql.getString("host"), mysql.getInt("port"), mysql.getString("user"), mysql.getString("password"), mysql.getString("database"));
			msm.update("CREATE TABLE IF NOT EXISTS Spieler (Spielername VARCHAR(100), Rekord VARCHAR(100), GebauteBloecke VARCHAR(100), Coins VARCHAR(100))");
			Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "§7Die MySQL Verbindung wurde ohne Fehler aufgebaut!");
		} catch (Exception e) {
			Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "§cMySQL Verbindung konnte nicht aufgebaut werden! Bitte eingegebene Infos überprüfen!");
		}
		
		MapManager.startScheduler();
		
		this.loadEvents();
		this.registerCommands();
		
		if (LocationManager.get("lobby") != null && LocationManager.get("orientationpoint") != null) {
			setup = true;
		}
		
		whitelist.add(null);
		
	}
	
	
	
	public void onDisable() {
		
		try {
			msm.closeConnection();
			Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "§7Die MySQL Verbindung wurde ohne Fehler geschlossen!");
		} catch (Exception e) {
			Bukkit.getServer().getConsoleSender().sendMessage(Main.prefix + "§cDie MySQL Verbindung konnte nicht geschlossen werden! Bitte eingegebene Infos überprüfen!");
		}
		
	}
	
	public void loadEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		
		pm.registerEvents(new PlayerJoinListener(), this);
		pm.registerEvents(new InteractListener(), this);
		pm.registerEvents(new AsyncChatListener(), this);
		pm.registerEvents(new CancelDropMoveListener(), this);
		
	}
	
	public void registerCommands() {
		this.getCommand("setup").setExecutor(new SetupCommand());
		this.getCommand("whitelist").setExecutor(new WhitelistCommand());
	}
	
	public static Main getInstance() {
		return instance;
	}
	
    public static WorldEditPlugin getWorldEdit() {
        Plugin p = Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
        if (p instanceof WorldEditPlugin) return (WorldEditPlugin) p;
        else return null;
    }
    
}
