package de.scrap.bridgebuilders.schedulers;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import de.orochimaruu.bridgebuilders.Main;
import de.orochimaruu.bridgebuilders.listener.PlayerJoinListener;
import de.scrap.bridgebuilders.managers.LocationManager;
import de.scrap.bridgebuilders.managers.MapManager;

public class MapManagingScheduler implements Runnable{
	//Der Scheduler läuft von Start an und erstellt immer dann ne neue Section wenn ein Spieler in die Waitinglist eingetragen wird, wenn schon Sections frei sind, werden die Spieler auf die freien Sections geportet
	private int id;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		if (Main.setup == true) {
			if (!MapManager.waitinglist.isEmpty()) {
				Player p = MapManager.waitinglist.get(0);
				Player p2 = null;
				if (!MapManager.createdSections.isEmpty()) {
					try {
						MapManager.waitinglist.remove(p);
						MapManager.playing.add(p);
						if (PlayerJoinListener.team.containsKey(p)) {
							MapManager.playing.add(PlayerJoinListener.team.get(p));
							p2 = PlayerJoinListener.team.get(p);
						}
						for (int i = 0; i <= MapManager.createdSections.size(); i++) {
							int size = MapManager.size.get(p);
							if (MapManager.createdSections.get(size + i) == true) {
								//Breite der Section = 21Blöcke (20 Spielfeld, 1 Trennblock) [Orientationpoint hat auch Barriere]
								Location loc1 = LocationManager.get("orientationpoint");
								Location loc2 = new Location(loc1.getWorld(), loc1.getBlockX(), loc1.getBlockY(), loc1.getBlockZ() + (i * 21));
								int soloduo = Integer.valueOf(String.valueOf(size).substring(0, 0));
								int blocks = Integer.valueOf(String.valueOf(size).substring(1, 2));
								
								if (soloduo == 1) {
									Location loc3 = new Location(loc2.getWorld(), loc2.getX() + 3.5, loc2.getY() + 1, loc2.getZ() + 10.5);
									if (blocks == 20) { 
										p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 30) { 
										p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 40) {
										p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 50) {
										p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 60) {
										p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 70) {
										p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 80) {
										p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}
								}else if (soloduo == 2) {
									Location loc3 = new Location(loc2.getWorld(), loc2.getX() + 3.5, loc2.getY() + 1, loc2.getZ() + 5.5);
									Location loc4 = new Location(loc2.getWorld(), loc2.getX() + 3.5, loc2.getY() + 1, loc2.getZ() + 16.5);
									if (blocks == 20) {
										p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F); p2.playSound(p2.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 30) {
										p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F); p2.playSound(p2.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 40) {
										p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F); p2.playSound(p2.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 50) {
										p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F); p2.playSound(p2.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 60) {
										p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F); p2.playSound(p2.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 70) {
										p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F); p2.playSound(p2.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 80) {
										p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F); p2.playSound(p2.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}
								}
							}else if (i == MapManager.createdSections.size()) {
								int i2 = MapManager.createdSections.size() + 1;
								Location loc1 = LocationManager.get("orientationpoint");
								Location loc2 = new Location(loc1.getWorld(), loc1.getBlockX(), loc1.getBlockY(), loc1.getBlockZ() + (i2 * 21));
								int soloduo = Integer.valueOf(String.valueOf(size).substring(0, 0));
								int blocks = Integer.valueOf(String.valueOf(size).substring(1, 2));

								if (soloduo == 1) {
									Location loc3 = new Location(loc2.getWorld(), loc2.getX() + 3.5, loc2.getY() + 1, loc2.getZ() + 10.5);
									if (blocks == 20) {
										MapManager.loadAndSetSchematic("bridgebuilders120.schematic", loc2); p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 30) {
										MapManager.loadAndSetSchematic("bridgebuilders130.schematic", loc2); p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 40) {
										MapManager.loadAndSetSchematic("bridgebuilders140.schematic", loc2); p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 50) {
										MapManager.loadAndSetSchematic("bridgebuilders150.schematic", loc2); p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 60) {
										MapManager.loadAndSetSchematic("bridgebuilders160.schematic", loc2); p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 70) {
										MapManager.loadAndSetSchematic("bridgebuilders170.schematic", loc2); p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 80) {
										MapManager.loadAndSetSchematic("bridgebuilders180.schematic", loc2); p.teleport(loc3); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}   
								}else if (soloduo == 2) {
									Location loc3 = new Location(loc2.getWorld(), loc2.getX() + 3.5, loc2.getY() + 1, loc2.getZ() + 5.5);
									Location loc4 = new Location(loc2.getWorld(), loc2.getX() + 3.5, loc2.getY() + 1, loc2.getZ() + 16.5);
									if (blocks == 20) {
										MapManager.loadAndSetSchematic("bridgebuilders220.schematic", loc2); p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 30) {
										MapManager.loadAndSetSchematic("bridgebuilders230.schematic", loc2); p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 40) {
										MapManager.loadAndSetSchematic("bridgebuilders240.schematic", loc2); p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 50) {
										MapManager.loadAndSetSchematic("bridgebuilders250.schematic", loc2); p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 60) {
										MapManager.loadAndSetSchematic("bridgebuilders260.schematic", loc2); p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 70) {
										MapManager.loadAndSetSchematic("bridgebuilders270.schematic", loc2); p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									}else if (blocks == 80) {
										MapManager.loadAndSetSchematic("bridgebuilders280.schematic", loc2); p.teleport(loc3); p2.teleport(loc4); p.playSound(p.getLocation(), Sound.FIREWORK_LAUNCH, 1F, 1F);
									} 
								}
							}
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
				}else {
					
				}
			}
		}
	}
}
