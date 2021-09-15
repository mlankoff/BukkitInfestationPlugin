package me.men8.infestation.menu;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.CustomItem;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Items;
import me.men8.infestation.permissions.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SkillWeaponsMenu{
	
	Main plugin;
	public static String skill_weapons_menu = "Weapons Skill Menu";
	
	public SkillWeaponsMenu(Main plug){
		this.plugin = plug;
	}
	
	public static void createSkillMenu(Player p){
		String expString = String.valueOf(HashMaps.exp.get(p.getName()));
		
		//create main menu
		HashMaps.skill_weapons_gui.put(p.getUniqueId(), Bukkit.createInventory(null, 45, skill_weapons_menu));
		//add items
		HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(40, Items.lobbyMenu);
		
		//TODO pistols skill
		HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(11, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Pistols", expString, "3000", Permissions.pistolLvl0, "Enables crafting", "pistol parts"));
					
		if(p.hasPermission(Permissions.pistolLvl1)){
			HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(11, CustomItem.createActiveItem(Items.unlockedSkill, "Pistols", "Enables crafting", "pistol parts"));
		}
				
		//TODO rifles skill
		HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(13, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Rifles", expString, "3000", Permissions.rifleLvl0, "Enables crafting", "rifle parts"));
					
		if(p.hasPermission(Permissions.rifleLvl1)){
			HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(13, CustomItem.createActiveItem(Items.unlockedSkill, "Rifles", "Enables crafting", "rifle parts"));
		}
						
		//TODO shotguns skill
		HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(15, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Shotguns", expString, "3000", Permissions.shotgunLvl0, "Enables crafting", "shotgun parts"));
				
		if(p.hasPermission(Permissions.shotgunLvl1)){
			HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(15, CustomItem.createActiveItem(Items.unlockedSkill, "Shotguns", "Enables crafting", "shotgun parts"));
		}
		
		//TODO archery skill
		HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(20, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Archery", expString, "3000", Permissions.archeryLvl0, "Enables crafting", "bows and crossbows"));
		
		if(p.hasPermission(Permissions.archeryLvl1)){
			HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(20, CustomItem.createActiveItem(Items.unlockedSkill, "Archery", "Enables crafting", "bows and crossbows"));
		}
		
		//TODO blade weapons skill
		HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(22, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Blade Weapons", expString, "3000", Permissions.bladeLvl0, "Enables crafting knives"));
		
		if(p.hasPermission(Permissions.bladeLvl1)){
			HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(22, CustomItem.createActiveItem(Items.unlockedSkill, "Blade Weapons", "Enables crafting knives"));
		}
		
		//TODO blunt weapons skill
		HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(24, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Blunt Weapons", expString, "3000", Permissions.bluntLvl0, "Enables crafting", "blunt weapons"));
		
		if(p.hasPermission(Permissions.bluntLvl1)){
			HashMaps.skill_weapons_gui.get(p.getUniqueId()).setItem(24, CustomItem.createActiveItem(Items.unlockedSkill, "Blunt Weapons", "Enables crafting", "blunt weapons"));
		}
	}
	
}