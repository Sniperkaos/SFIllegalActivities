package me.cworldstar.sfdrugs.utils;

import java.util.Random;

public class RandomUtils {
	private static Random random;
	public RandomUtils() {
		RandomUtils.random = new Random();
	}
	public static Random getRandom() {
		return RandomUtils.random;
	}
}
