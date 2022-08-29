package me.cworldstar.sfdrugs.utils;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Speak {
    public Speak(Player p, String text) {
    	p.getWorld().playSound(p.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 0.6F, 0.2F);
    	p.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    }
    public Speak(Entity Origin,List<Entity> Entities, String text) {
    	for(Entity e : Entities) {
    		Origin.getWorld().playSound(Origin.getLocation(), Sound.ENTITY_VILLAGER_TRADE, 0.6F, 0.2F);
    		e.sendMessage(ChatColor.translateAlternateColorCodes('&', text));
    	}
    }
}
