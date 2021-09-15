package me.men8.infestation.entity;

import me.men8.infestation.main.Main;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class MobHandler implements Listener{

	Main plugin;
	
	public MobHandler(Main plug){
		this.plugin = plug;
	}
	
	@EventHandler
	public static void mobSpawnLimit(CreatureSpawnEvent e){
		if(e.getSpawnReason().equals(SpawnReason.NATURAL)){
			EntityType mob = e.getEntityType();
			if(!mob.equals(EntityType.ZOMBIE)){
				e.getEntity().remove();
				e.setCancelled(true);
			}
		}
	}
	
}
