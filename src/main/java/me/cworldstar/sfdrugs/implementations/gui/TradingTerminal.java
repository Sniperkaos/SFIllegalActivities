package me.cworldstar.sfdrugs.implementations.gui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class TradingTerminal implements Listener {
	
	final Inventory TradingTerminalInterface = Bukkit.createInventory(null, 45);
	private static Map<Integer, ?> Hooks = new HashMap<>();
	
	
	public TradingTerminal() {
		for(int i=0; i>=9; i++) {
			TradingTerminalInterface.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS));
		}
		for(int i=36; i>=45; i++) {
			TradingTerminalInterface.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS));
		}

	};	
}
