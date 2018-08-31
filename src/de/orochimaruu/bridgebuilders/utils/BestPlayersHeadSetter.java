package de.orochimaruu.bridgebuilders.utils;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.block.Skull;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.orochimaruu.bridgebuilders.Main;
import de.scrap.bridgebuilders.managers.FileManager;
import de.scrap.bridgebuilders.managers.LocationManager;

public class BestPlayersHeadSetter {

	public static void setHead(Location l, int blocks) {
		String p = null; //Später abrufen 
		
		Block b = l.getBlock();
		BlockState bs = b.getState();
		
		if (b.getType().equals(Material.SKULL)) {
			if (blocks == 20) {
				updateStateAndEntity(p, "", "20 Blöcken", bs);
				LocationManager.save(l, "201");
			}else if (blocks == 30) {
				updateStateAndEntity(p, "", "30 Blöcken", bs);
				LocationManager.save(l, "301");
			}else if (blocks == 40) {
				updateStateAndEntity(p, "", "40 Blöcken", bs);
				LocationManager.save(l, "401");
			}else if (blocks == 50) {
				updateStateAndEntity(p, "", "50 Blöcken", bs);
				LocationManager.save(l, "501");
			}else if (blocks == 60) {
				updateStateAndEntity(p, "", "60 Blöcken", bs);
				LocationManager.save(l, "601");
			}else if (blocks == 70) {
				updateStateAndEntity(p, "", "70 Blöcken", bs);
				LocationManager.save(l, "701");
			}else if (blocks == 80) {
				updateStateAndEntity(p, "", "80 Blöcken", bs);
				LocationManager.save(l, "801");
			}
			
		}
		
	}
	
	public static void updateStateAndEntity(String p, String record, String blocks, BlockState bs) {
		
		Skull skull = (Skull) bs;
		skull.setOwner(p);
		skull.update();
		
		Location l1 = bs.getBlock().getLocation();
		Location l2 = new Location(l1.getWorld(), l1.getX(), l1.getY() - 1, l1.getZ());
		
		l2.getBlock().setType(Material.WALL_SIGN);
		Sign sign = (Sign) l2.getBlock();
		sign.setLine(0, "§6" + p);
		sign.setLine(1, "§a" + blocks);
		sign.setLine(2, "§7---------");
		sign.setLine(3, "§2" + record);
		sign.update();
		
	}
	
}
