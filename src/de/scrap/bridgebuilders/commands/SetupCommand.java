package de.scrap.bridgebuilders.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.orochimaruu.bridgebuilders.Main;
import de.scrap.bridgebuilders.managers.ItemManager;
import de.scrap.bridgebuilders.managers.LocationManager;

public class SetupCommand implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player p = (Player) sender;
			
			if (p.hasPermission("MBS.color.owner") || p.hasPermission("MBS.color.developer") || p.hasPermission("MBS.color.admin")) {
				
				if (args.length > 1) {
					
					if (args[0].equalsIgnoreCase("lobby") && args.length == 1) {
						LocationManager.save(p.getLocation(), "lobby");
						
					}
					
					if (args[0].equalsIgnoreCase("stats") && (args.length == 2 || args.length == 3)) {
						
						if (args[1].equalsIgnoreCase("gettool") && args.length == 2) {
							
							p.getInventory().addItem(ItemManager.createItem(Material.WOOD_PICKAXE, 1, "§7Best Player Stats Selector", null, null));
							p.sendMessage(Main.prefix + "§7Bitte wähle mit Rechts und Linksklick einen Spielerkopf an und führe den Command: §a/stats setstats [§b20,30,40,50,60,70,80] §7 aus!");
							
						}
						
						if (args[1].equalsIgnoreCase("setstats") && args.length == 3) {
							
							
							
						}
						
					}
					
					if (args[0].equalsIgnoreCase("orientationpoint") && args.length == 1) {
						
					}
				}
				
			}
			
		}
		
		return false;
	}

}
