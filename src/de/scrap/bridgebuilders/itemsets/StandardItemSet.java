package de.scrap.bridgebuilders.itemsets;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import de.scrap.bridgebuilders.managers.ItemManager;

public class StandardItemSet {

	Player p;
	
	public StandardItemSet(Player p) {
		this.p = p;
		lr1.add("§7Rechtsklick um das §aSpieler"); lr1.add("§averstecken §7Menü zu öffnen!");
		lr2.add("§7Rechtsklick um zu spielen!");
		lr3.add("§7Rechtsklick um deine Stats abzurufen!");
		SkullMeta m = (SkullMeta) stats.getItemMeta();
		m.setOwner(p.getName());
		m.setDisplayName("§eStats");
		m.setLore(lr3);
		stats.setItemMeta(m);
	}
	
	ArrayList<String> lr1 = new ArrayList<String>();
	public ItemStack hider = ItemManager.createItem(Material.BLAZE_ROD, 1, "§aSpieler verstecken", null, lr1);
	
	ArrayList<String> lr2 = new ArrayList<String>();
	public ItemStack play = ItemManager.createItem(Material.SANDSTONE, 1, "§6BridgeBuilders §7spielen", null, lr2);
	
	ArrayList<String> lr3 = new ArrayList<String>();
	public ItemStack stats = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
	
	public void setItems() {
		p.getInventory().setItem(0, stats);
		p.getInventory().setItem(4, play);
		p.getInventory().setItem(8, hider);
	}
	
}
