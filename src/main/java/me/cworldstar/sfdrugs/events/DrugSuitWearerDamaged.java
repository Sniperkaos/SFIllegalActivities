package me.cworldstar.sfdrugs.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.cworldstar.sfdrugs.implementations.items.DrugSuit;

public class DrugSuitWearerDamaged implements Listener {
	private JavaPlugin plugin;
    public DrugSuitWearerDamaged(JavaPlugin plugin) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	@EventHandler
	private void onEntityDamage(EntityDamageByEntityEvent e) {
		Player p = (Player) e.getEntity();
		ItemStack item = p.getInventory().getChestplate();
		if (SlimefunItem.getByItem(item) != null) {
			if(item.getItemMeta().getDisplayName().contains("Corporate Hazmat")) {
				DrugSuit T = (DrugSuit) SlimefunItem.getByItem(item);
				T.PlayerDamaged(e,p,item,new Double(e.getFinalDamage()).intValue() * 15);
			}
		}
	}
}
