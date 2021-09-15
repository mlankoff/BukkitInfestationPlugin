package me.men8.infestation.effects;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.*;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MedPack implements Listener{
	
	public Main plugin;
	int time;
	
	public MedPack(Main plugin){
		this.plugin = plugin;
	}
	
	/**
	 * Use bandage to stop bleeding
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	@EventHandler
	public void bandage(PlayerInteractEvent e){
		Player p = e.getPlayer();
		time = Main.config.getInt("Times." + "medpack_duration");
		if(p.getInventory().getItemInHand().getType().equals(Materials.bandage)){
			if(p.hasPotionEffect(PotionEffectType.POISON)||(!p.hasPotionEffect(PotionEffectType.REGENERATION)
					&&p.getHealth() < 20)){
				final ItemStack itemStack = p.getItemInHand();
				final int amount = itemStack.getAmount();
				if (amount > 1) {
				itemStack.setAmount(amount - 1);
				p.setItemInHand(itemStack);
				}
				 
				if (amount == 1) {
				p.setItemInHand(null);
				}
				p.removePotionEffect(PotionEffectType.POISON);
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, time, 1));
				HashMaps.bandage_use.put(p.getName(), HashMaps.bandage_use.get(p.getName()) + 1);
				Main.player.set("Players." + p.getName() + "." + "BandagesUsed", HashMaps.bandage_use.get(p.getName()));
				Main.player.saveConfig();
			}else{
				p.sendMessage(ChatColor.RED + "There is no need to use that");
			}
		}
	}
}
