package me.cworldstar.sfdrugs.implementations.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.bosses.CorporationMobZone;
import me.cworldstar.sfdrugs.implementations.bosses.entities.CorporateWorker;
import me.cworldstar.sfdrugs.implementations.bosses.entities.EscapedTestSubject;
import me.cworldstar.sfdrugs.implementations.bosses.entities.GangMember;
import me.cworldstar.sfdrugs.implementations.bosses.entities.SmallerGangMember;
import me.cworldstar.sfdrugs.implementations.items.armorupgrades.ExplosiveReactivePlating;

public class GiveUpgrade implements CommandExecutor {
	private SFDrugs plugin;
	public GiveUpgrade(SFDrugs plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = sender.getServer().getPlayer(sender.getName());
			ExplosiveReactivePlating x = new ExplosiveReactivePlating(this.plugin);
			p.getInventory().addItem(x.getItemStack());
			return true;
		}
		return false;
	}

}
