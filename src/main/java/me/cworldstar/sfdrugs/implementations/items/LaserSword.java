package me.cworldstar.sfdrugs.implementations.items;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.core.handlers.WeaponUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.dot.Burning;
import me.cworldstar.sfdrugs.implementations.dot.Decay;
import me.cworldstar.sfdrugs.utils.Speak;

public class LaserSword extends SlimefunItem implements Radioactive,Rechargeable {

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
	public void preRegister() {
		WeaponUseHandler One = this::getAttackHandler;
		addItemHandler(One);
		
		ItemUseHandler Two = this::getRightClickHandler;
		addItemHandler(Two);
	}
	public void getAttackHandler(EntityDamageByEntityEvent e, Player p, ItemStack i) {

		if(e.getFinalDamage() > 0 & this.getItemCharge(i) > 0) {
			if(this.removeItemCharge(i, new Float(e.getFinalDamage() * 2))) {
				if(e.getEntity() instanceof LivingEntity) {
					switch(i.getType()) {
						case STONE_SWORD: 
							new Decay((LivingEntity) e.getEntity(),this.plugin);
							e.setDamage(e.getFinalDamage() * 8);
							break;
						case GOLDEN_SWORD:
							if(this.removeItemCharge(i, new Float(e.getFinalDamage() * 10))) {
								new Burning((LivingEntity) e.getEntity(),this.plugin);
								e.setDamage(e.getFinalDamage() * 10);
							}
							break;
					default:
						break;
					}

				}
			} 
		} else if(this.getItemCharge(i) <= e.getFinalDamage() * 2){
			new Speak(p,"&7You attempt to swing with a sheathed hilt. It does not work.");
			e.setDamage(0);
			e.setCancelled(true);
		}
	}
	
	public void getRightClickHandler(PlayerRightClickEvent e) {
		ItemStack Sword = e.getItem();
		switch(Sword.getType()) {
		case STONE_SWORD:
			Sword.setType(Material.GOLDEN_SWORD);
			List<String> Lore = Sword.getItemMeta().getLore();
			Lore.set(1,new Speak().format("&eDisintegrate C")); 
			Sword.getItemMeta().setLore(Lore);
			Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 10);
			break;
		case GOLDEN_SWORD:
			Sword.setType(Material.STONE_SWORD);
			List<String> Lore2 = Sword.getItemMeta().getLore();
			Lore2.set(1,new Speak().format("&7Decay C")); 
			Sword.getItemMeta().setLore(Lore2);
			Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 5);
			break;
		default:
			break;
		}
	}
	
	
}
