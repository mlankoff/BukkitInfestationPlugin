package me.men8.infestation.menu;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.*;
import me.men8.infestation.scoreboard.UpdateScoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MainMenuHandler implements Listener{
	
	static Main plugin;
	
	public MainMenuHandler(Main plug){
		plugin = plug;
	}
	
	/**
	 * Main Menu Handler
	 * @param e
	 */
	@EventHandler
	public static void mainMenuHandler(InventoryClickEvent e){
		Player p = (Player)e.getWhoClicked();
		if(e.getCurrentItem() == null){
			return;
		}else{
			//TODO Main Menu Handler
			if(e.getInventory().getName().equals(MainMenu.main)){
				if(e.getCurrentItem().getDurability() == Items.quickCraftMenu.getDurability()){
					p.openInventory(HashMaps.craft_main_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.skillsMenu.getDurability()){
					SkillsMainMenu.createSkillMenu(p);
					p.openInventory(HashMaps.skill_main_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.magicMenu.getDurability()){
					p.openInventory(HashMaps.magic_main_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.hatsMenu.getDurability()){
					p.openInventory(HashMaps.hats_main_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.achievementsMenu.getDurability()){
					p.openInventory(HashMaps.achievements_gui1.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.optionsMenu.getDurability()){
					p.openInventory(HashMaps.options_main_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.lobbyMenu.getDurability()){
					p.closeInventory();
				}
				e.setCancelled(true);
			}
			//TODO Skill Main Menu Handler
			else if(e.getInventory().getName().equals(SkillsMainMenu.skill_main_menu)){
				if(e.getCurrentItem().getDurability() == Items.lobbyMenu.getDurability()){
					p.openInventory(HashMaps.main_menu_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.skillWeapons.getDurability()){
					SkillWeaponsMenu.createSkillMenu(p);
					p.openInventory(HashMaps.skill_weapons_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.skillCrafting.getDurability()){
					SkillCraftingMenu.createSkillMenu(p);
					p.openInventory(HashMaps.skill_crafting_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.skillScavenging.getDurability()){
					SkillScavengingMenu.createSkillMenu(p);
					p.openInventory(HashMaps.skill_scavenging_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.skillHealth.getDurability()){
					SkillHealthMenu.createSkillMenu(p);
					p.openInventory(HashMaps.skill_health_gui1.get(p.getUniqueId()));
				}
				e.setCancelled(true);
			}
			//TODO Skill Weapons Handler
			else if(e.getInventory().getName().equals(SkillWeaponsMenu.skill_weapons_menu)){
				if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Pistols")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add pistol.lvl1");
					refreshWeaponsMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Rifles")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add rifle.lvl1");
					refreshWeaponsMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Shotguns")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add shotgun.lvl1");
					refreshWeaponsMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Archery")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add archery.lvl1");
					refreshWeaponsMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Blade Weapons")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add blade.lvl1");
					refreshWeaponsMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Blunt Weapons")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add blunt.lvl1");
					refreshWeaponsMenu(p, 3000);
				}else if(e.getCurrentItem().getDurability() == Items.lobbyMenu.getDurability()){
					p.closeInventory();
					p.openInventory(HashMaps.skill_main_gui.get(p.getUniqueId()));
				}
				e.setCancelled(true);
			}
			//TODO Skill Crafting Handler
			else if(e.getInventory().getName().equals(SkillCraftingMenu.skill_crafting_menu)){
				if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Traps")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add traps.lvl1");
					refreshCraftingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Leatherworking")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add leatherwork.lvl1");
					refreshCraftingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Medicine")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add medicine.lvl1");
					refreshCraftingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Repair Kits")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add repairkit.lvl1");
					refreshCraftingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Light Armor")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add lightarmor.lvl1");
					refreshCraftingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Heavy Armor")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add heavyarmor.lvl1");
					refreshCraftingMenu(p, 3000);
				}else if(e.getCurrentItem().getDurability() == Items.lobbyMenu.getDurability()){
					p.closeInventory();
					p.openInventory(HashMaps.skill_main_gui.get(p.getUniqueId()));
				}
				e.setCancelled(true);
			}
			//TODO Skill Scavenging Handler
			else if(e.getInventory().getName().equals(SkillScavengingMenu.skill_scavenging_menu)){
				if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Scavenging Tier I")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add scavenging.lvl1");
					refreshScavengingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Scavenging Tier II")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add scavenging.lvl2");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove scavenging.lvl1");
					refreshScavengingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Scavenging Tier III")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add scavenging.lvl3");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove scavenging.lvl2");
					refreshScavengingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Scavenging Tier IV")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add scavenging.lvl4");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove scavenging.lvl3");
					refreshScavengingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Scavenging Tier V")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add scavenging.lvl5");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove scavenging.lvl4");
					refreshScavengingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Luck Tier I")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add luck.lvl1");
					refreshScavengingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Luck Tier II")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add luck.lvl2");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove luck.lvl1");
					refreshScavengingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Luck Tier III")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add luck.lvl3");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove luck.lvl2");
					refreshScavengingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Luck Tier IV")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add luck.lvl4");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove luck.lvl3");
					refreshScavengingMenu(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Luck Tier V")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add luck.lvl5");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove luck.lvl4");
					refreshScavengingMenu(p, 3000);
				}else if(e.getCurrentItem().getDurability() == Items.lobbyMenu.getDurability()){
					p.closeInventory();
					p.openInventory(HashMaps.skill_main_gui.get(p.getUniqueId()));
				}
				e.setCancelled(true);
			}else if(e.getInventory().getName().equals(SkillHealthMenu.skill_health_menu1)){
				if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Health Tier I")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add health.lvl1");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Health Tier II")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add health.lvl2");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove health.lvl1");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Health Tier III")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add health.lvl3");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove health.lvl2");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Health Tier IV")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add health.lvl4");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove health.lvl3");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Health Tier V")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add health.lvl5");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove health.lvl4");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Camel Tier I")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add thirst.lvl1");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Camel Tier II")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add thirst.lvl2");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove thirst.lvl1");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Camel Tier III")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add thirst.lvl3");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove thirst.lvl2");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Camel Tier IV")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add thirst.lvl4");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove thirst.lvl3");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Camel Tier V")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add thirst.lvl5");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove thirst.lvl4");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Eskimo Tier I")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add temperature.lvl1");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Eskimo Tier II")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add temperature.lvl2");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove temperature.lvl1");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Eskimo Tier III")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add temperature.lvl3");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove temperature.lvl2");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Eskimo Tier IV")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add temperature.lvl4");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove temperature.lvl3");
					refreshHealthMenu1(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Eskimo Tier V")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add temperature.lvl5");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove temperature.lvl4");
					refreshHealthMenu1(p, 3000);
				}else if(e.getCurrentItem().getDurability() == Items.lobbyMenu.getDurability()){
					p.closeInventory();
					p.openInventory(HashMaps.skill_main_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.nextPage.getDurability()){
					p.closeInventory();
					p.openInventory(HashMaps.skill_health_gui2.get(p.getUniqueId()));
				}
				e.setCancelled(true);
			}else if(e.getInventory().getName().equals(SkillHealthMenu.skill_health_menu2)){
				if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Agility Tier I")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add agility.lvl1");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Agility Tier II")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add agility.lvl2");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove agility.lvl1");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Agility Tier III")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add agility.lvl3");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove agility.lvl2");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Agility Tier IV")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add agility.lvl4");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove agility.lvl3");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Agility Tier V")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add agility.lvl5");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove agility.lvl4");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Hard Skin Tier I")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add hardskin.lvl1");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Hard Skin Tier II")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add hardskin.lvl2");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove hardskin.lvl1");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Hard Skin Tier III")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add hardskin.lvl3");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove hardskin.lvl2");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Hard Skin Tier IV")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add hardskin.lvl4");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove hardskin.lvl3");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Hard Skin Tier V")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add hardskin.lvl5");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove hardskin.lvl4");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Strength Tier I")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add strength.lvl1");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Strength Tier II")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add strength.lvl2");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove strength.lvl1");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Strength Tier III")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add strength.lvl3");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove strength.lvl2");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Strength Tier IV")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add strength.lvl4");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove strength.lvl3");
					refreshHealthMenu2(p, 3000);
				}else if((e.getCurrentItem().getDurability() == Items.readySkill.getDurability()) && e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Strength Tier V")){
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add strength.lvl5");
					Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " remove strength.lvl4");
					refreshHealthMenu2(p, 3000);
				}else if(e.getCurrentItem().getDurability() == Items.lobbyMenu.getDurability()){
					p.closeInventory();
					p.openInventory(HashMaps.skill_main_gui.get(p.getUniqueId()));
				}else if(e.getCurrentItem().getDurability() == Items.previousPage.getDurability()){
					p.closeInventory();
					p.openInventory(HashMaps.skill_health_gui1.get(p.getUniqueId()));
				}
				e.setCancelled(true);
			}
		}
	}
	
	/**
	 * reduce exp from player
	 * @param p
	 * @param exp
	 */
	public static void reduceExp(Player p, int exp){
		int experience = HashMaps.exp.put(p.getName(), HashMaps.exp.get(p.getName()) - (int) exp); 
		Main.player.set("Players." + p.getName() + "." + "Exp", experience);
		Main.player.saveConfig();
		UpdateScoreboard.updateScoreboard(p);
	}
	
	
	public static void refreshWeaponsMenu(Player p, int expToRemove){
		reduceExp(p, expToRemove);
		SkillWeaponsMenu.createSkillMenu(p);
		p.openInventory(HashMaps.skill_weapons_gui.get(p.getUniqueId()));
	}
	
	public static void refreshCraftingMenu(Player p, int expToRemove){
		reduceExp(p, expToRemove);
		SkillCraftingMenu.createSkillMenu(p);
		p.openInventory(HashMaps.skill_crafting_gui.get(p.getUniqueId()));
	}
	
	public static void refreshScavengingMenu(Player p, int expToRemove){
		reduceExp(p, expToRemove);
		SkillScavengingMenu.createSkillMenu(p);
		p.openInventory(HashMaps.skill_scavenging_gui.get(p.getUniqueId()));
	}
	
	public static void refreshHealthMenu1(Player p, int expToRemove){
		reduceExp(p, expToRemove);
		SkillHealthMenu.createSkillMenu(p);
		p.openInventory(HashMaps.skill_health_gui1.get(p.getUniqueId()));
	}
	
	public static void refreshHealthMenu2(Player p, int expToRemove){
		reduceExp(p, expToRemove);
		SkillHealthMenu.createSkillMenu(p);
		p.openInventory(HashMaps.skill_health_gui2.get(p.getUniqueId()));
	}
	
}
