package nl.nielsha.plugins.scoreboard;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;



public class Example extends JavaPlugin implements Listener {
	private Map<String, Scoreboard> playerScoreboards = new HashMap<String, Scoreboard>();
	private String title;

	public Example(){
		this.title = ChatColor.translateAlternateColorCodes('&', "&bTitle hiero");
	}

	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@SuppressWarnings("deprecation")
	public void register(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();

		final Scoreboard board = manager.getNewScoreboard();
		final Objective o;

		o = board.registerNewObjective((title.length() > 16 ? title.substring(0, 15) : title), "dummy");
		o.setDisplaySlot(DisplaySlot.SIDEBAR);
		o.setDisplayName("Migas Gayy");

		Score money = o.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Money"));
		money.setScore(5);

		playerScoreboards.put(player.getName(), board);
		player.setScoreboard(board);

	}

	public void unregister(Player player) {
		playerScoreboards.remove(player.getName());
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
		register(p);
	}
}