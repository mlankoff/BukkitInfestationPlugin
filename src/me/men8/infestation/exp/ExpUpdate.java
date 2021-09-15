package me.men8.infestation.exp;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.scoreboard.*;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class ExpUpdate {
	
	Main plugin;
	
	public ExpUpdate(Main plug){
		this.plugin = plug;
	}
	/**
	 * updates exp score i scoreboard
	 */
	public static void expCheck(){
		for(World w : Bukkit.getWorlds()){
			for(Player p : w.getPlayers()){
				if(w.getPlayers() != null){
					Main.player.set("Players." + p.getName() + "." + "Exp", HashMaps.exp.get(p.getName()));
					Main.player.saveConfig();
					UpdateScoreboard.updateScoreboard(p);
				}
			}
		}
	}

}
