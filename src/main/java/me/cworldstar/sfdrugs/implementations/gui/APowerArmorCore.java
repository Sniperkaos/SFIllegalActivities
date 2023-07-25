package me.cworldstar.sfdrugs.implementations.gui;

import java.util.ArrayList;

import org.bukkit.event.Listener;

import me.cworldstar.sfdrugs.implementations.powerarmor.PowerArmor;
import me.cworldstar.sfdrugs.implementations.powerarmor.PowerArmorCore;
import me.cworldstar.sfdrugs.implementations.powerarmor.PowerArmorCoreUpgrade;

public class APowerArmorCore implements Listener {
	
	private ArrayList<PowerArmorCoreUpgrade> Upgrades;
	private PowerArmorCore Core;
	private PowerArmor ArmorPiece;
	
	public APowerArmorCore(PowerArmor ArmorPiece) {
		this.ArmorPiece = ArmorPiece;
		this.Core = PowerArmor.getCore(ArmorPiece);
		this.Upgrades = PowerArmor.getUpgrades(ArmorPiece);
	}
	
}
