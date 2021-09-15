package me.men8.infestation.player;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.CustomItem;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Items;
import me.men8.infestation.misc.Materials;
import me.men8.infestation.permissions.Permissions;
import me.men8.infestation.scoreboard.CreateScoreboard;
import me.men8.infestation.config.PlayerConfig;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerJoin implements Listener{
	
	public Main plugin;
	
	public PlayerJoin(Main plug){
		this.plugin = plug;
	}
	/**
	 * Player join actions
	 * @param e
	 */
	@EventHandler
	public void playerJoin(PlayerJoinEvent e){
		//declare player
		Player p = e.getPlayer();
		
		if(p.getGameMode().equals(GameMode.SPECTATOR)){
			p.teleport(p.getWorld().getSpawnLocation().add(0, 3, 0));
			
			//set gamemode to adventure
			p.setGameMode(GameMode.ADVENTURE);
		}
		
		//add player to death location hashmap
		HashMaps.death.put(p.getUniqueId(), p.getLocation());
		
		//add player to respawn HashMap
		HashMaps.respawn.put(p.getUniqueId(), 20);
		
		//sets player inventory
		if(p.hasPermission(Permissions.strengthLvl1) && !p.hasPermission(Permissions.scavengingLvl2)){
			for(int i = 9 ; i <= 31 ; i++){
				p.getInventory().setItem(i, Items.blocked);
			}
		}
		if(p.hasPermission(Permissions.scavengingLvl2) && !p.hasPermission(Permissions.scavengingLvl3)){
			for(int i = 9 ; i <= 26 ; i++){
				p.getInventory().setItem(i, Items.blocked);
			}
		}
		if(p.hasPermission(Permissions.strengthLvl3) && !p.hasPermission(Permissions.strengthLvl4)){
			for(int i = 9 ; i <= 20 ; i++){
				p.getInventory().setItem(i, Items.blocked);
			}
		}
		if(p.hasPermission(Permissions.strengthLvl4) && !p.hasPermission(Permissions.scavengingLvl5)){
			for(int i = 9 ; i <= 13 ; i++){
				p.getInventory().setItem(i, Items.blocked);
			}
		}
		
		
		
		//create player data in config
//		if(!Main.player.contains("Players." + p.getName())){
//			PlayerConfig.createPlayerConfig(p);
//		}
		//put player in HashMaps
//		HashMaps.exp.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "Exp"));
//		HashMaps.check.put(p.getName(), 0);
//		HashMaps.radio.put(p.getName(), Main.player.getDouble("Players." + p.getName() + "." + "Rads"));
//		HashMaps.rads.put(p.getName(), 0);
//		HashMaps.thirst.put(p.getName(), (double) Main.player.getDouble("Players." + p.getName() + "." + "Thirst"));
//		HashMaps.temp.put(p.getName(), (double) Main.player.getDouble("Players." + p.getName() + "." + "Temperature"));
//		HashMaps.mob_kill.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "MobsKilled"));
//		HashMaps.player_kill.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "PlayerKilled"));
//		HashMaps.travel.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "Travelled"));
//		HashMaps.bandage_use.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "BandagesUsed"));
//		HashMaps.break_leg.put(p.getName(), Main.player.getInt("Players." + p.getName() + "." + "BreakeLeg"));
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
		HashMaps.gscore.get(p.getName()).setScore(13);
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
//		HashMaps.stop.put(p.getName(), 0);
//		if(Main.player.getInt("Players." + p.getName() + "." + "FirstJoin") == 0){
//			Main.player.set("Players." + p.getName() + "." + "FirstJoin", 1);
//			Main.player.saveConfig();
			p.getInventory().setItem(0, new ItemStack(Materials.arrow, 1, (short)0));
			p.getInventory().setItem(1, new ItemStack(Materials.cow_meat, 4, (short)0));
			p.getInventory().setItem(2, new ItemStack(Materials.bandage, 4, (short)0));
			p.getInventory().setItem(3, new ItemStack(Materials.lch, 1, (short)0));
			p.getInventory().setItem(7, new ItemStack(Materials.water_bottle, 1, (short)0));
			p.getInventory().setItem(8, new ItemStack(CustomItem.createPlayerHead(p)));
			p.updateInventory();
//		}
		//set visibility to player
//		p.setExp((float) 0.4);
		
	}
}
