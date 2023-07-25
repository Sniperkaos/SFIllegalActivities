package me.cworldstar.sfdrugs.implementations.items.armorsets;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;

public class AArmorSet implements Listener {
	public static List<AArmorPiece> ArmorPieces = new ArrayList<AArmorPiece>();
	public static List<PotionEffect> PotionEffects = new ArrayList<PotionEffect>();
	
	public AArmorSet(ItemStack[] ArmorPieces) {
		
	}
	
	public boolean PlayerIsWearingFullSet(Player p) {
		Inventory I = p.getInventory();
		int Wearing = 0;
		for (int i = 5; i <= 8 ;i++) {
			SlimefunItem IsItemArmorPiece = SlimefunItem.getByItem(I.getItem(i));
			if (!IsItemArmorPiece.equals(null) && IsItemArmorPiece instanceof AArmorPiece) {
				Wearing += 1;
			}
		}
		return (Wearing >=4);
	}
	
	
}
