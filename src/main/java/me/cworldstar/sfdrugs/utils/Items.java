package me.cworldstar.sfdrugs.utils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineTier;
import io.github.thebusybiscuit.slimefun4.core.attributes.MachineType;
import io.github.thebusybiscuit.slimefun4.core.attributes.Radioactivity;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.Centrifuge;
import me.cworldstar.sfdrugs.implementations.CircuitFabricator;
import me.cworldstar.sfdrugs.implementations.Dryer;
import me.cworldstar.sfdrugs.implementations.MoneyPrinter;
import me.cworldstar.sfdrugs.implementations.items.DrugBaton;
import me.cworldstar.sfdrugs.implementations.items.DrugSuit;
import me.cworldstar.sfdrugs.implementations.items.IrradiatedItem;
import me.cworldstar.sfdrugs.implementations.items.MoneyStamp;
import me.cworldstar.sfdrugs.implementations.items.Snaids;
import net.md_5.bungee.api.ChatColor;

public class Items {
	
	// Materials
	
	public static final ItemStack SFDRUGS_ITEM = new CustomItemStack(Material.SUGAR,"&d&lSFDrugs","","&d> Click to open");
	public static final SlimefunItemStack RED_PHOSPHORUS = new SlimefunItemStack("SFDRUGS_RED_PHOSPHORUS",Material.REDSTONE,"&cRed Phosphorus","","&c - Distilled meat juice.");
	public static final SlimefunItemStack PSEUDOEPHEDRINE = new SlimefunItemStack("SFDRUGS_PSEUDOEPHEDRINE",Material.WATER_BUCKET,"&bPseudoephedrine","","&b - Distilled plant juice.");
	public static final SlimefunItemStack TWELVE = new SlimefunItemStack("SFDRUGS_TWELVE",Material.FIRE_CHARGE,"&412", "", "&4- I'm not too sure where this comes from.");
	public static final SlimefunItemStack TRAY = new SlimefunItemStack("SFDRUGS_METH_TRAY",Material.HEAVY_WEIGHTED_PRESSURE_PLATE,"&f&lCooking Tray", "" , "&f- For use in a dryer.");
	public static final SlimefunItemStack METH_COMPOUND = new SlimefunItemStack("SFDRUGS_METH_COMPOUND",Material.DIAMOND,"&9Methamphetamine Compound", "" , "&9 - Pre-dried meth.");
	public static final SlimefunItemStack DRIED_PLANT = new SlimefunItemStack("SFDRUGS_DRIED_PLANT",Material.OAK_LEAVES,"&2Dried Plants", "" , "&2 - You can use these in the Centrifuge.");
	public static final SlimefunItemStack MONEY = new SlimefunItemStack("SFDRUGS_MONEY",Material.PAPER,"&a 100 Corporation Currency", "" , "&2 - You can use these for trading with the Corporation.");
	
	public static final SlimefunItemStack IRRADIATED_SIRTHIUM_RAW = new SlimefunItemStack("SFDRUGS_SIRTHIUM_RAW",Material.SLIME_BLOCK,"&aRaw Sirthium", "",LoreBuilder.radioactive(Radioactivity.MODERATE),LoreBuilder.HAZMAT_SUIT_REQUIRED);
	public static final SlimefunItemStack IRRADIATED_SIRTHIUM_PROCESSED = new SlimefunItemStack("SFDRUGS_SIRTHIUM",Material.EMERALD,"&aSirthium Crystal", "",LoreBuilder.radioactive(Radioactivity.HIGH),LoreBuilder.HAZMAT_SUIT_REQUIRED);
	public static final ItemStack SIRTHIUM_ALLOY_HEAD = SlimefunUtils.getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTkwNzkzZjU2NjE2ZjEwMTUwMmRlMWQzNGViMjU0NGY2MDdkOTg5MDBlMzY5OTM2OTI5NTMxOWU2MzBkY2Y2ZCJ9fX0=");
	public static final SlimefunItemStack IRRADIATED_SIRTHIUM_ALLOY = new SlimefunItemStack("SFDRUGS_SIRTHIUM_ALLOY",SIRTHIUM_ALLOY_HEAD,"&aSirthium Alloy", "",LoreBuilder.radioactive(Radioactivity.VERY_HIGH),LoreBuilder.HAZMAT_SUIT_REQUIRED);

	
	// Drugs
	public static final SlimefunItemStack SNAIDS = new SlimefunItemStack("SFDRUGS_SNAIDS",Material.HONEY_BOTTLE,"&d&lSnaids","","&d - You might blow up.");
	public static final SlimefunItemStack CYANIDE = new SlimefunItemStack("SFDRUGS_CYANIDE",Material.CLAY_BALL,"&1Cyanide", "" , "&1 - Eating this will kill you.", "&1 - Why did you even make it?");
	public static final SlimefunItemStack METH = new SlimefunItemStack("SFDRUGS_METH",Material.SUGAR,"&9Methamphetamine", "" , "&9 - Walter, I won't have sex with you right now Walter.");
	
	// Machines
	public static final SlimefunItemStack CIRCUIT_FABRICATOR = new SlimefunItemStack("SFDRUGS_MACHINES_CIRCUITFABRICATOR",Material.BLACK_CONCRETE,"&7Circuit Fabricator","","&7Automates the production of Basic Circuits.","",LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE));
	public static final SlimefunItemStack MONEY_PRINTER = new SlimefunItemStack("SFDRUGS_MACHINES_MONEYPRINTER",Material.ANCIENT_DEBRIS,"&7Money Printer","","&7Prints corporation money.","",LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE));
	public static final SlimefunItemStack DRYER = new SlimefunItemStack("SFDRUGS_MACHINES_DRYER",Material.BLAST_FURNACE,"&dDryer","","&d - Dries drug compounds.", "",LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE));
	public static final SlimefunItemStack CENTRIFUGE = new SlimefunItemStack("SFDRUGS_MACHINES_CENTRIFUGE",Material.BREWING_STAND,"&dCentrifuge","","&d - Creates drug compounds.", "",LoreBuilder.machine(MachineTier.END_GAME, MachineType.MACHINE));
	
	// Tools and the like
	
	public static final SlimefunItemStack DRUG_PICKAXE = new SlimefunItemStack("SFDRUGS_DRUG_PICKAXE",Material.NETHERITE_PICKAXE,"&a&l&k|||&r &7&lCorporate Mining Drill&r &a&l&k|||&r","",LoreBuilder.material("Irradiated Sirthium"), ""," &7 - Shift to enable Silk Touch.","",LoreBuilder.powerCharged(0, 12000), "",LoreBuilder.radioactive(Radioactivity.VERY_DEADLY),LoreBuilder.HAZMAT_SUIT_REQUIRED);
	public static final SlimefunItemStack DRUG_SHOVEL = new SlimefunItemStack("SFDRUGS_DRUG_SHOVEL",Material.NETHERITE_SHOVEL,"&a&l&k|||&r &7&lCorporate Ground Smasher&r &a&l&k|||&r","",LoreBuilder.material("Irradiated Sirthium"), ""," &7 - Shift to enable Silk Touch.","",LoreBuilder.powerCharged(0, 12000), "",LoreBuilder.radioactive(Radioactivity.VERY_DEADLY),LoreBuilder.HAZMAT_SUIT_REQUIRED);
	public static final SlimefunItemStack DRUG_AXE = new SlimefunItemStack("SFDRUGS_DRUG_AXE",Material.NETHERITE_AXE,"&a&l&k|||&r &7&lCorporate Chainsaw&r &a&l&k|||&r","",LoreBuilder.material("Irradiated Sirthium"), ""," &7 - Shift to enable Silk Touch.","",LoreBuilder.powerCharged(0, 12000), "",LoreBuilder.radioactive(Radioactivity.VERY_DEADLY),LoreBuilder.HAZMAT_SUIT_REQUIRED);

	public static final SlimefunItemStack HOE = new SlimefunItemStack("SFDRUGS_HOE",Material.WOODEN_HOE,"&dSmall Town Hoe", "","&d&lSPAWNER");
	public static final SlimefunItemStack GAY_PANTS = new SlimefunItemStack("SFDRUGS_GAY_PANTS",Material.LEATHER_LEGGINGS,"&cUsed G-String", "", "&c - This is stronger than diamond!", "", "&c&lARMOR");
	public static final ItemStack HOOKER_HEAD = SlimefunUtils.getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjM2ZjE1NDgwZWU0MTRmYWI1ZjU4NWQ1MjUwY2RlYjc1ZTg3M2U3NmYwNzYxYWZmYmRkY2M1MzZjMjkwYWFjNCJ9fX0=");
	public static final ItemStack CORPORATE_HEAD = SlimefunUtils.getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjZlZTAzYmE4NTBlYmJhMjE3MjFjYjMzN2Y3ZWRlYWI5YjBmYTYxNWE4NjJjNjg3MGNjOWM0ZDA1ZDRkMzJmYSJ9fX0=");
	public static final ItemStack MYSTEROUS_TRADER_HEAD = SlimefunUtils.getCustomHead("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjJlMzdjNjM2ZmZjYzA1ZjUxOGFiOTdiZjcxMTFjNmQzY2E5NWM1MzAwYzUyZTU2MGMzZGMzNTYzNzZlZWJkYiJ9fX0=");

	public static final SlimefunItemStack MONEY_STAMP = new SlimefunItemStack("SFDRUGS_MONEY_STAMP",Material.ANVIL,"&7Corporate Money Stamp","",LoreBuilder.radioactive(Radioactivity.LOW));
	public static final SlimefunItemStack BATON_BLUEPRINT = new SlimefunItemStack("SFDRUGS_BATON_BLUEPRINT",Material.FILLED_MAP,"&7Corporate Baton Blueprint");
	public static final SlimefunItemStack PICKAXE_BLUEPRINT = new SlimefunItemStack("SFDRUGS_PICKAXE_BLUEPRINT",Material.FILLED_MAP,"&7Corporate Pickaxe Blueprint");
	public static final SlimefunItemStack AXE_BLUEPRINT = new SlimefunItemStack("SFDRUGS_AXE_BLUEPRINT",Material.FILLED_MAP,"&7Corporate Axe Blueprint");
	public static final SlimefunItemStack SHOVEL_BLUEPRINT = new SlimefunItemStack("SFDRUGS_SHOVEL_BLUEPRINT",Material.FILLED_MAP,"&7Corporate Shovel Blueprint");

	// Armor
	
	public static final SlimefunItemStack DRUG_CHESTPLATE = new SlimefunItemStack("SFDRUGS_DRUG_CHESTPLATE",Material.NETHERITE_CHESTPLATE,"&a&l&k|||&r &7&lCorporate Hazmat Suit Top&r &a&l&k|||&r", "", LoreBuilder.material("Super-Compressed Carbon"), "",LoreBuilder.powerCharged(0, 1200), "", "&7Full Set Effects:","&e- Radiation immunity");
	public static final SlimefunItemStack DRUG_HELMET = new SlimefunItemStack("SFDRUGS_DRUG_HELMET",Material.NETHERITE_HELMET,"&a&l&k|||&r &7&lCorporate Hazmat Gas Mask&r &a&l&k|||&r", "", LoreBuilder.material("Super-Compressed Carbon"), "",LoreBuilder.powerCharged(0, 1200), "", "&7Full Set Effects:","&e- Radiation immunity");
	public static final SlimefunItemStack DRUG_BOOTS = new SlimefunItemStack("SFDRUGS_DRUG_BOOTS",Material.NETHERITE_BOOTS,"&a&l&k|||&r &7&lCorporate Hazmat Boots&r &a&l&k|||&r", "", LoreBuilder.material("Super-Compressed Carbon"), "",LoreBuilder.powerCharged(0, 1200), "", "&7Full Set Effects:","&e- Radiation immunity");
	public static final SlimefunItemStack DRUG_LEGGINGS = new SlimefunItemStack("SFDRUGS_DRUG_LEGGINGS",Material.NETHERITE_LEGGINGS,"&a&l&k|||&r &7&lCorporate Hazmat Suit Bottom&r &a&l&k|||&r", "", LoreBuilder.material("Super-Compressed Carbon"), "",LoreBuilder.powerCharged(0, 1200), "", "&7Full Set Effects:","&e- Radiation immunity");
	public static final SlimefunItemStack DRUG_BATON = new SlimefunItemStack("SFDRUGS_DRUG_BATON",Material.NETHERITE_SWORD,"&a&l&k|||&r &7&lCorporate Electric Baton&r &a&l&k|||&r", "", LoreBuilder.material("Irradiated Sirthium"), "",LoreBuilder.powerCharged(0, 4800), "", LoreBuilder.radioactive(Radioactivity.VERY_DEADLY),LoreBuilder.HAZMAT_SUIT_REQUIRED);
	
	
	static {
		HOOKER_HEAD.getItemMeta().setDisplayName(ChatColor.translateAlternateColorCodes('&', "&dHooker Zombie"));
		CORPORATE_HEAD.getItemMeta().setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7Corporate Transaction"));
		MYSTEROUS_TRADER_HEAD.getItemMeta().setDisplayName(ChatColor.translateAlternateColorCodes('&', "&cMysterious Trader"));

		SIRTHIUM_ALLOY_HEAD.getItemMeta().setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSirthium Alloy"));

	}
	public static final SlimefunItemStack HOOKER_GROUP = new SlimefunItemStack("HOOKER_GROUP",HOOKER_HEAD,"&dHooker Zombie");
	public static final SlimefunItemStack CORPORATE_GROUP = new SlimefunItemStack("CORPORATE_GROUP",CORPORATE_HEAD,"&7Corporation Trading");
	public static final SlimefunItemStack MYSTEROUS_TRADER = new SlimefunItemStack("MYSTERIOUS_TRADER",MYSTEROUS_TRADER_HEAD,"&cMysterious Trader");
	static {
		DRUG_CHESTPLATE.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		DRUG_HELMET.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		DRUG_BOOTS.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		DRUG_LEGGINGS.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		DRUG_BATON.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		
		GAY_PANTS.getItemMeta().addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, new AttributeModifier("SFDRUGS_GAY_PANTS_ARMOR_TOUGHNESS",3,Operation.ADD_NUMBER));
		GAY_PANTS.getItemMeta().addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("SFDRUGS_GAY_PANTS_ARMOR",6,Operation.ADD_NUMBER));
		GAY_PANTS.getItemMeta().addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, new AttributeModifier("SFDRUGS_GAY_PANTS_MAX_HEALTH",2,Operation.ADD_NUMBER));
		
		
		DRUG_CHESTPLATE.getItemMeta().addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("SFDRUGS_DRUG_ARMOR",4,Operation.ADD_NUMBER));
		DRUG_HELMET.getItemMeta().addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("SFDRUGS_DRUG_ARMOR",4,Operation.ADD_NUMBER));
		DRUG_BOOTS.getItemMeta().addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("SFDRUGS_DRUG_ARMOR",4,Operation.ADD_NUMBER));
		DRUG_LEGGINGS.getItemMeta().addAttributeModifier(Attribute.GENERIC_ARMOR, new AttributeModifier("SFDRUGS_DRUG_ARMOR",4,Operation.ADD_NUMBER));

		((LeatherArmorMeta) GAY_PANTS.getItemMeta()).setColor(Color.RED);
		GAY_PANTS.addUnsafeEnchantment(Enchantment.VANISHING_CURSE,10);
		GAY_PANTS.addUnsafeEnchantment(Enchantment.DURABILITY,10);
		GAY_PANTS.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,10);
		DRUG_PICKAXE.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
		DRUG_PICKAXE.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 10);
		DRUG_PICKAXE.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		DRUG_SHOVEL.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
		DRUG_SHOVEL.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
		DRUG_AXE.addUnsafeEnchantment(Enchantment.DIG_SPEED, 10);
		DRUG_AXE.addUnsafeEnchantment(Enchantment.DURABILITY, 10);
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
		RecipeType RECIPE_CENTRIFUGE = new RecipeType(new NamespacedKey(this.plugin,"CENTRIFUGE"),Items.CENTRIFUGE);
		RecipeType RECIPE_DRYER = new RecipeType(new NamespacedKey(this.plugin,"DRYER"),Items.DRYER);
		RecipeType HOOKER_TRADE = new RecipeType(new NamespacedKey(this.plugin,"HOOKER_TRADER"),Items.HOOKER_GROUP);
		RecipeType CORPORATION_TRADE = new RecipeType(new NamespacedKey(this.plugin,"CORPORATION_TRADER"),Items.CORPORATE_GROUP);
		RecipeType MYSTERIOUS_TRADER = new RecipeType(new NamespacedKey(this.plugin,"MYSTERIOUS_TRADER"),Items.MYSTEROUS_TRADER);

	
		
		CircuitFabricator NCIRCUIT_FABRICATOR = new CircuitFabricator(this.group,Items.CIRCUIT_FABRICATOR,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[] {
				null,SlimefunItems.ANDROID_MEMORY_CORE,null,
				SlimefunItems.ADVANCED_CIRCUIT_BOARD,Items.IRRADIATED_SIRTHIUM_ALLOY,SlimefunItems.ADVANCED_CIRCUIT_BOARD,
				SlimefunItems.REINFORCED_PLATE,SlimefunItems.REINFORCED_PLATE,SlimefunItems.REINFORCED_PLATE
		});
		NCIRCUIT_FABRICATOR.register(this.plugin);
		
		MoneyPrinter NMONEYPRINTER = new MoneyPrinter(this.group,Items.MONEY_PRINTER,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[] {
				new ItemStack(Material.ANVIL),Items.MONEY_STAMP,new ItemStack(Material.ANVIL),
				SlimefunItems.ADVANCED_CIRCUIT_BOARD,new ItemStack(Material.NETHERITE_BLOCK),SlimefunItems.ADVANCED_CIRCUIT_BOARD,
				SlimefunItems.REINFORCED_PLATE,SlimefunItems.REINFORCED_PLATE,SlimefunItems.REINFORCED_PLATE
		});
		
		NMONEYPRINTER.register(this.plugin);
		
		MoneyStamp NMONEY_STAMP = new MoneyStamp(this.group,Items.MONEY_STAMP,MYSTERIOUS_TRADER,new ItemStack[] {
				new CustomItemStack(Items.MONEY,30)
		});
		NMONEY_STAMP.register(this.plugin);
		IrradiatedItem NIRRADIATED_SIRTHIUM_RAW = new IrradiatedItem(this.group,Items.IRRADIATED_SIRTHIUM_RAW,CORPORATION_TRADE,new ItemStack[] {
			new CustomItemStack(Items.MONEY,20)	
		},Radioactivity.MODERATE);
		NIRRADIATED_SIRTHIUM_RAW.register(this.plugin);
		
		IrradiatedItem NIRRADIATED_SIRTHIUM_PROCESSED = new IrradiatedItem(this.group,Items.IRRADIATED_SIRTHIUM_PROCESSED,RECIPE_DRYER,new ItemStack[] {
				new CustomItemStack(Items.IRRADIATED_SIRTHIUM_RAW,16),Items.TRAY	
			},Radioactivity.HIGH);
		NIRRADIATED_SIRTHIUM_PROCESSED.register(this.plugin);
		
		IrradiatedItem NIRRADIATED_SIRTHIUM_ALLOY = new IrradiatedItem(this.group,Items.IRRADIATED_SIRTHIUM_ALLOY,RecipeType.SMELTERY,new ItemStack[] {
				new CustomItemStack(Items.IRRADIATED_SIRTHIUM_PROCESSED,8),new CustomItemStack(SlimefunItems.BLISTERING_INGOT_3,4), new ItemStack(Material.DRAGON_BREATH,32)
			},Radioactivity.VERY_HIGH);
		NIRRADIATED_SIRTHIUM_ALLOY.register(this.plugin);
		
		
		SlimefunItem NBATON_BLUEPRINT = new SlimefunItem(this.group,Items.BATON_BLUEPRINT,HOOKER_TRADE,new ItemStack[] {
				new CustomItemStack(Items.METH,21)
		});
		NBATON_BLUEPRINT.register(this.plugin);
		
		SlimefunItem NSHOVEL_BLUEPRINT = new SlimefunItem(this.group,Items.SHOVEL_BLUEPRINT,HOOKER_TRADE,new ItemStack[] {
				new CustomItemStack(Items.METH,24)
		});
		NSHOVEL_BLUEPRINT.register(this.plugin);
		
		SlimefunItem NAXE_BLUEPRINT = new SlimefunItem(this.group,Items.AXE_BLUEPRINT,HOOKER_TRADE,new ItemStack[] {
				new CustomItemStack(Items.METH,30)
		});
		NAXE_BLUEPRINT.register(this.plugin);
		
		
		SlimefunItem NPICKAXE_BLUEPRINT = new SlimefunItem(this.group,Items.PICKAXE_BLUEPRINT,HOOKER_TRADE,new ItemStack[] {
				new CustomItemStack(Items.METH,42)
		});
		NPICKAXE_BLUEPRINT.register(this.plugin);
		
		
		DrugBaton NDRUG_BATON = new DrugBaton(this.group,Items.DRUG_BATON,CORPORATION_TRADE,new ItemStack[] {
				new CustomItemStack(Items.MONEY,18),Items.BATON_BLUEPRINT,new CustomItemStack(Items.IRRADIATED_SIRTHIUM_ALLOY,3)
		});
		NDRUG_BATON.register(this.plugin);
		DrugSuit NDRUG_HELMET = new DrugSuit(plugin, group, Items.DRUG_HELMET,CORPORATION_TRADE, new ItemStack[] {
				
		}, new PotionEffect[] { new PotionEffect(PotionEffectType.WATER_BREATHING,1200,0)});
		NDRUG_HELMET.register(this.plugin);		

		DrugSuit NDRUG_CHESTPLATE = new DrugSuit(plugin, group, Items.DRUG_CHESTPLATE,CORPORATION_TRADE, new ItemStack[] {
				
		}, new PotionEffect[] { new PotionEffect(PotionEffectType.FIRE_RESISTANCE,1200,0)});
		NDRUG_CHESTPLATE.register(this.plugin);	
		
		DrugSuit NDRUG_LEGGINGS = new DrugSuit(plugin, group, Items.DRUG_LEGGINGS,CORPORATION_TRADE, new ItemStack[] {
				
		}, new PotionEffect[] { new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,1200,0), new PotionEffect(PotionEffectType.JUMP,1200,0)});
		NDRUG_LEGGINGS.register(this.plugin);	
		
		DrugSuit NDRUG_BOOTS = new DrugSuit(plugin, group, Items.DRUG_BOOTS,CORPORATION_TRADE, new ItemStack[] {
				
		}, new PotionEffect[] { new PotionEffect(PotionEffectType.SPEED,1200,1)});
		NDRUG_BOOTS.register(this.plugin);	
		
		Snaids NSNAIDS = new Snaids(this.plugin,this.group,Items.SNAIDS,RECIPE_DRYER,new ItemStack[] { new ItemStack(Material.STICK,64),Items.TRAY});
		NSNAIDS.register(this.plugin);
		
		SlimefunItem NMONEY = new SlimefunItem(this.group,Items.MONEY,RecipeType.NULL,new ItemStack[] {});
		NMONEY.register(this.plugin);
		SFDrugsHoe NHOE = new SFDrugsHoe(this.group,Items.HOE,RecipeType.ENHANCED_CRAFTING_TABLE,new ItemStack[] {
			null,null,null,
			null,Items.CYANIDE,null,
			null,null,null
		},this.plugin);
		SlimefunItem NGAY_PANTS = new SlimefunItem(this.group,Items.GAY_PANTS,HOOKER_TRADE,new ItemStack[] { new CustomItemStack(Items.METH,64) });
		NGAY_PANTS.register(this.plugin);
		NHOE.register(this.plugin);
		WorldEater NWORLDEATER = new WorldEater(this.group,Items.DRUG_PICKAXE,CORPORATION_TRADE,new ItemStack[] {
				new CustomItemStack(Items.MONEY,18),Items.PICKAXE_BLUEPRINT,new CustomItemStack(Items.IRRADIATED_SIRTHIUM_ALLOY,2)
			});

		NWORLDEATER.register(this.plugin);
		WorldEater NDRUG_AXE = new WorldEater(this.group,Items.DRUG_AXE,CORPORATION_TRADE,new ItemStack[] {
				new CustomItemStack(Items.MONEY,18),Items.AXE_BLUEPRINT,new CustomItemStack(Items.IRRADIATED_SIRTHIUM_ALLOY,2)
			});
		NDRUG_AXE.register(this.plugin);
		WorldEater NDRUG_SHOVEL= new WorldEater(this.group,Items.DRUG_SHOVEL,CORPORATION_TRADE,new ItemStack[] {
				new CustomItemStack(Items.MONEY,18),Items.SHOVEL_BLUEPRINT,new CustomItemStack(Items.IRRADIATED_SIRTHIUM_ALLOY,2)
			});
		NDRUG_SHOVEL.register(this.plugin);
		Drug NCYANIDE = new Drug(this.group,Items.CYANIDE,RECIPE_DRYER,new ItemStack[] { new CustomItemStack(Items.DRIED_PLANT,64),Items.TRAY },new PotionEffect[] { new PotionEffect(PotionEffectType.HARM,240,100) });
    	NCYANIDE.register(this.plugin);
		METH.getItemMeta().getPersistentDataContainer().set(new NamespacedKey(this.plugin,"METH"), PersistentDataType.STRING, "lmao");
    	Drug N_METH = new Drug(this.group,Items.METH,RECIPE_DRYER,new ItemStack[] { Items.METH_COMPOUND, Items.TRAY },
    			new PotionEffect[] { 
    			  new PotionEffect(PotionEffectType.CONFUSION,120,5), 
    			  new PotionEffect(PotionEffectType.SATURATION,600,10),
    			  new PotionEffect(PotionEffectType.FAST_DIGGING,480,5),
    			  new PotionEffect(PotionEffectType.POISON,10,5) 
    			}
    	);
    	N_METH.register(this.plugin);
    	SlimefunItem NDRIED_PLANT = new SlimefunItem(this.group,Items.DRIED_PLANT,RECIPE_DRYER,new ItemStack[] { new ItemStack(Material.OAK_SAPLING,64), Items.TRAY });
    	NDRIED_PLANT.register(this.plugin);
		SlimefunItem NRED_PHOSPHORUS = new SlimefunItem(this.group,Items.RED_PHOSPHORUS,RECIPE_CENTRIFUGE,new ItemStack[] {
				new ItemStack(Material.BEEF,8),new CustomItemStack(Items.RED_PHOSPHORUS)
		});
		NRED_PHOSPHORUS.register(this.plugin);
		SlimefunItem NPSEUDOEPHEDRINE = new SlimefunItem(this.group,Items.PSEUDOEPHEDRINE,RECIPE_CENTRIFUGE,new ItemStack[] {
				new CustomItemStack(Items.DRIED_PLANT,32),new CustomItemStack(Items.PSEUDOEPHEDRINE)
		});
		NPSEUDOEPHEDRINE.register(this.plugin);
		SlimefunItem NTWELVE = new SlimefunItem(this.group,Items.TWELVE,RECIPE_CENTRIFUGE,new ItemStack[] {
				new ItemStack(Material.FIRE_CHARGE,12),new CustomItemStack(Items.TWELVE)
		});
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
