package me.cworldstar.sfdrugs.implementations.items;


import org.bukkit.Axis;
import org.bukkit.Effect;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import me.cworldstar.sfdrugs.utils.Speak;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectionType;
import io.github.thebusybiscuit.slimefun4.core.attributes.ProtectiveArmor;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.implementation.items.armor.SlimefunArmorPiece;

public class DrugSuit extends SlimefunArmorPiece implements ProtectiveArmor, Rechargeable {
	public JavaPlugin plugin;

	public DrugSuit(JavaPlugin plugin, ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType,
			ItemStack[] recipe, PotionEffect[] effects) {
		super(itemGroup, item, recipeType, recipe, effects);
		this.plugin = plugin;
	}

	@Override
	public ProtectionType[] getProtectionTypes() {
		return new ProtectionType[] { ProtectionType.RADIATION };
	}

	@Override
	public boolean isFullSetRequired() {
		return true;
	}

	@Override
	public NamespacedKey getArmorSetId() {
		// TODO Auto-generated method stub
		return new NamespacedKey(this.plugin, "SFDRUGS_DRUGSET");
	}

	@Override
	public float getMaxItemCharge(ItemStack item) {
		// TODO Auto-generated method stub
		return 1200F;
	}

	public Boolean Damage(PlayerItemDamageEvent e, ItemStack Item, int dmg) {
		if (this.getItemCharge(Item) > 0 & !this.removeItemCharge(Item, dmg)) {
			return true;
		} else {
			e.setCancelled(true);
			return false;
		}
	}

	public void PlayerDamaged(EntityDamageByEntityEvent e,Player p,ItemStack item, int intValue) {
		if(this.getItemCharge(item) > 0 & this.removeItemCharge(item, intValue)) {
			p.getWorld().playEffect(p.getLocation(), Effect.ELECTRIC_SPARK,Axis.Y);
			p.getWorld().playSound(p.getLocation(), Sound.BLOCK_ANVIL_PLACE, 0.4F, 0.5F);
			new Speak(p,"&7&l[ Internal Radio ]: Blocked " + Integer.toString(intValue) + " damage.");
			e.setDamage(0);
		}
	}
}