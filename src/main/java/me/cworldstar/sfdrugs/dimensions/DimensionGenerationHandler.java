package me.cworldstar.sfdrugs.dimensions;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkLoadEvent;

import me.cworldstar.sfdrugs.SFDrugs;

public class DimensionGenerationHandler implements Listener {
	@SuppressWarnings("unused")
	private SFDrugs plugin;
	public DimensionGenerationHandler(SFDrugs plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void CorporateDimensionBuildingHandler(ChunkLoadEvent e) {
		if(e.getWorld().getName() == "corporate_dimension") {
			if(e.isNewChunk() == true && e.getChunk().getChunkSnapshot().getBiome(e.getChunk().getX(), 5, e.getChunk().getZ()).compareTo(Biome.WOODED_HILLS) == 0) {
				Block FirstAirBlock = e.getWorld().getHighestBlockAt(e.getChunk().getX(), e.getChunk().getZ());
			}
		}
	}
}
