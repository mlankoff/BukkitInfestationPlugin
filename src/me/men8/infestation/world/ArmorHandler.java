package me.men8.infestation.world;

import me.men8.infestation.main.Main;
import me.men8.infestation.misc.Materials;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ArmorHandler implements Listener{
	
	public Main plugin;
	
	public ArmorHandler(Main plug){
		this.plugin = plug;
	}
	/**
	 * Preventing player from wearing armor items from quickbar
	 * @param e
	 */
	@SuppressWarnings("deprecation")
	@EventHandler
	public void armorPreventFromRightClick(PlayerInteractEvent e){
		Player p = e.getPlayer();
		Material m = p.getItemInHand().getType();
		if(e.getAction().equals(Action.RIGHT_CLICK_AIR)||e.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
			if(m.equals(Materials.lh)||m.equals(Materials.lch)||m.equals(Materials.ll)||m.equals(Materials.lb)
					||m.equals(Materials.ih)||m.equals(Materials.ich)||m.equals(Materials.il)||m.equals(Materials.ib)
					||m.equals(Materials.gh)||m.equals(Materials.gch)||m.equals(Materials.gl)||m.equals(Materials.gb)
					||m.equals(Materials.dh)||m.equals(Materials.dch)||m.equals(Materials.dl)||m.equals(Materials.db)){
				e.setCancelled(true);
				p.updateInventory();
			}
		}
		
	}

}
