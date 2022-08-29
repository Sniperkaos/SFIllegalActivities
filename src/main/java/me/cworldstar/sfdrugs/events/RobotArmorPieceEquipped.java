package me.cworldstar.sfdrugs.events;

import java.util.logging.Level;

import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.events.ArmorEquipEvent;
import me.cworldstar.sfdrugs.implementations.items.RobotArmorSet;

public class RobotArmorPieceEquipped implements Listener {
	private SFDrugs plugin;
	private BukkitRunnable ArmorRunnable;
	public RobotArmorPieceEquipped(SFDrugs plugin) {
		this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onPlayerEquip(ArmorEquipEvent e) {
		this.plugin.getLogger().log(Level.INFO, "==================");
		this.plugin.getLogger().log(Level.INFO, "=Armor Equip Event=");
		this.plugin.getLogger().log(Level.INFO,e.toString());
		this.plugin.getLogger().log(Level.INFO, "==================");
		Player p = e.getPlayer();
		if(RobotArmorSet.WearingMostArmorSet(p) & e.getNewArmorPiece().getItemMeta().getDisplayName().contains("Corporate Security Robot")) {
			p.getWorld().playEffect(p.getLocation(), Effect.ENDERDRAGON_GROWL,1);
			if(this.ArmorRunnable == null) {
				this.ArmorRunnable = (BukkitRunnable) new BukkitRunnable() {
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
			} else {
				this.ArmorRunnable.cancel();
				this.ArmorRunnable = (BukkitRunnable) new BukkitRunnable() {
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
}
