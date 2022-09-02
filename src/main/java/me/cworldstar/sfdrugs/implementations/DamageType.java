package me.cworldstar.sfdrugs.implementations;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import me.cworldstar.sfdrugs.utils.Speak;

public enum DamageType {
	UNSTABLE_OBJECT("&f&l&k|||&r &f&lUnstable Object &k|||&r");

	private final String DAMAGETYPE_DISPLAY_NAME;
	
	DamageType(String name) {
		this.DAMAGETYPE_DISPLAY_NAME = new Speak().format(name);
		
	}
	public Entity damager(LivingEntity toDamage) {
		World thisWorld = toDamage.getWorld();
		ArmorStand thisDamager = ((ArmorStand) thisWorld.spawnEntity(toDamage.getLocation().add(new Location(thisWorld,0,20,0)),EntityType.ARMOR_STAND));
		thisDamager.setCustomName(new Speak().format(this.DAMAGETYPE_DISPLAY_NAME));
		thisDamager.setVisible(false);
		thisDamager.setCustomNameVisible(false);
		thisDamager.setAI(false);
		thisDamager.setCanPickupItems(false);
		thisDamager.setGravity(false);

		return thisDamager;		
	}
	
}
