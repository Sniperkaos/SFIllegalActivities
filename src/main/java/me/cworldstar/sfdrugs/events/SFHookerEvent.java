package me.cworldstar.sfdrugs.events;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.cworldstar.sfdrugs.utils.Items;
import net.md_5.bungee.api.ChatColor;

public class SFHookerEvent implements Listener {
	
    public SFHookerEvent(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    private void Speak(Player p, String text) {
    	p.getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 0.6F, 0.2F);
    	p.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    }
	@EventHandler
    private void onPlayerInteractEntity(PlayerInteractEntityEvent event) {
    	Player p = event.getPlayer();
    	PlayerInventory I = p.getInventory();
    	if (event.getRightClicked().hasMetadata("SFDRUGS_IS_HOOKER")) {
    		if(I.getItemInMainHand().isSimilar(Items.METH)) {
    			int Amount = I.getItemInMainHand().getAmount();
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

    		} else {
            	Speak(p,"&d&l[ Hooker Zombie ]: &r&dWhat are you trying to do? Handshake me? What a weirdo.");
        	}
    	}

    }
}
