package me.men8.infestation.main;

import me.men8.infestation.config.PlayerConfig;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.permissions.Permissions;
import me.men8.infestation.scoreboard.CreateScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Reload {
	
	Main plugin;
	
	public Reload(Main plug){
		this.plugin = plug;
	}
	/**
	 * load scoreboard on reload
	 */
	public static void onReload(){
		
		for(World w : Bukkit.getWorlds()){
			w.setGameRuleValue("doFireTick", "false");
			w.setGameRuleValue("doDaylightCycle", "false");
		}
		
		for(World w : Bukkit.getWorlds()){
			for(Player p : w.getPlayers()){
				if(w.getPlayers() != null){
					
					//add player to respawn HashMap
					HashMaps.respawn.put(p.getUniqueId(), 20);
					
					//sets player health
					if(p.hasPermission(Permissions.healthLvl1)){
						p.setHealthScale(12);
					}
					if(p.hasPermission(Permissions.healthLvl2)){
						p.setHealthScale(14);
					}
					if(p.hasPermission(Permissions.healthLvl3)){
						p.setHealthScale(16);
					}
					if(p.hasPermission(Permissions.healthLvl4)){
						p.setHealthScale(18);
					}
					if(p.hasPermission(Permissions.healthLvl5)){
						p.setHealthScale(20);
					}
					//create player data in config
					if(!Main.player.contains("Players." + p.getName())){
						PlayerConfig.createPlayerConfig(p);
					}
					//put player in HashMaps
					HashMaps.exp.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "Exp"));
					HashMaps.check.put(p.getName(), 0);
					HashMaps.radio.put(p.getName(), Main.player.getDouble("Players." + p.getName() + "." + "Rads"));
					HashMaps.rads.put(p.getName(), 0);
					HashMaps.thirst.put(p.getName(), (double) Main.player.getDouble("Players." + p.getName() + "." + "Thirst"));
					HashMaps.temp.put(p.getName(), (double) Main.player.getDouble("Players." + p.getName() + "." + "Temperature"));
					HashMaps.mob_kill.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "MobsKilled"));
					HashMaps.player_kill.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "PlayerKilled"));
					HashMaps.travel.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "Travelled"));
					HashMaps.bandage_use.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "BandagesUsed"));
					HashMaps.break_leg.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "BreakeLeg"));
					//create scoreboard
					CreateScoreboard.createScoreboard(p);
					//add scores to scoreboard
					//exp score
					if(!HashMaps.expscore.containsKey(p.getName())){
						HashMaps.expscore.put(p.getName(), CreateScoreboard.objective.getScore("CHECKING EXP"));
					}
					HashMaps.expscore.get(p.getName()).setScore(6);
					//guild score
					if(!HashMaps.gscore.containsKey(p.getName())){
						HashMaps.gscore.put(p.getName(), CreateScoreboard.objective.getScore("CHECKING GUILD"));
					}
					HashMaps.gscore.get(p.getName()).setScore(11);
					//money score
					if(!HashMaps.mscore.containsKey(p.getName())){
						HashMaps.mscore.put(p.getName(), CreateScoreboard.objective.getScore("CHECKING MONEY"));
					}
					HashMaps.mscore.get(p.getName()).setScore(8);
					//radioactive score
					if(!HashMaps.rscore.containsKey(p.getName())){
						HashMaps.rscore.put(p.getName(), CreateScoreboard.objective.getScore("CHECKING RADS"));
					}
					HashMaps.rscore.get(p.getName()).setScore(2);
					//thirst score
					if(!HashMaps.pscore.containsKey(p.getName())){
						HashMaps.pscore.put(p.getName(), CreateScoreboard.objective.getScore("CHECKING H2O"));
					}
					HashMaps.pscore.get(p.getName()).setScore(0);
					//temperature score
					if(!HashMaps.tscore.containsKey(p.getName())){
						HashMaps.tscore.put(p.getName(), CreateScoreboard.objective.getScore("CHECKING TEMP"));
					}
					HashMaps.tscore.get(p.getName()).setScore(4);
					//campfire limit
					HashMaps.stop.put(p.getName(), 0);
					
//					SetupEconomy.setupEconomy();
					CreateScoreboard.createScoreboard(p);
				}
			}
		}
	}

}
