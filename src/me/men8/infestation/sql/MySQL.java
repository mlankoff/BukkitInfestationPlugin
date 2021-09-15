package me.men8.infestation.sql;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class MySQL {
	
	static Main plugin;
	private static String ip = plugin.getConfig().getString("ip");
	private static String port = plugin.getConfig().getString("port");
	private static String database = plugin.getConfig().getString("database");
	private static String login = plugin.getConfig().getString("login");
	private static String password = plugin.getConfig().getString("password");
	private static String table = plugin.getConfig().getString("table");
	
	public MySQL(Main plug){
		plugin = plug;
	}

	/**
	 * close connection with database
	 */
	public synchronized static void closeConnection(){
		try {
			Main.connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * open connection with database
	 */
	public synchronized static void openConnection(){
		try {
			Main.connection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database + "?useSSL=false", login, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * check if player is in database
	 * @param p
	 * @return
	 */
	public synchronized static boolean playerDataContainsPlayer(Player p){
		try {
			PreparedStatement sql = Main.connection.prepareStatement("SELECT * FROM `" + table + "` WHERE uuid=?;");
			sql.setString(1, p.getUniqueId().toString());
			ResultSet resultSet = sql.executeQuery();
			boolean containsPlayer = resultSet.next();
			sql.close();
			resultSet.close();
			return containsPlayer;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private static void toDatabaseInt(Player p, String field, int value){
		try {
			PreparedStatement sql = Main.connection.prepareStatement("SELECT " + field + " From `" + table + "` WHERE uuid=?;");
			sql.setString(1, p.getUniqueId().toString());
			ResultSet sql_result = sql.executeQuery();
			sql_result.next();
			PreparedStatement sql_update = Main.connection.prepareStatement("UPDATE `" + table + "` SET " + field + "=? WHERE uuid=?;");
			sql_update.setInt(1, value);
			sql_update.setString(2, p.getUniqueId().toString());
			sql_update.execute();
			sql_update.close();
			sql.close();
			sql_result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void toDatabaseDouble(Player p, String field, double value){
		try {
			PreparedStatement sql = Main.connection.prepareStatement("SELECT ROUND(" + field + ",2) From `" + table + "` WHERE uuid=?;");
			sql.setString(1, p.getUniqueId().toString());
			ResultSet sql_result = sql.executeQuery();
			sql_result.next();
			PreparedStatement sql_update = Main.connection.prepareStatement("UPDATE `" + table + "` SET " + field + "=ROUND(?,2) WHERE uuid=?;");
			sql_update.setDouble(1, value);
			sql_update.setString(2, p.getUniqueId().toString());
			sql_update.execute();
			sql_update.close();
			sql.close();
			sql_result.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void createTable(){
		openConnection();
		Statement statement;
		try {
			statement = Main.connection.createStatement();
			String sql = "CREATE TABLE REGISTRATION " +
	                   "(id INTEGER not NULL, " +
	                   " first VARCHAR(255), " + 
	                   " last VARCHAR(255), " + 
	                   " age INTEGER, " + 
	                   " PRIMARY KEY ( id ))"; 
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void updateSql(){
		for(World w : Bukkit.getWorlds()){
			for(Player p : w.getPlayers()){
				if(w.getPlayers() != null){
					MySQL.openConnection();
					
					try{
						//check if player is in database
						if(MySQL.playerDataContainsPlayer(p)){
							
							//get and set experience field
							toDatabaseInt(p, "Experience", HashMaps.exp.get(p.getName()));
							
							//get and set exp total field
//							toDatabaseInt(p, "ExpTotal", HashMaps.e);
							
							//get and set temperature field
//							toDatabaseDouble(p, "Temperature", "Temperature");
							
							//get and set thirst field
//							toDatabaseDouble(p, "Thirst", "Thirst");
							
							//get and set rads field
//							toDatabaseDouble(p, "Rads", "Rads");
							
							//get and set time field
//							toDatabaseInt(p, "TimePlayed", "Time");
							
							//get and set travelled field
//							toDatabaseInt(p, "Travelled", "Travelled");
							
							//get and set players killed field
//							toDatabaseInt(p, "PlayersKilled", "PlayersKilled");
							
							//get and set mobs killed field
//							toDatabaseInt(p, "MobsKilled", "MobsKilled");
							
							//get and set bandages field
//							toDatabaseInt(p, "BandagesUsed", "BandagesUsed");
							
							//get and set break leg field
//							toDatabaseInt(p, "BreakeLeg", "BreakeLeg");
							
							//get and set money flag field
//							toDatabaseInt(p, "MoneyFlag", "MoneyFlag");
							
							//get and set campfire field
//							toDatabaseInt(p, "Campfire", "Campfire");
							
							//get and set anomaly neutralized field
//							toDatabaseInt(p, "AnomalyNeutralized", "AnomalyNeutralized");
							
							//get and set anti rad field
//							toDatabaseInt(p, "AntiRad", "AntiRad");
							
							//get and set barbed wire field
//							toDatabaseInt(p, "BarbedWire", "BarbedWire");
						}
					}catch(Exception exc){
						exc.printStackTrace();
					}finally{
						MySQL.closeConnection();
					}
				}
			}
		}
	}

}
