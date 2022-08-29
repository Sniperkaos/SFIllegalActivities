package me.cworldstar.sfdrugs.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.items.DrugSuit;
import me.cworldstar.sfdrugs.implementations.items.ElectricShears;
import me.cworldstar.sfdrugs.implementations.items.RobotArmor;

public class ElectricShearsEvent implements Listener {
	private SFDrugs plugin;
    public ElectricShearsEvent(SFDrugs plugin) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	@EventHandler
	private void onPlayerItemDamage(PlayerItemDamageEvent e) {
		ItemStack item = e.getItem();
		if (SlimefunItem.getByItem(item) != null) {
			if(item.getItemMeta().getDisplayName().contains("Electric Shears")) {
				ElectricShears E = (ElectricShears) SlimefunItem.getByItem(item);
			}
		} 
	}
}
