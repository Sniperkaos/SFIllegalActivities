package me.cworldstar.sfdrugs.implementations.bosses.entities;

import org.bukkit.scheduler.BukkitRunnable;

import me.cworldstar.sfdrugs.SFDrugs;

public class Skill {

	public enum SkillType {
		PASSIVE(1),ACTIVE(2),SEQUENCED(3);
		SkillType(int i) {
			// TODO Auto-generated constructor stub
		}
	}

	private Runnable Skill;
	private SkillType SkillType;
	
	public Skill(SkillType Type,BukkitRunnable Skill) {
		this.Skill = Skill;
		this.SkillType = Type;
	}
	
	public Skill(SkillType Type,Runnable Skill) {
		this.Skill = Skill;
		this.SkillType = Type;
	}
	
	public void use() {
		
		this.Skill.run();
		
		switch(this.SkillType) {
			case PASSIVE:
				//this.Skill.runTaskTimer(SFDrugs.getPlugin(SFDrugs.class), 0, 1L);
				break;
			case ACTIVE:
				this.Skill.run();
				break;
			case SEQUENCED:
				/**
				 * 
				 * Sequenced is passive but it runs every five seconds and needs to be
				 * manually canceled.
				 * 
				 * @author cworldstar
				 */
				//this.Skill.runTaskTimer(SFDrugs.getPlugin(SFDrugs.class), 0, 100L);
			default:
				throw new Error("invalid skill type");
		}
	}
}
