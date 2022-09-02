package me.cworldstar.sfdrugs.implementations.items;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.cworldstar.sfdrugs.SFDrugs;

public class UnstableObject extends SlimefunItem {
	private static SFDrugs plugin;
	private Unstable unstable;
	public UnstableObject(ItemGroup itemGroup, ItemStack item,String id,RecipeType recipeType,
			ItemStack[] recipe, Unstable unstable,SFDrugs plugin) {
		super(itemGroup, item,id,recipeType, recipe);
		this.unstable = unstable;
		UnstableObject.plugin = plugin;
		// TODO Auto-generated constructor stub
	}
	public UnstableObject(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
			ItemStack[] recipe, Unstable unstable,SFDrugs plugin) {
		super(itemGroup,item,recipeType, recipe);
		this.unstable = unstable;
		UnstableObject.plugin = plugin;
		item.getItemMeta().getPersistentDataContainer().set(new NamespacedKey(this.plugin,"Unstable"), PersistentDataType.INTEGER,unstable.UNSTABLE_VALUE);
		// TODO Auto-generated constructor stub
	}
	public Unstable getUnstableAmount() {
		return this.unstable;
	}
	public static enum Unstable {
		/**
		 * Will not explode.
		 * 
		 */
		STABLE(1),
		/**
		 * 
		 * Will not explode, but will vanish after 30 seconds.
		 */
		SLIGHTLY_UNSTABLE(2),
		/**
		 * 
		 * Will explode after 30 seconds.
		 * 
		 */
		UNSTABLE(3),
		
		/**
		 * 
		 * Will explode after 10 seconds.
		 * 
		 */
		HIGHLY_UNSTABLE(4);
		private final int UNSTABLE_VALUE;
		Unstable(int e) {
			this.UNSTABLE_VALUE = e;
		}
		public static Unstable getUnstableFromInteger(int unstable) {
			for(Unstable e2 : values()) {
				if (e2.equals(unstable)) {
					return e2;
				}
			}
			return STABLE;
		}
		
		public static double getCooldown(Unstable unstable) {
			
			switch(unstable) {
				case STABLE:
					return 0.0;
				case SLIGHTLY_UNSTABLE:
					return 15.0;
				case UNSTABLE:
					return 15.0;
				case HIGHLY_UNSTABLE:
					return 10.0;
				default:
					break;
				
			}
			
			return 0.0;
			
		}
		
	}
}
