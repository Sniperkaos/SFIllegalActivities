package me.cworldstar.sfdrugs.utils;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import net.md_5.bungee.api.ChatColor;

public class SFDrugsHoe extends SlimefunItem {
	public JavaPlugin plugin;
	public SFDrugsHoe(ItemGroup group, SlimefunItemStack hoe, RecipeType recipeType, ItemStack[] recipe,JavaPlugin plugin) {
		super(group,hoe,recipeType,recipe);
		this.plugin = plugin;
	}
	@Override
	public void preRegister() {
        ItemUseHandler itemUseHandler = this::onItemUseRightClick;
        addItemHandler(itemUseHandler);
	}
    private void onItemUseRightClick(PlayerRightClickEvent event) {
    	Location l = event.getPlayer().getLocation();
    	Zombie HoeZombie = (Zombie) (event.getPlayer().getWorld().spawnEntity(l, EntityType.ZOMBIE));
    	HoeZombie.setAI(false);
    	HoeZombie.setCustomName(ChatColor.translateAlternateColorCodes('&', "&d&lHooker Zombie"));
    	HoeZombie.setMetadata("SFDRUGS_IS_HOOKER", new FixedMetadataValue(this.plugin,true));
    	event.getItem().setAmount(0);
    }

	
}
