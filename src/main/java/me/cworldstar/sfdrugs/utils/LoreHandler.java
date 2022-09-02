package me.cworldstar.sfdrugs.utils;



public final class LoreHandler {
	private static Speak Formatter = new Speak();
	
	public LoreHandler() {}
	
	public Speak getFormatter() {
		return LoreHandler.Formatter;
	}
	public static String UnstableObjectCooldownTimer(double Cooldown) {
		return LoreHandler.Formatter.format("&f&lCooldown: ".concat(Double.toString(Cooldown)));
	}
}
