package me.cworldstar.sfdrugs.events;

import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.loot.LootContext;

import me.cworldstar.sfdrugs.SFDrugs;
import me.cworldstar.sfdrugs.implementations.loot.CorporationEnemyLootTable;
import me.cworldstar.sfdrugs.implementations.loot.SmallerGangMemberLootTable;
import me.cworldstar.sfdrugs.utils.RandomUtils;

public class CustomMobDeathEvent implements Listener {
	private SFDrugs plugin;
	public CustomMobDeathEvent(SFDrugs plugin) {
		this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onMobDeath(EntityDeathEvent e) {
		LivingEntity killedMob = e.getEntity();
		if(killedMob.hasMetadata("SFDRUGS_CUSTOM_MOB")) {
			String Identifier = killedMob.getMetadata("SFDRUGS_CUSTOM_MOB").get(0).asString();
			e.getDrops().clear();
			switch(Identifier) {
				case "red_wolves_trainee":
					e.getDrops().addAll(new SmallerGangMemberLootTable(this.plugin).populateLoot(RandomUtils.getRandom(),new LootContext.Builder(killedMob.getLocation()).build()));
					break;
				case "corporate_security_robot":
					e.getDrops().addAll(new CorporationEnemyLootTable(this.plugin).populateLoot(RandomUtils.getRandom(),new LootContext.Builder(killedMob.getLocation()).build()));
					break;
				case "escaped_test_subject":
					//TODO: Loot table for this guy.
					break;
				case "red_wolves_gangster":
					//TODO: Loot table for this guy.

					break;
			}
		}
	}
}
