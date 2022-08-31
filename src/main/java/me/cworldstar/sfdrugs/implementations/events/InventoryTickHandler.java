package me.cworldstar.sfdrugs.implementations.events;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import me.cworldstar.sfdrugs.SFDrugs;
public class InventoryTickHandler {
	private SFDrugs plugin;
	private Player player;
	private BukkitTask runnable;
	private PlayerInventory oldInventory;
	private BukkitTask itemAddedRunnable;
	private BukkitTask itemRemovingRunnable;
	/**
	 * 
	 * InventoryTickHandler for PlayerInventoryItemAddedEvent.
	 * Takes a Plugin and a Player.
	 * Has getRunnable() and getPlayer() tasks for cancelling.
	 * 
	 * This is stupid.
	 * 
	 *
	 * @author cworldstar
	 * @since today
	 * @param plugin
	 * @param p
	 */
	public InventoryTickHandler(SFDrugs plugin,Player p) {
		this.plugin = plugin;
		this.player = p;
		this.oldInventory = p.getInventory();
		this.itemAddedRunnable = new BukkitRunnable() {
			@Override
			public void run() {
				if(!oldInventory.getContents().equals(p.getInventory().getContents())) {
					List<ItemStack> NewItems = new ArrayList<>();
					for(ItemStack Item : p.getInventory().getContents()) {
						if(!oldInventory.contains(Item)) {
							NewItems.add(Item);
						}
					}
					Bukkit.getServer().getPluginManager().callEvent(new PlayerInventoryItemAddedEvent(p, p.getInventory(),NewItems,runnable));
				}
			}
			
		}.runTaskTimer(plugin, 0, 5L);
		this.itemRemovingRunnable = new BukkitRunnable() {
			@Override
			public void run() {
				if(!p.getInventory().getContents().equals(oldInventory.getContents())) {
					List<ItemStack> NewItems = new ArrayList<>();
					for(ItemStack Item : oldInventory.getContents()) {
						if(!p.getInventory().contains(Item)) {
							NewItems.add(Item);
						}
					}
					Bukkit.getServer().getPluginManager().callEvent(new PlayerInventoryItemRemovingEvent(p,oldInventory,NewItems,runnable));
				}
			}
			
		}.runTaskTimer(plugin, 0, 5L);
	}
	public BukkitTask getItemAddedRunnable() {
		return this.itemAddedRunnable;
	}
	public BukkitTask getItemRemovingRunnable() {
		return this.itemRemovingRunnable;
	}
	public Player getPlayer() {
		return this.player;
	}
	public void cancel() {
		this.itemAddedRunnable.cancel();
		this.itemRemovingRunnable.cancel();
	}
}
