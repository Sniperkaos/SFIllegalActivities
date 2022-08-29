package me.cworldstar.sfdrugs.events;

import java.util.Random;

import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.bosses.entities.GangMember;

public class GangMemberSpawnEvent implements Listener {
	
	private SFDrugs plugin;

	public GangMemberSpawnEvent(SFDrugs plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent e) {
		if(e.getEntity() instanceof Zombie) {
			if (new Random().nextInt(20) == 1) {
				new GangMember(plugin,(Zombie) e.getEntity());
			}
		}
	}
}
