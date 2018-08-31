package de.scrap.bridgebuilders.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.WorldEditAPI;
import com.sk89q.worldedit.bukkit.selections.Selection;

import de.orochimaruu.bridgebuilders.Main;
import de.orochimaruu.bridgebuilders.utils.BestPlayersHeadSetter;
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
						p.sendMessage(Main.prefix + "§aDie Lobbylocation wurde gesetzt");
					}
					
					if (args[0].equalsIgnoreCase("stats") && (args.length == 2 || args.length == 3)) {
						
						if (args[1].equalsIgnoreCase("gettool") && args.length == 2) {
							
							p.getInventory().addItem(ItemManager.createItem(Material.WOOD_PICKAXE, 1, "§7Best Player Stats Selector", null, null));
							p.sendMessage(Main.prefix + "§7Bitte wähle mit Rechts und Linksklick einen Spielerkopf an und führe den Command: §a/stats setstats [§b20,30,40,50,60,70,80] §7 aus!");
							
						}
						
						if (args[1].equalsIgnoreCase("setstats") && args.length == 3) {
							
							Selection s;
							
							s = Main.getWorldEdit().getSelection(p);
							
							if (s != null) {
								Location loc = s.getMaximumPoint() == s.getMinimumPoint() ? s.getMaximumPoint() : null;
								
								if (loc != null) {
									
									if (args[2].equalsIgnoreCase("20")) {
										BestPlayersHeadSetter.setHead(loc, 20);
									}else if (args[3].equalsIgnoreCase("30")) {
										BestPlayersHeadSetter.setHead(loc, 20);
									}else if (args[3].equalsIgnoreCase("40")) {
										BestPlayersHeadSetter.setHead(loc, 20);
									}else if (args[3].equalsIgnoreCase("50")) {
										BestPlayersHeadSetter.setHead(loc, 20);
									}else if (args[3].equalsIgnoreCase("60")) {
										BestPlayersHeadSetter.setHead(loc, 20);
									}else if (args[3].equalsIgnoreCase("70")) {
										BestPlayersHeadSetter.setHead(loc, 20);
									}else if (args[3].equalsIgnoreCase("80")) {
										BestPlayersHeadSetter.setHead(loc, 20);
									}else {
										p.sendMessage(Main.prefix + "§7Benutzung: §a/stats settstats [20,30,40,50,60,70,80]");
									}
									
								}else {
									p.sendMessage(Main.prefix + "§cBitte markiere nur einen Spielerkopf!");
								}
								
							}else {
								p.sendMessage(Main.prefix + "§cBitte markiere einen Spielerkopf!");
							}
							

							
						}else {
							p.sendMessage(Main.prefix + "§7Benutzung: §a/stats settstats [20,30,40,50,60,70,80]");
						}
						
					}else {
						p.sendMessage(Main.prefix + "§7Benutzung: §a/stats gettool §7| §a/stats settstats [20,30,40,50,60,70,80]");
					}
					
					if (args[0].equalsIgnoreCase("orientationpoint") && args.length == 1) {
						LocationManager.save(p.getLocation(), "orientationpoint");
						p.sendMessage(Main.prefix + "§aDer Orientationpoint wurde gesetzt!");
					}
				}
				
			}
			
		}
		
		return false;
	}

}
