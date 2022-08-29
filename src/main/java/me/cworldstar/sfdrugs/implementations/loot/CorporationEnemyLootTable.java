package me.cworldstar.sfdrugs.implementations.loot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.cworldstar.sfdrugs.utils.Items;

public class CorporationEnemyLootTable implements LootTable {
	
	private JavaPlugin plugin;
	private Collection<ItemStack> lootTable = new ArrayList<ItemStack>();

	public CorporationEnemyLootTable(JavaPlugin plugin) {
		this.plugin = plugin;
		this.lootTable.add(new CustomItemStack(Items.MONEY,8));
		this.lootTable.add(new CustomItemStack(Items.MONEY,2));
		this.lootTable.add(new CustomItemStack(Items.MONEY,3));
		this.lootTable.add(new CustomItemStack(Items.MONEY,5));
	}
	
	@Override
	public NamespacedKey getKey() {
		// TODO Auto-generated method stub
		return new NamespacedKey(plugin,"SFDRUGS_CORPORATIONENEMY");
	}

	@Override
	public Collection<ItemStack> populateLoot(Random random, LootContext context) {
		// TODO Auto-generated method stub
		if(random.nextInt(5) == 3) {
			this.lootTable.add(new CustomItemStack(Items.CORPORATION_ROBOT_CHESTPLATE));
		}
		if(random.nextInt(5) == 2) {
			this.lootTable.add(new CustomItemStack(Items.CORPORATION_ROBOT_LEGGINGS));
		}
		if(random.nextInt(5) == 1) {
			this.lootTable.add(new CustomItemStack(Items.CORPORATION_ROBOT_HELMET));
		}
		if(random.nextInt(5) == 4) {
			this.lootTable.add(new CustomItemStack(Items.CORPORATION_ROBOT_BOOTS));
		}
		return this.lootTable;
	}

	@Override
	public void fillInventory(Inventory inventory, Random random, LootContext context) {}

}
