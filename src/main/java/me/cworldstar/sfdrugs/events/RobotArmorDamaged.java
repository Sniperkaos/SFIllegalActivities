package me.cworldstar.sfdrugs.events;

import org.bukkit.Effect;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.cworldstar.sfdrugs.implementations.items.DrugSuit;
import me.cworldstar.sfdrugs.implementations.items.RobotArmor;

public class RobotArmorDamaged implements Listener {
	private JavaPlugin plugin;
    public RobotArmorDamaged(JavaPlugin plugin) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    private void HandleZombie(EntityDamageByEntityEvent e,Mob p) {
    	if(p.getEquipment().getChestplate() != null) {
			ItemStack item = p.getEquipment().getChestplate();
			if (SlimefunItem.getByItem(item) != null) {
				if(item.getItemMeta().getDisplayName().contains("Corporate Security Robot")) {
					RobotArmor T = (RobotArmor) SlimefunItem.getByItem(item);
					T.EntityDamaged(e,p,item,new Double(e.getFinalDamage() * 10));
					 for(Entity enemies : p.getNearbyEntities(3.0, 3.0, 3.0)) {
						 if(enemies instanceof LivingEntity) {
							 enemies.getWorld().playEffect(enemies.getLocation(), Effect.BONE_MEAL_USE, 12);
							 ((LivingEntity) enemies).damage(new Double(e.getDamage() / 2),p);
						 }
					 }
				}
			}
    	}
    }
    private void HandlePlayer(EntityDamageByEntityEvent e,Player p) {
    	if(p.getEquipment().getChestplate() != null) {
			ItemStack item = p.getInventory().getChestplate();
			if (SlimefunItem.getByItem(item) != null) {
				if(item.getItemMeta().getDisplayName().contains("Corporate Security Robot")) {
					DrugSuit T = (DrugSuit) SlimefunItem.getByItem(item);
					T.PlayerDamaged(e,p,item,new Double(e.getFinalDamage() * 10));
					 for(Entity enemies : p.getNearbyEntities(3.0, 3.0, 3.0)) {
						 if(enemies instanceof LivingEntity) {
							 enemies.getWorld().playEffect(enemies.getLocation(), Effect.BONE_MEAL_USE, 12);
							 ((LivingEntity) enemies).damage(new Double(e.getDamage() / 2),p);
						 }
					 }
				}
			}
    	}
    }
	@EventHandler
	private void onEntityDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player || e.getEntity() instanceof Mob) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity(); 
				this.HandlePlayer(e, p);
			} else {
				Mob p = (Mob) e.getEntity();
				this.HandleZombie(e, p);
			}

		}

	}
}
