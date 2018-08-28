package de.orochimaruu.bridgebuilders.listener;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.orochimaruu.bridgebuilders.Main;
import de.scrap.bridgebuilders.itemsets.StandardItemSet;
import de.scrap.bridgebuilders.managers.ScoreboardManager;

public class PlayerJoinListener implements Listener{
	
	public static HashMap<Player, Player> team = new HashMap<Player, Player>(); //Wenn 2. Player = null == Solo Game
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		ScoreboardManager sm = new ScoreboardManager();
		sm.createNewScoreboard(p);
		
		if(!p.hasPlayedBefore()) {
			e.setJoinMessage(null);
			sm.createNewScoreboard(p);
			p.sendMessage("§7<§m------------------------------------§7>");
			p.sendMessage("§aHerzlich Willkommen auf dem §bBridgeBuilder-Server!");
			p.sendMessage("");
			p.sendMessage("§aWähle zuerst, ob du §bSolo §aoder §bDuo §aspielen möchtest");
		}
		
		p.getInventory().clear();
		StandardItemSet sis = new StandardItemSet(p);
		sis.setItems();
		
	}

}
