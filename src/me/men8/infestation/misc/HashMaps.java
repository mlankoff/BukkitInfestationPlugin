package me.men8.infestation.misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.inventory.Inventory;
import org.bukkit.scoreboard.Score;

import me.men8.infestation.main.Main;

public class HashMaps {
	
	Main plugin;
	
	public HashMaps(Main plug){
		this.plugin = plug;
	}
	
//	public static HashMap<String, Integer> check = new HashMap<String, Integer>();
//	public static HashMap<String, Integer> rads = new HashMap<String, Integer>();
//	public static List<UUID> spawnedMobs = new ArrayList<UUID>();
	public static HashMap<String, Double> temp = new HashMap<String, Double>();//temperature
	public static HashMap<String, Double> thirst = new HashMap<String, Double>();//thirst
//	public static HashMap<String, Integer> stop = new HashMap<String, Integer>();//stop before next place fireplace
//	public static HashMap<String, Double> radio = new HashMap<String, Double>();//radioactivity hashmap
	public static HashMap<String, Score> tscore = new HashMap<String, Score>(); //temperature score
	public static HashMap<String, Score> pscore = new HashMap<String, Score>(); //thirst score
	public static HashMap<String, Score> gscore = new HashMap<String, Score>(); //guild score
	public static HashMap<String, Score> rscore = new HashMap<String, Score>(); //radioactivity scores
	public static HashMap<String, Score> mscore = new HashMap<String, Score>(); //money scores
	public static HashMap<String, Score> expscore = new HashMap<String, Score>(); //exp scores
	public static HashMap<String, Integer> exp = new HashMap<String, Integer>(); //exp
	public static HashMap<String, Integer> mob_kill = new HashMap<String, Integer>(); //mob kiled
	public static HashMap<String, Integer> player_kill = new HashMap<String, Integer>(); //player kiled
	public static HashMap<String, Integer> travel = new HashMap<String, Integer>(); //blocks travelled
	public static HashMap<String, Integer> bandage_use = new HashMap<String, Integer>(); //bandages used
	public static HashMap<String, Integer> break_leg = new HashMap<String, Integer>(); //how many times player break leg
	public static HashMap<UUID, Integer> respawn = new HashMap<UUID, Integer>();
	public static HashMap<UUID, Location> death = new HashMap<UUID, Location>();
	
	/**
	 * Inventory variables
	 */
	//Main Menu
	public static HashMap<UUID, Inventory> main_menu_gui = new HashMap<UUID, Inventory>();
	//Quick Craft Main Menu
	public static HashMap<UUID, Inventory> craft_main_gui       = new HashMap<UUID, Inventory>();
	//Skill Main Menu
	public static HashMap<UUID, Inventory> skill_main_gui       = new HashMap<UUID, Inventory>();
	public static HashMap<UUID, Inventory> skill_weapons_gui    = new HashMap<UUID, Inventory>();
	public static HashMap<UUID, Inventory> skill_crafting_gui  = new HashMap<UUID, Inventory>();
	public static HashMap<UUID, Inventory> skill_scavenging_gui = new HashMap<UUID, Inventory>();
	public static HashMap<UUID, Inventory> skill_health_gui1    = new HashMap<UUID, Inventory>();
	public static HashMap<UUID, Inventory> skill_health_gui2    = new HashMap<UUID, Inventory>();
	//Magic Main Menu
	public static HashMap<UUID, Inventory> magic_main_gui       = new HashMap<UUID, Inventory>();
	//Hats Main Menu
	public static HashMap<UUID, Inventory> hats_main_gui        = new HashMap<UUID, Inventory>();
	//Achievements Menu
	public static HashMap<UUID, Inventory> achievements_gui1    = new HashMap<UUID, Inventory>();
	public static HashMap<UUID, Inventory> achievements_gui2    = new HashMap<UUID, Inventory>();
	//Options Menu
	public static HashMap<UUID, Inventory> options_main_gui     = new HashMap<UUID, Inventory>();
	
}
