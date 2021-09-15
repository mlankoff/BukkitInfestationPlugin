package me.men8.infestation.zombie;

import me.men8.infestation.main.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffectType;

public class Visibility implements Listener{
	
	Main plugin;
	
	public Visibility(Main plug){
		this.plugin = plug;
	}
	
	public static void visibility(){
		for(World w : Bukkit.getWorlds()){
			for(Player p : w.getPlayers()){
				if(w.getPlayers() != null){
					if(p.isSneaking()){
						p.setExp((float) 0.15);
					}else if(p.isSprinting()){
						p.setExp((float) 0.75);
					}else if(!p.isSneaking()&&!p.isSprinting()){
						p.setExp((float) 0.4);
					}
					if(p.hasPotionEffect(PotionEffectType.POISON)){
						p.setExp((float) 1);
					}
				}
			}
		}
	}
}
