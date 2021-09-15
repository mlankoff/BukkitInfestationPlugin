package me.men8.infestation.misc;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

import me.men8.infestation.main.Main;

public class Items {
	
	Main plugin;
	
	public Items(Main plug){
		this.plugin = plug;
	}
	
	public static ItemStack quickCraftMenu = CustomItem.createCustomItem(ChatColor.GOLD, "Basic Crafting", (short) 1);
	public static ItemStack skillsMenu = CustomItem.createCustomItem(ChatColor.GOLD, "Skills", (short) 2);
	public static ItemStack achievementsMenu = CustomItem.createCustomItem(ChatColor.GOLD, "Achievements", (short) 3);
	public static ItemStack magicMenu = CustomItem.createCustomItem(ChatColor.GOLD, "Coming soon", (short) 4);
	public static ItemStack hatsMenu = CustomItem.createCustomItem(ChatColor.GOLD, "Hats", (short) 5);
	public static ItemStack optionsMenu = CustomItem.createCustomItem(ChatColor.GOLD, "Coming soon", (short) 6);
	public static ItemStack lobbyMenu = CustomItem.createCustomItem(ChatColor.GOLD, "Lobby", (short) 7);
	public static ItemStack nextPage = CustomItem.createCustomItem(ChatColor.GOLD, "Next Page", (short) 8);
	public static ItemStack previousPage = CustomItem.createCustomItem(ChatColor.GOLD, "Previous Page", (short) 9);
	public static ItemStack blocked = CustomItem.createCustomItem(ChatColor.GOLD, "Locked", (short) 10);
	public static ItemStack unlockedAchievement = CustomItem.createCustomItem((short) 12);
	public static ItemStack lockedAchievement = CustomItem.createCustomItem((short) 13);
	public static ItemStack skillFirearms = CustomItem.createCustomItem(ChatColor.GOLD, "Firearms Skills", (short) 14);
	public static ItemStack skillWeapons = CustomItem.createCustomItem(ChatColor.GOLD, "Weapons Skills", (short) 15);
	public static ItemStack skillCrafting = CustomItem.createCustomItem(ChatColor.GOLD, "Crafting Skills", (short) 16);
	public static ItemStack skillScavenging = CustomItem.createCustomItem(ChatColor.GOLD, "Scavenging Skills", (short) 17);
	public static ItemStack skillHealth = CustomItem.createCustomItem(ChatColor.GOLD, "Health Skills", (short) 18);
	public static ItemStack unlockedSkill = CustomItem.createCustomItem((short) 19);
	public static ItemStack lockedSkill = CustomItem.createCustomItem((short) 20);
	public static ItemStack readySkill = CustomItem.createCustomItem((short) 21);



}
