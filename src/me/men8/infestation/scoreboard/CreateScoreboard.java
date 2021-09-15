package me.men8.infestation.scoreboard;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class CreateScoreboard {
	
	public Main plugin;
	
	public static Scoreboard board;
	public static Objective objective;
	public static Score TEMPERATURE, RADIATION, MONEY, GUILD, THIRST, sep, EXP;
	public static ScoreboardManager sm;
	
	public CreateScoreboard(Main plugin){
		this.plugin = plugin;
	}
	/**
	 * Better scoreboard create
	 */
	public static void createScoreboard(Player p) {
        sm = Bukkit.getScoreboardManager();
        board = sm.getNewScoreboard();
        objective = board.registerNewObjective(ChatColor.YELLOW + "MineLogic.com", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        
		GUILD = objective.getScore(ChatColor.YELLOW + "GUILD:");
		GUILD.setScore(14);
		
		sep = objective.getScore("----------------");
		sep.setScore(12);
		
		MONEY = objective.getScore(ChatColor.BLUE + "╔" + ChatColor.YELLOW + "MONEY:");
		MONEY.setScore(11);
		
		EXP = objective.getScore(ChatColor.DARK_PURPLE + "╔" + ChatColor.YELLOW + "EXP:");
		EXP.setScore(9);
		
		TEMPERATURE = objective.getScore("╔" + ChatColor.YELLOW + "TEMPERATURE:");
		TEMPERATURE.setScore(7);
		
		RADIATION = objective.getScore(ChatColor.RED + "╔" + ChatColor.YELLOW + "RADIATION:");
		RADIATION.setScore(5);
		
		THIRST = objective.getScore(ChatColor.GREEN + "╔" + ChatColor.YELLOW + "THIRST:");
		THIRST.setScore(3);
        
		//guild score
		if(!HashMaps.gscore.containsKey(p.getName())){
			HashMaps.gscore.put(p.getName(), objective.getScore("CHECKING GUILD"));
		}
		HashMaps.gscore.get(p.getName()).setScore(13);
		//money score
		if(!HashMaps.mscore.containsKey(p.getName())){
			HashMaps.mscore.put(p.getName(), objective.getScore("CHECKING MONEY"));
		}
		HashMaps.mscore.get(p.getName()).setScore(10);
		//exp score
		if(!HashMaps.expscore.containsKey(p.getName())){
			HashMaps.expscore.put(p.getName(), objective.getScore("CHECKING EXP"));
		}
		HashMaps.expscore.get(p.getName()).setScore(8);
		//temperature score
		if(!HashMaps.tscore.containsKey(p.getName())){
			HashMaps.tscore.put(p.getName(), objective.getScore("CHECKING TEMP"));
		}
		HashMaps.tscore.get(p.getName()).setScore(6);
		//radioactive score
		if(!HashMaps.rscore.containsKey(p.getName())){
			HashMaps.rscore.put(p.getName(), objective.getScore("CHECKING RADS"));
		}
		HashMaps.rscore.get(p.getName()).setScore(4);
		//thirst score
		if(!HashMaps.pscore.containsKey(p.getName())){
			HashMaps.pscore.put(p.getName(), objective.getScore("CHECKING H2O"));
		}
		HashMaps.pscore.get(p.getName()).setScore(2);
		//set scoreboard to player
        p.setScoreboard(board);
    }
}
