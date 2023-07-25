package me.cworldstar.sfdrugs.utils;

import me.cworldstar.sfdrugs.implementations.items.UnstableObject;
import me.cworldstar.sfdrugs.implementations.items.UnstableObject.Unstable;

public final class LoreHandler {
	private static Speak Formatter = new Speak();
	
	public LoreHandler() {}
	
	public Speak getFormatter() {
		return LoreHandler.Formatter;
	}
	public static String UnstableObjectCooldownTimer(Unstable unstable) {
		return LoreHandler.Formatter.format("&f&lCooldown: ".concat(Double.toString(UnstableObject.getCooldown(unstable))));
	}
	public static String UnstableObjectCooldownTimer(double d) {
		return LoreHandler.Formatter.format("&f&lCooldown: ".concat(Double.toString(d)));
	}
}
