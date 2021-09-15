package me.men8.infestation.world;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class CampfireLimit implements Listener{
	
	public Main plugin;
	
	public CampfireLimit(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Method for preventing player to share fireplace via containers
	 * @param e
	 */
	@EventHandler(ignoreCancelled = true)
    public void disableFireplaceShare(InventoryClickEvent e) {
        ItemStack item = e.getCurrentItem();
        if(item != null && (item.getType().equals(Materials.fireplace))){
            if(!(e.getInventory().getHolder() instanceof Player)){
                e.setCancelled(true);
            }
        }
    }
	

}
