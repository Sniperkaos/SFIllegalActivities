package me.cworldstar.sfdrugs.implementations.loot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.utils.Items;

public class RareChestLootTable implements LootTable {
	private SFDrugs plugin;
	private Collection<ItemStack> lootTable = new ArrayList<ItemStack>();

	public RareChestLootTable(SFDrugs plugin) {
		this.plugin = plugin;

	}
	
	@Override
	public NamespacedKey getKey() {
		// TODO Auto-generated method stub
		return new NamespacedKey(plugin,"SFDRUGS_CORPORATIONENEMY");
	}

	@Override
	public Collection<ItemStack> populateLoot(Random random, LootContext context) {
		int num = random.nextInt(30);
		int items = random.nextInt(5);
		for(int i=0;i<items;i++) {
			switch(num) {
				case 1:
					this.lootTable.add(new CustomItemStack(Items.CORPORATION_ROBOT_HELMET));
					break;
				case 2:
					this.lootTable.add(new CustomItemStack(Items.CORPORATION_ROBOT_LEGGINGS));
					break;
				case 3:
					this.lootTable.add(new CustomItemStack(Items.CORPORATION_ROBOT_CHESTPLATE));
					break;
				case 4:
					this.lootTable.add(new CustomItemStack(Items.CORPORATION_ROBOT_BOOTS));
					break;
				case 5:
					this.lootTable.add(new CustomItemStack(Items.CORPORATE_ANDROID_CORE,1));	
					break;
				case 6:
					this.lootTable.add(new CustomItemStack(Items.MONEY,2));
					break;
				case 7:
					this.lootTable.add(new CustomItemStack(Items.MONEY,2));
					break;
				case 8:
					this.lootTable.add(new CustomItemStack(Items.MONEY,2));
					break;
				case 9:
					this.lootTable.add(new CustomItemStack(Items.MONEY,2));
					break;
				case 10:
					this.lootTable.add(new CustomItemStack(Items.MONEY,5));
					break;
				case 11:
					this.lootTable.add(new CustomItemStack(Items.MONEY,5));
					break;
				case 12:
					this.lootTable.add(new CustomItemStack(Items.MONEY,8));
					break;
				case 13:
					this.lootTable.add(new CustomItemStack(SlimefunItems.BASIC_CIRCUIT_BOARD,64));
					break;
				case 14:
					this.lootTable.add(new ItemStack(Material.DIAMOND_BLOCK,9));
					break;
				case 15:
					this.lootTable.add(new ItemStack(Material.DIAMOND_BLOCK,9));
					break;
				case 16:
					this.lootTable.add(new ItemStack(Material.DIAMOND_BLOCK,9));
					break;
				case 17:
					this.lootTable.add(new ItemStack(Material.DIAMOND_BLOCK,9));
					break;
				case 18:
					this.lootTable.add(new ItemStack(Material.NETHERITE_INGOT,4));
					break;
				case 19:
					this.lootTable.add(new ItemStack(Material.NETHERITE_INGOT,4));
					break;
				case 20:
					this.lootTable.add(new ItemStack(Material.NETHERITE_INGOT,4));
					break;
				case 21:
					this.lootTable.add(new CustomItemStack(SlimefunItems.BASIC_CIRCUIT_BOARD,32));
					break;
				case 22:
					this.lootTable.add(new CustomItemStack(SlimefunItems.BASIC_CIRCUIT_BOARD,48));
					break;
				case 23:
					this.lootTable.add(new CustomItemStack(SlimefunItems.BASIC_CIRCUIT_BOARD,50));
					break;
				case 24:
					this.lootTable.add(new CustomItemStack(SlimefunItems.BASIC_CIRCUIT_BOARD,58));
					break;
				case 25:
					this.lootTable.add(new CustomItemStack(SlimefunItems.BLISTERING_INGOT_3,1));
					break;
				case 26:
					this.lootTable.add(new CustomItemStack(SlimefunItems.BLISTERING_INGOT_2,2));
					break;
				case 27:
					this.lootTable.add(new CustomItemStack(SlimefunItems.BLISTERING_INGOT,4));
					break;
				case 28:
					this.lootTable.add(new ItemStack(Material.NETHER_STAR,2));
					break;
				case 29:
					this.lootTable.add(new ItemStack(Material.NETHER_STAR,2));
					break;
				case 30:
					this.lootTable.add(
						new CustomItemStack(Items.MONEY_STAMP,1)	
					);
				default:
					this.lootTable.add(new CustomItemStack(Items.MONEY,2));
			}
			num = random.nextInt(30);
		}
		return this.lootTable;
	}

	@Override
	public void fillInventory(Inventory inventory, Random random, LootContext context) {}

}
