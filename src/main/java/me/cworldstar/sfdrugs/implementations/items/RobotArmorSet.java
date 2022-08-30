package me.cworldstar.sfdrugs.implementations.items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.cworldstar.sfdrugs.SFDrugs;

public class RobotArmorSet {
	public static List<RobotArmor> ArmorPieces = new ArrayList<RobotArmor>();
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
	public static void applyRobotArmorSetEffects(Entity e) {
		if (e instanceof Player) {
			for(PotionEffect effect : PotionEffects) {
				((Player) e).addPotionEffect(effect);
			}
		}
	}
	
	public static RobotArmor[] ToRobotArmor(ItemStack[] ArmorPieces) {
		List<RobotArmor> ValidatedPieces = new ArrayList<RobotArmor>();
		for(ItemStack ArmorPiece : ArmorPieces) {
			if (SlimefunItem.getByItem(ArmorPiece) != null) {
				if (SlimefunItem.getByItem(ArmorPiece).getId().contains("SFDRUGS_CORPORATION_ROBOT")) {
					ValidatedPieces.add((RobotArmor)SlimefunItem.getByItem(ArmorPiece));
				}
			}
		}
		return ValidatedPieces.toArray(new RobotArmor[]{});
	}
	
	public static boolean RemoveSetItemCharge(RobotArmor[] ArmorPieces, int charge,PlayerItemDamageEvent e) {
		
		for(RobotArmor Piece : ArmorPieces) {
			Piece.ArmorDamaged(e,Piece.getItem(), charge / ArmorPieces.length);
		}
		return true;
	}
	public static boolean RemoveSetItemCharge(RobotArmor[] ArmorPieces, double charge,EntityDamageByEntityEvent e) {
		if(e.getEntity() instanceof Mob) {
			for(RobotArmor Piece : ArmorPieces) {
				Piece.EntityDamaged(e,(Mob) e.getEntity(),Piece.getItem(), charge / ArmorPieces.length);
			}
		} else if(e.getEntity() instanceof Player) {
			for(RobotArmor Piece: ArmorPieces) {
				Piece.PlayerDamaged(e, (Player) e.getEntity(), Piece.getItem(), charge / ArmorPieces.length);
			}
		}
		

		return true;
	}
	
	
	public RobotArmorSet(SFDrugs plugin, ItemGroup group, SlimefunItemStack[] ArmorPieces, RecipeType SecurityRobotDrop,PotionEffect[] PotionEffects) {
		for(SlimefunItemStack ArmorPiece : ArmorPieces) {
			RobotArmor NewRobotArmor = new RobotArmor(plugin, group, ArmorPiece, SecurityRobotDrop,new ItemStack[] {}, null);
			NewRobotArmor.register(plugin);
			RobotArmorSet.ArmorPieces.add(NewRobotArmor);
		}
		for(PotionEffect effect : PotionEffects) {
			RobotArmorSet.PotionEffects.add(effect);
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
