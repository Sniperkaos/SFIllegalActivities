package me.cworldstar.sfdrugs.implementations.bosses.entities;

import org.bukkit.scheduler.BukkitRunnable;
import me.cworldstar.sfdrugs.implementations.bosses.entities.Skill.SkillType;

public class SummonSkill extends Skill {

	public SummonSkill(SkillType Type, BukkitRunnable Skill, EnemyEntity E) {
		super(Type, Skill);
	}
	
	
}
