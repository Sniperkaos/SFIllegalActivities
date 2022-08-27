package me.cworldstar.sfdrugs.implementations.items;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;

public class IrradiatedItem extends SlimefunItem implements Radioactive {
	public Radioactivity radioactivity;
	public IrradiatedItem(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,Radioactivity Radioactive) {
		super(itemGroup, item,recipeType, recipe);
		// TODO Auto-generated constructor stub
		this.radioactivity = Radioactive;
	}

	@Override
	public Radioactivity getRadioactivity() {
		// TODO Auto-generated method stub
		return this.radioactivity;
	}

}
