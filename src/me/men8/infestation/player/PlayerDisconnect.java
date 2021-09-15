package me.men8.infestation.player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import me.men8.infestation.main.Main;
import me.men8.infestation.sql.MySQL;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerDisconnect implements Listener{
	
	Main plugin;
	
	public PlayerDisconnect(Main plug){
		this.plugin = plug;
	}
	
//	private static void toDatabaseInt(Player p, String field, String path){
//		try {
////			String table = Main.config.getString("MySql." + "table_name");
////			PreparedStatement sql = Main.connection.prepareStatement("SELECT " + field + " From `" + table + "` WHERE uuid=?;");
//			sql.setString(1, p.getUniqueId().toString());
//			ResultSet sql_result = sql.executeQuery();
//			sql_result.next();
//			PreparedStatement sql_update = Main.connection.prepareStatement("UPDATE `" + table + "` SET " + field + "=? WHERE uuid=?;");
////			sql_update.setInt(1, Main.player.getInt("Players." + p.getName() + "." + path));
//			sql_update.setString(2, p.getUniqueId().toString());
//			sql_update.execute();
//			sql_update.close();
//			sql.close();
//			sql_result.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	private static void toDatabaseDouble(Player p, String field, String path){
//		try {
//			String table = Main.config.getString("MySql." + "table_name");
//			PreparedStatement sql = Main.connection.prepareStatement("SELECT ROUND(" + field + ",2) From `" + table + "` WHERE uuid=?;");
//			sql.setString(1, p.getUniqueId().toString());
//			ResultSet sql_result = sql.executeQuery();
//			sql_result.next();
//			PreparedStatement sql_update = Main.connection.prepareStatement("UPDATE `" + table + "` SET " + field + "=ROUND(?,2) WHERE uuid=?;");
//			sql_update.setDouble(1, Main.player.getDouble("Players." + p.getName() + "." + path));
//			sql_update.setString(2, p.getUniqueId().toString());
//			sql_update.execute();
//			sql_update.close();
//			sql.close();
//			sql_result.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
	
	/**
	 * put player data to database
	 * @param e
	 */
	@EventHandler
	public static void onDisconnect(PlayerQuitEvent e){
		Player p = e.getPlayer();
		MySQL.openConnection();
		
//		try{
//			//check if player is in database
//			if(MySQL.playerDataContainsPlayer(p)){
//				
//				//get and set experience field
//				toDatabaseInt(p, "Experience", "Exp");
//				
//				//get and set exp total field
//				toDatabaseInt(p, "ExpTotal", "ExpTotal");
//				
//				//get and set temperature field
//				toDatabaseDouble(p, "Temperature", "Temperature");
//				
//				//get and set thirst field
//				toDatabaseDouble(p, "Thirst", "Thirst");
//				
//				//get and set rads field
//				toDatabaseDouble(p, "Rads", "Rads");
//				
//				//get and set time field
//				toDatabaseInt(p, "TimePlayed", "Time");
//				
//				//get and set travelled field
//				toDatabaseInt(p, "Travelled", "Travelled");
//				
//				//get and set players killed field
//				toDatabaseInt(p, "PlayersKilled", "PlayersKilled");
//				
//				//get and set mobs killed field
//				toDatabaseInt(p, "MobsKilled", "MobsKilled");
//				
//				//get and set bandages field
//				toDatabaseInt(p, "BandagesUsed", "BandagesUsed");
//				
//				//get and set break leg field
//				toDatabaseInt(p, "BreakeLeg", "BreakeLeg");
//				
//				//get and set money flag field
//				toDatabaseInt(p, "MoneyFlag", "MoneyFlag");
//				
//				//get and set campfire field
//				toDatabaseInt(p, "Campfire", "Campfire");
//				
//				//get and set anomaly neutralized field
//				toDatabaseInt(p, "AnomalyNeutralized", "AnomalyNeutralized");
//				
//				//get and set anti rad field
//				toDatabaseInt(p, "AntiRad", "AntiRad");
//				
//				//get and set barbed wire field
//				toDatabaseInt(p, "BarbedWire", "BarbedWire");
//			}
//		}catch(Exception exc){
//			exc.printStackTrace();
//		}finally{
//			MySQL.closeConnection();
//		}
	}
	

}
