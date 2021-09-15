package me.men8.infestation.world;

import me.men8.infestation.main.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent.RegainReason;

public class StopHealthRegain implements Listener{
	
	public Main plugin;
	
	public StopHealthRegain(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Cancel health regeneration if player's food bar is full
	 * @param e
	 */
	@EventHandler
	public void onHealthRegen(EntityRegainHealthEvent e){
		if(e.getRegainReason().equals(RegainReason.SATIATED)){
			e.setCancelled(true);
		}
	}

}
