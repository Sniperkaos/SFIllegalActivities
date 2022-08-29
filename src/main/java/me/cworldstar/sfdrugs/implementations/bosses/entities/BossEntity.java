package me.cworldstar.sfdrugs.implementations.bosses.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitTask;



public class BossEntity implements Listener  {
	private LivingEntity entity;
	private List<BukkitTask> skills = new ArrayList<BukkitTask>();
	public BossEntity(EntityType Entity,World world,Location location) {
		this.entity = (LivingEntity) world.spawnEntity(location, Entity);
	}
	public LivingEntity getEntity() {
		return this.entity;
	}
	public void setEntity(LivingEntity entity) {
		this.entity = entity;
	}
	/**
	 *
	 * ItemStack Helmet, ItemStack Chestplate, ItemStack Leggings, ItemStack Boots.
	 *
	 * @author cworldstar
	 *
	 */
	public void setArmor(ItemStack helmet,ItemStack chest,ItemStack leggings,ItemStack boots) {
		this.entity.getEquipment().setArmorContents(new ItemStack[] {boots,leggings,chest,helmet});
	}
	public void useRandomSkill() {
		this.skills.get(new Random().nextInt(skills.size()));
	}
}
