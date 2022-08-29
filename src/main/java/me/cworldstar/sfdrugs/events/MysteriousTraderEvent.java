package me.cworldstar.sfdrugs.events;
import java.util.Random;

import org.apache.commons.lang.math.RandomUtils;
import org.bukkit.Effect;
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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.TradingRecipe;
import me.cworldstar.sfdrugs.implementations.bosses.CorporationMobZone;
import me.cworldstar.sfdrugs.implementations.traders.HookerZombie;
import me.cworldstar.sfdrugs.implementations.traders.MysteriousTrader;
import me.cworldstar.sfdrugs.utils.Items;
import me.cworldstar.sfdrugs.utils.Trading;
import net.md_5.bungee.api.ChatColor;

public class MysteriousTraderEvent implements Listener {
	private SFDrugs plugin;
    public MysteriousTraderEvent(SFDrugs plugin, Trading tradingRegistry) {
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
    	if(!event.getRightClicked().hasMetadata("SFDRUGS_IS_MYSTERIOUS_TRADER") & !(event.getHand() == EquipmentSlot.HAND)) {
    		event.setCancelled(true);
    		return;
    	} else if(event.getRightClicked().hasMetadata("SFDRUGS_IS_MYSTERIOUS_TRADER") & event.getHand() == EquipmentSlot.HAND){
        	// stole this
        	float yaw = (float) Math.toDegrees(Math.atan2(
                    p.getLocation().getZ() - event.getRightClicked().getLocation().getZ(), p.getLocation().getX() - event.getRightClicked().getLocation().getX())) - 90;
        	event.getRightClicked().setRotation(yaw, event.getRightClicked().getLocation().getPitch());
        	p.setMetadata("SFDRUGS_PLAYER_IS_RIGHTCLICKING_TRADER",new FixedMetadataValue(this.plugin,true));
            new BukkitRunnable() {
                @Override
                public void run() {
                	p.removeMetadata("SFDRUGS_PLAYER_IS_RIGHTCLICKING_TRADER", plugin);
               }
            }.runTaskLater(plugin, 20L);
        	PlayerInventory I = p.getInventory();
        	if(I.getItemInMainHand() != null & MysteriousTrader.ItemIsRecipe(I.getItemInMainHand(),I.getItemInMainHand().getAmount()) == true) {
        		TradingRecipe T = MysteriousTrader.GetRecipeFromItem(SlimefunItem.getByItem(I.getItemInMainHand()).getItem(),I.getItemInMainHand().getAmount());
        		if(T != null) {
        			I.getItemInMainHand().setAmount(0);
            		I.addItem(T.getFor());
            		if(new Random().nextInt(4) == 1) {
            			Speak(p,"&c&l[ Mysterious Trader ]: &r&cOh no... They found us.. Run!");
            			p.getWorld().playEffect(event.getRightClicked().getLocation(), Effect.ENDERDRAGON_GROWL, 1);
            			p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS,40,100));
            			event.getRightClicked().remove();
            			new CorporationMobZone(this.plugin,p.getWorld(),p.getLocation());
            		} else {
            			Speak(p,"&c&l[ Mysterious Trader ]: &r&cQuickly, take this and go!");
            		}
        		}

        	} else {
    			Speak(p,"&c&l[ Mysterious Trader ]: &r&cCome back with something of value.");
            }
    	}

    }
}
