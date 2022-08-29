package me.cworldstar.sfdrugs.utils;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;

public class Drug extends SlimefunItem {
	private PotionEffect[] potionEffects;
	public Drug(ItemGroup itemGroup, SlimefunItemStack item,RecipeType recipeType, ItemStack[] recipe, PotionEffect[] effects) {
		super(itemGroup, item, recipeType, recipe);
		this.potionEffects = effects;
	}

	@Override
	public void preRegister() {
        ItemUseHandler itemUseHandler = this::onItemUseRightClick;
        addItemHandler(itemUseHandler);
	}
    private void onItemUseRightClick(PlayerRightClickEvent event) {
    	if(event.getPlayer().hasMetadata("SFDRUGS_PLAYER_IS_RIGHTCLICKING_TRADER")) {
    		event.cancel();
    		return;
    	}
    	for( PotionEffect effect : this.potionEffects) {
            event.getPlayer().addPotionEffect(effect);
    	}
        event.getItem().setAmount(event.getItem().getAmount()-1);
    }
}
