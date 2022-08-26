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

public class Centrifuge extends AContainer implements NotHopperable,RecipeDisplayItem  {
	public Centrifuge(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(itemGroup, item, recipeType, recipe);
		// TODO Auto-generated constructor stub
		this.setCapacity(480);
		this.setEnergyConsumption(120);
		this.setProcessingSpeed(20);
	}
    @Override
    public void registerDefaultRecipes() {
    	addRecipe(20,new ItemStack[] { new ItemStack(Material.BEEF,8) },  new ItemStack[] { new CustomItemStack(Items.RED_PHOSPHORUS) });
    	addRecipe(20,new ItemStack[] { new ItemStack(Material.FIRE_CHARGE,12) },  new ItemStack[] { new CustomItemStack(Items.TWELVE) });
    	addRecipe(20,new ItemStack[] { new CustomItemStack(Items.DRIED_PLANT,32)},  new ItemStack[] { new CustomItemStack(Items.PSEUDOEPHEDRINE) });
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
        return new ItemStack(Material.FIRE);
    }
}
