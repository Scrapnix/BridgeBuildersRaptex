package de.scrap.bridgebuilders.managers;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

public class MapManager {

	public static ArrayList<Player> playing = new ArrayList<Player>();
	public static ArrayList<Player> waitinglist = new ArrayList<Player>();
	public static HashMap<Player, Integer> size = new HashMap<Player, Integer>(); //Angaben in Solo : 1 + Anzahl der Entfernung Duo : 2 + Anzahl der Entfernung
	public static HashMap<Integer, Boolean> createdSections = new HashMap<Integer, Boolean>(); //Angaben wie oben + die Nummer der Section | Boolean = True : frei, False : Besetzt 
	
	public static void startScheduler() {
		
	}
	
}
