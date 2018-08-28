package de.scrap.bridgebuilders.managers;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemManager {

	public static ItemStack createItem(Material mat, int amount, String name, String durability, ArrayList<String> lore) {
		
		if(mat == null) {
			return null;
		}else {
			ItemStack is = new ItemStack(mat);
			ItemMeta im = is.getItemMeta();
			
			is.setAmount(amount);
			if (durability != null) {
				is.setDurability(Short.parseShort(durability));
			}
			if (name != null) {
				im.setDisplayName(name);
			}
			if (lore != null) {
				im.setLore(lore);
			}
		
			is.setItemMeta(im);
		
			return is;
		}
	}
	
}
