package me.men8.infestation.misc;

import java.util.ArrayList;

import me.men8.infestation.main.Main;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.permissions.Permission;

public class CustomItem {
	
	Main plugin;
	
	/**
	 * Constructor
	 * @param plug
	 */
	public CustomItem(Main plug){
		this.plugin = plug;
	}
	
	/**
	 * Create custom item from diamond hoe with lore
	 * @param nameColor
	 * @param name
	 * @param loreColor
	 * @param lore
	 * @param durability
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static ItemStack createCustomItem(ChatColor nameColor, String name, ChatColor loreColor, String lore, short durability){
		ItemStack customItem = new ItemStack(Material.DIAMOND_HOE, 1, durability);
		ItemMeta customItemMeta = customItem.getItemMeta();
		customItemMeta.spigot().setUnbreakable(true);
		customItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		customItemMeta.setDisplayName("" + nameColor + name);
		ArrayList<String> array = new ArrayList<String>();
		array.add("" + loreColor + lore);
		customItemMeta.setLore(array);
		customItem.setItemMeta(customItemMeta);
		return customItem;
	}
	
	/**
	 * Create custom item from diamond hoe with lore
	 * @param durability
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static ItemStack createCustomItem(short durability){
		ItemStack customItem = new ItemStack(Material.DIAMOND_HOE, 1, durability);
		ItemMeta customItemMeta = customItem.getItemMeta();
		customItemMeta.spigot().setUnbreakable(true);
		customItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		customItem.setItemMeta(customItemMeta);
		return customItem;
	}
	
	/**
	 * Create custom item from diamond hoe
	 * @param nameColor
	 * @param name
	 * @param durability
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static ItemStack createCustomItem(ChatColor nameColor, String name, short durability){
		ItemStack customItem = new ItemStack(Material.DIAMOND_HOE, 1, durability);
		ItemMeta customItemMeta = customItem.getItemMeta();
		customItemMeta.spigot().setUnbreakable(true);
		customItemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
		customItemMeta.setDisplayName("" + nameColor + name);
		customItem.setItemMeta(customItemMeta);
		return customItem;
	}
	
	/**
	 * Find longest String
	 * @param stringsToCheck
	 * @return
	 */
	private static String findLongestString(String... stringsToCheck){
		String longestString = "";
		int maxLength = 0;
		for(String s : stringsToCheck){
			if(s.length() > maxLength){
				longestString = s;
			}
		}
		return longestString;
	}
	
	/**
	 * Create separator with length as longest line
	 * @param stringsToCheck
	 * @return
	 */
	private static String createSeparator(String... stringsToCheck){
		String separator = "";
		String longestString = "";
		int maxLength = 0;
		for(String s : stringsToCheck){
			if(s.length() > maxLength){
				maxLength = s.length();
				longestString = s;
			}
		}
		for(int i = 0; i < longestString.length(); i++){
			separator += "-";
		}
		return separator;
	}
	
	
	/**
	 * Create inactive item from given item
	 * @param item
	 * @param name
	 * @param lore
	 * @param firstVal
	 * @param secoundVal
	 * @return
	 */
	public static ItemStack createInactiveItem(ItemStack item, String name, String lore, String firstVal, String secoundVal){
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName(ChatColor.RED + name);
		ArrayList<String> array = new ArrayList<String>();
		array.add("" + ChatColor.GREEN + lore);
		array.add("" + ChatColor.RED + createSeparator(lore, firstVal + "/" + secoundVal, name));
		array.add("" + ChatColor.GOLD + firstVal + " " + ChatColor.RED + "/ " + ChatColor.GOLD + secoundVal);
		itemMeta.setLore(array);
		item.setItemMeta(itemMeta);
		return item;
	}
	
	/**
	 * Create active item from given item
	 * @param item
	 * @param name
	 * @param lore
	 * @return
	 */
	public static ItemStack createActiveItem(ItemStack item, String name, String... lore){
		ItemMeta itemMeta = item.getItemMeta();
		itemMeta.setDisplayName("" + ChatColor.GOLD + name);
		ArrayList<String> array = new ArrayList<String>();
		for(String s : lore){
			array.add("" + ChatColor.GREEN + s);
		}
		itemMeta.setLore(array);
		item.setItemMeta(itemMeta);
		return item;
	}
	
	
	public static ItemStack createLockedItem(Player p, ItemStack itemReady, ItemStack itemLocked, String name, String firstVal, String secoundVal, Permission previous, String... lore){
		String longestString = null;
		ItemStack item = null;
		ItemMeta itemMeta;
		String readyToBuy = ChatColor.GOLD + "Skill Ready To Buy";
		if(p.hasPermission(previous)){
			item = itemReady;
			itemMeta = item.getItemMeta();
			itemMeta.setDisplayName(ChatColor.RED + name);
			ArrayList<String> array = new ArrayList<String>();
			for(String s : lore){
				array.add("" + ChatColor.GREEN + s);
				longestString = findLongestString(s);
			}
			if(Integer.parseInt(firstVal) >= Integer.parseInt(secoundVal)){
				array.add("" + ChatColor.RED + createSeparator(longestString, readyToBuy, name));
				array.add(readyToBuy);
			}else{
				array.add("" + ChatColor.RED + createSeparator(longestString, firstVal + "/" + secoundVal, name, readyToBuy));
				array.add("" + ChatColor.GOLD + firstVal + " " + ChatColor.RED + "/ " + ChatColor.GOLD + secoundVal);
			}
			itemMeta.setLore(array);
			item.setItemMeta(itemMeta);
		}else{
			item = itemLocked;
			itemMeta = item.getItemMeta();
			itemMeta.setDisplayName(ChatColor.RED + name);
			ArrayList<String> array = new ArrayList<String>();
			for(String s : lore){
				array.add("" + ChatColor.GREEN + s);
				longestString = findLongestString(s);
			}
			
			array.add("" + ChatColor.RED + createSeparator(longestString, firstVal + "/" + secoundVal, name, "Buy Previous Tier"));
			array.add("" + ChatColor.GRAY + "Buy Previous Tier");
			array.add("" + ChatColor.GOLD + firstVal + " " + ChatColor.RED + "/ " + ChatColor.GOLD + secoundVal);
			itemMeta.setLore(array);
			item.setItemMeta(itemMeta);
		}
		return item;
	}
	
	/**
	 * Create player's head item
	 * @param p
	 * @return
	 */
	public static ItemStack createPlayerHead(Player p){
		ItemStack playerHead = new ItemStack(Materials.head, 1, (short) SkullType.PLAYER.ordinal());
		SkullMeta statsMeta = (SkullMeta)playerHead.getItemMeta();
		statsMeta.setOwner(p.getName());
		statsMeta.setDisplayName(ChatColor.GOLD + p.getName() + "'s Menu");
		playerHead.setItemMeta(statsMeta);
		return playerHead;
	}
	
	

}
