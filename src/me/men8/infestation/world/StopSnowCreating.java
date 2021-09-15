package me.men8.infestation.world;

import me.men8.infestation.main.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;

public class StopSnowCreating implements Listener{
	
	Main plugin;
	
	public StopSnowCreating(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Cancel forming new snow
	 * @param e
	 */
	@EventHandler
	public void stopSnowCreating(BlockFormEvent e){
		e.setCancelled(true);
	}

}
