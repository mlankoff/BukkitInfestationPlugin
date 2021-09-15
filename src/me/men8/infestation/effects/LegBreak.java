package me.men8.infestation.effects;

import java.util.Random;

import me.men8.infestation.main.Main;
import me.men8.infestation.permissions.Permissions;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class LegBreak implements Listener{
	
	public Main plugin;
	Random rand = new Random();
	
	public LegBreak(Main plug){
		this.plugin = plug;
	}
	/**
	 * breaks player leg on fall
	 * @param e
	 */
	@EventHandler
	public void onMove(PlayerMoveEvent e){
		
		Player p = e.getPlayer();
		//only looking for y change
		if(e.getFrom().getBlockY() == e.getTo().getBlockY()){
			return;
		}
		//if fall distance is bigger than 6
		if(p.getFallDistance()>=6){
			if(p.hasPermission(Permissions.agilityLvl1)){
				int number = rand.nextInt(100) + 1;
				if(number >= 60)//40% chance to break the leg
				{
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,1));
				}
			}else if(p.hasPermission(Permissions.agilityLvl2)){
				int number = rand.nextInt(100) + 1;
				if(number >= 65)//35% chance to break the leg
				{
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,1));
				}
			}else if(p.hasPermission(Permissions.agilityLvl3)){
				int number = rand.nextInt(100) + 1;
				if(number >= 70)//30% chance to break the leg
				{
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,1));
				}
			}else if(p.hasPermission(Permissions.agilityLvl4)){
				int number = rand.nextInt(100) + 1;
				if(number >= 75)//25% chance to break the leg
				{
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,1));
				}
			}else if(p.hasPermission(Permissions.agilityLvl5)){
				int number = rand.nextInt(100) + 1;
				if(number >= 80)//20% chance to break the leg
				{
					p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,1));
				}
			}
			
		}
	}

}
