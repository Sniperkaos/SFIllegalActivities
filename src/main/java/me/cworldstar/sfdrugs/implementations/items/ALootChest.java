package me.cworldstar.sfdrugs.implementations.items;

import org.bukkit.loot.LootTable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;

public interface ALootChest {
	public abstract ItemUseHandler open();
	public abstract LootTable getLootTable();
	public abstract ItemUseHandler getItemHandler();
}
