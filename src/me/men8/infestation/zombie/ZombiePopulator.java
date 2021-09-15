package me.men8.infestation.zombie;

import me.men8.infestation.main.Main;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;

public class ZombiePopulator implements Listener{
	
	Main plugin;
	
	public ZombiePopulator(Main plug){
		this.plugin = plug;
	}
	
	@EventHandler
	public static void zombiePopulator(CreatureSpawnEvent e){
		EntityType ent = e.getEntityType();
		if(e.getSpawnReason().equals(SpawnReason.NATURAL)){
			if(ent.equals(EntityType.ZOMBIE)){
				e.getEntity().getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
				e.getEntity().getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
				e.getEntity().getWorld().spawnEntity(e.getLocation(), EntityType.ZOMBIE);
			}
		}
	}

}
