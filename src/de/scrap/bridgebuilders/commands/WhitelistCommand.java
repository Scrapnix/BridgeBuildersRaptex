package de.scrap.bridgebuilders.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.orochimaruu.bridgebuilders.Main;

public class WhitelistCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
				
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.hasPermission("MBS.color.owner") || p.hasPermission("MBS.color.developer") || p.hasPermission("MBS.color.admin")) {
				
				if (!Main.whitelist.isEmpty() || !Main.whitelist.contains(p)) {
					Main.whitelist.add(p);
					p.sendMessage(Main.prefix + "§aDu hast nun eine Wildcard! (Zum beenden /whitelist)");
				}else if (!Main.whitelist.isEmpty() | Main.whitelist.contains(p)) {
					Main.whitelist.remove(p);
					p.sendMessage(Main.prefix + "§7Du hast nun keine Wildcard mehr!");
				}else {
					Main.whitelist.add(p);
					p.sendMessage(Main.prefix + "§aDu hast nun eine Wildcard! (Zum beenden /whitelist)");
				}
				
			}
			
		}
		
		return false;
	}

}
