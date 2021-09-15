package me.men8.infestation.menu;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.CustomItem;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Items;
import me.men8.infestation.time.Time;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class AchievementsMenu implements Listener{
	
	Main plugin;
	
	public static String achievements_menu1 = "Achievements Menu Page 1";
	public static String achievements_menu2 = "Achievements Menu Page 2";
	
	public AchievementsMenu(Main plug){
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
				
				/////////////////////////////////////////////////////////////////////////////////////////////////////
				///[ACHIEVEMENTS MENU 1]/////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////////////////
				
				//create menu
				HashMaps.achievements_gui1.put(p.getUniqueId(), Bukkit.createInventory(null, 54, achievements_menu1));
				
				//add menu items
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(49, Items.lobbyMenu);
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(50, Items.nextPage);
				
				//TODO add time played items
				int timeInt = Main.player.getInt("Players." + p.getName() + "." + "Time");
				String timeString = Time.getPlayedTime(p);
				
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(2, CustomItem.createInactiveItem(Items.lockedAchievement, "Brush With Death", "Total Time Played", timeString, "0w0d5h0m"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(3, CustomItem.createInactiveItem(Items.lockedAchievement, "Near Death Experience", "Total Time Played", timeString, "0w1d1h0m"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(4, CustomItem.createInactiveItem(Items.lockedAchievement, "Cheated Death", "Total Time Played", timeString, "0w2d2h0m"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(5, CustomItem.createInactiveItem(Items.lockedAchievement, "Nearly Immortal", "Total Time Played", timeString, "0w6d6h0m"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(6, CustomItem.createInactiveItem(Items.lockedAchievement, "Immortal", "Total Time Played", timeString, "1w5d12h0m"));
				
				if(timeInt >= 18000){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(2, CustomItem.createActiveItem(Items.unlockedAchievement, "Brush With Death", "Achievement Unlocked"));
				}
				if(timeInt >= 90000){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(3, CustomItem.createActiveItem(Items.unlockedAchievement, "Near Death Experience", "Achievement Unlocked"));
				}
				if(timeInt >= 180000){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(4, CustomItem.createActiveItem(Items.unlockedAchievement, "Cheated Death", "Achievement Unlocked"));
				}
				if(timeInt >= 540000){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(5, CustomItem.createActiveItem(Items.unlockedAchievement, "Nearly Immortal", "Achievement Unlocked"));
				}
				if(timeInt >= 1080000){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(6, CustomItem.createActiveItem(Items.unlockedAchievement, "Immortal", "Achievement Unlocked"));
				}

				//TODO add exp items
				int expInt = Main.player.getInt("Players." + p.getName() + "." + "ExpTotal");
				String expString = String.valueOf(expInt);

				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(11, CustomItem.createInactiveItem(Items.lockedAchievement, "Apprentice", "Total Experience", expString, "2300"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(12, CustomItem.createInactiveItem(Items.lockedAchievement, "Adept", "Total Experience", expString, "11350"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(13, CustomItem.createInactiveItem(Items.lockedAchievement, "Expert", "Total Experience", expString, "22800"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(14, CustomItem.createInactiveItem(Items.lockedAchievement, "Master", "Total Experience", expString, "68250"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(15, CustomItem.createInactiveItem(Items.lockedAchievement, "Legendary", "Total Experience", expString, "136500"));
				
				if(expInt >= 2300){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(11, CustomItem.createActiveItem(Items.unlockedAchievement, "Apprentice", "Achievement Unlocked"));
				}
				if(expInt >= 11350){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(12, CustomItem.createActiveItem(Items.unlockedAchievement, "Adept", "Achievement Unlocked"));
				}
				if(expInt >= 22800){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(13, CustomItem.createActiveItem(Items.unlockedAchievement, "Expert", "Achievement Unlocked"));
				}
				if(expInt >= 68250){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(14, CustomItem.createActiveItem(Items.unlockedAchievement, "Master", "Achievement Unlocked"));
				}
				if(expInt >= 136500){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(15, CustomItem.createActiveItem(Items.unlockedAchievement, "Legendary", "Achievement Unlocked"));
				}
				
				//TODO add mob killed items
				int mobsInt = Main.player.getInt("Players." + p.getName() + "." + "MobsKilled");
				String mobsString = String.valueOf(mobsInt);
				
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(20, CustomItem.createInactiveItem(Items.lockedAchievement, "The Grave Digger", "Mobs Killed", mobsString, "450"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(21, CustomItem.createInactiveItem(Items.lockedAchievement, "The Embalmer", "Mobs Killed", mobsString, "2300"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(22, CustomItem.createInactiveItem(Items.lockedAchievement, "The Mortician", "Mobs Killed", mobsString, "4500"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(23, CustomItem.createInactiveItem(Items.lockedAchievement, "The Funeral Director", "Mobs Killed", mobsString, "13500"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(24, CustomItem.createInactiveItem(Items.lockedAchievement, "The Killing Machine", "Mobs Killed", mobsString, "27500"));
				
				if(mobsInt >= 450){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(20, CustomItem.createActiveItem(Items.unlockedAchievement, "The Grave Digger", "Achievement Unlocked"));
				}
				if(mobsInt >= 2300){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(21, CustomItem.createActiveItem(Items.unlockedAchievement, "The Embalmer", "Achievement Unlocked"));
				}
				if(mobsInt >= 4500){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(22, CustomItem.createActiveItem(Items.unlockedAchievement, "The Mortician", "Achievement Unlocked"));
				}
				if(mobsInt >= 13500){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(23, CustomItem.createActiveItem(Items.unlockedAchievement, "The Funeral Director", "Achievement Unlocked"));
				}
				if(mobsInt >= 27500){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(24, CustomItem.createActiveItem(Items.unlockedAchievement, "The Killing Machine", "Achievement Unlocked"));
				}
				
				//TODO add used medpacks items
				int medpackInt = Main.player.getInt("Players." + p.getName() + "." + "BandagesUsed");
				String medpackString = String.valueOf(medpackInt);
				
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(29, CustomItem.createInactiveItem(Items.lockedAchievement, "Placebo Effect", "Medpacks Used", medpackString, "60"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(30, CustomItem.createInactiveItem(Items.lockedAchievement, "Preventive Medicine", "Medpacks Used", medpackString, "300"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(31, CustomItem.createInactiveItem(Items.lockedAchievement, "Intern", "Medpacks Used", medpackString, "600"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(32, CustomItem.createInactiveItem(Items.lockedAchievement, "Play Doctor", "Medpacks Used", medpackString, "1800"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(33, CustomItem.createInactiveItem(Items.lockedAchievement, "Big Pharma", "Medpacks Used", medpackString, "3600"));
				
				if(medpackInt >= 60){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(29, CustomItem.createActiveItem(Items.unlockedAchievement, "Placebo Effect", "Achievement Unlocked"));
				}
				if(medpackInt >= 300){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(30, CustomItem.createActiveItem(Items.unlockedAchievement, "Preventive Medicine", "Achievement Unlocked"));
				}
				if(medpackInt >= 600){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(31, CustomItem.createActiveItem(Items.unlockedAchievement, "Intern", "Achievement Unlocked"));
				}
				if(medpackInt >= 1800){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(32, CustomItem.createActiveItem(Items.unlockedAchievement, "Play Doctor", "Achievement Unlocked"));
				}
				if(medpackInt >= 3600){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(33, CustomItem.createActiveItem(Items.unlockedAchievement, "Big Pharma", "Achievement Unlocked"));
				}
				
				//TODO add travelled distance items
				int travelledInt = Main.player.getInt("Players." + p.getName() + "." + "Travelled");
				String travelledString = String.valueOf(travelledInt / 1000) + "km";
				
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(38, CustomItem.createInactiveItem(Items.lockedAchievement, "Christopher Columbus", "Blocks Travelled", travelledString, "48km"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(39, CustomItem.createInactiveItem(Items.lockedAchievement, "Ferdinand Magellan", "Blocks Travelled", travelledString, "240km"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(40, CustomItem.createInactiveItem(Items.lockedAchievement, "Marco Polo", "Blocks Travelled", travelledString, "480km"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(41, CustomItem.createInactiveItem(Items.lockedAchievement, "Vasco da Gama", "Blocks Travelled", travelledString, "1450km"));
				HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(42, CustomItem.createInactiveItem(Items.lockedAchievement, "Neil Armstrong", "Blocks Travelled", travelledString, "2900km"));
				
				if(travelledInt >= 48000){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(38, CustomItem.createActiveItem(Items.unlockedAchievement, "Big Pharma", "Achievement Unlocked"));
				}
				if(travelledInt >= 240000){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(39, CustomItem.createActiveItem(Items.unlockedAchievement, "Big Pharma", "Achievement Unlocked"));
				}
				if(travelledInt >= 480000){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(40, CustomItem.createActiveItem(Items.unlockedAchievement, "Marco Polo", "Achievement Unlocked"));
				}
				if(travelledInt >= 1450000){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(41, CustomItem.createActiveItem(Items.unlockedAchievement, "Vasco da Gama", "Achievement Unlocked"));
				}
				if(travelledInt >= 2900000){
					HashMaps.achievements_gui1.get(p.getUniqueId()).setItem(42, CustomItem.createActiveItem(Items.unlockedAchievement, "Neil Armstrong", "Achievement Unlocked"));
				}
				
				/////////////////////////////////////////////////////////////////////////////////////////////////////
				///[ACHIEVEMENTS MENU 2]/////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////////////////
				
				//create menu
				HashMaps.achievements_gui2.put(p.getUniqueId(), Bukkit.createInventory(null, 54, achievements_menu2));
				
				//add menu items
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(48, Items.previousPage);
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(49, Items.lobbyMenu);
				
				//TODO add player killed items
				int playersInt = Main.player.getInt("Players." + p.getName() + "." + "PlayerKilled");
				String playersString = String.valueOf(playersInt);
				
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(2, CustomItem.createInactiveItem(Items.lockedAchievement, "Napoleon", "Players Killed", playersString, "10"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(3, CustomItem.createInactiveItem(Items.lockedAchievement, "Julius Caesar", "Players Killed", playersString, "100"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(4, CustomItem.createInactiveItem(Items.lockedAchievement, "Genghis Khan", "Players Killed", playersString, "500"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(5, CustomItem.createInactiveItem(Items.lockedAchievement, "Alexander the Great", "Players Killed", playersString, "2500"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(6, CustomItem.createInactiveItem(Items.lockedAchievement, "Vlad the Impaler", "Players Killed", playersString, "5000"));
				
				if(playersInt >= 10){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(2, CustomItem.createActiveItem(Items.unlockedAchievement, "Napoleon", "Achievement Unlocked"));
				}
				if(playersInt >= 100){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(3, CustomItem.createActiveItem(Items.unlockedAchievement, "Julius Caesar", "Achievement Unlocked"));
				}
				if(playersInt >= 500){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(4, CustomItem.createActiveItem(Items.unlockedAchievement, "Genghis Khan", "Achievement Unlocked"));
				}
				if(playersInt >= 2500){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(5, CustomItem.createActiveItem(Items.unlockedAchievement, "Alexander the Great", "Achievement Unlocked"));
				}
				if(playersInt >= 5000){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(6, CustomItem.createActiveItem(Items.unlockedAchievement, "Vlad the Impaler", "Achievement Unlocked"));
				}
				
				//TODO add player craft items
				int craftInt = Main.player.getInt("Players." + p.getName() + "." + "CraftedItems");
				String craftString = String.valueOf(craftInt);
				
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(11, CustomItem.createInactiveItem(Items.lockedAchievement, "Rookie", "Total Crafted Items", craftString, "10"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(12, CustomItem.createInactiveItem(Items.lockedAchievement, "Alexander Bell", "Total Crafted Items", craftString, "100"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(13, CustomItem.createInactiveItem(Items.lockedAchievement, "Benjamin Franklin", "Total Crafted Items", craftString, "500"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(14, CustomItem.createInactiveItem(Items.lockedAchievement, "Henry Ford", "Total Crafted Items", craftString, "2500"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(15, CustomItem.createInactiveItem(Items.lockedAchievement, "Thomas Edison", "Total Crafted Items", craftString, "5000"));
				
				if(craftInt >= 10){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(11, CustomItem.createActiveItem(Items.unlockedAchievement, "Rookie", "Achievement Unlocked"));
				}
				if(craftInt >= 100){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(12, CustomItem.createActiveItem(Items.unlockedAchievement, "Alexander Bell", "Achievement Unlocked"));
				}
				if(craftInt >= 500){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(13, CustomItem.createActiveItem(Items.unlockedAchievement, "Benjamin Franklin", "Achievement Unlocked"));
				}
				if(craftInt >= 2500){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(14, CustomItem.createActiveItem(Items.unlockedAchievement, "Henry Ford", "Achievement Unlocked"));
				}
				if(craftInt >= 5000){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(15, CustomItem.createActiveItem(Items.unlockedAchievement, "Thomas Edison", "Achievement Unlocked"));
				}
				
				//TODO add player deaths items
				int deathInt = Main.player.getInt("Players." + p.getName() + "." + "Deaths");
				String deathString = String.valueOf(deathInt);
				
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(20, CustomItem.createInactiveItem(Items.lockedAchievement, "Bite the Dust", "Player Deaths", deathString, "5"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(21, CustomItem.createInactiveItem(Items.lockedAchievement, "Knock em Dead", "Player Deaths", deathString, "25"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(22, CustomItem.createInactiveItem(Items.lockedAchievement, "Your Number's Up", "Player Deaths", deathString, "100"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(23, CustomItem.createInactiveItem(Items.lockedAchievement, "Stairway to Heaven", "Player Deaths", deathString, "500"));
				HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(24, CustomItem.createInactiveItem(Items.lockedAchievement, "Meet Your Maker", "Player Deaths", deathString, "2500"));
				
				if(playersInt >= 5){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(20, CustomItem.createActiveItem(Items.unlockedAchievement, "Bite the Dust", "Achievement Unlocked"));
				}
				if(playersInt >= 25){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(21, CustomItem.createActiveItem(Items.unlockedAchievement, "Knock em Dead", "Achievement Unlocked"));
				}
				if(playersInt >= 100){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(22, CustomItem.createActiveItem(Items.unlockedAchievement, "Your Number's Up", "Achievement Unlocked"));
				}
				if(playersInt >= 500){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(23, CustomItem.createActiveItem(Items.unlockedAchievement, "Stairway to Heaven", "Achievement Unlocked"));
				}
				if(playersInt >= 2500){
					HashMaps.achievements_gui2.get(p.getUniqueId()).setItem(24, CustomItem.createActiveItem(Items.unlockedAchievement, "Meet Your Maker", "Achievement Unlocked"));
				}
				
			}
		}
	}
	
	

}

