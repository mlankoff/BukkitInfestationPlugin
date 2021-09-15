package me.men8.infestation.world;

import java.util.Random;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class LootBagOpen implements Listener{
	
	Main plugin;
	public static Inventory loot_inv;
	public static Random rand;
	public static int item1, item2, item3, amount1, amount_fin1, amount2, amount_fin2, amount3, amount_fin3;
	public static ItemStack itemStack;
	
	
	public LootBagOpen(Main plug){
		this.plugin = plug;
	}
	/**
	 * drop random loot on open
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	@EventHandler
	public static void dropOpenLootBag(PlayerInteractEvent e){
		Player p = e.getPlayer();
		rand = new Random();
		item1 = rand.nextInt(17);
		item2 = rand.nextInt(17);
		item3 = rand.nextInt(12);
		amount1 = rand.nextInt(101);
		amount2 = rand.nextInt(101);
		amount3 = rand.nextInt(101);
		
		if(amount1 >= 0 && amount1 <= 50){
			amount_fin1 = 1;
		}else if(amount1 >= 51 && amount1 <= 85){
			amount_fin1 = 2;
		}else if(amount1 >= 86 && amount1 <= 100){
			amount_fin1 = 3;
		}
		if(amount2 >= 0 && amount2 <= 50){
			amount_fin2 = 1;
		}else if(amount2 >= 51 && amount2 <= 85){
			amount_fin2 = 2;
		}else if(amount2 >= 86 && amount2 <= 100){
			amount_fin2 = 3;
		}
		if(amount3 >= 0 && amount3 <= 50){
			amount_fin3 = 1;
		}else if(amount3 >= 51 && amount3 <= 85){
			amount_fin3 = 2;
		}else if(amount3 >= 86 && amount3 <= 100){
			amount_fin3 = 3;
		}
		
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			loot_inv = Bukkit.createInventory(p, 9, "Loot bag");
			
			if(p.getItemInHand().getType().equals(Materials.loot_small)){
				switch(item1){
					case 0:{
						break;
					}case 1:{
						loot_inv.setItem(0, new ItemStack(Materials.iodine_small, amount_fin1));
						break;
					}case 2:{
						loot_inv.setItem(0, new ItemStack(Materials.iodine_medium, amount_fin1));
						break;
					}case 3:{
						loot_inv.setItem(0, new ItemStack(Materials.bandage, amount_fin1));
						break;
					}case 4:{
						loot_inv.setItem(0, new ItemStack(Materials.stiffener, amount_fin1));
						break;
					}case 5:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_pistol, amount_fin1));
						break;
					}case 6:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_rifle, amount_fin1));
						break;
					}case 7:{
						loot_inv.setItem(0, new ItemStack(Materials.chocolate_bar, amount_fin1));
						break;
					}case 8:{
						loot_inv.setItem(0, new ItemStack(Materials.tuna, amount_fin1));
						break;
					}case 9:{
						loot_inv.setItem(0, new ItemStack(Materials.melon, amount_fin1));
						break;
					}case 10:{
						loot_inv.setItem(0, new ItemStack(Materials.carrot, amount_fin1));
						break;
					}case 11:{
						loot_inv.setItem(0, new ItemStack(Materials.baked_potato, amount_fin1));
						break;
					}case 12:{
						loot_inv.setItem(0, new ItemStack(Materials.pumpkin_pie, amount_fin1));
						break;
					}case 13:{
						loot_inv.setItem(0, new ItemStack(Materials.bread, amount_fin1));
						break;
					}case 14:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_shotgun, amount_fin1));
						break;
					}case 15:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_sniper, amount_fin1));
						break;
					}case 16:{
						loot_inv.setItem(0, new ItemStack(Materials.barbed_wire, amount_fin1));
						break;
					}
					
				}
				itemStack = p.getItemInHand();
				final int amount1 = itemStack.getAmount();
				if(amount1 > 1){
					itemStack.setAmount(amount1 - 1);
					p.setItemInHand(itemStack);
				}
				if(amount1 == 1){
					p.setItemInHand(null);
				}
				p.openInventory(loot_inv);
			}else if(p.getItemInHand().getType().equals(Materials.loot_medium)){
				switch(item1){
					case 0:{
						break;
					}case 1:{
						loot_inv.setItem(0, new ItemStack(Materials.iodine_small, amount_fin1));
						break;
					}case 2:{
						loot_inv.setItem(0, new ItemStack(Materials.iodine_medium, amount_fin1));
						break;
					}case 3:{
						loot_inv.setItem(0, new ItemStack(Materials.bandage, amount_fin1));
						break;
					}case 4:{
						loot_inv.setItem(0, new ItemStack(Materials.stiffener, amount_fin1));
						break;
					}case 5:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_pistol, amount_fin1));
						break;
					}case 6:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_rifle, amount_fin1));
						break;
					}case 7:{
						loot_inv.setItem(0, new ItemStack(Materials.chocolate_bar, amount_fin1));
						break;
					}case 8:{
						loot_inv.setItem(0, new ItemStack(Materials.tuna, amount_fin1));
						break;
					}case 9:{
						loot_inv.setItem(0, new ItemStack(Materials.melon, amount_fin1));
						break;
					}case 10:{
						loot_inv.setItem(0, new ItemStack(Materials.carrot, amount_fin1));
						break;
					}case 11:{
						loot_inv.setItem(0, new ItemStack(Materials.baked_potato, amount_fin1));
						break;
					}case 12:{
						loot_inv.setItem(0, new ItemStack(Materials.pumpkin_pie, amount_fin1));
						break;
					}case 13:{
						loot_inv.setItem(0, new ItemStack(Materials.bread, amount_fin1));
						break;
					}case 14:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_shotgun, amount_fin1));
						break;
					}case 15:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_sniper, amount_fin1));
						break;
					}case 16:{
						loot_inv.setItem(0, new ItemStack(Materials.barbed_wire, amount_fin1));
						break;
					}
				}
				switch(item2){
					case 0:{
						break;
					}case 1:{
						loot_inv.setItem(0, new ItemStack(Materials.iodine_small, amount_fin2));
						break;
					}case 2:{
						loot_inv.setItem(0, new ItemStack(Materials.iodine_medium, amount_fin2));
						break;
					}case 3:{
						loot_inv.setItem(0, new ItemStack(Materials.bandage, amount_fin2));
						break;
					}case 4:{
						loot_inv.setItem(0, new ItemStack(Materials.stiffener, amount_fin2));
						break;
					}case 5:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_pistol, amount_fin2));
						break;
					}case 6:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_rifle, amount_fin2));
						break;
					}case 7:{
						loot_inv.setItem(0, new ItemStack(Materials.chocolate_bar, amount_fin2));
						break;
					}case 8:{
						loot_inv.setItem(0, new ItemStack(Materials.tuna, amount_fin2));
						break;
					}case 9:{
						loot_inv.setItem(0, new ItemStack(Materials.melon, amount_fin2));
						break;
					}case 10:{
						loot_inv.setItem(0, new ItemStack(Materials.carrot, amount_fin2));
						break;
					}case 11:{
						loot_inv.setItem(0, new ItemStack(Materials.baked_potato, amount_fin2));
						break;
					}case 12:{
						loot_inv.setItem(0, new ItemStack(Materials.pumpkin_pie, amount_fin2));
						break;
					}case 13:{
						loot_inv.setItem(0, new ItemStack(Materials.bread, amount_fin2));
						break;
					}case 14:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_shotgun, amount_fin2));
						break;
					}case 15:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_sniper, amount_fin2));
						break;
					}case 16:{
						loot_inv.setItem(0, new ItemStack(Materials.barbed_wire, amount_fin2));
						break;
					}
				}
				itemStack = p.getItemInHand();
				final int amount1 = itemStack.getAmount();
				if(amount1 > 1){
					itemStack.setAmount(amount1 - 1);
					p.setItemInHand(itemStack);
				}
				if(amount1 == 1){
					p.setItemInHand(null);
				}
				p.openInventory(loot_inv);
			}else if(p.getItemInHand().getType().equals(Materials.loot_large)){
				switch(item1){
					case 0:{
						break;
					}case 1:{
						loot_inv.setItem(0, new ItemStack(Materials.iodine_small, amount_fin1));
						break;
					}case 2:{
						loot_inv.setItem(0, new ItemStack(Materials.iodine_medium, amount_fin1));
						break;
					}case 3:{
						loot_inv.setItem(0, new ItemStack(Materials.bandage, amount_fin1));
						break;
					}case 4:{
						loot_inv.setItem(0, new ItemStack(Materials.stiffener, amount_fin1));
						break;
					}case 5:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_pistol, amount_fin1));
						break;
					}case 6:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_rifle, amount_fin1));
						break;
					}case 7:{
						loot_inv.setItem(0, new ItemStack(Materials.chocolate_bar, amount_fin1));
						break;
					}case 8:{
						loot_inv.setItem(0, new ItemStack(Materials.tuna, amount_fin1));
						break;
					}case 9:{
						loot_inv.setItem(0, new ItemStack(Materials.melon, amount_fin1));
						break;
					}case 10:{
						loot_inv.setItem(0, new ItemStack(Materials.carrot, amount_fin1));
						break;
					}case 11:{
						loot_inv.setItem(0, new ItemStack(Materials.baked_potato, amount_fin1));
						break;
					}case 12:{
						loot_inv.setItem(0, new ItemStack(Materials.pumpkin_pie, amount_fin1));
						break;
					}case 13:{
						loot_inv.setItem(0, new ItemStack(Materials.bread, amount_fin1));
						break;
					}case 14:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_shotgun, amount_fin1));
						break;
					}case 15:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_sniper, amount_fin1));
						break;
					}case 16:{
						loot_inv.setItem(0, new ItemStack(Materials.barbed_wire, amount_fin1));
						break;
					}
				}
				switch(item2){
					case 0:{
						break;
					}case 1:{
						loot_inv.setItem(0, new ItemStack(Materials.iodine_small, amount_fin2));
						break;
					}case 2:{
						loot_inv.setItem(0, new ItemStack(Materials.iodine_medium, amount_fin2));
						break;
					}case 3:{
						loot_inv.setItem(0, new ItemStack(Materials.bandage, amount_fin2));
						break;
					}case 4:{
						loot_inv.setItem(0, new ItemStack(Materials.stiffener, amount_fin2));
						break;
					}case 5:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_pistol, amount_fin2));
						break;
					}case 6:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_rifle, amount_fin2));
						break;
					}case 7:{
						loot_inv.setItem(0, new ItemStack(Materials.chocolate_bar, amount_fin2));
						break;
					}case 8:{
						loot_inv.setItem(0, new ItemStack(Materials.tuna, amount_fin2));
						break;
					}case 9:{
						loot_inv.setItem(0, new ItemStack(Materials.melon, amount_fin2));
						break;
					}case 10:{
						loot_inv.setItem(0, new ItemStack(Materials.carrot, amount_fin2));
						break;
					}case 11:{
						loot_inv.setItem(0, new ItemStack(Materials.baked_potato, amount_fin2));
						break;
					}case 12:{
						loot_inv.setItem(0, new ItemStack(Materials.pumpkin_pie, amount_fin2));
						break;
					}case 13:{
						loot_inv.setItem(0, new ItemStack(Materials.bread, amount_fin2));
						break;
					}case 14:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_shotgun, amount_fin2));
						break;
					}case 15:{
						loot_inv.setItem(0, new ItemStack(Materials.bullet_sniper, amount_fin2));
						break;
					}case 16:{
						loot_inv.setItem(0, new ItemStack(Materials.barbed_wire, amount_fin2));
						break;
					}
				}
				switch(item3){
					case 0:{
						break;
					}case 1:{
						loot_inv.setItem(2, new ItemStack(Materials.iodine_small, amount_fin3));
						break;
					}case 2:{
						loot_inv.setItem(2, new ItemStack(Materials.iodine_medium, amount_fin3));
						break;
					}case 3:{
						loot_inv.setItem(2, new ItemStack(Materials.bandage, amount_fin3));
						break;
					}case 4:{
						loot_inv.setItem(2, new ItemStack(Materials.stiffener, amount_fin3));
						break;
					}case 5:{
						loot_inv.setItem(2, new ItemStack(Materials.bullet_pistol, amount_fin3));
						break;
					}case 6:{
						loot_inv.setItem(2, new ItemStack(Materials.bullet_rifle, amount_fin3));
						break;
					}case 7:{
						loot_inv.setItem(2, new ItemStack(Materials.chocolate_bar, amount_fin3));
						break;
					}case 8:{
						loot_inv.setItem(2, new ItemStack(Materials.tuna, amount_fin3));
						break;
					}case 9:{
						loot_inv.setItem(2, new ItemStack(Materials.melon, amount_fin3));
						break;
					}case 10:{
						loot_inv.setItem(2, new ItemStack(Materials.carrot, amount_fin3));
						break;
					}case 11:{
						loot_inv.setItem(2, new ItemStack(Materials.baked_potato, amount_fin3));
						break;
					}
				}
				itemStack = p.getItemInHand();
				final int amount1 = itemStack.getAmount();
				if(amount1 > 1){
					itemStack.setAmount(amount1 - 1);
					p.setItemInHand(itemStack);
				}
				if(amount1 == 1){
					p.setItemInHand(null);
				}
				p.openInventory(loot_inv);
			}else if(p.getItemInHand().getType().equals(Materials.loot_rare)){
				switch(item3){
					case 0:{
						loot_inv.setItem(0, new ItemStack(Materials.art1, 1));
						break;
					}case 1:{
						loot_inv.setItem(0, new ItemStack(Materials.art2, 1));
						break;
					}case 2:{
						loot_inv.setItem(0, new ItemStack(Materials.art3, 1));
						break;
					}case 3:{
						loot_inv.setItem(0, new ItemStack(Materials.art4, 1));
						break;
					}case 4:{
						loot_inv.setItem(0, new ItemStack(Materials.art5, 1));
						break;
					}case 5:{
						loot_inv.setItem(0, new ItemStack(Materials.art6, 1));
						break;
					}case 6:{
						loot_inv.setItem(0, new ItemStack(Materials.art7, 1));
						break;
					}case 7:{
						loot_inv.setItem(0, new ItemStack(Materials.art8, 1));
						break;
					}case 8:{
						loot_inv.setItem(0, new ItemStack(Materials.art9, 1));
						break;
					}case 9:{
						loot_inv.setItem(0, new ItemStack(Materials.art10, 1));
						break;
					}case 10:{
						loot_inv.setItem(0, new ItemStack(Materials.art11, 1));
						break;
					}case 11:{
						loot_inv.setItem(0, new ItemStack(Materials.art12, 1));
						break;
					}
				}
				itemStack = p.getItemInHand();
				final int stack = itemStack.getAmount();
				if(stack > 1){
					itemStack.setAmount(stack - 1);
					p.setItemInHand(itemStack);
				}
				if(stack == 1){
					p.setItemInHand(null);
				}
				p.openInventory(loot_inv);
			}
		}
	}

}
