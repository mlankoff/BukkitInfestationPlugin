package me.men8.infestation.world;

import me.men8.infestation.main.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockIgniteEvent;
import org.bukkit.event.block.BlockIgniteEvent.IgniteCause;

public class LightningNoFire implements Listener{
	
	public Main plugin;
	
	public LightningNoFire(Main plug){
		this.plugin = plug;
	}
	/**
	 * Stops crating fire from lightning
	 * @param e
	 */
	@EventHandler
	public void lightningNoFire(BlockIgniteEvent e){
		if(e.getCause().equals(IgniteCause.LIGHTNING)){
			e.setCancelled(true);
		}
	}

}
