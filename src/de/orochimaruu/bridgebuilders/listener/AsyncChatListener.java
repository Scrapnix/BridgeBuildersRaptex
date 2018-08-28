package de.orochimaruu.bridgebuilders.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class AsyncChatListener implements Listener {

	public void onChat(AsyncPlayerChatEvent e) {
		
		String m = e.getMessage();
		Player p = e.getPlayer();
		
		if (PlayerJoinListener.soloduo.containsKey(p)) {
			if ((!m.contains("@all"))) {
				for (Player players : e.getRecipients()) {
					e.getRecipients().remove(players);
					if (PlayerJoinListener.team.containsKey(p)) {
						e.getRecipients().add(PlayerJoinListener.team.get(p));
					}
				}
			}
		}
	}
	
}
