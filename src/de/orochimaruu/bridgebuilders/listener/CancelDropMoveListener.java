package de.orochimaruu.bridgebuilders.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryInteractEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import de.orochimaruu.bridgebuilders.Main;
import de.scrap.bridgebuilders.managers.MapManager;

public class CancelDropMoveListener implements Listener{
	
	@EventHandler
	public void onMove (InventoryInteractEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (Main.setup == true && !Main.whitelist.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onDrop (PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		if (Main.setup == true && !Main.whitelist.contains(p)) {
			e.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onBlockBreak (BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (Main.setup == true && !Main.whitelist.contains(p)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlockBuild (BlockPlaceEvent e) {
		Player p = e.getPlayer();
		if (Main.setup == true && !Main.whitelist.contains(p) && !MapManager.playing.contains(p)) {
			//Später hier noch if Abfrage des Bereichs hinmachen
			e.setCancelled(true);
		}
	}
	
}
