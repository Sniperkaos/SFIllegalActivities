package me.cworldstar.sfdrugs.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetEvent;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.utils.Speak;

public class CustomMobTargetedEvent implements Listener {

	private SFDrugs plugin;

	public CustomMobTargetedEvent(SFDrugs plugin) {
		this.plugin = plugin;
	    plugin.getServer().getPluginManager().registerEvents(this, plugin);

	}
	
	@EventHandler
	public void onCustomMobTargetedEvent(EntityTargetEvent e) {
		if(e.getEntity().hasMetadata("SFDRUGS_CUSTOM_MOB")) {
			switch(e.getEntity().getMetadata("SFDRUGS_CUSTOM_MOB").get(0).asString().toUpperCase()) {
				case "CORPORATE_WORKER":
					new Speak(e.getEntity(),"&7[Corporate Worker]: &cHey! You can't be here!",20);
					break;
				default:
					break;
			};
		};
	}

}
