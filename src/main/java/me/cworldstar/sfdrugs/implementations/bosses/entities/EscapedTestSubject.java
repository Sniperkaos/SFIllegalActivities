package me.cworldstar.sfdrugs.implementations.bosses.entities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.loot.SmallerGangMemberLootTable;
import me.cworldstar.sfdrugs.utils.Speak;
import net.md_5.bungee.api.ChatColor;

public class EscapedTestSubject {
	public EscapedTestSubject(SFDrugs plugin, Zombie z) {
		z.setCustomName(ChatColor.translateAlternateColorCodes('&', "&a&l|||&r &2&l⚠ Escaped Corporate Test Subject ⚠&r &a&l|||&r"));
		z.setMaxHealth(2500.0);
		z.setHealth(2500.0);
		z.setAdult();
		z.setCanPickupItems(false);		
		z.setLootTable(new SmallerGangMemberLootTable(plugin));
		BossBar EnemyBossBar = Bukkit.getServer().createBossBar(ChatColor.translateAlternateColorCodes('&',"&c&l&k|||&r &4&l⚠ Red Wolves Gangster ⚠&r &c&l&k|||&r"),BarColor.RED, BarStyle.SEGMENTED_12);
		EnemyBossBar.setVisible(true);
		EnemyBossBar.setProgress(1.0);
		List<Player> Players = new ArrayList<Player>();
		new BukkitRunnable() {
			@Override
			public void run() {
				if(z.isDead()) {
					EnemyBossBar.setVisible(false);
					this.cancel();
				} else {
					double Health = Double.parseDouble(new DecimalFormat("#.###").format(z.getHealth() / z.getMaxHealth()));
					EnemyBossBar.setProgress(Health);
					for(Entity e : z.getNearbyEntities(20.0, 20.0, 20.0)) {
						if (e instanceof Player) {
							if(!Players.contains((Player) e)) {
								Players.add((Player) e);
								EnemyBossBar.addPlayer((Player) e);
							}
						}
					}
					for(Player p : EnemyBossBar.getPlayers()) {
						if(!Players.contains(p)) {
							EnemyBossBar.removePlayer(p);
						}
					}
				}
			}
		}.runTaskTimer(plugin, 0L, 10L);
		ItemStack ZombieHead = SlimefunUtils.getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWNjNGI1YjdmNjE2OTQyOGNlZTcyZDFkZTNlYjkzNTc5M2I3ZDZmNGI2YzFhMjNjMzRhMjZkZGE2MDYwMWNjOSJ9fX0=");
		ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta BootsMeta = (LeatherArmorMeta) Boots.getItemMeta();
		new Speak(BootsMeta,"&c Red Wolves Vest");
		BootsMeta.setColor(Color.LIME);
		BootsMeta.setUnbreakable(true);
		Boots.setItemMeta(BootsMeta);
		
		//TODO: Add a "Thorns" effect to EscapedTestSubject and a "Regeneration" effect. Attacks should apply "Decaying" unless player is wearing armored hazmat.
		//TODO: Increase zombie speed and strength. Make it slightly faster than the player and give it a warden-like ranged projectile attack.
		
		
		ItemStack Leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta LeggingsMeta = (LeatherArmorMeta) Leggings.getItemMeta();
		new Speak(LeggingsMeta,"&c Red Wolves Jeans");
		LeggingsMeta.setColor(Color.LIME);		
		LeggingsMeta.setUnbreakable(true);
		Leggings.setItemMeta(LeggingsMeta);
		
		
		ItemStack Chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta ChestplateMeta = (LeatherArmorMeta) Chestplate.getItemMeta();
		new Speak(ChestplateMeta,"&c Red Wolves Vest");
		ChestplateMeta.setColor(Color.LIME);
		ChestplateMeta.setUnbreakable(true);
		Chestplate.setItemMeta(ChestplateMeta);
		z.getEquipment().setArmorContents(new ItemStack[] {
				Boots,
				Leggings,
				Chestplate,
				ZombieHead
		});
	}
}