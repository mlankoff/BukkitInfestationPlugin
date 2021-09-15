package me.men8.infestation.menu;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.CustomItem;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Items;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class MagicMenu implements Listener{
	
	Main plugin;
	public static String magic_menu = "Magic Menu";
	
	public MagicMenu(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Create and open main menu on player head use
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void mainMenuOpen(PlayerInteractEvent e){
		Player p = e.getPlayer();
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR)||e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(p.getItemInHand().getType().equals(CustomItem.createPlayerHead(p).getType())){
				/////////////////////////////////////////////////////////////////////////////////////////////////////
				///[MAIN MENU]///////////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////////////////
				
				//create main menu
				HashMaps.magic_main_gui.put(p.getUniqueId(), Bukkit.createInventory(null, 54, magic_menu));
				//add items
				
				HashMaps.magic_main_gui.get(p.getUniqueId()).setItem(49, Items.lobbyMenu);
			}
		}
	}
	
	

}

