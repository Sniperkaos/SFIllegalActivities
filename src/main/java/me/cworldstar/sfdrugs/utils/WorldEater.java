package me.cworldstar.sfdrugs.utils;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.DamageableItem;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactive;
import io.github.thebusybiscuit.slimefun4.core.handlers.ToolUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import net.md_5.bungee.api.ChatColor;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;

public class WorldEater extends SimpleSlimefunItem<ToolUseHandler> implements Radioactive, DamageableItem, Rechargeable {
	public WorldEater(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(itemGroup, item, recipeType, recipe);
		// TODO Auto-generated constructor stub
	}
	@Override
    public Radioactivity getRadioactivity() {
        return Radioactivity.VERY_DEADLY;
    }
    public float getMaxItemCharge(ItemStack item) {
        return 12000F;
    }
    @Override
    public ToolUseHandler getItemHandler() {
        return (e, tool, fortune, drops) -> {
            Player p = e.getPlayer();
            if (!p.isSneaking()) {
            	if(this.removeItemCharge(tool,2F)) {
                    Block b = e.getBlock();
                    b.getWorld().spawnParticle(Particle.VILLAGER_HAPPY,b.getLocation(),5);
                    b.getWorld().playSound(b.getLocation(), Sound.BLOCK_SCULK_SENSOR_PLACE, 0.2F, 1F);
                    b.breakNaturally(tool);
            	} else {
            		p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&f&l[ SFDrugs ]: &dYour mining drill has run out of power!"));
            		e.setCancelled(true);
            	}

            }
        };
    }
	@Override
	public boolean isDamageable() {
		// TODO Auto-generated method stub
		return false;
	}
}
