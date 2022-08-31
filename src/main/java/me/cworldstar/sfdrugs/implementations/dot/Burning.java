package me.cworldstar.sfdrugs.implementations.dot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.utils.Speak;

public class Burning {
	private static List<PotionEffect> PotionEffects = new ArrayList<PotionEffect>();
	private static boolean ShouldEnd = false;
	static {
		Collection<PotionEffect> PotionEffectCollection = new ArrayList<PotionEffect>();
		PotionEffectCollection.add(new PotionEffect(PotionEffectType.WITHER,120,2));
		PotionEffectCollection.add(new PotionEffect(PotionEffectType.GLOWING,240,1));
		PotionEffects.addAll(PotionEffectCollection);
	}
	/**
	 * Takes a LivingEntity p, and the APlugin extension.
	 * Causes Disintegration.
	 * 
	 * @param p
	 * @param sfdrugs
	 * @author cworldstar
	 */
	public Burning(LivingEntity p,SFDrugs sfdrugs) {
		for(PotionEffect potion : Burning.PotionEffects) {
			p.addPotionEffect(potion);
		}
		p.setFireTicks(60);
		new Speak(p,"&e&lYou are disintegrating. Consider running away.");
		new BukkitRunnable() {
			@Override
			public void run() {
				if(Burning.ShouldEnd == true) {
					this.cancel();
				}
				p.getWorld().spawnParticle(Particle.SMOKE_NORMAL,p.getLocation(),10,1.0,2.0,1.0);
				for(PotionEffect potion : Burning.PotionEffects) {
					p.addPotionEffect(potion);
				}
			}
		}.runTaskTimer(sfdrugs, 0, 20);
		new BukkitRunnable() {
			@Override
			public void run() {
				Burning.ShouldEnd = true;
				this.cancel();
			}
		}.runTaskLater(sfdrugs, 240);
	}
}
