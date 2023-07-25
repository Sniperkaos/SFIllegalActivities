package me.cworldstar.sfdrugs.implementations.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import me.cworldstar.sfdrugs.SFDrugs;

import me.cworldstar.sfdrugs.implementations.traders.ATrader;

public class RefreshTraders implements CommandExecutor  {
	private SFDrugs plugin;
	public RefreshTraders(SFDrugs plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = sender.getServer().getPlayer(sender.getName());
			if(p.isOp()) {
				switch(args[0]) {
				case "all":
					for(ATrader Trader : ATrader.Traders.values()) {
						// completely reset all trading interfaces
						Trader.getTradingInterface().PopulateInventory();
						return true;
					}
					break;
				default:
					ATrader Trader = ATrader.Traders.get(args[0]);
					if(!Trader.equals(null)) {
						Trader.getTradingInterface().PopulateInventory();
						return true;
					}
					break;
				}

			} else {
				sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Only operators may run this command!");
				return false;
			}
		}
		return false;
	}

}
