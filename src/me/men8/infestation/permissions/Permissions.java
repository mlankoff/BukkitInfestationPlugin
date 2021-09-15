package me.men8.infestation.permissions;
 
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.PluginManager;
 
public class Permissions{
	
	////////////////////
	//General permission
	////////////////////
	
	//Admin permission
	public static Permission admin = new Permission("infestation.admin");
	
	//Money permission
	public static Permission doubleCoin = new Permission("money.doublecoin");
	public static Permission boost25    = new Permission("money.boost25");
	public static Permission boost50    = new Permission("money.boost50");
	public static Permission boost75    = new Permission("money.boost75");
	
	//////////////////////////
	//Weapons skill permission
	//////////////////////////
	
	//Pistols permission
	public static Permission pistolLvl0 = new Permission("pistol.lvl0");
	public static Permission pistolLvl1 = new Permission("pistol.lvl1");
		
	//Rifles permission
	public static Permission rifleLvl0 = new Permission("rifle.lvl0");
	public static Permission rifleLvl1 = new Permission("rifle.lvl1");
		
	//Shotguns permission
	public static Permission shotgunLvl0 = new Permission("shotgun.lvl0");
	public static Permission shotgunLvl1 = new Permission("shotgun.lvl1");
	
	//Archery permission
	public static Permission archeryLvl0 = new Permission("archery.lvl0");
	public static Permission archeryLvl1 = new Permission("archery.lvl1");
	
	//Blade Weapons permission
	public static Permission bladeLvl0 = new Permission("blade.lvl0");
	public static Permission bladeLvl1 = new Permission("blade.lvl1");
	
	//Blunt Weapons permission
	public static Permission bluntLvl0 = new Permission("blunt.lvl0");
	public static Permission bluntLvl1 = new Permission("blunt.lvl1");
	
	///////////////////////////
	//Crafting skill permission
	///////////////////////////
	
	//Traps permission
	public static Permission trapLvl0 = new Permission("traps.lvl0");
	public static Permission trapLvl1 = new Permission("traps.lvl1");
	
	//Leatherworking permission
	public static Permission leatherLvl0 = new Permission("leatherwork.lvl0");
	public static Permission leatherLvl1 = new Permission("leatherwork.lvl1");
	
	//Medicine permission
	public static Permission medicineLvl0 = new Permission("medicine.lvl0");
	public static Permission medicineLvl1 = new Permission("medicine.lvl1");
	
	//Repair kits permission
	public static Permission repairLvl0 = new Permission("repairkit.lvl0");
	public static Permission repairLvl1 = new Permission("repairkit.lvl1");
	
	//Light Armor permission
	public static Permission lightLvl0 = new Permission("lightarmor.lvl0");
	public static Permission lightLvl1 = new Permission("lightarmor.lvl1");
	
	//Heavy Armor permission
	public static Permission heavyLvl0 = new Permission("heavyarmor.lvl0");
	public static Permission heavyLvl1 = new Permission("heavyarmor.lvl1");
	
	/////////////////////////////
	//Scavenging skill permission
	/////////////////////////////
	
	//Scavenging permission
	public static Permission scavengingLvl0 = new Permission("scavenging.lvl0");
	public static Permission scavengingLvl1 = new Permission("scavenging.lvl1");
	public static Permission scavengingLvl2 = new Permission("scavenging.lvl2");
	public static Permission scavengingLvl3 = new Permission("scavenging.lvl3");
	public static Permission scavengingLvl4 = new Permission("scavenging.lvl4");
	public static Permission scavengingLvl5 = new Permission("scavenging.lvl5");
	
	//Luck permission
	public static Permission luckLvl0 = new Permission("luck.lvl0");
	public static Permission luckLvl1 = new Permission("luck.lvl1");
	public static Permission luckLvl2 = new Permission("luck.lvl2");
	public static Permission luckLvl3 = new Permission("luck.lvl3");
	public static Permission luckLvl4 = new Permission("luck.lvl4");
	public static Permission luckLvl5 = new Permission("luck.lvl5");
	
	/////////////////////////
	//Health skill permission
	/////////////////////////
	
	//Health permission
	public static Permission healthLvl0 = new Permission("health.lvl0");
	public static Permission healthLvl1 = new Permission("health.lvl1");
	public static Permission healthLvl2 = new Permission("health.lvl2");
	public static Permission healthLvl3 = new Permission("health.lvl3");
	public static Permission healthLvl4 = new Permission("health.lvl4");
	public static Permission healthLvl5 = new Permission("health.lvl5");
	   
	//Camel permission
	public static Permission thirstLvl0 = new Permission("thirst.lvl0");
	public static Permission thirstLvl1 = new Permission("thirst.lvl1");
	public static Permission thirstLvl2 = new Permission("thirst.lvl2");
	public static Permission thirstLvl3 = new Permission("thirst.lvl3");
	public static Permission thirstLvl4 = new Permission("thirst.lvl4");
	public static Permission thirstLvl5 = new Permission("thirst.lvl5");
	   
	//Eskimo permission
	public static Permission temperatureLvl0 = new Permission("temperature.lvl0");
	public static Permission temperatureLvl1 = new Permission("temperature.lvl1");
	public static Permission temperatureLvl2 = new Permission("temperature.lvl2");
	public static Permission temperatureLvl3 = new Permission("temperature.lvl3");
	public static Permission temperatureLvl4 = new Permission("temperature.lvl4");
	public static Permission temperatureLvl5 = new Permission("temperature.lvl5");
	
	//Agility permission
	public static Permission agilityLvl0 = new Permission("agility.lvl0");
	public static Permission agilityLvl1 = new Permission("agility.lvl1");
	public static Permission agilityLvl2 = new Permission("agility.lvl2");
	public static Permission agilityLvl3 = new Permission("agility.lvl3");
	public static Permission agilityLvl4 = new Permission("agility.lvl4");
	public static Permission agilityLvl5 = new Permission("agility.lvl5");
	
	//Hard Skin permission
	public static Permission hardSkinLvl0 = new Permission("hardskin.lvl0");
	public static Permission hardSkinLvl1 = new Permission("hardskin.lvl1");
	public static Permission hardSkinLvl2 = new Permission("hardskin.lvl2");
	public static Permission hardSkinLvl3 = new Permission("hardskin.lvl3");
	public static Permission hardSkinLvl4 = new Permission("hardskin.lvl4");
	public static Permission hardSkinLvl5 = new Permission("hardskin.lvl5");
	
	//Strength permission
	public static Permission strengthLvl0 = new Permission("strength.lvl0");
	public static Permission strengthLvl1 = new Permission("strength.lvl1");
	public static Permission strengthLvl2 = new Permission("strength.lvl2");
	public static Permission strengthLvl3 = new Permission("strength.lvl3");
	public static Permission strengthLvl4 = new Permission("strength.lvl4");
	public static Permission strengthLvl5 = new Permission("strength.lvl5");
 
	public static void registerPermissions(PluginManager pm){
		pm.addPermission(admin);
		pm.addPermission(doubleCoin);
		pm.addPermission(boost25);
		pm.addPermission(boost50);
		pm.addPermission(boost75);
		pm.addPermission(pistolLvl0);
		pm.addPermission(pistolLvl1);
		pm.addPermission(rifleLvl0);
		pm.addPermission(rifleLvl1);
		pm.addPermission(shotgunLvl0);
		pm.addPermission(shotgunLvl1);
		pm.addPermission(archeryLvl0);
		pm.addPermission(archeryLvl1);
		pm.addPermission(bladeLvl0);
		pm.addPermission(bladeLvl1);
		pm.addPermission(bluntLvl0);
		pm.addPermission(bluntLvl1);
		pm.addPermission(trapLvl0);
		pm.addPermission(trapLvl1);
		pm.addPermission(leatherLvl0);
		pm.addPermission(leatherLvl1);
		pm.addPermission(medicineLvl0);
		pm.addPermission(medicineLvl1);
		pm.addPermission(repairLvl0);
		pm.addPermission(repairLvl1);
		pm.addPermission(lightLvl0);
		pm.addPermission(lightLvl1);
		pm.addPermission(heavyLvl0);
		pm.addPermission(heavyLvl1);
		pm.addPermission(scavengingLvl0);
		pm.addPermission(scavengingLvl1);
		pm.addPermission(scavengingLvl2);
		pm.addPermission(scavengingLvl3);
		pm.addPermission(scavengingLvl4);
		pm.addPermission(scavengingLvl5);
		pm.addPermission(luckLvl0);
		pm.addPermission(luckLvl1);
		pm.addPermission(luckLvl2);
		pm.addPermission(luckLvl3);
		pm.addPermission(luckLvl4);
		pm.addPermission(luckLvl5);
		pm.addPermission(healthLvl0);
		pm.addPermission(healthLvl1);
		pm.addPermission(healthLvl2);
		pm.addPermission(healthLvl3);
		pm.addPermission(healthLvl4);
		pm.addPermission(healthLvl5);
		pm.addPermission(thirstLvl0);
		pm.addPermission(thirstLvl1);
		pm.addPermission(thirstLvl2);
		pm.addPermission(thirstLvl3);
		pm.addPermission(thirstLvl4);
		pm.addPermission(thirstLvl5);
		pm.addPermission(temperatureLvl0);
		pm.addPermission(temperatureLvl1);
		pm.addPermission(temperatureLvl2);
		pm.addPermission(temperatureLvl3);
		pm.addPermission(temperatureLvl4);
		pm.addPermission(temperatureLvl5);
		pm.addPermission(agilityLvl0);
		pm.addPermission(agilityLvl1);
		pm.addPermission(agilityLvl2);
		pm.addPermission(agilityLvl3);
		pm.addPermission(agilityLvl4);
		pm.addPermission(agilityLvl5);
		pm.addPermission(hardSkinLvl0);
		pm.addPermission(hardSkinLvl1);
		pm.addPermission(hardSkinLvl2);
		pm.addPermission(hardSkinLvl3);
		pm.addPermission(hardSkinLvl4);
		pm.addPermission(hardSkinLvl5);
		pm.addPermission(strengthLvl0);
		pm.addPermission(strengthLvl1);
		pm.addPermission(strengthLvl2);
		pm.addPermission(strengthLvl3);
		pm.addPermission(strengthLvl4);
		pm.addPermission(strengthLvl5);
	}
	
}
