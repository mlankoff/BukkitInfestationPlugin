package me.men8.infestation.zombie;

import me.men8.infestation.main.Main;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

public class VisibilityManager implements Listener{
	
	static Main plugin;
	static float visibility;
	static double blocks, distance;
	static Entity entity;
	
	@SuppressWarnings("static-access")
	public VisibilityManager(Main plug){
		this.plugin = plug;
	}
	
	@EventHandler
	public static void visibilityManager(EntityTargetLivingEntityEvent e){
		entity = e.getEntity();
		if(e.getTarget() instanceof Player){
			Player p = (Player) e.getTarget();
			visibility = p.getExp();
			if(visibility == 1f){
				blocks = 50;
			}else if(visibility == 0.75f){
				blocks = 37;
			}else if(visibility == 0.4f){
				blocks = 18;
			}else if(visibility == 0.15f){
				blocks = 8;
			}
			distance = entity.getLocation().distance(p.getLocation());
			if(distance > blocks){
				e.setCancelled(true);
			}
		}
				
		
	}

}
