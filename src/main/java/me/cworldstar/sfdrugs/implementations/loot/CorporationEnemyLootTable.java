package me.cworldstar.sfdrugs.implementations.loot;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.loot.LootContext;
import org.bukkit.loot.LootTable;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.utils.Items;

public class CorporationEnemyLootTable implements LootTable {
	
	private SFDrugs plugin;
	private Collection<ItemStack> lootTable = new ArrayList<ItemStack>();

	public CorporationEnemyLootTable(SFDrugs plugin) {
		this.plugin = plugin;

	}
	
	@Override
	public NamespacedKey getKey() {
		// TODO Auto-generated method stub
		return new NamespacedKey(plugin,"SFDRUGS_CORPORATIONENEMY");
	}

	@Override
	public Collection<ItemStack> populateLoot(Random random, LootContext context) {
		// TODO Auto-generated method stub
		this.lootTable.add(new CustomItemStack(Items.MONEY,8));
		this.lootTable.add(new CustomItemStack(Items.MONEY,2));
		this.lootTable.add(new CustomItemStack(Items.MONEY,3));
		this.lootTable.add(new CustomItemStack(Items.MONEY,5));
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
