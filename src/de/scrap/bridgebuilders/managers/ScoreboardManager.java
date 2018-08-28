package de.scrap.bridgebuilders.managers;

import java.util.ArrayList; 
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import de.orochimaruu.bridgebuilders.Main;
import ru.tehkode.permissions.PermissionUser;
import ru.tehkode.permissions.bukkit.PermissionsEx;


public class ScoreboardManager {
	private Map<Player, Scoreboard> playerScoreboards;

	public ScoreboardManager() {
		this.playerScoreboards = new HashMap<Player, Scoreboard>();
		updateAllScoreboards(true, true);
		startSidebarUpdater();
	}

	public void createNewScoreboard(Player p) {
		if (this.playerScoreboards.containsKey(p)) {
			return;
		}
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();

		Objective healthOb = board.registerNewObjective("PlayerHealth", "health");
		healthOb.setDisplaySlot(DisplaySlot.BELOW_NAME);
		healthOb.setDisplayName(ChatColor.RED + "§4<3"); //Emoji ist nich UTF-8 xD

		Objective sidebar = board.registerNewObjective("Sidebar", "dummy");
		sidebar.setDisplaySlot(DisplaySlot.SIDEBAR);
		sidebar.setDisplayName("§8» §6§lNetzwerk.de §8«");

		Team teamTime = board.registerNewTeam("Time");
		Team teamBestTime = board.registerNewTeam("BestTime");

		teamTime.addEntry("§8» §a§f");
		teamBestTime.addEntry("§8» §b§f");
		
		sidebar.getScore("§c ").setScore(8);
		sidebar.getScore("§2Time:§f").setScore(7);
		sidebar.getScore("§8» §a§f").setScore(6);
		sidebar.getScore(" §f").setScore(5);
		sidebar.getScore("§2Beste Zeit§f:").setScore(4);
		sidebar.getScore("§8» §b§f").setScore(3);
		sidebar.getScore("§c ").setScore(2);
		
		

		p.setScoreboard(board);
		this.playerScoreboards.put(p, board);
		updateTeamlistForPlayer(p);
		updateSidebar(p);
	}

	public void removePlayerScoreboard(Player p) {
		if (!this.playerScoreboards.containsKey(p)) {
			return;
		}
		Scoreboard board = (Scoreboard) this.playerScoreboards.get(p);
		for (Objective scoreOb : board.getObjectives()) {
			scoreOb.unregister();
		}
		for (Team scoreTeam : board.getTeams()) {
			scoreTeam.unregister();
		}
		this.playerScoreboards.remove(p);
		p.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
	}
	
	public void updateTeamlistForPlayer(Player forWhom) {
		if (!this.playerScoreboards.containsKey(forWhom)) {
			createNewScoreboard(forWhom);
		}
		Scoreboard board = (Scoreboard) this.playerScoreboards.get(forWhom);
		Collection<? extends Player> online = Bukkit.getOnlinePlayers();
		List<String> onlineName = new ArrayList<String>();
		for (Player all : online) {
			onlineName.add(all.getName());
			Team playerTeam = getTeamForPlayer(board, all);
			if (!playerTeam.hasEntry(all.getName())) {
				playerTeam.addEntry(all.getName());
			}
		}
		for (String entry : board.getEntries()) {
			if (!onlineName.contains(entry)) {
				Team team = searchTeamsForEntry(forWhom, entry);
				if ((team != null) && (!team.getName().equals("Player")) && (!team.getName().equals("Time"))
						&& (!team.getName().equals("BestTime"))) {
					team.removeEntry(entry);
				}
			}
		}
	}

	public void updateSidebar(Player forWhom) {
		if (!this.playerScoreboards.containsKey(forWhom)) {
			createNewScoreboard(forWhom);
		}
		Scoreboard board = (Scoreboard) this.playerScoreboards.get(forWhom);
		Team teamTime = board.getTeam("Time");
		Team teamBestTime = board.getTeam("BestTime");

		PermissionUser user = PermissionsEx.getPermissionManager().getUser(forWhom.getUniqueId());
		final String prefix = ChatColor.translateAlternateColorCodes('&', user.getPrefix());

		teamTime.setSuffix("§8---");
		teamBestTime.setSuffix("§8---");
	}

	public void updateAllScoreboards(boolean teamList, boolean sidebar) {
		if (teamList) {
			for (Player all : this.playerScoreboards.keySet()) {
				updateTeamlistForPlayer(all);
			}
		}
		if (sidebar) {
			for (Player all : this.playerScoreboards.keySet()) {
				updateSidebar(all);
			}
		}
	}

	private static Team getTeamForPlayer(Scoreboard board, Player forWhom) {
		if (forWhom.hasPermission("MBS.color.owner")) {
			return board.getTeam("ATeamOwner");
		}
		if (forWhom.hasPermission("MBS.color.Architekt")) {
			return board.getTeam("MTeamArchi");
		}
		if (forWhom.hasPermission("MBS.color.admin")) {
			return board.getTeam("BTeamAdmin");
		}
		if (forWhom.hasPermission("MBS.color.moderator")) {
			return board.getTeam("DTeamModerator");
		}
		if (forWhom.hasPermission("MBS.color.supporter")) {
			return board.getTeam("ETeamSupporter");
		}
		if (forWhom.hasPermission("MBS.color.teamfreund")) {
			return board.getTeam("FTeamFreund");
		}
		if (forWhom.hasPermission("MBS.color.ask")) {
			return board.getTeam("GTeamAsk");
		}
		if (forWhom.hasPermission("MBS.color.master")) {
			return board.getTeam("HTeamYT");
		}
		if (forWhom.hasPermission("MBS.color.elite")) {
			return board.getTeam("JTeamElite");
		}
		if (forWhom.hasPermission("MBS.color.vip")) {
			return board.getTeam("KTeamPro");
		}
		if (forWhom.hasPermission("MBS.color.youtuber")) {
			return board.getTeam("GTeamYt");
		}
		return null;

	}

	private Team searchTeamsForEntry(Player forWhom, String entry) {
		if (!this.playerScoreboards.containsKey(forWhom)) {
			createNewScoreboard(forWhom);
		}
		Scoreboard board = (Scoreboard) this.playerScoreboards.get(forWhom);
		for (Team team : board.getTeams()) {
			if (team.hasEntry(entry)) {
				return team;
			}
		}
		return null;
	}

	private void startSidebarUpdater() {
		new BukkitRunnable() {
			public void run() {
				ScoreboardManager.this.updateAllScoreboards(false, true);
			}
		}.runTaskTimer(Main.getInstance(), 120L, 120L);
	}

}
