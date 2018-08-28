package de.scrap.bridgebuilders.itemsets;
 
import java.util.ArrayList; 

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import de.scrap.bridgebuilders.managers.ItemManager;

public class IngameSet {

	Player p;
	Material block;
	String name;
	
	public IngameSet(Player p, Material block, String name) {
		this.p = p;
		this.block = block;
		this.name = name;
		lr1.add("§7Rechtsklick um den §6Shop zu öffnen!");
		lr2.add("§7Rechtsklick um das §aSpieler"); lr2.add("§averstecken §7Menü zu öffnen!");
	}
	
	public ItemStack stone = ItemManager.createItem(block, 64, name, null, null);
		
	ArrayList<String> lr1 = new ArrayList<String>();
	public ItemStack shop = ItemManager.createItem(Material.CHEST, 1, "§6Shop", null, null);

	ArrayList<String> lr2 = new ArrayList<String>();
	public ItemStack hider = ItemManager.createItem(Material.BLAZE_ROD, 1, "§aSpieler verstecken", null, lr1);
	
	public void setItems() {
		p.getInventory().setItem(0, stone);
		p.getInventory().setItem(1, stone);
		p.getInventory().setItem(2, stone);
		p.getInventory().setItem(6, shop);
		p.getInventory().setItem(7, hider);
	}
	
}
