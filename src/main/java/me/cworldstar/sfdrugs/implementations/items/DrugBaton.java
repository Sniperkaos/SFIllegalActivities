package me.cworldstar.sfdrugs.implementations.items;

import org.bukkit.Axis;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;
import me.cworldstar.sfdrugs.utils.Speak;

public class DrugBaton extends SlimefunItem implements Radioactive,Rechargeable {

	public DrugBaton(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(itemGroup, item, recipeType, recipe);
	}

	@Override
	public float getMaxItemCharge(ItemStack item) {
		// TODO Auto-generated method stub
		return 4800F;
	}
	
	public WeaponUseHandler getItemHandler() {
		return (e,p,i) -> {
			if(e.getDamage() > 0 & this.getItemCharge(i) > 0) {
				if(this.removeItemCharge(i, new Float(e.getDamage()/2))) {
					e.setDamage(e.getDamage() * 1.5);
					p.getWorld().playEffect(p.getLocation(), Effect.ELECTRIC_SPARK,Axis.Y);
					p.getWorld().playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 0.5F, 1.0F);
				} else {
					e.setDamage(e.getFinalDamage()/3);
					new Speak(p,"&7Your baton has run out of power.");
				}
			}
		
		};
	}

	@Override
	public Radioactivity getRadioactivity() {
		return Radioactivity.VERY_DEADLY;
	}

}
