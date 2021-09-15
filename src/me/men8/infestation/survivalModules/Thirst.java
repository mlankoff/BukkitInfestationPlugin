package me.men8.infestation.survivalModules;

import java.text.DecimalFormat;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.permissions.Permissions;
import me.men8.infestation.scoreboard.UpdateScoreboard;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;

public class Thirst {
	
	public static Main plugin;
	public static DecimalFormat df = new DecimalFormat("#.##");

	
	public Thirst(Main plug){
		Thirst.plugin = plug;
	}
	/**
	 * thirst module
	 */
	public static void thirst(){
		for(World w : Bukkit.getWorlds()){
			for(final Player p : w.getPlayers()){
				if(w.getPlayers()!=null){
					Damageable dplayer = (Damageable)p;
					double thirst = HashMaps.thirst.get(p.getName());
					if(Survival.checkForSafeZone(p) == false){
						if(p.isSprinting() == true){
							if(p.hasPermission(Permissions.thirstLvl5)){
								HashMaps.thirst.put(p.getName(), thirst - (double)0.55);
							}else if(p.hasPermission(Permissions.thirstLvl4)){
								HashMaps.thirst.put(p.getName(), thirst - (double)0.6);
							}else if(p.hasPermission(Permissions.thirstLvl3)){
								HashMaps.thirst.put(p.getName(), thirst - (double)0.66);
							}else if(p.hasPermission(Permissions.thirstLvl2)){
								HashMaps.thirst.put(p.getName(), thirst - (double)0.74);
							}else if(p.hasPermission(Permissions.thirstLvl1)){
								HashMaps.thirst.put(p.getName(), thirst - (double)0.83);
							}
						}else{
							if(p.hasPermission(Permissions.thirstLvl5)){
								HashMaps.thirst.put(p.getName(), thirst - (double)0.27);
							}else if(p.hasPermission(Permissions.thirstLvl4)){
								HashMaps.thirst.put(p.getName(), thirst - (double)0.3);
							}else if(p.hasPermission(Permissions.thirstLvl3)){
								HashMaps.thirst.put(p.getName(), thirst - (double)0.33);
							}else if(p.hasPermission(Permissions.thirstLvl2)){
								HashMaps.thirst.put(p.getName(), thirst - (double)0.37);
							}else if(p.hasPermission(Permissions.thirstLvl1)){
								HashMaps.thirst.put(p.getName(), thirst - (double)0.41);
							}
						}
					}
					if(thirst <= (double) 1.0){
						HashMaps.thirst.put(p.getName(), (double) 0.0);
						p.setHealth(dplayer.getHealth() - (double) 1);
					}
//					Main.player.set("Players." + p.getName() + "." + "Thirst", HashMaps.thirst.get(p.getName()));
//					Main.player.saveConfig();
					UpdateScoreboard.updateScoreboard(p);
					
				}
			}
		}
	}
}


