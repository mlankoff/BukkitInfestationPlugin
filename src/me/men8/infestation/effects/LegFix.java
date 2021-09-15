package me.men8.infestation.effects;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Materials;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffectType;

public class LegFix implements Listener{
	
	public Main plugin;
	
	public LegFix(Main plug){
		this.plugin = plug;
	}
	/**
	 * fix players broken leg
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onInteract(PlayerInteractEvent e){
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR)||e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			Player p = e.getPlayer();
			if(p.getInventory().getItemInHand().getType().equals(Materials.stiffener)){
				if(p.hasPotionEffect(PotionEffectType.SLOW)){
					final ItemStack itemStack = p.getItemInHand();
					final int amount = itemStack.getAmount();
					if (amount > 1) {
					itemStack.setAmount(amount - 1);
					p.setItemInHand(itemStack);
					}
					 
					if (amount == 1) {
					p.setItemInHand(null);
					}
					p.removePotionEffect(PotionEffectType.SLOW);
					HashMaps.break_leg.put(p.getName(), HashMaps.break_leg.get(p.getName()) + 1);
					Main.player.set("Players." + p.getName() + "." + "BreakeLeg", HashMaps.break_leg.get(p.getName()));
					Main.player.saveConfig();
				}else{
					p.sendMessage(ChatColor.YELLOW + "There is no need to use that");
				}
			}
		}
	}

}
