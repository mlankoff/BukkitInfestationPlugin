package me.men8.infestation.menu;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Items;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SkillsMainMenu{
	
	Main plugin;
	public static String skill_main_menu = "Skill Menu";
	
	public SkillsMainMenu(Main plug){
		this.plugin = plug;
	}
	
	public static void createSkillMenu(Player p){
		//create main menu
		HashMaps.skill_main_gui.put(p.getUniqueId(), Bukkit.createInventory(null, 18, skill_main_menu));
		//add items
		HashMaps.skill_main_gui.get(p.getUniqueId()).setItem(13, Items.lobbyMenu);
		
		HashMaps.skill_main_gui.get(p.getUniqueId()).setItem(1, Items.skillWeapons);
		HashMaps.skill_main_gui.get(p.getUniqueId()).setItem(3, Items.skillCrafting);
		HashMaps.skill_main_gui.get(p.getUniqueId()).setItem(5, Items.skillScavenging);
		HashMaps.skill_main_gui.get(p.getUniqueId()).setItem(7, Items.skillHealth);
	}
	
}
