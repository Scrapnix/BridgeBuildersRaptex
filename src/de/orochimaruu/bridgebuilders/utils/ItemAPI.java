package de.orochimaruu.bridgebuilders.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
	
	//Joo hab mal ne etwas einfachere, umfangreichere ItemAPI eingebaut :)

public class ItemAPI {
	
	ItemStack itemStack;
	ItemMeta itemMeta;
	
	public ItemAPI(String displayname, Material material, byte subid, int amount) {
		itemStack = new ItemStack(material, amount, subid);
		itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(displayname);
	}
	
	public ItemAPI(String displayname, Material material, byte subid, int amount, Enchantment enchantment) {
		itemStack = new ItemStack(material, amount, subid);
		itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(displayname);
		itemMeta.addEnchant(enchantment, 10, true);
	}
	
	public ItemStack build() {
		itemStack.setItemMeta(itemMeta);
		return itemStack;
	}
}
