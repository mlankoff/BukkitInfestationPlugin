package me.men8.infestation.effects;

import java.text.DecimalFormat;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Materials;
import me.men8.infestation.scoreboard.UpdateScoreboard;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class Neutralizer implements Listener{
	
	public Main plugin;
	static DecimalFormat df = new DecimalFormat("#.##");
	
	public Neutralizer(Main plug){
		this.plugin = plug;
	}
	/**
	 * If player use neutralizer radiation goes down by 15 or 25 units
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void radioactiveNeutralizer(PlayerInteractEvent e){
		Player p = e.getPlayer();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR)||e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(HashMaps.radio.get(p.getName()) != (double) 0){
				if(p.getItemInHand().getType().equals(Materials.iodine_small)){
					Main.player.set("Players." + p.getName() + "." + "AntiRad", (int) Main.player.get("Players." + p.getName() + "." + "AntiRad") + (int) 1);
					if(HashMaps.radio.get(p.getName()) <= (double) 15){
						HashMaps.radio.put(p.getName(), (double) 0);
					}else{
						HashMaps.radio.put(p.getName(), (double) HashMaps.radio.get(p.getName()) - (double) 15);
					}
					UpdateScoreboard.updateScoreboard(p);
					final ItemStack itemStack = p.getItemInHand();
					final int amount = itemStack.getAmount();
					if (amount > 1) {
						itemStack.setAmount(amount - 1);
						p.setItemInHand(itemStack);
					}
				 
					if (amount == 1) {
						p.setItemInHand(null);
					}
					p.sendMessage(ChatColor.GREEN + "Your radiation level is decreased by 15 units.");
				}else if(p.getItemInHand().getType().equals(Materials.iodine_medium)){
					Main.player.set("Players." + p.getName() + "." + "AntiRad", (int) Main.player.get("Players." + p.getName() + "." + "AntiRad") + (int) 1);
					if(HashMaps.radio.get(p.getName()) <= (double) 25){
						HashMaps.radio.put(p.getName(), (double) 0);
					}else{
						HashMaps.radio.put(p.getName(), (double) HashMaps.radio.get(p.getName()) - (double) 25);
					}
					UpdateScoreboard.updateScoreboard(p);
					final ItemStack itemStack = p.getItemInHand();
					final int amount = itemStack.getAmount();
					if (amount > 1) {
						itemStack.setAmount(amount - 1);
						p.setItemInHand(itemStack);
					}
				 
					if (amount == 1) {
						p.setItemInHand(null);
					}
					p.sendMessage(ChatColor.GREEN + "Your radiation level is decreased by 25 units.");
				}
			}
			Main.player.set("Players." + p.getName() + "." + "Rads", HashMaps.radio.get(p.getName()));
			Main.player.saveConfig();
		}
	}

}
