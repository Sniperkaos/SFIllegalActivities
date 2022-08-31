package me.cworldstar.sfdrugs.events;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.events.InventoryTickHandler;

public class PlayerAddedEvent implements Listener {
	private SFDrugs plugin;
	private Map<Player,InventoryTickHandler> storage = new HashMap<>();
	public PlayerAddedEvent(SFDrugs plugin) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onPlayerAdded(PlayerJoinEvent e) {
		// Assume player is not instance of OfflinePlayer
		this.storage.put(e.getPlayer(),new InventoryTickHandler(plugin, e.getPlayer()));
	}
	@EventHandler
	public void onPlayerRemoving(PlayerQuitEvent e) {
		if(this.storage.get(e.getPlayer()) != null) {
			this.storage.get(e.getPlayer()).cancel();
		}
	}
	@EventHandler
	public void onPlayerRemoving(PlayerKickEvent e) {
		if(this.storage.get(e.getPlayer()) != null) {
			this.storage.get(e.getPlayer()).cancel();
		}
	}
	
}
