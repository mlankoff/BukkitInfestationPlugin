package me.men8.infestation.player;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.*;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Travel implements Listener{
	
	Main plugin;

	public Travel(Main plug){
		this.plugin = plug;
	}
	/**
	 * counts players distance
	 * @param e
	 */
	@EventHandler
	public static void blocksTravelled(PlayerMoveEvent e){
		Player p = e.getPlayer();
		
		if(e.getFrom().getBlockX() == e.getTo().getBlockX() && e.getFrom().getBlockY() == e.getTo().getBlockY() && e.getFrom().getBlockZ() == e.getTo().getBlockZ()){
			return;
		}
		HashMaps.travel.put(p.getName(), HashMaps.travel.get(p.getName()) + 1);
//		Main.player.set("Players." + p.getName() + "." + "Travelled", HashMaps.travel.get(p.getName()));
//		Main.player.saveConfig();
	}
	
	

}
