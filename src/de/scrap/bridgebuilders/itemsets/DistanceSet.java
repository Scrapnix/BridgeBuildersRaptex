package de.scrap.bridgebuilders.itemsets;
 
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.scrap.bridgebuilders.managers.ItemManager;

public class DistanceSet {

	Player p;
	
	public DistanceSet(Player p) {
		this.p = p;
		ItemMeta im = lapis.getItemMeta();
		im.setDisplayName("§140 Blöcke §7Entfernung");
		lapis.setItemMeta(im);
	}
	
	public ItemStack coal = ItemManager.createItem(Material.COAL, 1, "§020 Blöcke §7Entfernung", null, null);
	
	public ItemStack redstone = ItemManager.createItem(Material.REDSTONE, 1, "§430 Blöcke §7Entfernung", null, null);
	
	@SuppressWarnings("deprecation")
	public ItemStack lapis = new ItemStack(351);
	
	public ItemStack iron = ItemManager.createItem(Material.IRON_INGOT, 1, "§750 Blöcke §7Entfernung", null, null);

	public ItemStack gold = ItemManager.createItem(Material.GOLD_INGOT, 1, "§660 Blöcke §7Entfernung", null, null);

	public ItemStack emerald = ItemManager.createItem(Material.EMERALD, 1, "§270Blöcke §7Entfernung", null, null);

	public ItemStack diamond = ItemManager.createItem(Material.DIAMOND, 1, "§b80 Blöcke §7Entfernung", null, null);

	public void setItems() {
		p.getInventory().setItem(1, coal);
		p.getInventory().setItem(2, redstone);
		p.getInventory().setItem(3, lapis);
		p.getInventory().setItem(4, iron);
		p.getInventory().setItem(5, gold);
		p.getInventory().setItem(6, emerald);
		p.getInventory().setItem(7, diamond);

	}
	
}
