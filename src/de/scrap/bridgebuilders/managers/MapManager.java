package de.scrap.bridgebuilders.managers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.CuboidClipboard;
import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.data.DataException;
import com.sk89q.worldedit.schematic.MCEditSchematicFormat;
import com.sk89q.worldedit.schematic.SchematicFormat;

import de.orochimaruu.bridgebuilders.Main;

public class MapManager {

	public static ArrayList<Player> playing = new ArrayList<Player>();
	public static ArrayList<Player> waitinglist = new ArrayList<Player>();
	public static HashMap<Player, Integer> size = new HashMap<Player, Integer>(); //Angaben in Solo : 1 + Anzahl der Entfernung Duo : 2 + Anzahl der Entfernung
	public static HashMap<Integer, Boolean> createdSections = new HashMap<Integer, Boolean>(); //Angaben wie oben + die Nummer der Section | Boolean = True : frei, False : Besetzt 
	
	public static void startScheduler() {
		
	}
	
	@SuppressWarnings("deprecation")
	public static void loadAndSetSchematic(String name, Location loc) {
		File schematic = new File("plugin/BridgeBuilders/schematics" + name);
		Main.getWorldEdit().getWorldEdit();
		EditSession session = Main.getWorldEdit().getWorldEdit().getEditSessionFactory().getEditSession(new BukkitWorld(LocationManager.get("orientationpoint").getWorld()), WorldEdit.getInstance().getConfiguration().maxChangeLimit);
		SchematicFormat format = SchematicFormat.getFormat(schematic);
		try {
			CuboidClipboard clipboard = format.load(schematic);
			Vector v = new Vector(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
			clipboard.paste(session, v, true);
		} catch (DataException | IOException e) {
			Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cDie Schematic §a" + name + " §cwurde nicht gefunden!");
			e.printStackTrace();
		} catch (MaxChangedBlocksException e) {
			Bukkit.getConsoleSender().sendMessage(Main.prefix + "§cZu viele Blöcke wurden versucht zu ändern!");
			e.printStackTrace();
		}

	}
	
}
