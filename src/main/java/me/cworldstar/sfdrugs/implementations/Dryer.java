package me.cworldstar.sfdrugs.implementations;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotHopperable;
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.cworldstar.sfdrugs.utils.Items;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import net.md_5.bungee.api.ChatColor;

public class Dryer extends AContainer implements NotHopperable,RecipeDisplayItem  {
	public Dryer(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(itemGroup, item, recipeType, recipe);
		// TODO Auto-generated constructor stub
		this.setCapacity(480);
		this.setEnergyConsumption(120);
		this.setProcessingSpeed(20);
	}
    @Override
    public void registerDefaultRecipes() {
    	addRecipe(20,new ItemStack[] { new ItemStack(Material.PAPER), Items.TRAY },  new ItemStack[] { new CustomItemStack(Items.METH,8),Items.TRAY });
    }
    @Override
    public String getMachineIdentifier() {
        return "SFDRUGS_DRYER";
    }
    private void addRecipe(int seconds, ItemStack[] input, ItemStack[] output) {
    	registerRecipe(seconds,input,output);
    }
    @Override
    public ItemStack getProgressBar() {

        return new ItemStack(Material.CAMPFIRE);
    }
}
