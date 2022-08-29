package me.cworldstar.sfdrugs.implementations.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.cworldstar.sfdrugs.implementations.bosses.CorporationMobZone;

public class TestCorporationEnemy implements CommandExecutor  {
	private JavaPlugin plugin;
	public TestCorporationEnemy(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
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
		return false;
	}

}
