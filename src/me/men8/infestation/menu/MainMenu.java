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

public class MainMenu implements Listener{
	
	Main plugin;
	public static String main = "Main Menu";
	
	public MainMenu(Main plug){
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
				
				createMenu(p);
				
				/////////////////////////////////////////////////////////////////////////////////////////////////////
				///[OPEN MENU]///////////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////////////////				
				
				//open main inventory
				p.openInventory(HashMaps.main_menu_gui.get(p.getUniqueId()));
			}
		}
	}
	
	public static void createMenu(Player p){
		//create main menu
		HashMaps.main_menu_gui.put(p.getUniqueId(), Bukkit.createInventory(null, 9, main));
		//add items
		HashMaps.main_menu_gui.get(p.getUniqueId()).setItem(0, Items.quickCraftMenu);
		HashMaps.main_menu_gui.get(p.getUniqueId()).setItem(1, Items.skillsMenu);
		HashMaps.main_menu_gui.get(p.getUniqueId()).setItem(2, Items.magicMenu);
		HashMaps.main_menu_gui.get(p.getUniqueId()).setItem(3, Items.hatsMenu);
		HashMaps.main_menu_gui.get(p.getUniqueId()).setItem(4, Items.achievementsMenu);
		HashMaps.main_menu_gui.get(p.getUniqueId()).setItem(6, Items.optionsMenu);
		HashMaps.main_menu_gui.get(p.getUniqueId()).setItem(8, Items.lobbyMenu);
		
		SkillWeaponsMenu.createSkillMenu(p);
		SkillCraftingMenu.createSkillMenu(p);
		SkillScavengingMenu.createSkillMenu(p);
		SkillHealthMenu.createSkillMenu(p);
	}

}
