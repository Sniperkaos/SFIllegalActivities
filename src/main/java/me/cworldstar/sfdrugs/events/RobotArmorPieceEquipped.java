package me.cworldstar.sfdrugs.events;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.cworldstar.sfdrugs.implementations.events.ArmorEquipEvent;
import me.cworldstar.sfdrugs.implementations.items.RobotArmorSet;

public class RobotArmorPieceEquipped implements Listener {
	private JavaPlugin plugin;
	public RobotArmorPieceEquipped(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onEntityEquip(ArmorEquipEvent e) {
		Player p = e.getPlayer();
		if(RobotArmorSet.WearingFullArmorSet(p)) {
			new BukkitRunnable() {
				@Override
				public void run() {
					if(!RobotArmorSet.WearingFullArmorSet(p)) {
						RobotArmorSet.removeRobotArmorSetEffects(p);
						this.cancel();
					} else {
						RobotArmorSet.applyRobotArmorSetEffects(p);
						p.getWorld().spawnParticle(Particle.CAMPFIRE_COSY_SMOKE, p.getLocation(), 30, 0.5, 0.5, 0.5);
					}
				}
				
			}.runTaskTimer(plugin, 0L, 20L);
		}
	}
}
