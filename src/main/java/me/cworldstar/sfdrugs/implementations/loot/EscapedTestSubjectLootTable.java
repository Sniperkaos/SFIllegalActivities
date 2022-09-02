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

public class EscapedTestSubjectLootTable implements LootTable {
	
	private SFDrugs plugin;
	private Collection<ItemStack> lootTable = new ArrayList<ItemStack>();

	public EscapedTestSubjectLootTable(SFDrugs plugin) {
		this.plugin = plugin;

	}
	
	@Override
	public NamespacedKey getKey() {
		// TODO Auto-generated method stub
		return new NamespacedKey(plugin,"SFDRUGS_CORPORATIONENEMY");
	}

	@Override
	public Collection<ItemStack> populateLoot(Random random, LootContext context) {
		int num = random.nextInt(12);
		int items = random.nextInt(3);
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
				default:
					this.lootTable.add(new CustomItemStack(Items.MONEY,2));
			}
			num = random.nextInt(12);
		}
		return this.lootTable;
	}

	@Override
	public void fillInventory(Inventory inventory, Random random, LootContext context) {}

}
