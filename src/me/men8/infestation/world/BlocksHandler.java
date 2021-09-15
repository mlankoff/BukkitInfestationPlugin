package me.men8.infestation.world;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;
import me.men8.infestation.permissions.Permissions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlocksHandler implements Listener{
	
	Main plugin;
	
	public BlocksHandler(Main plug){
		this.plugin = plug;
	}
	
	@EventHandler
	public static void blockPlaceLimit(BlockPlaceEvent e){
		Player p = e.getPlayer();
		if(!p.hasPermission(Permissions.admin)){
			if(!e.getBlock().getType().equals(Materials.barbed_wire)){
				e.setCancelled(true);
			}
		}
	}

}
