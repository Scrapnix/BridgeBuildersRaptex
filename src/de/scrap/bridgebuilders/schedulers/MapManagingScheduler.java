package de.scrap.bridgebuilders.schedulers;

import org.bukkit.Location;
import org.bukkit.entity.Player;

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
		
		if (!MapManager.waitinglist.isEmpty()) {
			Player p = MapManager.waitinglist.get(0);
			if (!MapManager.createdSections.isEmpty()) {
				
				try {
					MapManager.waitinglist.remove(p);
					for (int i = 0; i < MapManager.createdSections.size(); i++) {
						int size = MapManager.size.get(p);
						if (MapManager.createdSections.get(size + i) == true) {
							//Breite der Section = 20Blöcke
//							Location loc = new Location(world, x, y, z) Erstmal setup command erstellen (Kannst du das bitte machen, habe schon nen LocationManager erstellt, ist nicht so schwierig ;))
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				
			}
		}
		
	}

}
