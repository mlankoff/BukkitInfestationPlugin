package me.men8.infestation.time;

import me.men8.infestation.main.Main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Time {
	
	Main plugin;
	
	public Time(Main plugin){
		this.plugin = plugin;
	}
	
	/**
	 * Add played time to config
	 */
	public static void timeAdd(){
		for(World w : Bukkit.getWorlds()){
			for(Player p : w.getPlayers()){
				if((w.getPlayers()) != null){
//					Main.player.set("Players." + p.getName() + "." + "Time", Main.player.getInt("Players." + p.getName() + "." + "Time") + (int)60);
//					Main.player.saveConfig();
					
				}
			}
		}
	}
	
	/**
	 * Return Played time in 0w0d0h0m format
	 * @param p
	 * @return
	 */
	public static String getPlayedTime(Player p){
		String time = "";
		String unit = "";
		int sec = 0;
//		int sec = Main.player.getInt("Players." + p.getName() + "." + "Time");
		int t = 0;
		int[] time_system = new int[]{60*60*24*7, 60*60*24, 60*60, 60};
		
		for(int i=0; i<=3; i++){
			t = sec / time_system[i];
			sec -= t * time_system[i];
			switch(i){
				case 0:{
					unit = "w";
					break;
				}case 1:{
					unit = "d";
					break;
				}case 2:{
					unit = "h";
					break;
				}case 3:{
					unit = "m";
					break;
				}
			}
			time += t + unit;
		}
		return time;
	}

}
