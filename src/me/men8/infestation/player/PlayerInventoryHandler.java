package me.men8.infestation.player;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.CustomItem;
import me.men8.infestation.permissions.Permissions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class PlayerInventoryHandler implements Listener{
	
	Main plugin;
	/**
	 * blocks player inventory
	 * @param plug
	 */
	public PlayerInventoryHandler(Main plug){
		this.plugin = plug;
	}
	
	@EventHandler
	public static void playerInventoryHandler(InventoryClickEvent e){
		ItemStack m = e.getCurrentItem();
		Player p = (Player) e.getWhoClicked();
		if(m != null){
		//Disable shift click
			if(e.isShiftClick()){
				if(m.getType().equals(CustomItem.createPlayerHead(p))){
					e.setCancelled(true);
				}
			}
			if(e.getSlot() == (int) 8){
				e.setCancelled(true);
			}
			if( !p.hasPermission(Permissions.strengthLvl2) &&p.hasPermission(Permissions.strengthLvl1)){
				for(int i = 9 ; i <= 31 ; i++){
					if(e.getSlot() == (int) i){
						e.setCancelled(true);
					}
				}
			}
			if(p.hasPermission(Permissions.strengthLvl2) && !p.hasPermission(Permissions.strengthLvl3)){
				for(int i = 9 ; i <= 26 ; i++){
					if(e.getSlot() == (int) i){
						e.setCancelled(true);
					}
				}
			}
			if(p.hasPermission(Permissions.strengthLvl3) && !p.hasPermission(Permissions.strengthLvl4)){
				for(int i = 9 ; i <= 20 ; i++){
					if(e.getSlot() == (int) i){
						e.setCancelled(true);
					}
				}
			}
			if(p.hasPermission(Permissions.strengthLvl4) && !p.hasPermission(Permissions.strengthLvl5)){
				for(int i = 9 ; i <= 13 ; i++){
					if(e.getSlot() == (int) i){
						e.setCancelled(true);
					}
				}
			}
		}
	}
	
	
	
	@EventHandler
	public void onItemDrop(PlayerDropItemEvent e){
		Player p = e.getPlayer();
		PlayerInventory playerInventory = p.getInventory();
	 
		if(playerInventory.getHeldItemSlot() == 8){
			ItemStack item = e.getItemDrop().getItemStack().clone();
			e.getItemDrop().remove();
			p.getInventory().setItem(8, item);
		}
	}

}
