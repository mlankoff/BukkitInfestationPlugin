package me.men8.infestation.world;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class SlowOnSnow implements Listener{
	
	public Main plugin;
	
	public SlowOnSnow(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Method that slows down player on snow_panel or snow
	 * @param e
	 */
	@EventHandler
	public void snowWalkSpeed(PlayerMoveEvent e){
		Player p = e.getPlayer();
		World w = p.getWorld();
		double x = p.getLocation().getX();
		double y = p.getLocation().getY();
		double z = p.getLocation().getZ();
		Location loc1 = new Location(w,x,y,z);
		Location loc2 = new Location(w,x,y-1,z);
		Material ch1 = loc1.getBlock().getType();
		Material ch2 = loc2.getBlock().getType();
		if(ch1.equals(Materials.snowb)||ch1.equals(Materials.snow)||ch2.equals(Materials.snowb)||ch2.equals(Materials.snow)){
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, Integer.MAX_VALUE, 1));
		}else{
			p.removePotionEffect(PotionEffectType.SLOW);
		}
	}

}
