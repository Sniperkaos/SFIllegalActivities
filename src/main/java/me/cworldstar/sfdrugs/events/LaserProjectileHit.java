package me.cworldstar.sfdrugs.events;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LaserProjectileHit implements Listener {
	private JavaPlugin plugin;
    public LaserProjectileHit(JavaPlugin plugin) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	@EventHandler
	private void onProjectileHit(EntityDamageByEntityEvent e) {
        if(e.getDamager() instanceof Projectile & e.getDamager() instanceof Snowball) {
            Snowball projectile = (Snowball) e.getDamager();
            e.getEntity().getWorld().createExplosion(projectile.getLocation(), 2F);
        }
	}
}
