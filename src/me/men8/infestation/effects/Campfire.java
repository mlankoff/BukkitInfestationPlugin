package me.men8.infestation.effects;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Materials;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Campfire implements Listener{
	
	public Main plugin;
	int time;
	
	public Campfire(Main plugin){
		this.plugin = plugin;
	}
	
	/**
	 * Creating fireplace for 3 minutes
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	@EventHandler
	public void setAndGatherFireplace(final PlayerInteractEvent e){
		final Player p = e.getPlayer();
		time = Main.config.getInt("Times." + "campfire_duration");
		ItemStack item1 = new ItemStack((Materials.fireplace),1);
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(p.getInventory().getItemInHand().getType().equals(Materials.fireplace)){
				if(!HashMaps.stop.get(p.getName()).equals(1)){
					final Location u2 = e.getClickedBlock().getLocation().add(0, 1, 0);

					if(u2.getBlock().getType().equals(Materials.air)){
						if(e.getClickedBlock() != p.getLocation().add(0, -1, 0)){
							if(e.getClickedBlock().getType()==Materials.dirt||e.getClickedBlock().getType()==Materials.grass
									||e.getClickedBlock().getType()==Materials.stone||e.getClickedBlock().getType()==Materials.sand){
								p.setItemInHand(null);
								Main.player.set("Players." + p.getName() + "." + "Campfire", (int) Main.player.get("Players." + p.getName() + "." + "Campfire") + (int) 1);
								u2.getBlock().setType(Materials.fire);
								HashMaps.stop.put(p.getName(), 1);
								if(HashMaps.stop.get(p.getName()) == (int)1){
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
										public void run(){
											u2.getBlock().setType(Materials.air);
											HashMaps.stop.put(p.getName(), 0);
										}
									}, time);
								}
							}
						}else{
							p.sendMessage(ChatColor.RED + "Sorry " + ChatColor.GOLD + p.getName() + ChatColor.RED + ", but you can't place campfire under your feets!");
						}
					}
				}else{
					p.sendMessage(ChatColor.RED + "Sorry " + ChatColor.GOLD + p.getName() + ChatColor.RED + ", but you can only place 1 campfire in " + ChatColor.GOLD + time + ChatColor.RED + " minute");
				}
			}
		}
		if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(e.getClickedBlock().getType().equals(Materials.log)||e.getClickedBlock().getType().equals(Materials.log2)){
				if(p.getInventory().contains(item1)){
					p.sendMessage(ChatColor.RED + "You have got enough wood " + ChatColor.GOLD + p.getName());
				}else{
			        p.getInventory().addItem(item1);
			    }
			}
		}
	}


}
