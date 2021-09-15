package me.men8.infestation.world;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class DisablePickUp implements Listener{
	
	public Main plugin;
	
	public DisablePickUp(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Method for disabling pickup fireplace if player got one
	 * @param e
	 */
	@EventHandler
	public void disableFireplacePickup(PlayerPickupItemEvent e){
		Player p = e.getPlayer();
		if(e.getItem().getItemStack().getType().equals(Materials.fireplace)){
			if(p.getInventory().contains(Materials.fireplace)){
				e.setCancelled(true);
			}
		}else{}
	}

}
