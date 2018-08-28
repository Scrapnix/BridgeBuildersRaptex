package de.orochimaruu.bridgebuilders.listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import de.orochimaruu.bridgebuilders.Main;
import de.scrap.bridgebuilders.itemsets.DistanceSet;
import de.scrap.bridgebuilders.itemsets.SoloDuoSet;
import de.scrap.bridgebuilders.itemsets.StandardItemSet;
import de.scrap.bridgebuilders.managers.InventoryManager;
import de.scrap.bridgebuilders.managers.MapManager;

public class InteractListener implements Listener {

	Player clicked;
	
	public void onInteraction(PlayerInteractAtEntityEvent e) {
		
		Player p = e.getPlayer();
		
		if (e.getRightClicked() instanceof Player) {
			clicked = Bukkit.getPlayer(e.getRightClicked().getName());
			SoloDuoSet sds = new SoloDuoSet(p);
			
			if (p.getItemInHand().equals(sds.duo)) {
				p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
//				p.sendMessage(Main.prefix + "§7Du bist jetzt in einem Team §a" + clicked.getName() + " §7!");
//				PlayerJoinListener.team.put(p, clicked);
				clicked.sendMessage(Main.prefix + "§7Möchtest du gegen §a" + p.getName() + " §6BridgeBuilders spielen?"); //Anklickbar mach ich später
				
			}
		}
	}
	
	public void onPlayerInteract(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		
		SoloDuoSet sds = new SoloDuoSet(p);
		StandardItemSet sis = new StandardItemSet(p);
		DistanceSet ds = new DistanceSet(p);
		
		if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

			if (p.getItemInHand().equals(sis.play)) {
				p.playSound(p.getLocation(), Sound.WOOD_CLICK, 1F, 1F);
				InventoryManager.setSoloDuo(p);
			}else if (p.getItemInHand().equals(sis.hider)) {
				p.playSound(p.getLocation(), Sound.WOOD_CLICK, 1F, 1F);
				InventoryManager.openHider(p);
			}else if (p.getItemInHand().equals(sis.stats)) {
				p.playSound(p.getLocation(), Sound.WOOD_CLICK, 1F, 1F);
				InventoryManager.openStats(p);
			}
			
			if (p.getItemInHand().equals(sds.solo)) {
				p.playSound(p.getLocation(), Sound.ORB_PICKUP, 1F, 1F);
				InventoryManager.setDistance(p);
				PlayerJoinListener.team.put(p, null);
			}
			
			if (p.getItemInHand().equals(ds.coal)) { //Sryyy, hier wird nur was in den MapManager eingetragen
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				int i = (PlayerJoinListener.team.get(p) == null) ? 120 : 220;
				MapManager.size.put(p, i);
				MapManager.waitinglist.add(p);
			}else if (p.getItemInHand().equals(ds.redstone)) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				int i = (PlayerJoinListener.team.get(p) == null) ? 130 : 230;
				MapManager.size.put(p, i);
				MapManager.waitinglist.add(p);
			}else if (p.getItemInHand().equals(ds.lapis)) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				int i = (PlayerJoinListener.team.get(p) == null) ? 140 : 240;
				MapManager.size.put(p, i);
				MapManager.waitinglist.add(p);
			}else if (p.getItemInHand().equals(ds.iron)) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				int i = (PlayerJoinListener.team.get(p) == null) ? 150 : 250;
				MapManager.size.put(p, i);
				MapManager.waitinglist.add(p);
			}else if (p.getItemInHand().equals(ds.gold)) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				int i = (PlayerJoinListener.team.get(p) == null) ? 160 : 260;
				MapManager.size.put(p, i);
				MapManager.waitinglist.add(p);
			}else if (p.getItemInHand().equals(ds.emerald)) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				int i = (PlayerJoinListener.team.get(p) == null) ? 170 : 270;
				MapManager.size.put(p, i);
				MapManager.waitinglist.add(p);
			}else if (p.getItemInHand().equals(ds.diamond)) {
				p.playSound(p.getLocation(), Sound.LEVEL_UP, 1F, 1F);
				int i = (PlayerJoinListener.team.get(p) == null) ? 180 : 280;
				MapManager.size.put(p, i);
				MapManager.waitinglist.add(p);
			}
			
			if (p.getItemInHand().getType().equals(Material.CHEST)) {
				p.playSound(p.getLocation(), Sound.CHEST_OPEN, 1F, 1F);
				InventoryManager.openShop(p);
			}
			
		}	
	}
	
}
