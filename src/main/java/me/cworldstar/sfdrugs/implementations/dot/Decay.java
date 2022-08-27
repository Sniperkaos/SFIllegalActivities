package me.cworldstar.sfdrugs.implementations.dot;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import me.cworldstar.sfdrugs.utils.Speak;

public class Decay {
	public Decay(JavaPlugin plugin,Player p,PotionEffect[] PotionEffects) {
		for(PotionEffect potion : PotionEffects) {
			p.addPotionEffect(potion);
		}
		new Speak(p,"&7&lYou are decaying. Consider running away.");
	}
}
