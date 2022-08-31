package me.cworldstar.sfdrugs.events;

import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.bosses.entities.GangMember;
import me.cworldstar.sfdrugs.implementations.bosses.entities.SmallerGangMember;
import me.cworldstar.sfdrugs.utils.RandomUtils;

public class GangMemberSpawnEvent implements Listener {
	
	private SFDrugs plugin;

	public GangMemberSpawnEvent(SFDrugs plugin) {
		this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onEntitySpawn(EntitySpawnEvent e) {
		if(e.getEntity() instanceof Zombie) {
			switch(RandomUtils.getRandom().nextInt(20)) {
				case 1:
					new GangMember(plugin,(Zombie) e.getEntity());
					break;
				case 2:
					new SmallerGangMember(plugin,(Zombie) e.getEntity());
					break;				
				case 3:
					new SmallerGangMember(plugin,(Zombie) e.getEntity());
					break;				
				case 4:
					new SmallerGangMember(plugin,(Zombie) e.getEntity());
					break;				
				case 5:
					new SmallerGangMember(plugin,(Zombie) e.getEntity());
					break;					
				case 6:
					new SmallerGangMember(plugin,(Zombie) e.getEntity());
					break;					
				default:
					break;
			}
		}
	}
}
