package me.men8.infestation.world;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class StopIceToWater implements Listener{
	
public Main plugin;
	
	public StopIceToWater(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Replace ICE to AIR on block brak
	 * @param e
	 */
	@EventHandler
	public void stopIceGather(BlockBreakEvent e){
		if(e.getBlock().getType().equals(Materials.ice)){
			e.getBlock().setType(Materials.air);
		}
	}

}
