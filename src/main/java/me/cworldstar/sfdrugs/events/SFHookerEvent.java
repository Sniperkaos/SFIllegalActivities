package me.cworldstar.sfdrugs.events;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.TradingRecipe;
import me.cworldstar.sfdrugs.implementations.traders.HookerZombie;
import me.cworldstar.sfdrugs.utils.Items;
import me.cworldstar.sfdrugs.utils.Trading;
import net.md_5.bungee.api.ChatColor;

public class SFHookerEvent implements Listener {
	private SFDrugs plugin;
    public SFHookerEvent(SFDrugs plugin, Trading tradingRegistry) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    private void Speak(Player p, String text) {
    	p.getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 0.6F, 0.2F);
    	p.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    }
	@EventHandler(priority = EventPriority.HIGH)
    private void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
		//TODO: Replace this with a ChestInventory.
		
    	Player p = event.getPlayer();
    	if(!event.getRightClicked().hasMetadata("SFDRUGS_IS_HOOKER") & !(event.getHand() == EquipmentSlot.HAND)) {
    		event.setCancelled(true);
    		return;
    	} else if(event.getRightClicked().hasMetadata("SFDRUGS_IS_HOOKER")) {
        	p.setMetadata("SFDRUGS_PLAYER_IS_RIGHTCLICKING_TRADER",new FixedMetadataValue(this.plugin,true));
            new BukkitRunnable() {
                @Override
                public void run() {
                	p.removeMetadata("SFDRUGS_PLAYER_IS_RIGHTCLICKING_TRADER", plugin);
               }
            }.runTaskLater(plugin, 20L);
        	PlayerInventory I = p.getInventory();
        	if(I.getItemInMainHand() != null & HookerZombie.ItemIsRecipe(I.getItemInMainHand(),I.getItemInMainHand().getAmount()) == true) {
        		Speak(p,"&d&l[ Hooker Zombie ]: &r&dOh here, take this.");
        		TradingRecipe T = HookerZombie.GetRecipeFromItem(SlimefunItem.getByItem(I.getItemInMainHand()).getItem(),I.getItemInMainHand().getAmount());
        		if(T != null) {
        			I.getItemInMainHand().setAmount(0);
            		I.addItem(T.getFor());
        		}
        	} else if(I.getItem(I.getHeldItemSlot()) != null) {
    			Speak(p,"&d&l[ Hooker Zombie ]: &r&dWhat makes you think I'd like that? Go away, loser.");
            } else {
                Speak(p,"&d&l[ Hooker Zombie ]: &r&dWhat are you trying to do? Handshake me? What a weirdo.");
            }
    	}
    }
}
