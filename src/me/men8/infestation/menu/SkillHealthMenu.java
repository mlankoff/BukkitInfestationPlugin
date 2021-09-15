package me.men8.infestation.menu;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.CustomItem;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Items;
import me.men8.infestation.permissions.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class SkillHealthMenu{
	
	Main plugin;
	public static String skill_health_menu1 = "Health Skill Menu Page 1";
	public static String skill_health_menu2 = "Health Skill Menu Page 2";
	
	public SkillHealthMenu(Main plug){
		this.plugin = plug;
	}

	public static void createSkillMenu(Player p){
		String expString = String.valueOf(HashMaps.exp.get(p.getName()));
		
		//create main menu
		HashMaps.skill_health_gui1.put(p.getUniqueId(), Bukkit.createInventory(null, 54, skill_health_menu1));
		//add items
		
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(49, Items.lobbyMenu);
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(50, Items.nextPage);
		
		//TODO health skill
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(11, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Health Tier I", expString, "3000", Permissions.healthLvl0, "Increase max health", "by 2 hearts"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(12, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Health Tier II", expString, "3000", Permissions.healthLvl1, "Increase max health", "by 2 hearts"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(13, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Health Tier III", expString, "3000", Permissions.healthLvl2, "Increase max health", "by 2 hearts"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(14, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Health Tier IV", expString, "3000", Permissions.healthLvl3, "Increase max health", "by 2 hearts"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(15, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Health Tier V", expString, "3000", Permissions.healthLvl4, "Increase max health", "by 2 hearts"));
		
		if(p.hasPermission(Permissions.healthLvl1)||p.hasPermission(Permissions.healthLvl2)||p.hasPermission(Permissions.healthLvl3)||p.hasPermission(Permissions.healthLvl4)||p.hasPermission(Permissions.healthLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(11, CustomItem.createActiveItem(Items.unlockedSkill, "Health Tier I", "Increase max health", "by 2 hearts"));
		}
		if(p.hasPermission(Permissions.healthLvl2)||p.hasPermission(Permissions.healthLvl3)||p.hasPermission(Permissions.healthLvl4)||p.hasPermission(Permissions.healthLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(12, CustomItem.createActiveItem(Items.unlockedSkill, "Health Tier II", "Increase max health", "by 2 hearts"));
		}
		if(p.hasPermission(Permissions.healthLvl3)||p.hasPermission(Permissions.healthLvl4)||p.hasPermission(Permissions.healthLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(13, CustomItem.createActiveItem(Items.unlockedSkill, "Health Tier III", "Increase max health", "by 2 hearts"));
		}
		if(p.hasPermission(Permissions.healthLvl4)||p.hasPermission(Permissions.healthLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(14, CustomItem.createActiveItem(Items.unlockedSkill, "Health Tier IV", "Increase max health", "by 2 hearts"));
		}
		if(p.hasPermission(Permissions.healthLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(15, CustomItem.createActiveItem(Items.unlockedSkill, "Health Tier V", "Increase max health", "by 2 hearts"));
		}
		
		//TODO Camel skill
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(20, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Camel Tier I", expString, "3000", Permissions.thirstLvl0, "Increases basic", "resistance to thirst", "by 25%"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(21, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Camel Tier II", expString, "3000", Permissions.thirstLvl1, "Increases basic", "resistance to thirst", "by 50%"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(22, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Camel Tier III", expString, "3000", Permissions.thirstLvl2, "Increases basic", "resistance to thirst", "by 75%"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(23, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Camel Tier IV", expString, "3000", Permissions.thirstLvl3, "Increases basic", "resistance to thirst", "by 100%"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(24, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Camel Tier V", expString, "3000", Permissions.thirstLvl4, "Increases basic", "resistance to thirst", "by 125%"));
		
		if(p.hasPermission(Permissions.thirstLvl1)||p.hasPermission(Permissions.thirstLvl2)||p.hasPermission(Permissions.thirstLvl3)||p.hasPermission(Permissions.thirstLvl4)||p.hasPermission(Permissions.thirstLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(20, CustomItem.createActiveItem(Items.unlockedSkill, "Camel Tier I", "Increases basic", "resistance to thirst", "by 25%"));
		}
		if(p.hasPermission(Permissions.thirstLvl2)||p.hasPermission(Permissions.thirstLvl3)||p.hasPermission(Permissions.thirstLvl4)||p.hasPermission(Permissions.thirstLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(21, CustomItem.createActiveItem(Items.unlockedSkill, "Camel Tier II", "Increases basic", "resistance to thirst", "by 50%"));
		}
		if(p.hasPermission(Permissions.thirstLvl3)||p.hasPermission(Permissions.thirstLvl4)||p.hasPermission(Permissions.thirstLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(22, CustomItem.createActiveItem(Items.unlockedSkill, "Camel Tier III", "Increases basic", "resistance to thirst", "by 75%"));
		}
		if(p.hasPermission(Permissions.thirstLvl4)||p.hasPermission(Permissions.thirstLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(23, CustomItem.createActiveItem(Items.unlockedSkill, "Camel Tier IV", "Increases basic", "resistance to thirst", "by 100%"));
		}
		if(p.hasPermission(Permissions.thirstLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(24, CustomItem.createActiveItem(Items.unlockedSkill, "Camel Tier V", "Increases basic", "resistance to thirst", "by 125%"));
		}
		
		//TODO Eskimo skill
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(29, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Eskimo Tier I", expString, "3000", Permissions.temperatureLvl0, "Increases basic", "resistance to", "temperature by 25%"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(30, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Eskimo Tier II", expString, "3000", Permissions.temperatureLvl1, "Increases basic", "resistance to", "temperature by 50%"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(31, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Eskimo Tier III", expString, "3000", Permissions.temperatureLvl2, "Increases basic", "resistance to", "temperature by 75%"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(32, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Eskimo Tier IV", expString, "3000", Permissions.temperatureLvl3, "Increases basic", "resistance to", "temperature by 100%"));
		HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(33, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Eskimo Tier V", expString, "3000", Permissions.temperatureLvl4, "Increases basic", "resistance to", "temperature by 125%"));
		
		if(p.hasPermission(Permissions.temperatureLvl1)||p.hasPermission(Permissions.temperatureLvl2)||p.hasPermission(Permissions.temperatureLvl3)||p.hasPermission(Permissions.temperatureLvl4)||p.hasPermission(Permissions.temperatureLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(29, CustomItem.createActiveItem(Items.unlockedSkill, "Eskimo Tier I", "Increases basic", "resistance to", "temperature by 25%"));
		}
		if(p.hasPermission(Permissions.temperatureLvl2)||p.hasPermission(Permissions.temperatureLvl3)||p.hasPermission(Permissions.temperatureLvl4)||p.hasPermission(Permissions.temperatureLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(30, CustomItem.createActiveItem(Items.unlockedSkill, "Eskimo Tier II", "Increases basic", "resistance to", "temperature by 50%"));
		}
		if(p.hasPermission(Permissions.temperatureLvl3)||p.hasPermission(Permissions.temperatureLvl4)||p.hasPermission(Permissions.temperatureLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(31, CustomItem.createActiveItem(Items.unlockedSkill, "Eskimo Tier III", "Increases basic", "resistance to", "temperature by 75%"));
		}
		if(p.hasPermission(Permissions.temperatureLvl4)||p.hasPermission(Permissions.temperatureLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(32, CustomItem.createActiveItem(Items.unlockedSkill, "Eskimo Tier IV", "Increases basic", "resistance to", "temperature by 100%"));
		}
		if(p.hasPermission(Permissions.temperatureLvl5)){
			HashMaps.skill_health_gui1.get(p.getUniqueId()).setItem(33, CustomItem.createActiveItem(Items.unlockedSkill, "Eskimo Tier V", "Increases basic", "resistance to", "temperature by 125%"));
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		///[MAIN MENU]///////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//create main menu
		HashMaps.skill_health_gui2.put(p.getUniqueId(), Bukkit.createInventory(null, 54, skill_health_menu2));
		//add items
		
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(48, Items.previousPage);
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(49, Items.lobbyMenu);
		
		//TODO Agility skill
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(11, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Agility Tier I", expString, "3000", Permissions.agilityLvl0, "Increase agility and", "reduce chance of", "breaking leg to 40%"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(12, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Agility Tier II", expString, "3000", Permissions.agilityLvl1, "Increase agility and", "reduce chance of", "breaking leg to 35%"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(13, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Agility Tier III", expString, "3000", Permissions.agilityLvl2, "Increase agility and", "reduce chance of", "breaking leg to 30%"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(14, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Agility Tier IV", expString, "3000", Permissions.agilityLvl3, "Increase agility and", "reduce chance of", "breaking leg to 25%"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(15, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Agility Tier V", expString, "3000", Permissions.agilityLvl4, "Increase agility and", "reduce chance of", "breaking leg to 20%"));
		
		if(p.hasPermission(Permissions.agilityLvl1)||p.hasPermission(Permissions.agilityLvl2)||p.hasPermission(Permissions.agilityLvl3)||p.hasPermission(Permissions.agilityLvl4)||p.hasPermission(Permissions.agilityLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(11, CustomItem.createActiveItem(Items.unlockedSkill, "Agility Tier I", "Increase agility and", "reduce chance of", "breaking leg to 40%"));
		}
		if(p.hasPermission(Permissions.agilityLvl2)||p.hasPermission(Permissions.agilityLvl3)||p.hasPermission(Permissions.agilityLvl4)||p.hasPermission(Permissions.agilityLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(12, CustomItem.createActiveItem(Items.unlockedSkill, "Agility Tier II", "Increase agility and", "reduce chance of", "breaking leg to 35%"));
		}
		if(p.hasPermission(Permissions.agilityLvl3)||p.hasPermission(Permissions.agilityLvl4)||p.hasPermission(Permissions.agilityLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(13, CustomItem.createActiveItem(Items.unlockedSkill, "Agility Tier III", "Increase agility and", "reduce chance of", "breaking leg to 30%"));
		}
		if(p.hasPermission(Permissions.agilityLvl4)||p.hasPermission(Permissions.agilityLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(14, CustomItem.createActiveItem(Items.unlockedSkill, "Agility Tier IV", "Increase agility and", "reduce chance of", "breaking leg to 25%"));
		}
		if(p.hasPermission(Permissions.agilityLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(15, CustomItem.createActiveItem(Items.unlockedSkill, "Agility Tier V", "Increase agility and", "reduce chance of", "breaking leg to 20%"));
		}
		
		//TODO Hard Skin skill
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(20, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Hard Skin Tier I", expString, "3000", Permissions.hardSkinLvl0, "Reduces the chance", "of bleeding to 40%"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(21, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Hard Skin Tier II", expString, "3000", Permissions.hardSkinLvl1, "Reduces the chance", "of bleeding to 35%"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(22, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Hard Skin Tier III", expString, "3000", Permissions.hardSkinLvl2, "Reduces the chance", "of bleeding to 30%"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(23, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Hard Skin Tier IV", expString, "3000", Permissions.hardSkinLvl3, "Reduces the chance", "of bleeding to 25%"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(24, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Hard Skin Tier V", expString, "3000", Permissions.hardSkinLvl4, "Reduces the chance", "of bleeding to 20%"));
		
		if(p.hasPermission(Permissions.hardSkinLvl1)||p.hasPermission(Permissions.hardSkinLvl2)||p.hasPermission(Permissions.hardSkinLvl3)||p.hasPermission(Permissions.hardSkinLvl4)||p.hasPermission(Permissions.hardSkinLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(20, CustomItem.createActiveItem(Items.unlockedSkill, "Hard Skin Tier I", "Reduces the chance", "of bleeding to 40%"));
		}
		if(p.hasPermission(Permissions.hardSkinLvl2)||p.hasPermission(Permissions.hardSkinLvl3)||p.hasPermission(Permissions.hardSkinLvl4)||p.hasPermission(Permissions.hardSkinLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(21, CustomItem.createActiveItem(Items.unlockedSkill, "Hard Skin Tier II", "Reduces the chance", "of bleeding to 35%"));
		}
		if(p.hasPermission(Permissions.hardSkinLvl3)||p.hasPermission(Permissions.hardSkinLvl4)||p.hasPermission(Permissions.hardSkinLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(22, CustomItem.createActiveItem(Items.unlockedSkill, "Hard Skin Tier III", "Reduces the chance", "of bleeding to 30%"));
		}
		if(p.hasPermission(Permissions.hardSkinLvl4)||p.hasPermission(Permissions.hardSkinLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(23, CustomItem.createActiveItem(Items.unlockedSkill, "Hard Skin Tier IV", "Reduces the chance", "of bleeding to 25%"));
		}
		if(p.hasPermission(Permissions.hardSkinLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(24, CustomItem.createActiveItem(Items.unlockedSkill, "Hard Skin Tier V", "Reduces the chance", "of bleeding to 20%"));
		}
		
		//TODO Strength skill
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(29, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Strength Tier I", expString, "3000", Permissions.strengthLvl0, "Increases strength", "and backpack", "capacity by 5 slots"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(30, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Strength Tier II", expString, "3000", Permissions.strengthLvl1, "Increases strength", "and backpack", "capacity by 5 slots"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(31, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Strength Tier III", expString, "3000", Permissions.strengthLvl2, "Increases strength", "and backpack", "capacity by 5 slots"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(32, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Strength Tier IV", expString, "3000", Permissions.strengthLvl3, "Increases strength", "and backpack", "capacity by 6 slots"));
		HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(33, CustomItem.createLockedItem(p, Items.readySkill, Items.lockedSkill, "Strength Tier V", expString, "3000", Permissions.strengthLvl4, "Increases strength", "and backpack", "capacity by 6 slots"));
		
		if(p.hasPermission(Permissions.strengthLvl1)||p.hasPermission(Permissions.strengthLvl2)||p.hasPermission(Permissions.strengthLvl3)||p.hasPermission(Permissions.strengthLvl4)||p.hasPermission(Permissions.strengthLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(29, CustomItem.createActiveItem(Items.unlockedSkill, "Strength Tier I", "Increases strength", "and backpack", "capacity by 5 slots"));
		}
		if(p.hasPermission(Permissions.strengthLvl2)||p.hasPermission(Permissions.strengthLvl3)||p.hasPermission(Permissions.strengthLvl4)||p.hasPermission(Permissions.strengthLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(30, CustomItem.createActiveItem(Items.unlockedSkill, "Strength Tier II", "Increases strength", "and backpack", "capacity by 5 slots"));
		}
		if(p.hasPermission(Permissions.strengthLvl3)||p.hasPermission(Permissions.strengthLvl4)||p.hasPermission(Permissions.strengthLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(31, CustomItem.createActiveItem(Items.unlockedSkill, "Strength Tier III", "Increases strength", "and backpack", "capacity by 5 slots"));
		}
		if(p.hasPermission(Permissions.strengthLvl4)||p.hasPermission(Permissions.strengthLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(32, CustomItem.createActiveItem(Items.unlockedSkill, "Strength Tier IV", "Increases strength", "and backpack", "capacity by 6 slots"));
		}
		if(p.hasPermission(Permissions.strengthLvl5)){
			HashMaps.skill_health_gui2.get(p.getUniqueId()).setItem(33, CustomItem.createActiveItem(Items.unlockedSkill, "Strength Tier V", "Increases strength", "and backpack", "capacity by 6 slots"));
		}
	}
	
}
