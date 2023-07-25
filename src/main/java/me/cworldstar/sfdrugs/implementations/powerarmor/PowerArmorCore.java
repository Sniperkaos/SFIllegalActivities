package me.cworldstar.sfdrugs.implementations.powerarmor;

import java.util.ArrayList;

import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.NotImplementedYet;

public class PowerArmorCore extends SlimefunItem implements Rechargeable, NotImplementedYet {
	
	
	public static ArrayList<PowerArmorCore> Cores = new ArrayList<PowerArmorCore>();

	public PowerArmorCore(ItemGroup itemGroup, ItemStack item, String id, RecipeType recipeType, ItemStack[] recipe, String core_id) {
		super(itemGroup, item, id, recipeType, recipe);
		// TODO Auto-generated constructor stub
		this.getItem().getItemMeta().getPersistentDataContainer().set(SFDrugs.createKey("power_armor_core"), PersistentDataType.STRING, core_id);
		PowerArmorCore.Cores.add(this);
	}

	
	
	
	@Override
	public float getMaxItemCharge(ItemStack item) {
		// TODO Auto-generated method stub
		return 0;
	}

}
