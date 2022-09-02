package me.cworldstar.sfdrugs.implementations.events;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class PlayerInventoryItemRemovingEvent extends PlayerEvent implements Cancellable {

	private static final HandlerList handlers = new HandlerList();
	private List<ItemStack> item;
	private boolean cancelled;
	private Inventory inventory;
	
	public PlayerInventoryItemRemovingEvent(Player who,Inventory i,List<ItemStack> items) {
		super(who);
		this.item = items;
		this.inventory = i;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return this.cancelled;
	}

	public void cancel() {
		this.cancelled = true;
	}
	public static HandlerList getHandlerList(){
		return handlers;
	}
	@Override
	public HandlerList getHandlers() {
		// TODO Auto-generated method stub
		return PlayerInventoryItemRemovingEvent.handlers;
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
		this.cancelled = true;
		this.cancel();
	}

}
