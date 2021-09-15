package me.men8.infestation.money;

import me.men8.infestation.main.Main;
import me.men8.infestation.permissions.Permissions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MoneyAnouncer {
	
	public Main plugin;
	
	public MoneyAnouncer(Main plug){
		this.plugin = plug;
	}
	/**
	 * money chat anouncer
	 */
	public static void moneyAnouncer(){
		for(World w : Bukkit.getWorlds()){
			for(Player p : w.getPlayers()){
				if(w.getPlayers()!=null){
					if(!p.isOp()){
						if(p.hasPermission(Permissions.boost25)){
							p.sendMessage(ChatColor.YELLOW + "Server is running with" + ChatColor.RED 
									+ " 25% " + ChatColor.YELLOW + "money boost");
						}
						else if(p.hasPermission(Permissions.boost50)){
							p.sendMessage(ChatColor.YELLOW + "Server is running with" + ChatColor.RED 
									+ " 50% " + ChatColor.YELLOW + "money boost");
						}
						else if(p.hasPermission(Permissions.boost75)){
							p.sendMessage(ChatColor.YELLOW + "Server is running with" + ChatColor.RED 
									+ " 75% " + ChatColor.YELLOW + "money boost");
						}
						else if(p.hasPermission(Permissions.boost25)&&p.hasPermission(Permissions.boost50)){
							p.sendMessage(ChatColor.YELLOW + "Server is running with" + ChatColor.RED 
									+ " 75% " + ChatColor.YELLOW + "money boost");
						}
						else if(p.hasPermission(Permissions.boost25)&&p.hasPermission(Permissions.boost75)){
							p.sendMessage(ChatColor.YELLOW + "Server is running with" + ChatColor.RED 
									+ " 100% " + ChatColor.YELLOW + "money boost");
						}
						else if(p.hasPermission(Permissions.boost75)&&p.hasPermission(Permissions.boost50)){
							p.sendMessage(ChatColor.YELLOW + "Server is running with" + ChatColor.RED 
									+ " 125% " + ChatColor.YELLOW + "money boost");
						}
						else if(p.hasPermission(Permissions.boost75)&&p.hasPermission(Permissions.boost50)
								&&p.hasPermission(Permissions.boost25)){
							p.sendMessage(ChatColor.YELLOW + "Server is running with" + ChatColor.RED 
									+ " 150% " + ChatColor.YELLOW + "money boost");
						}
					}
				}
			}
		}
	}

}
