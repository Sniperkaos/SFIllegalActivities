package me.cworldstar.sfdrugs.events;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.dot.Decay;

public class LaserProjectileHit implements Listener {
	private SFDrugs plugin;
    public LaserProjectileHit(SFDrugs plugin) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	@EventHandler
	private void onProjectileHit(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Projectile & e.getDamager() instanceof Snowball) {
            Snowball projectile = (Snowball) e.getDamager();
            e.getEntity().getWorld().createExplosion(projectile.getLocation(), 4F);
            if(e.getEntity() instanceof LivingEntity) {
            	LivingEntity Entity = (LivingEntity) e.getEntity();
            	Entity.damage(10, e.getDamager());
            	new Decay(Entity, plugin);
            }
        }
	}
}
