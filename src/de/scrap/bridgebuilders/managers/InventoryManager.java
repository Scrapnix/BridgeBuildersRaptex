package de.scrap.bridgebuilders.managers;

import org.bukkit.entity.Player;

import de.orochimaruu.bridgebuilders.Main;
import de.scrap.bridgebuilders.itemsets.DistanceSet;
import de.scrap.bridgebuilders.itemsets.SoloDuoSet;

public class InventoryManager {

	public static void setSoloDuo(Player p) {
		p.sendMessage(Main.prefix + "§7Bitte wähle §5Solo §7oder §5Duo§7! Wenn du §5Duo §7spielen möchtest Rechtsklicke deinen Kontrahenten!");
		SoloDuoSet sds = new SoloDuoSet(p);
		sds.setItems();
	}

	public static void openHider(Player p) {
		// TODO Auto-generated method stub
		
	}

	public static void openStats(Player p) {
		// TODO Auto-generated method stub
		
	}

	public static void setDistance(Player p) {
		p.sendMessage(Main.prefix + "§7Bitte wähle die §aDistanz §7aus!");
		DistanceSet ds = new DistanceSet(p);
		ds.setItems();
	}

	public static void openShop(Player p) {
		// TODO Auto-generated method stub
		
	}
	
}
