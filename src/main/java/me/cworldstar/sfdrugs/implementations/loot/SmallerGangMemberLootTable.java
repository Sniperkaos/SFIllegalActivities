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

public class SmallerGangMemberLootTable implements LootTable {

	private SFDrugs plugin;
	private Collection<ItemStack> lootTable = new ArrayList<ItemStack>();

	public SmallerGangMemberLootTable(SFDrugs plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public NamespacedKey getKey() {
		// TODO Auto-generated method stub
		return new NamespacedKey(plugin,"SmallerGangMember");
	}

	@Override
	public Collection<ItemStack> populateLoot(Random random, LootContext context) {
		int num = random.nextInt(12);
		int items = random.nextInt(3);
		for(int i=0;i<items;i++) {
			switch(num) {
				case 1:
					this.lootTable.add(new CustomItemStack(Items.MONEY,2));
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
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
		}
		return this.lootTable;
	}

	@Override
	public void fillInventory(Inventory inventory, Random random, LootContext context) {}

}
