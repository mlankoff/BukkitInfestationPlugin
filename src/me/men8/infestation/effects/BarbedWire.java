package me.men8.infestation.effects;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BarbedWire implements Listener{
	
	public Main plugin;
	int time;
	
	public BarbedWire(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Create Barbed wire for 3 minutes
	 * @param e
	 */
	@EventHandler
	public void barbedWire(final BlockPlaceEvent e){
		Player p = e.getPlayer();
		time = Main.config.getInt("Times." + "barbed_wire_duration");
		if(e.getBlock().getType().equals(Materials.barbed_wire)){
			Main.player.set("Players." + p.getName() + "." + "BarbedWire", (int) Main.player.getInt("Players." + p.getName() + "." + "BarbedWire") + (int) 1);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
				public void run(){
					e.getBlockPlaced().setType(Materials.air);
				}
			}, time);
		}else{}
	}


}
