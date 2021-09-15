package me.men8.infestation.world;

import java.util.ArrayList;
import java.util.Random;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class LootBagRandom implements Listener{
	
	Main plugin;
	public static Random rand;
	public static int percent;
	public static EntityType zombie, pigzombie, skeleton, spider, cave_spider, pig, cow, chicken, sheep;
	public static ItemStack small, medium, large, rare;
	public static ItemMeta smeta, mmeta, lmeta, rmeta;
	public static ArrayList<String> loot_array;
	
	public LootBagRandom(Main plug){
		this.plugin = plug;
	}
	/**
	 * drop randomizer
	 * @param e
	 */
	@EventHandler
	public static void dropRandomLootBag(EntityDeathEvent e){
		rand = new Random();
		percent = rand.nextInt(101);
		
		zombie = EntityType.ZOMBIE;
		pigzombie = EntityType.PIG_ZOMBIE;
		skeleton = EntityType.SKELETON;
		spider = EntityType.SPIDER;
		cave_spider = EntityType.CAVE_SPIDER;
		pig = EntityType.PIG;
		cow = EntityType.COW;
		chicken = EntityType.CHICKEN;
		sheep = EntityType.SHEEP;
		
		loot_array = new ArrayList<String>();
		loot_array.add(ChatColor.GOLD + "Right Click in QuickBar to open");
		
		//small loot bag
		small = new ItemStack(Materials.loot_small , (int)1, (short)0);
		smeta = (ItemMeta)small.getItemMeta();
		smeta.setDisplayName(ChatColor.GRAY + "Small Loot Bag");
		smeta.setLore(loot_array);
		small.setItemMeta(smeta);
		//medium loot bag
		medium = new ItemStack(Materials.loot_medium , (int)1, (short)0);
		mmeta = (ItemMeta)medium.getItemMeta();
		mmeta.setDisplayName(ChatColor.GREEN + "Medium Loot Bag");
		mmeta.setLore(loot_array);
		medium.setItemMeta(mmeta);
		//large loot bag
		large = new ItemStack(Materials.loot_large , (int)1, (short)0);
		lmeta = (ItemMeta)large.getItemMeta();
		lmeta.setDisplayName(ChatColor.GOLD + "Large Loot Bag");
		lmeta.setLore(loot_array);
		large.setItemMeta(lmeta);
		//rare loot bag
		rare = new ItemStack(Materials.loot_rare , (int)1, (short)0);
		rmeta = (ItemMeta)rare.getItemMeta();
		rmeta.setDisplayName(ChatColor.DARK_PURPLE + "Rare Loot Bag");
		rmeta.setLore(loot_array);
		rare.setItemMeta(rmeta);
		
		if(e.getEntity().getKiller() instanceof Player){
			EntityType mob = e.getEntity().getType();
			if(mob == zombie || mob == pigzombie || mob == skeleton || mob == spider || mob == cave_spider){
				e.getDrops().clear();
				e.setDroppedExp((int) 0);
				if(percent == 65){
					e.getDrops().add(rare);
				}else if(percent >= 20 && percent <= 45){
					e.getDrops().add(small);
				}else if(percent >= 50 && percent <= 60){
					e.getDrops().add(medium);
				}else if(percent >= 80 && percent <= 85){
					e.getDrops().add(large);
				}
			}else if(mob == pig){
				e.getDrops().clear();
				e.setDroppedExp((int) 0);
				if(percent >= 35 && percent <= 48){
					e.getDrops().add(new ItemStack(Materials.pig_meat, 1));
				}else if(percent >= 60 && percent <= 72){
					e.getDrops().add(new ItemStack(Materials.pig_meat, 1));
				}
			}else if(mob == cow){
				e.getDrops().clear();
				e.setDroppedExp((int) 0);
				if(percent >= 35 && percent <= 48){
					e.getDrops().add(new ItemStack(Materials.cow_meat, 1));
				}else if(percent >= 60 && percent <= 72){
					e.getDrops().add(new ItemStack(Materials.cow_meat, 1));
				}
			}else if(mob == chicken){
				e.getDrops().clear();
				e.setDroppedExp((int) 0);
				if(percent >= 35 && percent <= 48){
					e.getDrops().add(new ItemStack(Materials.chicken_meat, 1));
				}else if(percent >= 60 && percent <= 72){
					e.getDrops().add(new ItemStack(Materials.chicken_meat, 1));
				}
			}else if(mob == sheep){
				e.getDrops().clear();
				e.setDroppedExp((int) 0);
				if(percent >= 35 && percent <= 48){
					e.getDrops().add(new ItemStack(Materials.chicken_meat, 1));
				}else if(percent >= 60 && percent <= 72){
					e.getDrops().add(new ItemStack(Materials.chicken_meat, 1));
				}
			}
				
		}
	}

}
