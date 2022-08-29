package me.cworldstar.sfdrugs.events;


import org.bukkit.Effect;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.events.ArmorEquipEvent;
import me.cworldstar.sfdrugs.implementations.items.RobotArmorSet;
import me.cworldstar.sfdrugs.utils.ParticleUtils;

public class RobotArmorPieceEquipped implements Listener {
	private SFDrugs plugin;
	private BukkitTask ArmorRunnable;
	public RobotArmorPieceEquipped(SFDrugs plugin) {
		this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	@EventHandler
	public void onPlayerEquip(ArmorEquipEvent e) {
		Player p = e.getPlayer();
		if(e.getNewArmorPiece() == null) return;
		if(e.getNewArmorPiece().getItemMeta() != null & RobotArmorSet.WearingMostArmorSet(p)) {
			p.getWorld().playEffect(p.getLocation(), Effect.ENDERDRAGON_GROWL,1);
			p.getWorld().spawnParticle(Particle.EXPLOSION_HUGE,p.getLocation(),1);
			for(PotionEffect potion : p.getActivePotionEffects()) {
				p.removePotionEffect(potion.getType());
			}
			if(this.ArmorRunnable == null) {
				this.ArmorRunnable = new BukkitRunnable() {
					@Override
					public void run() {
						if(!e.getPlayer().isOnline()) {
							this.cancel();
						}
						
						if(!RobotArmorSet.WearingFullArmorSet(p)) {
							RobotArmorSet.removeRobotArmorSetEffects(p);
							p.getWorld().playEffect(p.getLocation(),Effect.LAVA_INTERACT,1);
							this.cancel();
						} else {
							RobotArmorSet.applyRobotArmorSetEffects(p);
							p.getWorld().spawnParticle(Particle.PORTAL, p.getLocation(), 30, 0.2, 0.2, 0.2);
							ParticleUtils.SpawnInCircleWithOffset(p.getLocation().add(0.0, 1, 0.0), Particle.SOUL_FIRE_FLAME, 0.6, 4,1,1);
						}
					}
					
				}.runTaskTimer(plugin, 0L, 1L);
			} else {
				this.ArmorRunnable.cancel();
				this.ArmorRunnable = new BukkitRunnable() {
					@Override
					public void run() {
						if(!e.getPlayer().isOnline()) {
							this.cancel();
						}
						
						if(!RobotArmorSet.WearingFullArmorSet(p)) {
							RobotArmorSet.removeRobotArmorSetEffects(p);
							p.getWorld().playEffect(p.getLocation(),Effect.LAVA_INTERACT,1);
							this.cancel();
						} else {
							RobotArmorSet.applyRobotArmorSetEffects(p);
							p.getWorld().spawnParticle(Particle.PORTAL, p.getLocation(), 30, 0.2, 0.2, 0.2);
							ParticleUtils.SpawnInCircleWithOffset(p.getLocation().add(0.0, 1, 0.0), Particle.SOUL_FIRE_FLAME, 0.6, 4,1,1);
						}
					}
					
				}.runTaskTimer(plugin, 0L, 10L);
			}

		}
	}
}
