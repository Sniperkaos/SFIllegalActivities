package me.cworldstar.sfdrugs.events;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.cworldstar.sfdrugs.utils.Items;
import net.md_5.bungee.api.ChatColor;

public class SFHookerEvent implements Listener {
	private JavaPlugin plugin;
    public SFHookerEvent(JavaPlugin plugin) {
    	this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    private void Speak(Player p, String text) {
    	p.getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 0.6F, 0.2F);
    	p.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    }
	@EventHandler(priority = EventPriority.HIGH)
    private void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
    	Player p = event.getPlayer();
    	if(!event.getRightClicked().hasMetadata("SFDRUGS_IS_HOOKER")) {
    		event.setCancelled(true);
    		return;
    	}
    	p.setMetadata("SFDRUGS_PLAYER_IS_RIGHTCLICKING_HOOKER",new FixedMetadataValue(this.plugin,true));
        new BukkitRunnable() {
            @Override
            public void run() {
            	p.removeMetadata("SFDRUGS_PLAYER_IS_RIGHTCLICKING_HOOKER", plugin);
           }
        }.runTaskLater(plugin, 20L);
    	PlayerInventory I = p.getInventory();
    	if (event.getRightClicked().hasMetadata("SFDRUGS_IS_HOOKER")) {
    		if(SlimefunItem.getByItem(I.getItem(I.getHeldItemSlot())).isItem(Items.METH)) {
    			int Amount = I.getItem(I.getHeldItemSlot()).getAmount();
    			if(Amount <= 32 & Amount >= 16) {
	    			Speak(p,"&d&l[ Hooker Zombie ]: &r&dYou really don't have that much meth...");
	    			Speak(p,"&d&l[ Hooker Zombie ]: &r&dI can give you this, though!");
                	ItemStack Meth = I.getItem(I.first(Items.METH));
                	Meth.setAmount(Meth.getAmount()-16);
                	I.addItem(SlimefunItems.BASIC_CIRCUIT_BOARD);
    				return;

	    			
    			} else if(Amount < 16) {
    				Speak(p,"&d&l[ Hooker Zombie ]: &r&dUgh, Ew. A loser. Come back when you have at least 16 meth crystals.");
    				return;

    			} else if(Amount > 32 & Amount < 64) {
    				Speak(p,"&d&l[ Hooker Zombie ]: &r&dOh wow, that's some meth.");
    				Speak(p,"&d&l[ Hooker Zombie ]: &r&dMaybe, a little bit more to sweeten the deal.");

    				return;

    			} else {
                	Speak(p,"&d&l[ Hooker Zombie ]: &r&dOoh, wow. You have a ton of meth. Okay, I guess I can trade");
                	Speak(p,"&d&l[ Hooker Zombie ]: &r&dmy prized possession with you.");
                	ItemStack Meth = I.getItem(I.first(Items.METH));
                	Meth.setAmount(0);
                	I.addItem(Items.GAY_PANTS);
                	return;
    			}

    		} else if(I.getItem(I.getHeldItemSlot()) != null) {
				Speak(p,"&d&l[ Hooker Zombie ]: &r&dWhat makes you think I'd like that? Go away, loser.");

        	} else {
            	Speak(p,"&d&l[ Hooker Zombie ]: &r&dWhat are you trying to do? Handshake me? What a weirdo.");
        	}
    	}

    }
}
