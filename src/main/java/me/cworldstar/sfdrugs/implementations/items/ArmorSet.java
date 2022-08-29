package me.cworldstar.sfdrugs.implementations.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.cworldstar.sfdrugs.SFDrugs;

public class ArmorSet {
	public static List<CustomArmorPiece> ArmorPieces = new ArrayList<CustomArmorPiece>();
	public static List<PotionEffect> PotionEffects = new ArrayList<PotionEffect>();
	public static boolean WearingFullArmorSet(Entity e) {
		if(e instanceof Player) {
			int count = 0;
			for(ItemStack ArmorPiece : ((Player) e).getInventory().getArmorContents()) {
				if(ArmorPieces.contains(SlimefunItem.getByItem(ArmorPiece))) {
					count++;
				}
			}
			return (count == 4);
		} else if(e instanceof Zombie) {
			// ASSUME YES
			return true;
		}
		return false;
	}
	public static boolean WearingMostArmorSet(Entity e) {
		if(e instanceof Player) {
			int count = 0;
			for(ItemStack ArmorPiece : ((Player) e).getInventory().getArmorContents()) {
				if(ArmorPieces.contains(SlimefunItem.getByItem(ArmorPiece))) {
					count++;
				}
			}
			return (count >=3);
		} else if(e instanceof Zombie) {
			// ASSUME YES
			return true;
		}
		return false;
	}
	public static void applyArmorSetEffects(Entity e) {
		if (e instanceof Player) {
			for(PotionEffect effect : PotionEffects) {
				((Player) e).addPotionEffect(effect);
			}
		}
	}
	
	public ArmorSet(SFDrugs plugin, ItemGroup group, SlimefunItemStack[] ArmorPieces, RecipeType RecipeType,PotionEffect[] PotionEffects) {
		for(SlimefunItemStack ArmorPiece : ArmorPieces) {
			CustomArmorPiece NewArmorPiece = new CustomArmorPiece(plugin,group, ArmorPiece,RecipeType,new ItemStack[] {}, null);
			NewArmorPiece.register(plugin);
			ArmorSet.ArmorPieces.add(NewArmorPiece);
		}
		for(PotionEffect effect : PotionEffects) {
			ArmorSet.PotionEffects.add(effect);
		}
	}
	
	public static void removeRobotArmorSetEffects(Entity e) {
		// TODO Auto-generated method stub
		if (e instanceof Player) {
			for(PotionEffect effect : PotionEffects) {
				((Player) e).removePotionEffect(effect.getType());
			}
		}
	}



}
