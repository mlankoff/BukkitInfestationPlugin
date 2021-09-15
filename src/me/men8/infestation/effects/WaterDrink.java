package me.men8.infestation.effects;

import java.text.DecimalFormat;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Materials;
import me.men8.infestation.scoreboard.UpdateScoreboard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class WaterDrink implements Listener{
	
	public Main plugin;
	public static DecimalFormat df = new DecimalFormat("#.##");
	
	public WaterDrink(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Set full ExpBar if player drink water from water bottle
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onDrinkWater(PlayerItemConsumeEvent e){
		Player p = e.getPlayer();
		if(p.getInventory().getItemInHand().getType().equals(Materials.water_bottle)&& (e.getItem().getDurability() == 0)){
			HashMaps.thirst.put(p.getName(), (double)100);
			Main.player.set("Players." + p.getName() + "." + "Thirst", HashMaps.thirst.get(p.getName()));
			UpdateScoreboard.updateScoreboard(p);
		}	
	}
}
