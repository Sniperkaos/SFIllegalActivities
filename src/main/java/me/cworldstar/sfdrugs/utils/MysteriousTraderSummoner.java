package me.cworldstar.sfdrugs.utils;

import org.bukkit.Location;
import org.bukkit.Material;
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

public class MysteriousTraderSummoner extends SlimefunItem {
	public JavaPlugin plugin;
	public MysteriousTraderSummoner(ItemGroup group, SlimefunItemStack hoe, RecipeType recipeType, ItemStack[] recipe,JavaPlugin plugin) {
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
    	HoeZombie.setSilent(true);
    	HoeZombie.getEquipment().setArmorContents(new ItemStack[] {
    			new ItemStack(Material.NETHERITE_BOOTS),
    			new ItemStack(Material.NETHERITE_LEGGINGS),
    			new ItemStack(Material.NETHERITE_CHESTPLATE),
    			Items.MYSTERIOUS_TRADER_HEAD,
    			
    	});
    	
    	HoeZombie.setCustomName(ChatColor.translateAlternateColorCodes('&', "&c&lMysterious Trader"));
    	HoeZombie.setMetadata("SFDRUGS_IS_MYSTERIOUS_TRADER", new FixedMetadataValue(this.plugin,true));
    	event.getItem().setAmount(0);
    }

	
}
