package me.men8.infestation.scoreboard;

import me.men8.economy.main.Economy;
import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class UpdateScoreboard {

	Main plugin;
	
	public static Scoreboard board;
	public static Objective objective;
	public static Score TEMPERATURE, RADIATION, MONEY, GUILD, THIRST, sep, EXP;
	public static ScoreboardManager sm;
	
	public UpdateScoreboard(Main plug){
		this.plugin = plug;
	}
	
	public static void updateScoreboard(Player p) {
		if(p != null){
			try{
				if(p.getScoreboard() != null) {
		            board = p.getScoreboard();
		            objective = board.getObjective(DisplaySlot.SIDEBAR);
		            
		            //exp score
		    		if(!HashMaps.expscore.containsKey(p.getName())){
		    			HashMaps.expscore.put(p.getName(), objective.getScore("CHECKING EXP"));
		    		}
		    		HashMaps.expscore.get(p.getName()).setScore(8);
		            
		            if(HashMaps.expscore.get(p.getName()).getScore()==8){
						board.resetScores(HashMaps.expscore.get(p.getName()).getEntry());
						HashMaps.expscore.put(p.getName(), objective.getScore(ChatColor.DARK_PURPLE + "╚ " + ChatColor.WHITE + HashMaps.exp.get(p.getName())));
						HashMaps.expscore.get(p.getName()).setScore(8);
					}
		            
		          //money score
            		if(!HashMaps.mscore.containsKey(p.getName())){
            			HashMaps.mscore.put(p.getName(), objective.getScore("CHECKING MONEY"));
            		}
            		HashMaps.mscore.get(p.getName()).setScore(10);
                    
                    if(HashMaps.mscore.get(p.getName()).getScore()==10){
        				board.resetScores(HashMaps.mscore.get(p.getName()).getEntry());
        				HashMaps.mscore.put(p.getName(), objective.getScore(ChatColor.BLUE + "╚ " + ChatColor.WHITE + Economy.getBalance(p) + ChatColor.GREEN + "$"));
        				HashMaps.mscore.get(p.getName()).setScore(10);
        			}
                    
                    //radioactive score
		    		if(!HashMaps.rscore.containsKey(p.getName())){
		    			HashMaps.rscore.put(p.getName(), objective.getScore("CHECKING RADS"));
		    		}
		    		HashMaps.rscore.get(p.getName()).setScore(4);
		            
//		            if(HashMaps.rscore.get(p.getName()).getScore()==4){
//						board.resetScores(HashMaps.rscore.get(p.getName()).getEntry());
//						if(HashMaps.radio.get(p.getName()) == 0){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.GRAY + "██████████"));
//						}else if(HashMaps.radio.get(p.getName()) <= 10){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.GREEN + "█" + ChatColor.GRAY + "█████████"));
//						}else if(HashMaps.radio.get(p.getName()) > 10 && HashMaps.radio.get(p.getName()) <= 20){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.GREEN + "██" + ChatColor.GRAY + "████████"));
//						}else if(HashMaps.radio.get(p.getName()) > 20 && HashMaps.radio.get(p.getName()) <= 30){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.GREEN + "███" + ChatColor.GRAY + "███████"));
//						}else if(HashMaps.radio.get(p.getName()) > 30 && HashMaps.radio.get(p.getName()) <= 40){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.YELLOW + "████" + ChatColor.GRAY + "██████"));
//						}else if(HashMaps.radio.get(p.getName()) > 40 && HashMaps.radio.get(p.getName()) <= 50){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.YELLOW + "█████" + ChatColor.GRAY + "█████"));
//						}else if(HashMaps.radio.get(p.getName()) > 50 && HashMaps.radio.get(p.getName()) <= 60){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.YELLOW + "██████" + ChatColor.GRAY + "████"));
//						}else if(HashMaps.radio.get(p.getName()) > 60 && HashMaps.radio.get(p.getName()) <= 70){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.YELLOW + "███████" + ChatColor.GRAY + "███"));
//						}else if(HashMaps.radio.get(p.getName()) > 70 && HashMaps.radio.get(p.getName()) <= 80){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.RED + "████████" + ChatColor.GRAY + "██"));
//						}else if(HashMaps.radio.get(p.getName()) > 80 && HashMaps.radio.get(p.getName()) <= 90){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.RED + "█████████" + ChatColor.GRAY + "█"));
//						}else if(HashMaps.radio.get(p.getName()) > 90){
//							HashMaps.rscore.put(p.getName(), objective.getScore(ChatColor.RED + "╚ " + ChatColor.RED + "██████████"));
//						}
//						HashMaps.rscore.get(p.getName()).setScore(4);
//					}
		            
		          //temperature score
		    		if(!HashMaps.tscore.containsKey(p.getName())){
		    			HashMaps.tscore.put(p.getName(), objective.getScore("CHECKING TEMP"));
		    		}
		    		HashMaps.tscore.get(p.getName()).setScore(6);
		            
		            if(HashMaps.tscore.get(p.getName()).getScore()==6){
						board.resetScores(HashMaps.tscore.get(p.getName()).getEntry());
						if(HashMaps.temp.get(p.getName()) <= 10){
							HashMaps.tscore.put(p.getName(), objective.getScore("╚ " + ChatColor.RED + "█" + ChatColor.GRAY + "█████████"));
						}else if(HashMaps.temp.get(p.getName()) > 10 && HashMaps.temp.get(p.getName()) <= 20){
							HashMaps.tscore.put(p.getName(), objective.getScore("╚ " + ChatColor.RED + "██" + ChatColor.GRAY + "████████"));
						}else if(HashMaps.temp.get(p.getName()) > 20 && HashMaps.temp.get(p.getName()) <= 30){
							HashMaps.tscore.put(p.getName(), objective.getScore("╚ " + ChatColor.RED + "███" + ChatColor.GRAY + "███████"));
						}else if(HashMaps.temp.get(p.getName()) > 30 && HashMaps.temp.get(p.getName()) <= 40){
							HashMaps.tscore.put(p.getName(), objective.getScore("╚ " + ChatColor.YELLOW + "████" + ChatColor.GRAY + "██████"));
						}else if(HashMaps.temp.get(p.getName()) > 40 && HashMaps.temp.get(p.getName()) <= 50){
							HashMaps.tscore.put(p.getName(), objective.getScore("╚ " + ChatColor.YELLOW + "█████" + ChatColor.GRAY + "█████"));
						}else if(HashMaps.temp.get(p.getName()) > 50 && HashMaps.temp.get(p.getName()) <= 60){
							HashMaps.tscore.put(p.getName(), objective.getScore("╚ " + ChatColor.YELLOW + "██████" + ChatColor.GRAY + "████"));
						}else if(HashMaps.temp.get(p.getName()) > 60 && HashMaps.temp.get(p.getName()) <= 70){
							HashMaps.tscore.put(p.getName(), objective.getScore("╚ " + ChatColor.YELLOW + "███████" + ChatColor.GRAY + "███"));
						}else if(HashMaps.temp.get(p.getName()) > 70 && HashMaps.temp.get(p.getName()) <= 80){
							HashMaps.tscore.put(p.getName(), objective.getScore("╚ " + ChatColor.GREEN + "████████" + ChatColor.GRAY + "██"));
						}else if(HashMaps.temp.get(p.getName()) > 80 && HashMaps.temp.get(p.getName()) <= 90){
							HashMaps.tscore.put(p.getName(), objective.getScore("╚ " + ChatColor.GREEN + "█████████" + ChatColor.GRAY + "█"));
						}else if(HashMaps.temp.get(p.getName()) > 90){
							HashMaps.tscore.put(p.getName(), objective.getScore("╚ " + ChatColor.GREEN + "██████████"));
						}
						HashMaps.tscore.get(p.getName()).setScore(6);
					}
		            
		            //thirst score
		    		if(!HashMaps.pscore.containsKey(p.getName())){
		    			HashMaps.pscore.put(p.getName(), objective.getScore("CHECKING H2O"));
		    		}
		    		HashMaps.pscore.get(p.getName()).setScore(2);
		            
		            if(HashMaps.pscore.get(p.getName()).getScore()==2){
						board.resetScores(HashMaps.pscore.get(p.getName()).getEntry());
						if(HashMaps.thirst.get(p.getName()) == 0){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.GRAY + "██████████"));
						}else if(HashMaps.thirst.get(p.getName()) <= 10){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.RED + "█" + ChatColor.GRAY + "█████████"));
						}else if(HashMaps.thirst.get(p.getName()) > 10 && HashMaps.thirst.get(p.getName()) <= 20){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.RED + "██" + ChatColor.GRAY + "████████"));
						}else if(HashMaps.thirst.get(p.getName()) > 20 && HashMaps.thirst.get(p.getName()) <= 30){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.RED + "███" + ChatColor.GRAY + "███████"));
						}else if(HashMaps.thirst.get(p.getName()) > 30 && HashMaps.thirst.get(p.getName()) <= 40){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.YELLOW + "████" + ChatColor.GRAY + "██████"));
						}else if(HashMaps.thirst.get(p.getName()) > 40 && HashMaps.thirst.get(p.getName()) <= 50){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.YELLOW + "█████" + ChatColor.GRAY + "█████"));
						}else if(HashMaps.thirst.get(p.getName()) > 50 && HashMaps.thirst.get(p.getName()) <= 60){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.YELLOW + "██████" + ChatColor.GRAY + "████"));
						}else if(HashMaps.thirst.get(p.getName()) > 60 && HashMaps.thirst.get(p.getName()) <= 70){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.YELLOW + "███████" + ChatColor.GRAY + "███"));
						}else if(HashMaps.thirst.get(p.getName()) > 70 && HashMaps.thirst.get(p.getName()) <= 80){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.GREEN + "████████" + ChatColor.GRAY + "██"));
						}else if(HashMaps.thirst.get(p.getName()) > 80 && HashMaps.thirst.get(p.getName()) <= 90){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.GREEN + "█████████" + ChatColor.GRAY + "█"));
						}else if(HashMaps.thirst.get(p.getName()) > 90){
							HashMaps.pscore.put(p.getName(), objective.getScore(ChatColor.GREEN + "╚ " + ChatColor.GREEN + "██████████"));
						}
						HashMaps.pscore.get(p.getName()).setScore(2);
		            }
		        }else{
		        	if(p != null){
		        		CreateScoreboard.createScoreboard(p);
		        	}
		        }
			}catch(NullPointerException e){
				
			}
			
		}
        
    }
	
}
