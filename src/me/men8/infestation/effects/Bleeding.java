package me.men8.infestation.effects;

import java.util.Random;

import me.men8.infestation.main.Main;
import me.men8.infestation.permissions.Permissions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Bleeding implements Listener{
	
	public Main plugin;
	Random rand = new Random();
	
	public Bleeding(Main plugin){
		this.plugin = plugin;
	}
	
	/**
	 * Start bleeding when hit with percentage chance
	 * @param e
	 */
	@EventHandler
	public void bleeding(EntityDamageByEntityEvent e){
		if(e.getEntity() instanceof Player){
			Player p = (Player)e.getEntity();
			int number = rand.nextInt(100) + 1;
			if(p.hasPermission(Permissions.hardSkinLvl1)){
				if(number >= 60){//40% chance to start bleeding
					p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Integer.MAX_VALUE, 0));
				}
			}else if(p.hasPermission(Permissions.hardSkinLvl2)){
				if(number >= 65){//35% chance to start bleeding
					p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Integer.MAX_VALUE, 0));
				}
			}else if(p.hasPermission(Permissions.hardSkinLvl3)){
				if(number >= 70){//30% chance to start bleeding
					p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Integer.MAX_VALUE, 0));
				}
			}else if(p.hasPermission(Permissions.hardSkinLvl4)){
				if(number >= 75){//25% chance to start bleeding
					p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Integer.MAX_VALUE, 0));
				}
			}else if(p.hasPermission(Permissions.hardSkinLvl5)){
				if(number >= 80){//20% chance to start bleeding
					p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, Integer.MAX_VALUE, 0));
				}
			}
			
		}
	}

}
