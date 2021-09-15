package me.men8.infestation.world;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DisableDrop implements Listener{

	Main plugin;
	
	public DisableDrop(Main plug){
		this.plugin = plug;
	}
	
	@EventHandler
	public static void disableItemDrop(PlayerDropItemEvent e){
		if(e.getItemDrop().getType().equals(Materials.openMainMenu)){
			e.setCancelled(true);
		}
	}
}
