package me.men8.infestation.world;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFadeEvent;

public class StopSnowMelting implements Listener{
	
	public Main plugin;
	
	public StopSnowMelting(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Cancel block fade if block is ICE, SNOW or SNOW_PANEL
	 * @param e
	 */
	@EventHandler
	public void stopSnowMelting(BlockFadeEvent e){
		Material b = e.getBlock().getType();
		if (b.equals(Materials.ice)||b.equals(Materials.snow)||b.equals(Materials.snowb)){
			e.setCancelled(true);
		}
	}

}
