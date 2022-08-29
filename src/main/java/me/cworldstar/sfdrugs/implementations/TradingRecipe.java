package me.cworldstar.sfdrugs.implementations;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class TradingRecipe {
	private CustomItemStack Have;
	private CustomItemStack For;

	public TradingRecipe(ItemStack Have, int HaveAmt, ItemStack For, int ForAmt) {
		this.Have = new CustomItemStack(Have,HaveAmt);
		this.For = new CustomItemStack(For,ForAmt);
	}
	public ItemStack getHave() {
		return this.Have;
	}
	public ItemStack getFor() {
		return this.For;
	}
	public TradingRecipe getTradingRecipe() {
		return this;
		
	}
	public boolean Validate() {
		if(this.Have.getAmount() < 65 & this.For.getAmount() < 65) {
			return true;
		}
		return false;
	}
}
