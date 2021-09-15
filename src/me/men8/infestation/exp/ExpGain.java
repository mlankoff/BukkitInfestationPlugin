package me.men8.infestation.exp;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.scoreboard.UpdateScoreboard;

import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class ExpGain implements Listener{
	
	Main plugin;
	
	public ExpGain(Main plug){
		this.plugin = plug;
	}
	/**
	 * gives exp from mobs
	 * @param e
	 */
	@EventHandler
	public static void expFromMobs(EntityDeathEvent e){
		Entity mob = e.getEntity();
	    Entity killer = e.getEntity().getKiller();
	    
	    if(killer instanceof Player){
	      	Player p = (Player)killer;
	      	if(!HashMaps.spawnedMobs.contains(e.getEntity().getUniqueId())){
	      		if(mob != null){
	      			if(mob instanceof Zombie || mob instanceof PigZombie){
	      					HashMaps.exp.put(p.getName(), HashMaps.exp.get(p.getName()) + (int) 5);
//	      					Main.player.set("Players." + p.getName() + "." + "ExpTotal"
//	      					, (int)Main.player.get("Players." + p.getName() + "." + "ExpTotal") + (int) 5);
	      			}else if(mob instanceof Player){
	      					HashMaps.exp.put(p.getName(), HashMaps.exp.get(p.getName()) + (int) 15);
//	      					Main.player.set("Players." + p.getName() + "." + "ExpTotal"
//	      					, (int)Main.player.get("Players." + p.getName() + "." + "ExpTotal") + (int) 15);
	      			}
//	      			Main.player.set("Players." + p.getName() + "." + "Exp", HashMaps.exp.get(p.getName()));
//	      			Main.player.saveConfig();
	      			UpdateScoreboard.updateScoreboard(p);
	      		}
	      	}
	    }

	}

}
