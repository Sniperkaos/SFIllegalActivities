package me.cworldstar.sfdrugs.implementations.generators;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

import me.cworldstar.sfdrugs.SFDrugs;

public interface DarkMatter {
	SFDrugs getPlugin();
	
	abstract void onExplode(Block b);
	abstract void onBreakdown(Block b, double integrity);
	public long maxIntegrity = 100;
	
	default long getDarkMatter(Location BlockLocation) {
		Block b = BlockLocation.getBlock();
		if(b.hasMetadata("dark-matter-machine")) {
			return b.getMetadata("dark-matter-amount").get(0).asLong();
		}
		return 0;
	}
	default long getDarkMatter(Block Machine) {
		Block b = Machine;
		if(b.hasMetadata("dark-matter-machine")) {
			return b.getMetadata("dark-matter-amount").get(0).asLong();
		}
		return 0;
	}
	
	
	default boolean hasDarkMatter(Block b) {
		if(b.getMetadata("dark-matter-machine") != null) {
			if(this.getDarkMatter(b) > 0) {
				return true;
			}
		}
		return false;
	}
	//TODO: temperature system
	default boolean shouldMeltDown(Block b) {
		if(!this.hasDarkMatter(b)) {
			new BukkitRunnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					if(getDarkMatter(b) > 0) {
						this.cancel();
					} else {
						onBreakdown(b, maxIntegrity);
					}
				}
			};
			return true;
		}
		return false;
	}
	
	
	default boolean isDarkMatterMachine(Block b) {
		if(b.getMetadata("dark-matter-machine") != null) {
			return true;
		}
		return false;
	}
	
	default void addDarkMatter(Location BlockLocation,Long DarkMatter) {
		Block b = BlockLocation.getBlock();
		if(b.hasMetadata("dark-matter-machine")) {
			b.setMetadata("dark-matter-amount", new FixedMetadataValue(this.getPlugin(),this.getDarkMatter(BlockLocation) + DarkMatter));
		}
	}
	default void addDarkMatter(Block Machine,Long DarkMatter) {
		Block b = Machine;
		if(b.hasMetadata("dark-matter-machine")) {
			b.setMetadata("dark-matter-amount", new FixedMetadataValue(this.getPlugin(),this.getDarkMatter(Machine) + DarkMatter));
		}
	}
	default void removeDarkMatter(Block Machine,Long DarkMatter) {
		Block b = Machine;
		if(b.hasMetadata("dark-matter-machine")) {
			b.setMetadata("dark-matter-amount", new FixedMetadataValue(this.getPlugin(),this.getDarkMatter(Machine) - DarkMatter));
		}
	}


}
