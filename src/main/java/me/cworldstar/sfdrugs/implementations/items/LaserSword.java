package me.cworldstar.sfdrugs.implementations.items;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.dot.Decay;
import me.cworldstar.sfdrugs.utils.Speak;

public class LaserSword extends SimpleSlimefunItem<WeaponUseHandler> implements Radioactive,Rechargeable {

	private SFDrugs plugin;

	public LaserSword(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,SFDrugs plugin) {
		super(itemGroup, item, recipeType, recipe);
		// TODO Auto-generated constructor stub
		this.plugin = plugin;
	}

	@Override
	public float getMaxItemCharge(ItemStack item) {
		// TODO Auto-generated method stub
		return 12800;
	}

	@Override
	public Radioactivity getRadioactivity() {
		// TODO Auto-generated method stub
		return Radioactivity.MODERATE;
	}

	@Override
	public WeaponUseHandler getItemHandler() {
		// TODO Auto-generated method stub
		return (e,p,i) -> {
			if(e.getFinalDamage() > 0 & this.getItemCharge(i) > 0) {
				if(this.removeItemCharge(i, new Float(e.getFinalDamage() * 2))) {
					if(e.getEntity() instanceof LivingEntity) {
						new Decay((LivingEntity) e.getEntity(),this.plugin);
						e.setDamage(e.getFinalDamage() * 8);
					}
				} 
			} else if(this.getItemCharge(i) <= e.getFinalDamage() * 2){
				new Speak(p,"&7You attempt to swing with a sheathed hilt. It does not work.");
				e.setDamage(0);
				e.setCancelled(true);
			}
		};
	}

}
