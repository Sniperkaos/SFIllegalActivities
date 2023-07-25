package me.cworldstar.sfdrugs.implementations.bosses.entities;

import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;

public abstract class NormalEntity {
	public abstract void applyEntityEdits(Mob b);
	public abstract List<Skill> getSkills();
	public abstract List<String> getIdleDialog();
	public abstract List<String> getAttackingDialog(Player e);
}
