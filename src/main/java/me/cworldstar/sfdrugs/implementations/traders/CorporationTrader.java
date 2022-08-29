package me.cworldstar.sfdrugs.implementations.traders;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.cworldstar.sfdrugs.implementations.TradingRecipe;

public class CorporationTrader {
	private static ArrayList<TradingRecipe> Recipes;
	public CorporationTrader() {
		CorporationTrader.Recipes = new ArrayList<TradingRecipe>();
	}
	public void RegisterTradingRecipe(TradingRecipe t) {
		if(t.getTradingRecipe().Validate()) {
			CorporationTrader.Recipes.add(t);
		}
	}
	public static TradingRecipe GetRecipeFromItem(ItemStack Item,int Amount) {
		for(TradingRecipe T : CorporationTrader.Recipes) {
			if(T.getHave().equals(new CustomItemStack(Item,Amount))) {
				return T;
			}
		}
		return null;
	}
	public static boolean ItemIsRecipe(ItemStack Item, int Amount) {
		for(TradingRecipe T : CorporationTrader.Recipes) {
			if(T.getHave().equals(new CustomItemStack(Item,Amount))) {
				Logger.getGlobal().log(Level.INFO, "===========================");
				Logger.getGlobal().log(Level.INFO, Item.toString());
				Logger.getGlobal().log(Level.INFO, Integer.toString(Amount));
				Logger.getGlobal().log(Level.INFO, "===========================");
				return true;
			}
		}
		return false;
	}
}
