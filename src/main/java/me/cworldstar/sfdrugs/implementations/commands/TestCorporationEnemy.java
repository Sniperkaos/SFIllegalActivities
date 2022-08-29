package me.cworldstar.sfdrugs.implementations.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.cworldstar.sfdrugs.implementations.bosses.CorporationMobZone;

public class TestCorporationEnemy extends Command {

	private JavaPlugin plugin;

	public TestCorporationEnemy(JavaPlugin plugin,String name) {
		super(name);
		this.plugin = plugin;
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		Player p = sender.getServer().getPlayer(sender.getName());
		switch(args[0]) {
		case "corporationEnemy":
			new CorporationMobZone(plugin,p.getWorld(),p.getLocation());
			break;
		default:
			return false;
		}
		return true;
	}

}
