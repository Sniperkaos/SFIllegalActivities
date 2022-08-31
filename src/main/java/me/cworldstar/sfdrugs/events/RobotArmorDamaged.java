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
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.items.DrugSuit;
import me.cworldstar.sfdrugs.implementations.items.RobotArmor;
import me.cworldstar.sfdrugs.implementations.items.RobotArmorSet;

public class RobotArmorDamaged implements Listener {
	private SFDrugs plugin;
    public RobotArmorDamaged(SFDrugs plugin) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    private void HandleZombie(EntityDamageByEntityEvent e,Mob p) {
    	/*if(p.getEquipment().getChestplate() != null) {
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
    	} Old Implementation */
		if (RobotArmorSet.WearingMostArmorSet(p)) {
			RobotArmorSet.RemoveSetItemCharge(RobotArmorSet.ToRobotArmor(p.getEquipment().getArmorContents()),e.getDamage(),e);
			for(Entity enemies : p.getNearbyEntities(3.0, 3.0, 3.0)) {
				if(enemies instanceof LivingEntity) {
					if(RobotArmor.IsNotAffected((LivingEntity) enemies) & (!enemies.equals(p))) {
						enemies.getWorld().playEffect(enemies.getLocation(), Effect.BONE_MEAL_USE, 12);
						((LivingEntity) enemies).damage(new Double(e.getDamage() / 2),p);
					}
				}
			}
		}
    }
    private void HandlePlayer(EntityDamageByEntityEvent e,Player p) {
    	if(p.getEquipment().getChestplate() != null) {
			if (RobotArmorSet.WearingMostArmorSet(p)) {
				RobotArmorSet.RemoveSetItemCharge(RobotArmorSet.ToRobotArmor(p.getInventory().getArmorContents()),e.getDamage(),e);
				for(Entity enemies : p.getNearbyEntities(3.0, 3.0, 3.0)) {
					if(enemies instanceof LivingEntity) {
						if(RobotArmor.IsNotAffected((LivingEntity) enemies) & (!enemies.equals(p))) {
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
		if (!e.getEntity().hasMetadata("AFFLICTED_BY_SFDRUGS_ROBOT_ARMOR") & (e.getEntity() instanceof Player || e.getEntity() instanceof Mob)) {
			if(e.getEntity() instanceof Player) {
				Player p = (Player) e.getEntity(); 
				this.HandlePlayer(e, p);
			} else {
				Mob p = (Mob) e.getEntity();
				this.HandleZombie(e, p);
			}

		}

	}
	@EventHandler
	private void onPlayerItemDamage(PlayerItemDamageEvent e) {
		ItemStack item = e.getItem();
		if (SlimefunItem.getByItem(item) != null) {
			if(item.getItemMeta().getDisplayName().contains("Corporate Security Robot")) {
				RobotArmor T = (RobotArmor) SlimefunItem.getByItem(item);
				T.ArmorDamaged(e, item, e.getDamage());		
			}
		} 
		
	}
}
