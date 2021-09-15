package me.men8.infestation.config;

import org.bukkit.entity.Player;

import me.men8.infestation.main.*;;

public class PlayerConfig {
	
	Main plugin;
	
	public PlayerConfig(Main plug){
		this.plugin = plug;
	}
	
	public static void createPlayerConfig(Player p){
		Main.player.set("Players." + p.getName() + "." + "FirstJoin", 0);
		Main.player.set("Players." + p.getName() + "." + "Exp", (int) 0);
		Main.player.set("Players." + p.getName() + "." + "ExpTotal", (int) 0);
		Main.player.set("Players." + p.getName() + "." + "Temperature", 100);
		Main.player.set("Players." + p.getName() + "." + "Thirst", 100);
		Main.player.set("Players." + p.getName() + "." + "Rads", (int) 0);
		Main.player.set("Players." + p.getName() + "." + "Time", 0);
		Main.player.set("Players." + p.getName() + "." + "Travelled", 0);
		Main.player.set("Players." + p.getName() + "." + "PlayersKilled", 0);
		Main.player.set("Players." + p.getName() + "." + "MobsKilled", 0);
		Main.player.set("Players." + p.getName() + "." + "BandagesUsed", 0);
		Main.player.set("Players." + p.getName() + "." + "MoneyFlag", 0);
		Main.player.set("Players." + p.getName() + "." + "CraftedItems", 0);
		Main.player.set("Players." + p.getName() + "." + "Deaths", 0);
		Main.player.saveConfig();
	}
}
