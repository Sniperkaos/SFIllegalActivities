package me.cworldstar.sfdrugs.utils;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DrugEffect {

	private int PotionEndTime;
	private int amplifier;
	private int interval;
	private int NauseaBegin;
	private int NauseaEnd;

	public DrugEffect(PotionEffectType type, int PotionEndTime, int amplifier,int interval,int NauseaBegin,int NauseaEnd) {
		// TODO Auto-generated constructor stub
		this.PotionEndTime = PotionEndTime;
		this.amplifier = amplifier;
		this.interval = interval;
		this.NauseaBegin = NauseaBegin;
		this.NauseaEnd = NauseaEnd;
	}
	private void LingeringPotionListener() {
		
	}
}
