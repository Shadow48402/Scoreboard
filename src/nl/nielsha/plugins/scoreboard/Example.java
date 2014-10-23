package nl.nielsha.plugins.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Example extends JavaPlugin implements Listener{
	
	/**
	 * Updated by Niels Hamelink
	 * @author Niels Hamelink
	 */
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void event(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		SimpleScoreboard scoreboard = new SimpleScoreboard("§a§lFeatures:"); // create a new scoreboard with title
		
		scoreboard.add("§lCustom scores ->", 1337); // text with custom score
		scoreboard.blankLine();                     // also supports blank lines (up to 23 of them!)
		scoreboard.add("§cBLANK LINES");
		scoreboard.blankLine();                     // if you dont specify a score it will display them in the order you add them in
		scoreboard.add("lines");
		scoreboard.add("§bin");
		scoreboard.add("§edescending");
		scoreboard.add("§2order");
		scoreboard.add(":)");
		scoreboard.blankLine();
		scoreboard.add("and long lines with up to §l48 characters"); // the text can be up to 48 characters long (including color codes)
		scoreboard.build(); // call this to create the scoreboard, nothing will happen if you forget to call this
		scoreboard.send(player); // send the scoreboard to the player(s), takes an array
	}
}