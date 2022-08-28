package me.cworldstar.sfdrugs.implementations.items;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.cworldstar.sfdrugs.utils.Speak;

public class DrugBaton extends SimpleSlimefunItem<WeaponUseHandler> implements Radioactive,Rechargeable {

	public DrugBaton(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(itemGroup, item, recipeType, recipe);
	}

	@Override
	public float getMaxItemCharge(ItemStack item) {
		// TODO Auto-generated method stub
		return 4800F;
	}
    @Override
	public WeaponUseHandler getItemHandler() {
		return (e,p,i) -> {
			if(e.getDamage() > 0 & this.getItemCharge(i) > 0) {
				if(this.removeItemCharge(i, new Float(e.getDamage()/2))) {
					e.setDamage(e.getFinalDamage() * 2);
                    p.getWorld().spawnParticle(Particle.VILLAGER_HAPPY,e.getEntity().getLocation(),8);
					p.getWorld().playSound(p.getLocation(), Sound.ITEM_TRIDENT_HIT, 0.5F, 1.0F);
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
