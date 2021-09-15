package me.men8.infestation.money;

import me.men8.economy.main.Economy;
import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.permissions.Permissions;

import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class Money implements Listener{
	
	public Main plugin;
	
	
	public Money(Main plug){
		this.plugin = plug;
	}
	
	  /**
	   * Add money on monster kill
	   * @param event
	   */
	  @EventHandler
	    public void mobKill(EntityDeathEvent event){
	      Entity mob = event.getEntity();
	      
	      Entity killer = event.getEntity().getKiller();

	      if(killer instanceof Player){
	      	Player player = (Player)killer;
	      	if(!HashMaps.spawnedMobs.contains(event.getEntity().getUniqueId())){
	      		if(mob != null){
	      			double cash = 0.0D;
	      			if(mob instanceof Zombie || mob instanceof PigZombie){
	      				if(player.hasPermission(Permissions.doubleCoin)){
	      					if(player.hasPermission(Permissions.boost25)){
	      						cash = 2.5D;
	      					}else if(player.hasPermission(Permissions.boost50)){
	      						cash = 3.0D;
	      					}else if(player.hasPermission(Permissions.boost75)){
	      						cash = 3.5D;
	      					}else if(player.hasPermission(Permissions.boost25)||player.hasPermission(Permissions.boost50)){
	      						cash = 3.5D;
	      					}else if(player.hasPermission(Permissions.boost25)||player.hasPermission(Permissions.boost75)){
	      						cash = 4.0D;
	      					}else if(player.hasPermission(Permissions.boost50)||player.hasPermission(Permissions.boost75)){
	      						cash = 4.5D;
	      					}else if(player.hasPermission(Permissions.boost25)||player.hasPermission(Permissions.boost50)
	      							||player.hasPermission(Permissions.boost75)){
	      						cash = 5.0D;
	      					}else{
	      						cash = 2.0D;
	      					}
	      				}else{
	      					if(player.hasPermission(Permissions.boost25)){
	      						cash = 1.25D;
	      					}else if(player.hasPermission(Permissions.boost50)){
	      						cash = 1.50D;
	      					}else if(player.hasPermission(Permissions.boost75)){
	      						cash = 1.75D;
	      					}else if(player.hasPermission(Permissions.boost25)||player.hasPermission(Permissions.boost50)){
	      						cash = 1.75D;
	      					}else if(player.hasPermission(Permissions.boost25)||player.hasPermission(Permissions.boost75)){
	      						cash = 2.0D;
	      					}else if(player.hasPermission(Permissions.boost50)||player.hasPermission(Permissions.boost75)){
	      						cash = 2.25D;
	      					}else if(player.hasPermission(Permissions.boost25)||player.hasPermission(Permissions.boost50)
	      							||player.hasPermission(Permissions.boost75)){
	      						cash = 2.5D;
	      					}else{
	      						cash = 1.0D;
	      					}
	      				}
	      			}
	      			if (cash != 0.0D){
	      				Economy.increaseBalance(player, cash);
	      			}
	      		}
	      	}
	      }
	    }

}
