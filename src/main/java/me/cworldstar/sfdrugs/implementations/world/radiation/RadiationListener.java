package me.cworldstar.sfdrugs.implementations.world.radiation;

import org.bukkit.block.Block;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.HashMap;
import me.cworldstar.sfdrugs.SFDrugs;

public class RadiationListener implements Listener {
	private SFDrugs plugin;
	private BukkitRunnable radiationRunnable;
	public static HashMap<Radiation, Block> RadiatedBlocks = new HashMap<Radiation, Block>();
	
	
	public RadiationListener(SFDrugs plugin) {
		this.plugin = plugin;
	}
}
