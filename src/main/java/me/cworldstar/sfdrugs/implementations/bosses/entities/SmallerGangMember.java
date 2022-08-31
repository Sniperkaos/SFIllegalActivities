package me.cworldstar.sfdrugs.implementations.bosses.entities;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.LlamaSpit;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.loot.CorporationEnemyLootTable;
import me.cworldstar.sfdrugs.implementations.loot.SmallerGangMemberLootTable;
import me.cworldstar.sfdrugs.utils.ParticleUtils;
import me.cworldstar.sfdrugs.utils.Speak;
import net.md_5.bungee.api.ChatColor;

public class SmallerGangMember {
	public SmallerGangMember(SFDrugs plugin,Zombie z) {
		z.setCustomName(ChatColor.translateAlternateColorCodes('&', "&c&lRed Wolves Trainee"));
		z.setMaxHealth(100.0);
		z.setHealth(100.0);
		z.setAdult();
		z.setCanPickupItems(false);		
		z.setLootTable(new SmallerGangMemberLootTable(plugin));
		ItemStack ZombieHead = SlimefunUtils.getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjgxOWM5OTY2ZmQ4OWI0YjM4MTJlMmRmMTdkODk4NzliZTVmMjNmZGU5ZmQ3MTQ2NWQzZjAwMjM2ZGJkMjZmOCJ9fX0=");
		ItemStack Boots = new ItemStack(Material.LEATHER_BOOTS);
		LeatherArmorMeta BootsMeta = (LeatherArmorMeta) Boots.getItemMeta();
		new Speak(BootsMeta,"&c Red Wolves Vest");
		BootsMeta.setColor(Color.RED);
		BootsMeta.setUnbreakable(true);
		Boots.setItemMeta(BootsMeta);
		ItemStack Leggings = new ItemStack(Material.LEATHER_LEGGINGS);
		LeatherArmorMeta LeggingsMeta = (LeatherArmorMeta) Leggings.getItemMeta();
		new Speak(LeggingsMeta,"&c Red Wolves Jeans");
		LeggingsMeta.setColor(Color.RED);
		LeggingsMeta.setUnbreakable(true);
		Leggings.setItemMeta(LeggingsMeta);
		ItemStack Chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta ChestplateMeta = (LeatherArmorMeta) Chestplate.getItemMeta();
		new Speak(ChestplateMeta,"&c Red Wolves Vest");
		ChestplateMeta.setColor(Color.RED);
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
