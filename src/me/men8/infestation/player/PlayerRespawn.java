package me.men8.infestation.player;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.CustomItem;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Items;
import me.men8.infestation.misc.Materials;
import me.men8.infestation.permissions.Permissions;
import me.men8.infestation.scoreboard.UpdateScoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerRespawn implements Listener{

	static Main plugin;
	
	@SuppressWarnings("static-access")
	public PlayerRespawn(Main plug){
		this.plugin = plug;
	}
	
	@EventHandler
	public static void playerRespawn(PlayerRespawnEvent e){
		//declare player
		Player p = e.getPlayer();
		
		//sets player inventory
		if(p.hasPermission(Permissions.strengthLvl1) && !p.hasPermission(Permissions.strengthLvl2)){
			for(int i = 9 ; i <= 31 ; i++){
				p.getInventory().setItem(i, Items.blocked);
			}
		}
		if(p.hasPermission(Permissions.scavengingLvl2) && !p.hasPermission(Permissions.scavengingLvl3)){
			for(int i = 9 ; i <= 26 ; i++){
				p.getInventory().setItem(i, Items.blocked);
			}
		}
		if(p.hasPermission(Permissions.scavengingLvl3) && !p.hasPermission(Permissions.scavengingLvl4)){
			for(int i = 9 ; i <= 20 ; i++){
				p.getInventory().setItem(i, Items.blocked);
			}
		}
		if(p.hasPermission(Permissions.scavengingLvl4) && !p.hasPermission(Permissions.scavengingLvl5)){
			for(int i = 9 ; i <= 13 ; i++){
				p.getInventory().setItem(i, Items.blocked);
			}
		}
		
		//add player to death location hashmap
		HashMaps.death.put(p.getUniqueId(), p.getLocation());
		
		//give items
		p.getInventory().setItem(0, new ItemStack(Materials.arrow, 1, (short)0));
		p.getInventory().setItem(1, new ItemStack(Materials.cow_meat, 4, (short)0));
		p.getInventory().setItem(2, new ItemStack(Materials.bandage, 4, (short)0));
		p.getInventory().setItem(3, new ItemStack(Materials.lch, 1, (short)0));
		p.getInventory().setItem(7, new ItemStack(Materials.water_bottle, 1, (short)0));
		p.getInventory().setItem(8, new ItemStack(CustomItem.createPlayerHead(p)));
		p.updateInventory();
		//thirst
		HashMaps.thirst.put(p.getName(), (double)100);
//		Main.player.set("Players." + p.getName() + "." + "Thirst", HashMaps.thirst.get(p.getName()));
//		Main.player.saveConfig();
		//temperature
		HashMaps.temp.put(p.getName(), (double)100);
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
			public void run(){
				UpdateScoreboard.updateScoreboard(p);
			}
		}, 20L);
		
	}
	
}
