package me.men8.infestation.world;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class ArmorCreate implements Listener{
	
	public Main plugin;
	
	public ArmorCreate(Main plug){
		this.plugin = plug;
	}
	/**
	 * Creates leggings and boots specific to chestplate
	 * @param e
	 */
	@EventHandler
	public void armorCreate(InventoryClickEvent e){
		final Player p = (Player) e.getWhoClicked();
		Material cursor = e.getCursor().getType();
		ItemStack m = e.getCurrentItem();
		if(m != null){
		//Disable shift click
			if(e.isShiftClick()){
				if(m.getType().equals(Materials.lch)||m.getType().equals(Materials.ich)
						||m.getType().equals(Materials.gch)||m.getType().equals(Materials.dch)){
					e.setCancelled(true);
				}
			}
		}
		if(e.getSlotType() != null){
			if(e.getSlotType().equals(InventoryType.SlotType.ARMOR)){
				if(e.getSlot() == (int) 38){
					if(cursor.equals(Materials.lch)){
						p.getInventory().setLeggings(new ItemStack(Materials.ll));
						p.getInventory().setBoots(new ItemStack(Materials.lb));
					}else if(cursor.equals(Materials.ich)){
						p.getInventory().setLeggings(new ItemStack(Materials.il));
						p.getInventory().setBoots(new ItemStack(Materials.ib));
					}else if(cursor.equals(Materials.gch)){
						p.getInventory().setLeggings(new ItemStack(Materials.gl));
						p.getInventory().setBoots(new ItemStack(Materials.gb));
					}else if(cursor.equals(Materials.dch)){
						p.getInventory().setLeggings(new ItemStack(Materials.dl));
						p.getInventory().setBoots(new ItemStack(Materials.db));
					}else{
						p.getInventory().setLeggings(new ItemStack(Materials.air));
						p.getInventory().setBoots(new ItemStack(Materials.air));
					}
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
						public void run(){
							p.updateInventory();
						}
					}, (long) 2);
				}
				if(e.getSlot() == (int) 36){
					e.setCancelled(true);
				}
				if(e.getSlot() == (int) 37){
					e.setCancelled(true);
				}
			}
		}
	}
}
