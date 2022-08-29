package me.cworldstar.sfdrugs.implementations.items;

import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

public class Blueprint {
	private String blueprintName;
	public Blueprint(String BlueprintName) {
		this.blueprintName = BlueprintName;
	}
	public SlimefunItemStack getBlueprint() {
		return new SlimefunItemStack("SFDRUGS_".concat(this.blueprintName.replace(' ', '_').toUpperCase()).concat("_BLUEPRINT"),Material.FILLED_MAP,"&7".concat(this.blueprintName).concat(" Blueprint"));
	}

}
