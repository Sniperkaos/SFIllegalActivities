package me.cworldstar.sfdrugs.implementations.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.bosses.CorporationMobZone;
import me.cworldstar.sfdrugs.implementations.bosses.entities.EscapedTestSubject;
import me.cworldstar.sfdrugs.implementations.bosses.entities.GangMember;
import me.cworldstar.sfdrugs.implementations.bosses.entities.SmallerGangMember;

public class TestCorporationEnemy implements CommandExecutor  {
	private SFDrugs plugin;
	public TestCorporationEnemy(SFDrugs plugin) {
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
			case "gangMember":
				new GangMember(plugin,(Zombie) p.getWorld().spawnEntity(p.getLocation(),EntityType.ZOMBIE));
			case "escapedTestSubject":
				new EscapedTestSubject(plugin,(Zombie) p.getWorld().spawnEntity(p.getLocation(),EntityType.ZOMBIE));
			case "smallerGangMember":
				new SmallerGangMember(plugin,(Zombie) p.getWorld().spawnEntity(p.getLocation(),EntityType.ZOMBIE));
			default:
				return false;
			}
			return true;
		}
		return false;
	}

}
