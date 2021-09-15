package me.men8.infestation.survivalModules;

import java.util.ArrayList;
import java.util.List;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.scoreboard.UpdateScoreboard;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Survival{
	
	Main plugin;
	
	public Survival(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Check if player is in safe zone
	 * @param player
	 * @return
	 */
	public static boolean checkForSafeZone(Player player){
		boolean isSafe = false;
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
		Location loc;
		for(int i = 0; i <= 15; i++){
			loc = new Location(player.getWorld(), x, y - i, z);
			if(loc.getBlock().getType().equals(Material.SPONGE)){
				isSafe = true;
			}else{
				isSafe = false;
			}
		}
		return isSafe;
	}
	
	/**
	 * Return all block in radius
	 * @param location - center
	 * @param radius
	 * @return
	 */
	public static List<Block> getNearbyBlocks(Location location, int radius) {
        List<Block> blocks = new ArrayList<Block>();
        for(int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++) {
            for(int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++) {
                for(int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++) {
                   blocks.add(location.getWorld().getBlockAt(x, y, z));
                }
            }
        }
        return blocks;
    }
	
	/**
	 * Check if player is near fireplace
	 * @param player
	 * @param radius
	 * @param fireplace - fireplace material
	 * @return
	 */
	public static boolean checkForFire(Player player, int radius, Material fireplace) {
        boolean nearFire = false;
		Location loc = player.getLocation();
        for(Block b : getNearbyBlocks(loc, radius)) {
            if(b.getState().getType().equals(fireplace)){
            	nearFire = true;
            }else{
            	nearFire = false;
            }
        }
        return nearFire;
    }
	
	/**
	 * Check if player is in radioactive zone
	 * @param player
	 * @param low
	 * @param medium
	 * @param high
	 */
	public static void checkForRadiation(Player player, Material low, Material medium, Material high){
		int x = player.getLocation().getBlockX();
		int y = player.getLocation().getBlockY();
		int z = player.getLocation().getBlockZ();
//		double radiation = HashMaps.radio.get(player.getName());
		Location loc;
		for(int i = 0; i <= 15; i++){
			loc = new Location(player.getWorld(), x, y - i, z);
			if(loc.getBlock().getType().equals(low)){
//				HashMaps.rads.put(player.getName(), (int) 1);
			}else if(loc.getBlock().getType().equals(medium)){
//				HashMaps.rads.put(player.getName(), (int) 2);
			}else if(loc.getBlock().getType().equals(high)){
//				HashMaps.rads.put(player.getName(), (int) 3);
			}else{
//				HashMaps.rads.put(player.getName(), (int) 0);
			}
		}
//		if(radiation > (double) 70){
			player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, Integer.MAX_VALUE, 1));
//		}else{
			player.removePotionEffect(PotionEffectType.CONFUSION);
//		}
		UpdateScoreboard.updateScoreboard(player);
	}
	
	

}
