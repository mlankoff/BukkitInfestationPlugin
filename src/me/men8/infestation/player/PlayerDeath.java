package me.men8.infestation.player;

import io.puharesource.mc.titlemanager.api.TitleObject;
import io.puharesource.mc.titlemanager.api.TitleObject.TitleType;
import me.men8.infestation.main.Main;
import me.men8.infestation.misc.HashMaps;
import me.men8.infestation.misc.Materials;
import me.men8.infestation.scoreboard.UpdateScoreboard;
import net.minecraft.server.v1_12_R1.PacketPlayInClientCommand;
import net.minecraft.server.v1_12_R1.PacketPlayInClientCommand.EnumClientCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerDeath implements Listener{
	
	static Main plugin;
	private static int task1;
	
	@SuppressWarnings("static-access")
	public PlayerDeath(Main plug){
		this.plugin = plug;
	}
	
	public static void timer(final Player p){
		task1 = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable(){
			public void run(){
				sendTitleRespawn(p, ChatColor.GOLD + "Respawning in... " + ChatColor.RED + "" + HashMaps.respawn.get(p.getUniqueId()), 1, 40, 80);
				if(HashMaps.respawn.get(p.getUniqueId()) == 0){
					p.teleport(p.getWorld().getSpawnLocation().add(0, 3, 0));
					p.setGameMode(GameMode.ADVENTURE);
					Bukkit.getScheduler().cancelTask(task1);
					HashMaps.respawn.put(p.getUniqueId(), 20);
					int x = (int)HashMaps.death.get(p.getUniqueId()).getX();
					int y = (int)HashMaps.death.get(p.getUniqueId()).getY();
					int z = (int)HashMaps.death.get(p.getUniqueId()).getZ();
					//tell player where is his grave at
					sendTitle(p, ChatColor.YELLOW + "Your grave is at", 
							ChatColor.YELLOW + "X:" + ChatColor.RED + x + ChatColor.YELLOW + " Y: " 
									+ ChatColor.RED + y + ChatColor.YELLOW + " Z: " + ChatColor.RED + z);
				}
				HashMaps.respawn.put(p.getUniqueId(), HashMaps.respawn.get(p.getUniqueId()) - (int) 1);
			}
		},0L, 20L);
	  }
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void playerDeath(PlayerDeathEvent e){
		//declare player
		Player p = (Player) e.getEntity();
		
		//clear exp from player
		e.setDroppedExp(0);
		
		//create grave
		double x = HashMaps.death.get(p.getUniqueId()).getX();
    	double y = HashMaps.death.get(p.getUniqueId()).getY();
    	double z = HashMaps.death.get(p.getUniqueId()).getZ();
    	World w = p.getWorld();
    	final Location grave = new Location(w,x,y-1,z);
    	final Location loot = new Location(w,x,y,z);
    	final Material old = grave.getBlock().getType();
        Block chestBlock = e.getEntity().getWorld().getBlockAt(loot);
        chestBlock.setType(Materials.grave);
        Block graveBlock = e.getEntity().getWorld().getBlockAt(grave);
        graveBlock.setType(Materials.cross);
        final Chest chest = (Chest) chestBlock.getState();
        
        for(ItemStack drop: e.getDrops()){
        	if(!drop.getType().equals(Materials.openMainMenu)&&!drop.getType().equals(Materials.water_bottle)
        			&&!drop.getType().equals(Materials.bandage)&&!drop.getType().equals(Materials.lch)
        			&&!drop.getType().equals(Materials.ich)&&!drop.getType().equals(Materials.gch)
        			&&!drop.getType().equals(Materials.dch)&&!drop.getType().equals(Materials.screw)
        			&&!drop.getType().equals(Materials.cow_meat)&&!drop.getType().equals(Materials.log)
        			&&!drop.getType().equals(Materials.log2)){
        		chest.getInventory().addItem(drop);
        	}
        }
        e.getDrops().clear();
		
        //death runnable
		Bukkit.getScheduler().runTaskLater(plugin, new BukkitRunnable() {
			public void run(){
				Location ploc = p.getLocation();
				PacketPlayInClientCommand packet = new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN);
				((CraftPlayer)p).getHandle().playerConnection.a(packet);
				p.teleport(ploc, TeleportCause.SPECTATE);
				p.setGameMode(GameMode.SPECTATOR);
				UpdateScoreboard.updateScoreboard(p);
				p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 5));
			}
		}, 2L);
		
		//set counter to teleport player to spawn
		timer(p);
		
		//clear inventory
		p.getInventory().clear();
		
		//radiation
//		HashMaps.radio.put(p.getName(), (double) 0);
		UpdateScoreboard.updateScoreboard(p);
		HashMaps.death.put(p.getUniqueId(), p.getLocation());
		
		//remove grave and set blocks to previous state
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable(){
        	public void run(){
        		chest.getBlockInventory().clear();
        		loot.getBlock().setType(Materials.air);
        		grave.getBlock().setType(old);
        		//tell player that his grave just disappear
        		
        	}
        }, (5*60)*20);
		
	}
	
	public static void sendTitle(Player p, String title, String subtitle) {
		  new TitleObject(title, subtitle).send(p);
	}
	
	public static void sendTitleRespawn(Player player, String title, int fadeIn, int stay, int fadeOut) {
		  new TitleObject(title, TitleType.TITLE).setFadeIn(fadeIn).setStay(stay).setFadeOut(fadeOut).send(player);
	}
	
	public static void getDeathLocation(){
		for(World w : Bukkit.getWorlds()){
			for(Player p : w.getPlayers()){
				if(w.getPlayers() != null){
					Location loc = p.getLocation();
					Location loc1 = p.getLocation().add(0, -1, 0);
					Location right = p.getLocation().add(1, 0, 0);
					Location left = p.getLocation().add(-1, 0, 0);
					Location front = p.getLocation().add(0, 0, 1);
					Location back = p.getLocation().add(0, 0, -1);
					
					if(!loc1.getBlock().getType().equals(Materials.air)&&!loc.getBlock().getType().equals(Materials.stat_water)
						&&!loc.getBlock().getType().equals(Materials.water)&&!loc1.getBlock().getType().equals(Materials.leaves)
						&&!loc1.getBlock().getType().equals(Materials.leaves2)&&!right.getBlock().getType().equals(Materials.grave)
						&&!left.getBlock().getType().equals(Materials.grave)&&!front.getBlock().getType().equals(Materials.grave)
						&&!back.getBlock().getType().equals(Materials.grave)){
						HashMaps.death.put(p.getUniqueId(), p.getLocation());
					}
				}
			}
		}
	}

}
