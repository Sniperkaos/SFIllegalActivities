package me.cworldstar.sfdrugs.implementations.bosses.entities;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.cworldstar.sfdrugs.implementations.loot.CorporationEnemyLootTable;
import me.cworldstar.sfdrugs.utils.Items;
import net.md_5.bungee.api.ChatColor;

public class CorporationEnemy {
	private static Zombie Zombie;
	public CorporationEnemy(JavaPlugin Plugin,Zombie z) {
		z.setCustomName(ChatColor.translateAlternateColorCodes('&', "&7&lCorporate Security Robot"));
		z.setCanPickupItems(false);
		z.setMaxHealth(500.0);
		z.setHealth(500.0);
		z.setGlowing(true);
		z.setLootTable(new CorporationEnemyLootTable(Plugin));
		BossBar EnemyBossBar = Bukkit.getServer().createBossBar(ChatColor.translateAlternateColorCodes('&',"&a&lCorporate Security Robot"),BarColor.WHITE, BarStyle.SEGMENTED_12,BarFlag.DARKEN_SKY,BarFlag.CREATE_FOG);
		EnemyBossBar.setVisible(true);
		EnemyBossBar.setProgress(1.0);
		for(Player player : z.getWorld().getPlayers()) {
			EnemyBossBar.addPlayer(player);
		}
		new BukkitRunnable() {
			@Override
			public void run() {
				if(z.isDead()) {
					EnemyBossBar.setVisible(false);
					this.cancel();
				} else {
					double Health = Double.parseDouble(new DecimalFormat("#.###").format(z.getHealth() / z.getMaxHealth()));
					EnemyBossBar.setProgress(Health);
				}
			}
		}.runTaskTimer(Plugin, 0L, 20L);
		new BukkitRunnable() {
			@Override
			public void run() {
				if(z.isDead()) {
					this.cancel();
				} else if(z.hasAI() & z.getTarget() != null) {
					int RandomNumber = new Random().nextInt(3);
					switch(RandomNumber) {
						case 0:
							break;
						case 1:
							z.getTarget().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l[ Corporate Security Robot ]:&r &7Target Confirmed."));
							z.getWorld().playSound(z.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_CHIME, 1F, 0.5F);
							z.getWorld().spawnParticle(Particle.DRAGON_BREATH, z.getLocation(),30, 6, 2, 6);
							z.getWorld().createExplosion(z.getTarget().getLocation(), 3L, false,false);
							break;
						case 2:
							z.getTarget().sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&l[ Corporate Security Robot ]:&r &7Damage Detected. Beginning self repair."));
							z.setAI(false);
							z.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION,100,2));
							new BukkitRunnable() {
								@Override
								public void run() {
									// TODO Auto-generated method stub
									z.setAI(true);
									z.getWorld().playSound(z.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1F, 0.5F);
									z.getWorld().spawnParticle(Particle.EXPLOSION_HUGE, z.getLocation(),30, 6, 2, 6);
									z.getWorld().createExplosion(z.getTarget().getLocation(), 10L, true,false);
								}
								
							}.runTaskLater(Plugin, 100L);

					}
					

				}
			}
			
		}.runTaskTimer(Plugin,0L,200L);
		z.getEquipment().setArmorContents(new ItemStack[] {
				Items.CORPORATION_ROBOT_BOOTS,
				Items.CORPORATION_ROBOT_LEGGINGS,
				Items.CORPORATION_ROBOT_CHESTPLATE,
				Items.CORPORATION_ROBOT_HELMET,
		});
		z.getEquipment().setItemInMainHand(Items.CORPORATION_LASER_SWORD);
		z.getEquipment().setItemInOffHand(Items.CORPORATION_LASER_SWORD);
		CorporationEnemy.Zombie = z;
	}
	public Zombie GetEnemy() {
		return CorporationEnemy.Zombie;
	}
}
