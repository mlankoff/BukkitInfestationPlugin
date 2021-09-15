package me.men8.infestation.menu;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.CustomItem;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Items;
import me.men8.infestation.permissions.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SkillCraftingMenu{
	
	Main plugin;
	public static String skill_crafting_menu = "Crafting Skill Menu";
	
	public SkillCraftingMenu(Main plug){
		this.plugin = plug;
	}
	
	public static void createSkillMenu(Player p){
		String expString = String.valueOf(HashMaps.exp.get(p.getName()));
		
		//create main menu
		HashMaps.skill_crafting_gui.put(p.getUniqueId(), Bukkit.createInventory(null, 45, skill_crafting_menu));
		//add items
		HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(40, Items.lobbyMenu);
		
		//TODO traps skill
		HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(11, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Traps", expString, "3000", Permissions.trapLvl0, "Enables crafting traps"));
		
		if(p.hasPermission(Permissions.trapLvl1)){
			HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(11, CustomItem.createActiveItem(Items.unlockedSkill, "Traps", "Enables crafting traps"));
		}
		
		//TODO leatherworking skill
		HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(13, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Leatherworking", expString, "3000", Permissions.leatherLvl0, "Enables crafting", "leather armor"));
		
		if(p.hasPermission(Permissions.leatherLvl1)){
			HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(13, CustomItem.createActiveItem(Items.unlockedSkill, "Leatherworking", "Enables crafting", "leather armor"));
		}
		
		//TODO medicine skill
		HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(15, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Medicine", expString, "3000", Permissions.medicineLvl0, "Enables crafting", "medicaments"));
		
		if(p.hasPermission(Permissions.medicineLvl1)){
			HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(15, CustomItem.createActiveItem(Items.unlockedSkill, "Medicine", "Enables crafting", "medicaments"));
		}
		
		//TODO repair kits skill
		HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(20, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Repair Kits", expString, "3000", Permissions.repairLvl0, "Enables crafting", "repair kits"));
		
		if(p.hasPermission(Permissions.repairLvl1)){
			HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(20, CustomItem.createActiveItem(Items.unlockedSkill, "Repair Kits", "Enables crafting", "repair kits"));
		}
		
		//TODO light armor skill
		HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(22, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Light Armor", expString, "3000", Permissions.lightLvl0, "Enables crafting", "light armors"));
		
		if(p.hasPermission(Permissions.lightLvl1)){
			HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(22, CustomItem.createActiveItem(Items.unlockedSkill, "Light Armor", "Enables crafting", "light armors"));
		}
		
		//TODO heavy armor skill
		HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(24, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Heavy Armor", expString, "3000", Permissions.heavyLvl0, "Enables crafting", "heavy armors"));
		
		if(p.hasPermission(Permissions.heavyLvl1)){
			HashMaps.skill_crafting_gui.get(p.getUniqueId()).setItem(24, CustomItem.createActiveItem(Items.unlockedSkill, "Heavy Armor", "Enables crafting", "heavy armors"));
		}
	}
	
}
