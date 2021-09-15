package me.men8.infestation.player;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;

import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillCounter implements Listener{
	
	Main plugin;
	
	public KillCounter(Main plug){
		this.plugin = plug;
	}
	/**
	 * Counts mobs and player kills
	 * @param e
	 */
	@EventHandler
	public static void killCounter(EntityDeathEvent e){
		Entity mob = e.getEntity();
	      Entity killer = e.getEntity().getKiller();
	      if(killer instanceof Player){
	      	Player p = (Player)killer;
	      	if(!HashMaps.spawnedMobs.contains(e.getEntity().getUniqueId())){
	      		if(mob != null){
	      			if(mob instanceof Zombie || mob instanceof PigZombie){
	      				HashMaps.mob_kill.put(p.getName(), HashMaps.mob_kill.get(p.getName()) + 1);
	      			}else if( mob instanceof Player){
	      				HashMaps.player_kill.put(p.getName(), HashMaps.player_kill.get(p.getName()) + 1);
	      			}
//	      			Main.player.set("Players." + p.getName() + "." + "MobsKilled", HashMaps.mob_kill.get(p.getName()));
//	      			Main.player.set("Players." + p.getName() + "." + "PlayersKilled", HashMaps.player_kill.get(p.getName()));
//	      			Main.player.saveConfig();
	      		}
	      	}
	      }
	}

}
