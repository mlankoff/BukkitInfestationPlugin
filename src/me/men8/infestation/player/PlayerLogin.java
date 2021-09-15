package me.men8.infestation.player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.men8.infestation.main.Main;
import me.men8.infestation.sql.MySQL;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class PlayerLogin implements Listener{
	
	Main plugin;
	
	public PlayerLogin(Main plug){
		this.plugin = plug;
	}
	
//	public static void fromDatabaseInt(Player p, String field, String path){
//		try {
////			String table = Main.config.getString("MySql." + "table_name");
//			PreparedStatement sql = Main.connection.prepareStatement("SELECT " + field + " From `" + table + "` WHERE uuid=?;");
//			sql.setString(1, p.getUniqueId().toString());
//			ResultSet result = sql.executeQuery();
//			result.next();
////			Main.player.set("Players." + p.getName() + "." + path, result.getInt(field));
//			sql.close();
//			result.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void fromDatabaseDouble(Player p, String field, String path){
//		try {
//			String table = Main.config.getString("MySql." + "table_name");
//			PreparedStatement sql = Main.connection.prepareStatement("SELECT " + field + " From `" + table + "` WHERE uuid=?;");
//			sql.setString(1, p.getUniqueId().toString());
//			ResultSet result = sql.executeQuery();
//			result.next();
//			Main.player.set("Players." + p.getName() + "." + path, result.getDouble(field));
//			sql.close();
//			result.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@EventHandler
//	public static void onLogin(PlayerLoginEvent e){
//		Player p = e.getPlayer();
//		MySQL.openConnection();
//		
//		try{
//			//check if player is in database
//			if(MySQL.playerDataContainsPlayer(p)){
//				
//				//get and set first login
//				fromDatabaseInt(p, "FirstJoin", "FirstJoin");
//				
//				//get and set exp
//				fromDatabaseInt(p, "Experience", "Exp");
//				
//				//get and set exp total
//				fromDatabaseInt(p, "ExpTotal", "ExpTotal");
//				
//				//get and set temperature
//				fromDatabaseDouble(p, "Temperature", "Temperature");
//				
//				//get and set thirst
//				fromDatabaseDouble(p, "Thirst", "Thirst");
//				
//				//get and set rads
//				fromDatabaseDouble(p, "Rads", "Rads");
//				
//				//get and set time
//				fromDatabaseInt(p, "TimePlayed", "Time");
//				
//				//get and set travel
//				fromDatabaseInt(p, "Travelled", "Travelled");
//				
//				//get and set players kill
//				fromDatabaseInt(p, "PlayersKilled", "PlayersKilled");
//				
//				//get and set mobs kill
//				fromDatabaseInt(p, "MobsKilled", "MobsKilled");
//				
//				//get and set bandage
//				fromDatabaseInt(p, "BandagesUsed", "BandagesUsed");
//				
//				//get and set leg
//				fromDatabaseInt(p, "BreakeLeg", "BreakeLeg");
//				
//				//get and set money flag
//				fromDatabaseInt(p, "MoneyFlag", "MoneyFlag");
//				
//				//get and set campfire
//				fromDatabaseInt(p, "Campfire", "Campfire");
//				
//				//get and set anomaly neutralized
//				fromDatabaseInt(p, "AnomalyNeutralized", "AnomalyNeutralized");
//				
//				//get and set anti rad
//				fromDatabaseInt(p, "AntiRad", "AntiRad");
//				
//				//get and set barbed wire
//				fromDatabaseInt(p, "BarbedWire", "BarbedWire");
//			}else{
//				//create player in database
//				String table = Main.config.getString("MySql." + "table_name");
//				PreparedStatement new_player = Main.connection.prepareStatement("INSERT INTO `" + table + "` values(?,?,1,0,0,100,100,0,0,0,0,0,0,0,0,0,0,0,0);");
//				new_player.setString(1, p.getName());
//				new_player.setString(2, p.getUniqueId().toString());
//				new_player.execute();
//				new_player.close();
//			}
//		}catch(Exception exc){
//			exc.printStackTrace();
//		}finally{
//			MySQL.closeConnection();
//		}
//	}
	
}
