package me.men8.infestation.config;

import me.men8.infestation.main.Main;

public class ServerConfig {
	
	Main plugin;
	
	public ServerConfig(Main plug){
		this.plugin = plug;
	}
	
	public static void createServerConfig(){
		
		//Version
		Main.config.set("Version." + "config_version", 1.0);
		
		//MySql connection data
		Main.config.set("MySql." + "ip", "127.0.0.1");
		Main.config.set("MySql." + "port", "3306");
		Main.config.set("MySql." + "database", "infestation");
		Main.config.set("MySql." + "login", "root");
		Main.config.set("MySql." + "password", "Stalingrad8");
		Main.config.set("MySql." + "table_name", "player_data");
		
		//Save config
		Main.config.saveConfig();
	}

}
