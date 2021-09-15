package me.men8.infestation.menu;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.CustomItem;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Items;
import me.men8.infestation.permissions.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SkillScavengingMenu{
	
	Main plugin;
	public static String skill_scavenging_menu = "Scavenging Skill Menu";
	
	public SkillScavengingMenu(Main plug){
		this.plugin = plug;
	}

	public static void createSkillMenu(Player p){
		String expString = String.valueOf(HashMaps.exp.get(p.getName()));
		
		//create main menu
		HashMaps.skill_scavenging_gui.put(p.getUniqueId(), Bukkit.createInventory(null, 45, skill_scavenging_menu));
		//add items
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(40, Items.lobbyMenu);
		
		//TODO scavenging skill
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(11, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Scavenging Tier I", expString, "3000", Permissions.scavengingLvl0, "Increases your", "chances of getting", "more raw material", "by 5%"));
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(12, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Scavenging Tier II", expString, "3000", Permissions.scavengingLvl1, "Increases your", "chances of getting", "more raw material", "by 10%"));
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(13, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Scavenging Tier III", expString, "3000", Permissions.scavengingLvl2, "Increases your", "chances of getting", "more raw material", "by 15%"));
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(14, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Scavenging Tier IV", expString, "3000", Permissions.scavengingLvl3, "Increases your", "chances of getting", "more raw material", "by 20%"));
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(15, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Scavenging Tier V", expString, "3000", Permissions.scavengingLvl4, "Increases your", "chances of getting", "more raw material", "by 25%"));
		
		if(p.hasPermission(Permissions.scavengingLvl1)||p.hasPermission(Permissions.scavengingLvl2)||p.hasPermission(Permissions.scavengingLvl3)||p.hasPermission(Permissions.scavengingLvl4)||p.hasPermission(Permissions.scavengingLvl5)){
			HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(11, CustomItem.createActiveItem(Items.unlockedSkill, "Scavenging Tier I", "Increases your", "chances of getting", "more raw material", "by 5%"));
		}
		if(p.hasPermission(Permissions.scavengingLvl2)||p.hasPermission(Permissions.scavengingLvl3)||p.hasPermission(Permissions.scavengingLvl4)||p.hasPermission(Permissions.scavengingLvl5)){
			HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(12, CustomItem.createActiveItem(Items.unlockedSkill, "Scavenging Tier II", "Increases your", "chances of getting", "more raw material", "by 10%"));
		}
		if(p.hasPermission(Permissions.scavengingLvl3)||p.hasPermission(Permissions.scavengingLvl4)||p.hasPermission(Permissions.scavengingLvl5)){
			HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(13, CustomItem.createActiveItem(Items.unlockedSkill, "Scavenging Tier III", "Increases your", "chances of getting", "more raw material", "by 15%"));
		}
		if(p.hasPermission(Permissions.scavengingLvl4)||p.hasPermission(Permissions.scavengingLvl5)){
			HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(14, CustomItem.createActiveItem(Items.unlockedSkill, "Scavenging Tier IV", "Increases your", "chances of getting", "more raw material", "by 20%"));
		}
		if(p.hasPermission(Permissions.scavengingLvl5)){
			HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(15, CustomItem.createActiveItem(Items.unlockedSkill, "Scavenging Tier V", "Increases your", "chances of getting", "more raw material", "by 25%"));
		}
		
		//TODO luck skill
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(20, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Luck Tier I", expString, "3000", Permissions.luckLvl0, "Increases your", "chances of finding", "better items by 5%"));
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(21, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Luck Tier II", expString, "3000", Permissions.luckLvl1, "Increases your", "chances of finding", "better items by 10%"));
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(22, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Luck Tier III", expString, "3000", Permissions.luckLvl2, "Increases your", "chances of finding", "better items by 15%"));
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(23, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Luck Tier IV", expString, "3000", Permissions.luckLvl3, "Increases your", "chances of finding", "better items by 20%"));
		HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(24, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Luck Tier V", expString, "3000", Permissions.luckLvl4, "Increases your", "chances of finding", "better items by 25%"));
		
		if(p.hasPermission(Permissions.luckLvl1)||p.hasPermission(Permissions.luckLvl2)||p.hasPermission(Permissions.luckLvl3)||p.hasPermission(Permissions.luckLvl4)||p.hasPermission(Permissions.luckLvl5)){
			HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(20, CustomItem.createActiveItem(Items.unlockedSkill, "Luck Tier I", "Increases your", "chances of finding", "better items by 5%"));
		}
		if(p.hasPermission(Permissions.luckLvl2)||p.hasPermission(Permissions.luckLvl3)||p.hasPermission(Permissions.luckLvl4)||p.hasPermission(Permissions.luckLvl5)){
			HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(21, CustomItem.createActiveItem(Items.unlockedSkill, "Luck Tier II", "Increases your", "chances of finding", "better items by 10%"));
		}
		if(p.hasPermission(Permissions.luckLvl3)||p.hasPermission(Permissions.luckLvl4)||p.hasPermission(Permissions.luckLvl5)){
			HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(22, CustomItem.createActiveItem(Items.unlockedSkill, "Luck Tier III", "Increases your", "chances of finding", "better items by 15%"));
		}
		if(p.hasPermission(Permissions.luckLvl4)||p.hasPermission(Permissions.luckLvl5)){
			HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(23, CustomItem.createActiveItem(Items.unlockedSkill, "Luck Tier IV", "Increases your", "chances of finding", "better items by 20%"));
		}
		if(p.hasPermission(Permissions.luckLvl5)){
			HashMaps.skill_scavenging_gui.get(p.getUniqueId()).setItem(24, CustomItem.createActiveItem(Items.unlockedSkill, "Luck Tier V", "Increases your", "chances of finding", "better items by 25%"));
		}
	}
	
}
