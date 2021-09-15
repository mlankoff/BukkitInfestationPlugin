package me.men8.infestation.commands;

import me.men8.infestation.main.Main;
import me.men8.infestation.permissions.Permissions;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Infestation implements CommandExecutor {
	
@SuppressWarnings("unused")
private Main plugin;
	
	public Infestation(Main plug){
		this.plugin = plug;
	}
	/**
	 * List of all commands
	 */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args){
		Player p = (Player)sender;
		
		if(cmd.getName().equalsIgnoreCase("infestation")){
			if(p.hasPermission(Permissions.admin)){
				/**
				 * infestation help
				 */
				if(args.length == 0){
					Bukkit.dispatchCommand((CommandSender)Bukkit.getServer().getConsoleSender(), "minecraft:recipe give " + p.getName() + " *");
					p.sendMessage(ChatColor.GREEN + "/infestation"         + ChatColor.YELLOW + " - lista komend");
					p.sendMessage(ChatColor.GREEN + "/infestation anounce" + ChatColor.YELLOW + " - pokazuje boost w formie tytulu");
				}else if(args.length==1){
					/**
					 * Boost announcer
					 */
					if(args[0].equalsIgnoreCase("anounce")){
						if(p.hasPermission(Permissions.boost25)){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tm bc " + ChatColor.GOLD 
									+ "WoooHooo<nl>" + ChatColor.RED + "25% " + ChatColor.GREEN + "money boost");
						}else if(p.hasPermission(Permissions.boost50)){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tm bc " + ChatColor.GOLD 
									+ "WoooHooo<nl>" + ChatColor.RED + "50% " + ChatColor.GREEN + "money boost");
						}else if(p.hasPermission(Permissions.boost75)){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tm bc " + ChatColor.GOLD 
									+ "WoooHooo<nl>" + ChatColor.RED + "75% " + ChatColor.GREEN + "money boost");
						}else if(p.hasPermission(Permissions.boost25) && p.hasPermission(Permissions.boost50)){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tm bc " + ChatColor.GOLD 
									+ "WoooHooo<nl>" + ChatColor.RED + "75% " + ChatColor.GREEN + "money boost");
						}else if(p.hasPermission(Permissions.boost25) && p.hasPermission(Permissions.boost75)){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tm bc " + ChatColor.GOLD 
									+ "WoooHooo<nl>" + ChatColor.RED + "100% " + ChatColor.GREEN + "money boost");
						}else if(p.hasPermission(Permissions.boost50) && p.hasPermission(Permissions.boost75)){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tm bc " + ChatColor.GOLD 
									+ "WoooHooo<nl>" + ChatColor.RED + "125% " + ChatColor.GREEN + "money boost");
						}else if(p.hasPermission(Permissions.boost25) && p.hasPermission(Permissions.boost50) 
								&& p.hasPermission(Permissions.boost75)){
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tm bc " + ChatColor.GOLD 
									+ "WoooHooo<nl>" + ChatColor.RED + "150% " + ChatColor.GREEN + "money boost");
						}
					}
				}
			}else{
				p.sendMessage(ChatColor.RED + "You don't have permission to do that!");
			}
		}
		return true;
	}
	

}
