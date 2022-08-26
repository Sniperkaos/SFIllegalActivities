package me.cworldstar.sfdrugs.utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.Centrifuge;
import me.cworldstar.sfdrugs.implementations.Dryer;

public class Items {
	public static final ItemStack SFDRUGS_ITEM = new CustomItemStack(Material.SUGAR,"&d&lSFDrugs","","&d> Click to open");
	public static final SlimefunItemStack RED_PHOSPHORUS = new SlimefunItemStack("SFDRUGS_RED_PHOSPHORUS",Material.REDSTONE,"&cRed Phosphorus","","&c - Distilled meat juice.");
	public static final SlimefunItemStack PSEUDOEPHEDRINE = new SlimefunItemStack("SFDRUGS_PSEUDOEPHEDRINE",Material.WATER_BUCKET,"&bPseudoephedrine","","&b - Distilled plant juice.");
	public static final SlimefunItemStack TWELVE = new SlimefunItemStack("SFDRUGS_TWELVE",Material.FIRE_CHARGE,"&412", "", "&4- I'm not too sure where this comes from.");
	public static final SlimefunItemStack TRAY = new SlimefunItemStack("SFDRUGS_METH_TRAY",Material.HEAVY_WEIGHTED_PRESSURE_PLATE,"&f&lCooking Tray", "" , "&f- For use in a dryer.");
	public static final SlimefunItemStack METH_COMPOUND = new SlimefunItemStack("SFDRUGS_METH_COMPOUND",Material.DIAMOND,"&9Methamphetamine Compound", "" , "&9 - Pre-dried meth.");
	public static final SlimefunItemStack DRIED_PLANT = new SlimefunItemStack("SFDRUGS_DRIED_PLANT",Material.OAK_LEAVES,"&2Dried Plants", "" , "&2 - You can use these in the Centrifuge.");
	public static final SlimefunItemStack METH = new SlimefunItemStack("SFDRUGS_METH",Material.SUGAR,"&9Methamphetamine", "" , "&9 - Walter, I won't have sex with you right now Walter.");
	public static final SlimefunItemStack DRYER = new SlimefunItemStack("SFDRUGS_MACHINES_DRYER",Material.BLAST_FURNACE,"&dDryer","","&d - Dries drug compounds.");
	public static final SlimefunItemStack CENTRIFUGE = new SlimefunItemStack("SFDRUGS_MACHINES_CENTRIFUGE",Material.BREWING_STAND,"&dCentrifuge","","&d - Creates drug compounds.");
	public static final SlimefunItemStack CYANIDE = new SlimefunItemStack("SFDRUGS_CYANIDE",Material.CLAY_BALL,"&1Cyanide", "" , "&1 - Eating this will kill you.", "&1 - Why did you even make it?");
	public static final SlimefunItemStack WORLDEATER = new SlimefunItemStack("SFDRUGS_WORLD_EATER",Material.NETHERITE_PICKAXE,"&6&lWorld Eater", "", "&6 - An alright pickaxe.");
	public static final SlimefunItemStack HOE = new SlimefunItemStack("SFDRUGS_HOE",Material.WOODEN_HOE,"&dSmall Town Hoe");
	static {
		WORLDEATER.addUnsafeEnchantment(Enchantment.DIG_SPEED, 12);
		WORLDEATER.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 12);
		WORLDEATER.addUnsafeEnchantment(Enchantment.DURABILITY, 5);
		HOE.addUnsafeEnchantment(Enchantment.LOYALTY, 999);
	}
	private SFDrugs plugin;
	private ItemGroup group;
	public Items(SFDrugs sfDrugs) {
    	NamespacedKey SFDRUGS_KEY = new NamespacedKey(sfDrugs, "SFDRUGS");
    	ItemGroup SFDRUGS = new ItemGroup(SFDRUGS_KEY,Items.SFDRUGS_ITEM);
		this.plugin = sfDrugs;
		this.group = SFDRUGS;
	}
	public void register() {
		RecipeType RECIPE_CENTRIFUGE = new RecipeType(new NamespacedKey(this.plugin,"Centrifuge"),Items.CENTRIFUGE);
		RecipeType RECIPE_DRYER = new RecipeType(new NamespacedKey(this.plugin,"Dryer"),Items.DRYER);
		SlimefunItem NHOE = new SlimefunItem(this.group,Items.HOE,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[] {
			null,null,null,
			null,Items.CYANIDE,null,
			null,null,null
		});
		NHOE.register(this.plugin);
		WorldEater NWORLDEATER = new WorldEater(this.group,Items.WORLDEATER,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[] {
				Items.CYANIDE,new ItemStack(Material.NETHERITE_PICKAXE),Items.CYANIDE,
				null,SlimefunItems.BLISTERING_INGOT_3,null,
				null,SlimefunItems.BLISTERING_INGOT_3,null
			});
		NWORLDEATER.register(this.plugin);
		Drug NCYANIDE = new Drug(this.group,Items.CYANIDE,RECIPE_DRYER,new ItemStack[] { new CustomItemStack(Items.DRIED_PLANT,64),Items.TRAY },new PotionEffect[] { new PotionEffect(PotionEffectType.HARM,240,100) });
    	NCYANIDE.register(this.plugin);
		Drug N_METH = new Drug(this.group,Items.METH,RECIPE_DRYER,new ItemStack[] { Items.METH_COMPOUND, Items.TRAY },new PotionEffect[] { new PotionEffect(PotionEffectType.CONFUSION,240,10), new PotionEffect(PotionEffectType.BLINDNESS,240,4),new PotionEffect(PotionEffectType.SLOW,240,10),new PotionEffect(PotionEffectType.POISON,240,10) });
    	N_METH.register(this.plugin);
    	SlimefunItem NDRIED_PLANT = new SlimefunItem(this.group,Items.DRIED_PLANT,RECIPE_DRYER,new ItemStack[] { new ItemStack(Material.OAK_SAPLING,64), Items.TRAY });
    	NDRIED_PLANT.register(this.plugin);
		SlimefunItem NRED_PHOSPHORUS = new SlimefunItem(this.group,Items.RED_PHOSPHORUS,RECIPE_CENTRIFUGE,new ItemStack[] {
				
		});
		NRED_PHOSPHORUS.register(this.plugin);
		SlimefunItem NPSEUDOEPHEDRINE = new SlimefunItem(this.group,Items.PSEUDOEPHEDRINE,RECIPE_CENTRIFUGE,null);
		NPSEUDOEPHEDRINE.register(this.plugin);
		SlimefunItem NTWELVE = new SlimefunItem(this.group,Items.TWELVE,RECIPE_CENTRIFUGE,null);
		NTWELVE.register(this.plugin);
		SlimefunItem NTRAY = new SlimefunItem(this.group,Items.TRAY,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[] {
				null,null,null,null,null,null,new ItemStack(SlimefunItems.STEEL_INGOT),new ItemStack(SlimefunItems.STEEL_INGOT),new ItemStack(SlimefunItems.STEEL_INGOT)
		});
		NTRAY.register(this.plugin);
		SlimefunItem METH_COMPOUND = new SlimefunItem(this.group,Items.METH_COMPOUND,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[] { (ItemStack)new CustomItemStack(Items.RED_PHOSPHORUS,8),(ItemStack)new CustomItemStack(Items.PSEUDOEPHEDRINE,16),(ItemStack)new CustomItemStack(Items.TWELVE,12) });
		METH_COMPOUND.register(this.plugin);
		Dryer DRYER = new Dryer(this.group,Items.DRYER,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[] {
				null,null,null,null,null,new ItemStack(SlimefunItems.STEEL_INGOT),new ItemStack(SlimefunItems.STEEL_INGOT),new ItemStack(SlimefunItems.STEEL_INGOT),new ItemStack(SlimefunItems.STEEL_INGOT)
		});
		DRYER.register(this.plugin);
		Centrifuge CENTRIFUGE = new Centrifuge(this.group,Items.CENTRIFUGE,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[] {
			null,null,null,
			new ItemStack(Material.GLASS),new ItemStack(SlimefunItems.BATTERY),new ItemStack(Material.GLASS),
			new ItemStack(SlimefunItems.REINFORCED_ALLOY_INGOT),new ItemStack(SlimefunItems.REINFORCED_PLATE),new ItemStack(SlimefunItems.REINFORCED_ALLOY_INGOT)
		});
		CENTRIFUGE.register(this.plugin);
	}
	
}
