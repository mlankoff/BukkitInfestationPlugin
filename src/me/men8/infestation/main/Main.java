package me.men8.infestation.main;

import java.sql.Connection;
import java.sql.SQLException;

import me.men8.infestation.commands.*;
import me.men8.infestation.effects.*;
import me.men8.infestation.entity.*;
import me.men8.infestation.exp.*;
import me.men8.infestation.menu.*;
import me.men8.infestation.money.*;
import me.men8.infestation.permissions.*;
import me.men8.infestation.player.*;
import me.men8.infestation.sql.MySQL;
import me.men8.infestation.time.*;
import me.men8.infestation.world.*;
import me.men8.infestation.zombie.*;
import me.men8.infestation.survivalModules.*;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Main extends JavaPlugin{
	
	public Main plugin;
	PluginManager pm = Bukkit.getServer().getPluginManager();
	public static BukkitScheduler task;
	public static Connection connection;
	

	
	/**
	 * Declaring listeners
	 */
	//Player menu section
	MainMenu                mainMenu                = new MainMenu(this);
	MainMenuHandler         mainMenuHandler         = new MainMenuHandler(this);
	QuickCraftMenu          quickCraftMenu          = new QuickCraftMenu(this);
	MagicMenu               magicMenu               = new MagicMenu(this);
	HatsMenu                hatsMenu                = new HatsMenu(this);
	AchievementsMenu        achievementsMenu        = new AchievementsMenu(this);
	AchievementsMenuHandler achievementsMenuHandler = new AchievementsMenuHandler(this);
	OptionsMenu             optionsMenu             = new OptionsMenu(this);
	//World listeners section
	StopIceToWater         stopIceToWater         = new StopIceToWater(this);
	StopSnowMelting        stopSnowMelting        = new StopSnowMelting(this);
	StopSnowCreating       stopSnowCreating       = new StopSnowCreating(this);
	StopHealthRegain       stopHealthRegain       = new StopHealthRegain(this);
	WaterDrink             waterDrink             = new WaterDrink(this);
	Money                  money2                 = new Money(this);
	BarbedWire             barbedWire             = new BarbedWire(this);
	DisablePickUp          disablePickUp          = new DisablePickUp(this);
	Campfire               campfire               = new Campfire(this);
	SlowOnSnow             slowOnSnow             = new SlowOnSnow(this);
	CampfireLimit          campfireLimit          = new CampfireLimit(this);
	PlayerJoin             playerJoin             = new PlayerJoin(this);
	LegBreak               legBreak               = new LegBreak(this);
	LegFix                 legFix                 = new LegFix(this);
	Bleeding               bleeding               = new Bleeding(this);
	MedPack                medPack                = new MedPack(this);
	ArmorHandler           armorHandler           = new ArmorHandler(this);
	ArmorCreate            armorCreate            = new ArmorCreate(this);
	Neutralizer            neutralizer            = new Neutralizer(this);
	LightningNoFire        lightningNoFire        = new LightningNoFire(this);
	LootBagRandom          lootBagRandom          = new LootBagRandom(this);
	LootBagOpen            lootBagOpen            = new LootBagOpen(this);
	ExpGain                expGain                = new ExpGain(this);
	KillCounter            killCounter            = new KillCounter(this);
	Travel                 travel                 = new Travel(this);
	PlayerInventoryHandler playerInventoryHandler = new PlayerInventoryHandler(this);
	BlocksHandler          blocksHandler          = new BlocksHandler(this);
	DisableDrop            disableDrop            = new DisableDrop(this);
	MobHandler             mobHandler             = new MobHandler(this);
	PlayerDeath            playerDeath            = new PlayerDeath(this);
	PlayerRespawn          playerRespawn          = new PlayerRespawn(this);
	VisibilityManager      visibilityManager      = new VisibilityManager(this);
	ZombiePopulator        zombiePopulator        = new ZombiePopulator(this);
	NoWeather              noWeather              = new NoWeather(this);
	PlayerLogin            playerLogin            = new PlayerLogin(this);
	PlayerDisconnect       playerDisconnect       = new PlayerDisconnect(this);
	/**
	 * Main constructor
	 * @param plug
	 */
	public void getPlugin(Main plug){
		this.plugin = plug;
	}
	
	
	/**
	 * onEnable method
	 */
	public void onEnable(){
		
		for(World w : Bukkit.getWorlds()){
			w.setGameRuleValue("doFireTick", "false");
			w.setGameRuleValue("doDaylightCycle", "false");
			w.setThundering(false);
			w.setTime(20000);
		}
		
		task = Bukkit.getServer().getScheduler();
		/**
		 * Tasks
		 */
		//Task 5 min
		task.scheduleSyncRepeatingTask(this, new Runnable(){public void run(){
			MoneyAnouncer.moneyAnouncer();
			MySQL.updateSql();
			}}, 0, 20*(60*5));
		
		//Task 1 min
		task.scheduleSyncRepeatingTask(this, new Runnable(){public void run(){
			Time.timeAdd();
			}}, 0, 20*60L);
		
		//Task 5 sek
		task.scheduleSyncRepeatingTask(this, new Runnable(){public void run(){
			Temperature.temperature();
			Thirst.thirst();
			Visibility.visibility();
			PlayerDeath.getDeathLocation();
			MoneyUpdate.moneyUpdateScoreboard();
			ExpUpdate.expCheck();
			}}, 0, 20*5L);
		
		registerConfig();
		
		
		Reload.onReload();
		/**
		 * Listeners
		 */
		//Player menu listeners
		pm.registerEvents(this.mainMenu, this);
		pm.registerEvents(this.mainMenuHandler, this);
		pm.registerEvents(this.quickCraftMenu, this);
		pm.registerEvents(this.magicMenu, this);
		pm.registerEvents(this.hatsMenu, this);
		pm.registerEvents(this.achievementsMenu, this);
		pm.registerEvents(this.achievementsMenuHandler, this);
		pm.registerEvents(this.optionsMenu, this);
		//other
		pm.registerEvents(this.stopIceToWater, this);
		pm.registerEvents(this.stopSnowCreating, this);
		pm.registerEvents(this.stopSnowMelting, this);
		pm.registerEvents(this.stopHealthRegain, this);
		pm.registerEvents(this.waterDrink, this);
		pm.registerEvents(this.money2, this);
		pm.registerEvents(this.barbedWire, this);
		pm.registerEvents(this.disablePickUp, this);
		pm.registerEvents(this.campfire, this);
		pm.registerEvents(this.campfireLimit, this);
		pm.registerEvents(this.slowOnSnow, this);
		pm.registerEvents(this.playerJoin, this);
		pm.registerEvents(this.legBreak, this);
		pm.registerEvents(this.legFix, this);
		pm.registerEvents(this.bleeding, this);
		pm.registerEvents(this.medPack, this);
		pm.registerEvents(this.armorHandler, this);
		pm.registerEvents(this.armorCreate, this);
		pm.registerEvents(this.neutralizer, this);
		pm.registerEvents(this.lightningNoFire, this);
		pm.registerEvents(this.lootBagOpen, this);
		pm.registerEvents(this.lootBagRandom, this);
		pm.registerEvents(this.expGain, this);
		pm.registerEvents(this.killCounter, this);
		pm.registerEvents(this.travel, this);
		pm.registerEvents(this.playerInventoryHandler, this);
		pm.registerEvents(this.blocksHandler, this);
		pm.registerEvents(this.disableDrop, this);
		pm.registerEvents(this.mobHandler, this);
		pm.registerEvents(this.playerDeath, this);
		pm.registerEvents(this.playerRespawn, this);
		pm.registerEvents(this.visibilityManager, this);
		pm.registerEvents(this.zombiePopulator, this);
		pm.registerEvents(this.noWeather, this);
		pm.registerEvents(this.playerLogin, this);
		pm.registerEvents(this.playerDisconnect, this);
		
		/**
		 * Permissions
		 */
		Permissions.registerPermissions(pm);
		
		/**
		 * Commands
		 */
		this.getCommand("infestation").setExecutor(new Infestation(this));
		/**
		 * Other
		 */
	}
	
	public void registerConfig(){
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	/**
	 * onDisable method
	 */
	public void onDisable(){
		for(World w : Bukkit.getWorlds()){
			for(Player p : w.getPlayers()){
				if(w.getPlayers()!=null){
				//TODO
				}
			}
		}
		
		try{
			if(connection != null && connection.isClosed()){
				connection.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
}
