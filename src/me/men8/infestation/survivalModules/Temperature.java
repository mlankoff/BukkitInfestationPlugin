package me.men8.infestation.survivalModules;

import java.text.DecimalFormat;

import me.men8.infestation.permissions.Permissions;
import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.scoreboard.UpdateScoreboard;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;

public class Temperature {
	
	public Main plugin;
	public static DecimalFormat df = new DecimalFormat("#.##");
	public static Material fireplace = Material.BEACON; //TODO zmienic na jakies inne fireplace
	
	
	public Temperature(Main plug){
		this.plugin = plug;
	}
	
	
	/**
	 * temperature module
	 */
	public static void temperature(){
		for(World w : Bukkit.getWorlds()){
			for(Player p : w.getPlayers()){
				if(w.getPlayers() != null){
					double temperature = HashMaps.temp.get(p.getName());
					if(Survival.checkForSafeZone(p) != true){
						if(Survival.checkForFire(p, 3, fireplace) == false){
							if(p.hasPermission(Permissions.temperatureLvl5)){
								if(p.getInventory().getChestplate() == null){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.41);
								}else if(p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.37);
								}else if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.33);
								}else if(p.getInventory().getChestplate().getType() == Material.GOLD_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.37);
								}else if(p.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.33);
								}else if(p.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.3);
								}
							}else if(p.hasPermission(Permissions.temperatureLvl4)){
								if(p.getInventory().getChestplate() == null){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.47);
								}else if(p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.41);
								}else if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.37);
								}else if(p.getInventory().getChestplate().getType() == Material.GOLD_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.41);
								}else if(p.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.37);
								}else if(p.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.33);
								}
							}else if(p.hasPermission(Permissions.temperatureLvl3)){
								if(p.getInventory().getChestplate() == null){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.55);
								}else if(p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.47);
								}else if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.41);
								}else if(p.getInventory().getChestplate().getType() == Material.GOLD_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.46);
								}else if(p.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.41);
								}else if(p.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.37);
								}
							}else if(p.hasPermission(Permissions.temperatureLvl2)){
								if(p.getInventory().getChestplate() == null){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.66);
								}else if(p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.55);
								}else if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.47);
								}else if(p.getInventory().getChestplate().getType() == Material.GOLD_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.52);
								}else if(p.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.47);
								}else if(p.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.41);
								}
							}else if(p.hasPermission(Permissions.temperatureLvl1)){
								if(p.getInventory().getChestplate() == null){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.83);
								}else if(p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.66);
								}else if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.55);
								}else if(p.getInventory().getChestplate().getType() == Material.GOLD_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.59);
								}else if(p.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.55);
								}else if(p.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE){
									HashMaps.temp.put(p.getName(), temperature - (double) 0.47);
								}
							}
							/**
							 * Slowly kill Player if HashMaps.temperature is 0
							 */
							Damageable dp = (Damageable)p;
							if(temperature <= (double) 1.0){
								HashMaps.temp.put(p.getName(), (double)0.0);
								p.setHealth(dp.getHealth() - (double) 1);
							}
						}else{
							if(p.getInventory().getChestplate() == null){
								HashMaps.temp.put(p.getName(), temperature + (double) 5.55);
							}else if(p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE){
								HashMaps.temp.put(p.getName(), temperature + (double) 6.66);
							}else if(p.getInventory().getChestplate().getType() == Material.CHAINMAIL_CHESTPLATE){
								HashMaps.temp.put(p.getName(), temperature + (double) 8.33);
							}else if(p.getInventory().getChestplate().getType() == Material.GOLD_CHESTPLATE){
								HashMaps.temp.put(p.getName(), temperature + (double) 7.57);
							}else if(p.getInventory().getChestplate().getType() == Material.IRON_CHESTPLATE){
								HashMaps.temp.put(p.getName(), temperature + (double) 8.33);
							}else if(p.getInventory().getChestplate().getType() == Material.DIAMOND_CHESTPLATE){
								HashMaps.temp.put(p.getName(), temperature + (double) 11.11);
							}
							if(temperature >= (double) 99){
								HashMaps.temp.put(p.getName(), (double)100.0);
							}
						}
					}
//					Main.player.set("Players." + p.getName() + "." + "Temperature", HashMaps.temp.get(p.getName()));
//					Main.player.saveConfig();
					UpdateScoreboard.updateScoreboard(p);
				}
			}
		}
	}
}