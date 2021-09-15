package me.men8.infestation.menu;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Items;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class AchievementsMenuHandler implements Listener{
	
	Main plugin;
	
	public AchievementsMenuHandler(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Achievements Menu Handler
	 * @param e
	 */
	@EventHandler
	public static void achievementMenuHandler(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getCurrentItem() == null){
			return;
		}else{
			if(e.getInventory().getName().equals(AchievementsMenu.achievements_menu1)){
				if(e.getCurrentItem().getDurability() == Items.nextPage.getDurability()){
					p.openInventory(HashMaps.achievements_gui2.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.lobbyMenu.getDurability()){
					p.openInventory(HashMaps.main_menu_gui.get(p.getUniqueId()));
				}
				e.setCancelled(true);
			}else if(e.getInventory().getName().equals(AchievementsMenu.achievements_menu2)){
				if(e.getCurrentItem().getDurability() == Items.previousPage.getDurability()){
					p.openInventory(HashMaps.achievements_gui1.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.lobbyMenu.getDurability()){
					p.openInventory(HashMaps.main_menu_gui.get(p.getUniqueId()));
				}
				e.setCancelled(true);
			}
		}
	}

}
