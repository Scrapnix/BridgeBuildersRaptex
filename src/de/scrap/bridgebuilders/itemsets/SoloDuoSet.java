package de.scrap.bridgebuilders.itemsets;

import java.util.ArrayList; 

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.scrap.bridgebuilders.managers.ItemManager;

public class SoloDuoSet {

	Player p;
	
	public SoloDuoSet(Player p) {
		this.p = p;
		lr1.add("§7Rechtsklick um"); lr1.add("§5Solo §7zu spielen!");
		lr2.add("§7Rechtsklicke einen Spieler"); lr2.add("§7um §5Duo §7zu spielen!");
	}
	
	ArrayList<String> lr1 = new ArrayList<String>();
	public ItemStack solo = ItemManager.createItem(Material.DIAMOND_SWORD, 1, "§5Solo", null, lr1);
	
	ArrayList<String> lr2 = new ArrayList<String>();
	public ItemStack duo = ItemManager.createItem(Material.DIAMOND_SWORD, 1, "§5Duo", null, lr2);
	
	public void setItems() {
		p.getInventory().setItem(3, solo);
		p.getInventory().setItem(5, duo);
	}
	
}
