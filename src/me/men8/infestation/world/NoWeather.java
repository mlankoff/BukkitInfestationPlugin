package me.men8.infestation.world;

import me.men8.infestation.main.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class NoWeather implements Listener{
	
	Main plugin;
	
	public NoWeather(Main plug){
		this.plugin = plug;
	}
	
	@EventHandler
	public static void noWeather(WeatherChangeEvent e){
		e.setCancelled(true);
	}

}
