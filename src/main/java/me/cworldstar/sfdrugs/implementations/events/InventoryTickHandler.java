package me.cworldstar.sfdrugs.implementations.events;

import java.util.ArrayList;
import java.util.Arrays;
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
	private List<ItemStack> oldInventory;
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
		this.oldInventory = new ArrayList<>(Arrays.asList(p.getInventory().getStorageContents()));
		this.itemAddedRunnable = new BukkitRunnable() {
			@Override
			public void run() {
				if(!oldInventory.containsAll(new ArrayList<>(Arrays.asList(p.getInventory().getStorageContents())))) {
					List<ItemStack> NewItems = new ArrayList<>(Arrays.asList(p.getInventory().getStorageContents()));
					NewItems.removeAll(oldInventory);
					if(NewItems.size() > 0) {
						Bukkit.getServer().getPluginManager().callEvent(new PlayerInventoryItemAddedEvent(p, p.getInventory(),NewItems));
						oldInventory = new ArrayList<>(Arrays.asList(p.getInventory().getContents()));
					}
				}
			}
			
		}.runTaskTimer(plugin, 0, 1L);
		this.itemRemovingRunnable = new BukkitRunnable() {
			@Override
			public void run() {
				if(!new ArrayList<>(Arrays.asList(p.getInventory().getStorageContents())).containsAll(oldInventory)) {
					List<ItemStack> NewItems = oldInventory;
					NewItems.removeAll(new ArrayList<>(Arrays.asList(p.getInventory().getStorageContents())));
					if(NewItems.size() > 0) {
						Bukkit.getServer().getPluginManager().callEvent(new PlayerInventoryItemRemovingEvent(p, p.getInventory(),NewItems));
						oldInventory = new ArrayList<>(Arrays.asList(p.getInventory().getContents()));
					}
				}
			}
		}.runTaskTimer(plugin, 0, 1L);
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
