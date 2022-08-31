package me.cworldstar.sfdrugs.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.events.PlayerInventoryItemAddedEvent;
import me.cworldstar.sfdrugs.implementations.items.UnstableObject;
import me.cworldstar.sfdrugs.utils.Speak;

public class UnstableObjectEvent implements Listener {

	private SFDrugs plugin;

	public UnstableObjectEvent(SFDrugs plugin) {
		this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onPlayerItemAdded(PlayerInventoryItemAddedEvent e) {
		new Speak(e.getPlayer(),"onPlayerItemAdded fired successfully.");
		for(ItemStack item : e.getItem()) {
			if(SlimefunItem.getByItem(item) != null && SlimefunItem.getByItem(item) instanceof UnstableObject) {
				new Speak(e.getPlayer(),"&eYou have picked up an unstable object. Either dispose of it or use it.");
				UnstableObject item2 = ((UnstableObject) SlimefunItem.getByItem(item));
				switch(item2.getUnstableAmount()) {
				case STABLE:
					break;
				case SLIGHTLY_UNSTABLE:
					new BukkitRunnable() {
						@Override
						public void run() {
							if(e.getPlayer().getInventory().contains(item) && !e.isCancelled() && e.getPlayer().isOnline()) {
								new Speak(e.getPlayer(),"&c&lYou took too long to dispose of a slightly unstable object.");
								item.setAmount(0);
							}
						}
						
					}.runTaskLater(plugin, 600L);
					break;
				case UNSTABLE:
					new BukkitRunnable() {
						@Override
						public void run() {
							if(e.getPlayer().getInventory().contains(item) && !e.isCancelled() && e.getPlayer().isOnline()) {
								new Speak(e.getPlayer(),"&c&lYou took too long to dispose of an unstable object.");
								item.setAmount(0);
								e.getPlayer().getWorld().createExplosion(e.getPlayer().getLocation(),2F);
							}
						}
						
					}.runTaskLater(plugin, 600L);
					break;
				case HIGHLY_UNSTABLE:
					new BukkitRunnable() {
						@Override
						public void run() {
							if(e.getPlayer().getInventory().contains(item) && !e.isCancelled() && e.getPlayer().isOnline()) {
								new Speak(e.getPlayer(),"&c&lYou took too long to dispose of a highly unstable object.");
								item.setAmount(0);
								e.getPlayer().getWorld().createExplosion(e.getPlayer().getLocation(),3F);
							}
						}
						
					}.runTaskLater(plugin, 300L);
					break;
				default:
					break;
				}
			}
		}
	}
}
