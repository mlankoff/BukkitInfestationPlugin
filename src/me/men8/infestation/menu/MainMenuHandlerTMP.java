package me.men8.infestation.menu;
//
//import me.men8.infestation.main.Main;
//import me.men8.infestation.misc.HashMaps;
//import me.men8.infestation.misc.Materials;
//import me.men8.infestation.scoreboard.UpdateScoreboard;
//import me.men8.infestation.permissions.Permissions;
//
//import org.bukkit.Bukkit;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.inventory.InventoryClickEvent;
//import org.bukkit.inventory.ItemStack;
//
public class MainMenuHandlerTMP{
//	
//	static Main plugin;
//	
//	@SuppressWarnings("static-access")
//	public MainMenuHandlerTMP(Main plug){
//		this.plugin = plug;
	}
//	
//	/**
//	 * reduce exp from player
//	 * @param p
//	 * @param exp
//	 */
//	public static void reduceExp(Player p, int exp){
//		int experience = HashMaps.exp.put(p.getName(), HashMaps.exp.get(p.getName()) - (int) exp); 
//		Main.player.set("Players." + p.getName() + "." + "Exp", experience);
//		Main.player.saveConfig();
//		UpdateScoreboard.updateScoreboard(p);
//	}
//	
//	/**
//	 * handler for menus
//	 * @param e
//	 */
//	@EventHandler
//	public static void mainMenuHandler(InventoryClickEvent e){
//		Player p = (Player)e.getWhoClicked();
//		int exp = Main.player.getInt("Players." + p.getName() + "." + "Exp");
//		if(e.getCurrentItem() == null){
//			return;
//		}else{
//			//main menu page
//			if(e.getInventory().getName().equals(MainMenu.main)){
//				if(e.getCurrentItem().getType().equals(Materials.player_skills)){
//					p.openInventory(HashMaps.skill_main_gui.get(p.getUniqueId()));
//				}else if(e.getCurrentItem().getType().equals(Materials.achievements)){
//					p.openInventory(HashMaps.achievements_gui1.get(p.getUniqueId()));
//				}else if(e.getCurrentItem().getType().equals(Materials.hats)){
//					p.openInventory(HashMaps.hats_gui.get(p.getUniqueId()));
//				}else if(e.getCurrentItem().getType().equals(Materials.lobby)){
//					p.closeInventory();
//				}
//				
//				e.setCancelled(true);
//			}
//			//skills menu page 1
////			else if(e.getInventory().getName().equals(OpenMainMenu.skill1)){
////				if(e.getSlot() == 49){
////					p.openInventory(HashMaps.main_menu_gui.get(p.getUniqueId()));
////				}
////				if(e.getSlot() == 50){
////					p.openInventory(HashMaps.skill_menu2_gui.get(p.getUniqueId()));
////				}
////				//////////////////////////////////////////////////////////////////////////////////////////////////////////
////				//[BUY SKILL SECTION]/////////////////////////////////////////////////////////////////////////////////////
////				//////////////////////////////////////////////////////////////////////////////////////////////////////////
////				if(e.getCurrentItem().getType().equals(Materials.to_buy)){
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					//[TIER 2]////////////////////////////////////////////////////////////////////////////////////////////////
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					if(e.getSlot() == 2 && exp >= 3000){
////						reduceExp(p, 3000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add health.lvl2");
////						p.setHealthScale(14);
////						p.closeInventory();
////					}
////					if(e.getSlot() == 11 && exp >= 3000){
////						reduceExp(p, 3000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add thirst.lvl2");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 20 && exp >= 3000){
////						reduceExp(p, 3000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add money.lvl2");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 29 && exp >= 3000){
////						reduceExp(p, 3000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add temperature.lvl2");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 38 && exp >= 3000){
////						reduceExp(p, 3000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add agility.lvl2");
////						p.closeInventory();
////					}
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					//[TIER 3]////////////////////////////////////////////////////////////////////////////////////////////////
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					if(e.getSlot() == 4 && exp >= 3500 && p.hasPermission(Permissions.hlvl2)){
////						reduceExp(p, 3500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add health.lvl3");
////						p.setHealthScale(16);
////						p.closeInventory();
////					}
////					if(e.getSlot() == 13 && exp >= 3500 && p.hasPermission(Permissions.plvl2)){
////						reduceExp(p, 3500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add thirst.lvl3");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 22 && exp >= 3500 && p.hasPermission(Permissions.mlvl2)){
////						reduceExp(p, 3500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add money.lvl3");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 31 && exp >= 3500 && p.hasPermission(Permissions.tlvl2)){
////						reduceExp(p, 3500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add temperature.lvl3");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 40 && exp >= 3500 && p.hasPermission(Permissions.alvl2)){
////						reduceExp(p, 3500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add agility.lvl3");
////						p.closeInventory();
////					}
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					//[TIER 4]////////////////////////////////////////////////////////////////////////////////////////////////
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					if(e.getSlot() == 6 && exp >= 4000 && p.hasPermission(Permissions.hlvl3)){
////						reduceExp(p, 4000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add health.lvl4");
////						p.setHealthScale(18);
////						p.closeInventory();
////					}
////					if(e.getSlot() == 15 && exp >= 4000 && p.hasPermission(Permissions.plvl3)){
////						reduceExp(p, 4000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add thirst.lvl4");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 24 && exp >= 4000 && p.hasPermission(Permissions.mlvl3)){
////						reduceExp(p, 4000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add money.lvl4");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 33 && exp >= 4000 && p.hasPermission(Permissions.tlvl3)){
////						reduceExp(p, 4000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add temperature.lvl4");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 42 && exp >= 4000 && p.hasPermission(Permissions.alvl3)){
////						reduceExp(p, 4000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add agility.lvl4");
////						p.closeInventory();
////					}
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					//[TIER 5]////////////////////////////////////////////////////////////////////////////////////////////////
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					if(e.getSlot() == 8 && exp >= 4500 && p.hasPermission(Permissions.hlvl4)){
////						reduceExp(p, 4500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add health.lvl5");
////						p.setHealthScale(20);
////						p.closeInventory();
////					}
////					if(e.getSlot() == 17 && exp >= 4500 && p.hasPermission(Permissions.plvl4)){
////						reduceExp(p, 4500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add thirst.lvl5");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 26 && exp >= 4500 && p.hasPermission(Permissions.mlvl4)){
////						reduceExp(p, 4500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add money.lvl5");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 35 && exp >= 4500 && p.hasPermission(Permissions.tlvl4)){
////						reduceExp(p, 4500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add temperature.lvl5");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 44 && exp >= 4500 && p.hasPermission(Permissions.alvl4)){
////						reduceExp(p, 4500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add agility.lvl5");
////						p.closeInventory();
////					}
////				}
////				e.setCancelled(true);
////			}
////			//skills menu page 2
////			else if(e.getInventory().getName().equals(OpenMainMenu.skill2)){
////				if(e.getSlot() == 49){
////					p.openInventory(HashMaps.main_menu_gui.get(p.getUniqueId()));
////				}
////				if(e.getSlot() == 48){
////					p.openInventory(HashMaps.skills_menu.get(p.getUniqueId()));
////				}
////				//////////////////////////////////////////////////////////////////////////////////////////////////////////
////				//[BUY SKILL SECTION]/////////////////////////////////////////////////////////////////////////////////////
////				//////////////////////////////////////////////////////////////////////////////////////////////////////////
////				if(e.getCurrentItem().getType().equals(Materials.to_buy)){
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					//[TIER 2]////////////////////////////////////////////////////////////////////////////////////////////////
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					if(e.getSlot() == 2 && exp >= 3000){
////						reduceExp(p, 3000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add blood.lvl2");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 11 && exp >= 3000){
////						reduceExp(p, 3000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add radioactive.lvl2");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 20 && exp >= 3000){
////						reduceExp(p, 3000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add strength.lvl2");
////						p.closeInventory();
////						for(int i = 27 ; i <= 31 ; i++){
////							p.getInventory().setItem(i, new ItemStack(Materials.air , 1, (short) 0));
////						}
////					}
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					//[TIER 3]////////////////////////////////////////////////////////////////////////////////////////////////
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					if(e.getSlot() == 4 && exp >= 3500 && p.hasPermission(Permissions.blvl2)){
////						reduceExp(p, 3500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add blood.lvl3");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 13 && exp >= 3500 && p.hasPermission(Permissions.rlvl2)){
////						reduceExp(p, 3500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add radioactive.lvl3");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 22 && exp >= 3500 && p.hasPermission(Permissions.slvl2)){
////						reduceExp(p, 3500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add strength.lvl3");
////						p.closeInventory();
////						for(int i = 21 ; i <= 26 ; i++){
////							p.getInventory().setItem(i, new ItemStack(Materials.air , 1, (short) 0));
////						}
////					}
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					//[TIER 4]////////////////////////////////////////////////////////////////////////////////////////////////
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					if(e.getSlot() == 6 && exp >= 4000 && p.hasPermission(Permissions.blvl3)){
////						reduceExp(p, 4000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add blood.lvl4");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 15 && exp >= 4000 && p.hasPermission(Permissions.rlvl3)){
////						reduceExp(p, 4000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add radioactive.lvl4");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 24 && exp >= 4000 && p.hasPermission(Permissions.slvl3)){
////						reduceExp(p, 4000);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add strength.lvl4");
////						p.closeInventory();
////						for(int i = 14 ; i <= 20 ; i++){
////							p.getInventory().setItem(i, new ItemStack(Materials.air , 1, (short) 0));
////						}
////					}
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					//[TIER 5]////////////////////////////////////////////////////////////////////////////////////////////////
////					//////////////////////////////////////////////////////////////////////////////////////////////////////////
////					if(e.getSlot() == 8 && exp >= 4500 && p.hasPermission(Permissions.blvl4)){
////						reduceExp(p, 4500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add blood.lvl5");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 17 && exp >= 4500 && p.hasPermission(Permissions.rlvl4)){
////						reduceExp(p, 4500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add radioactive.lvl5");
////						p.closeInventory();
////					}
////					if(e.getSlot() == 26 && exp >= 4500 && p.hasPermission(Permissions.slvl4)){
////						reduceExp(p, 4500);
////						Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "pex user " + p.getName() + " add strength.lvl5");
////						p.closeInventory();
////						for(int i = 9 ; i <= 13 ; i++){
////							p.getInventory().setItem(i, new ItemStack(Materials.air , 1, (short) 0));
////						}
////					}
////				}
////				e.setCancelled(true);
////			}
////			//achievements menu page 1
////			else if(e.getInventory().getName().equals(OpenMainMenu.achieve1)){
////				if(e.getCurrentItem().getType().equals(Materials.next)){
////					p.openInventory(HashMaps.achieve_menu2_gui.get(p.getUniqueId()));
////				}else if(e.getCurrentItem().getType().equals(Materials.lobby)){
////					p.openInventory(HashMaps.main_menu_gui.get(p.getUniqueId()));
////				}
////				e.setCancelled(true);
////			}
////			//achievements menu page 2
////			else if(e.getInventory().getName().equals(OpenMainMenu.achieve2)){
////				if(e.getCurrentItem().getType().equals(Materials.next)){
////					p.openInventory(HashMaps.achieve_menu3_gui.get(p.getUniqueId()));
////				}else if(e.getCurrentItem().getType().equals(Materials.lobby)){
////					p.openInventory(HashMaps.main_menu_gui.get(p.getUniqueId()));
////				}else if(e.getCurrentItem().getType().equals(Materials.previous)){
////					p.openInventory(HashMaps.achieve_menu1_gui.get(p.getUniqueId()));
////				}
////				e.setCancelled(true);
////			}
////			//achievements menu page 3
////			else if(e.getInventory().getName().equals(OpenMainMenu.achieve3)){
////				if(e.getCurrentItem().getType().equals(Materials.previous)){
////					p.openInventory(HashMaps.achieve_menu2_gui.get(p.getUniqueId()));
////				}else if(e.getCurrentItem().getType().equals(Materials.lobby)){
////					p.openInventory(HashMaps.main_menu_gui.get(p.getUniqueId()));
////				}
////				e.setCancelled(true);
////			}
////			//hats menu page
////			else if(e.getInventory().getName().equals(OpenMainMenu.hats)){
////				if(e.getCurrentItem().getType().equals(Materials.lobby)){
////					p.openInventory(HashMaps.main_menu_gui.get(p.getUniqueId()));
////				}
////				e.setCancelled(true);
////			}
//		}
//	}
//
//}
