package me.cworldstar.sfdrugs.implementations.items.armorsets;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.items.CustomArmorPiece;

public class AArmorPiece extends CustomArmorPiece {

	public AArmorPiece(SFDrugs plugin, ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
			ItemStack[] recipe, PotionEffect[] effects) {
		super(plugin, itemGroup, item, recipeType, recipe, effects);
		// TODO Auto-generated constructor stub
	}
	
	public void applyPieceEdits(ItemStack ArmorPiece, double HealthBonus, double Armor, double Hardness) {
		
		ItemMeta meta = ArmorPiece.getItemMeta();
		meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier("SFDRUGS_ARMOR_HEALTH_BONUS", HealthBonus, Operation.ADD_NUMBER));
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("SFDRUGS_ARMOR_HEALTH_BONUS", Armor, Operation.ADD_NUMBER));
		meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier("SFDRUGS_ARMOR_HEALTH_BONUS", Hardness, Operation.ADD_NUMBER));
		ArmorPiece.setItemMeta(meta);
		
	}


	
}
