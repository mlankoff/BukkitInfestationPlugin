package me.men8.infestation.money;


import me.men8.economy.main.Economy;
import me.men8.infestation.main.Main;
import me.men8.infestation.scoreboard.*;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MoneyUpdate {
	
	public Main plugin;
	public static int achievement_flaga;
	
	public MoneyUpdate(Main plug){
		this.plugin = plug;
	}
	/**
	 * update money in scoreboard
	 */
	public static void moneyUpdateScoreboard(){
		for(World w : Bukkit.getWorlds()){
			for(Player p : w.getPlayers()){
				UpdateScoreboard.updateScoreboard(p);
				achievement_flaga = Main.player.getInt("Players." + p.getName() + "." + "MoneyFlag");
				if(achievement_flaga == 0 && Economy.getBalance(p) >= 700){
					Main.player.set("Players." + p.getName() + "." + "MoneyFlag", 1);
					Main.player.saveConfig();
				}
				if(achievement_flaga == 1 && Economy.getBalance(p) >= 3450){
					Main.player.set("Players." + p.getName() + "." + "MoneyFlag", 2);
					Main.player.saveConfig();
				}
				if(achievement_flaga == 2 && Economy.getBalance(p) >= 6900){
					Main.player.set("Players." + p.getName() + "." + "MoneyFlag", 3);
					Main.player.saveConfig();
				}
				if(achievement_flaga == 3 && Economy.getBalance(p) >= 20700){
					Main.player.set("Players." + p.getName() + "." + "MoneyFlag", 4);
					Main.player.saveConfig();
				}
				if(achievement_flaga == 4 && Economy.getBalance(p) >= 41500){
					Main.player.set("Players." + p.getName() + "." + "MoneyFlag", 5);
					Main.player.saveConfig();
				}
				if(achievement_flaga == 5 && Economy.getBalance(p) >= 62000){
					Main.player.set("Players." + p.getName() + "." + "MoneyFlag", 6);
					Main.player.saveConfig();
				}
				if(achievement_flaga == 6 && Economy.getBalance(p) >= 90000){
					Main.player.set("Players." + p.getName() + "." + "MoneyFlag", 7);
					Main.player.saveConfig();
				}
			}
		}
	}

}
