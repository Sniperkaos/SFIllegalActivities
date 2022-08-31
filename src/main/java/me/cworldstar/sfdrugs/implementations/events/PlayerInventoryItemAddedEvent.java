package me.cworldstar.sfdrugs.implementations.events;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;

public class PlayerInventoryItemAddedEvent extends PlayerEvent implements Cancellable {

	public static final HandlerList handlers = new HandlerList();
	private List<ItemStack> item;
	private boolean cancelled;
	private Inventory inventory;
	private BukkitTask runnable;
	
	public PlayerInventoryItemAddedEvent(Player who,Inventory i,List<ItemStack> items,BukkitTask runnable) {
		super(who);
		this.item = items;
		this.inventory = i;
		this.runnable = runnable;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return this.cancelled;
	}

	public void cancel() {
		this.runnable.cancel();
	}
	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return PlayerInventoryItemAddedEvent.handlers;
	}
	public List<ItemStack> getItem() {
		return this.item;
	}
	public Inventory getInventory() {
		return this.inventory;
	}

	@Override
	public void setCancelled(boolean cancel) {
		// TODO Auto-generated method stub
		this.cancel();
	}

}
