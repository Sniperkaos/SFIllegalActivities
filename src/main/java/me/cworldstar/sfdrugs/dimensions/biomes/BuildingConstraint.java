package me.cworldstar.sfdrugs.dimensions.biomes;

import java.io.InvalidClassException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Chunk;
import org.bukkit.entity.Entity;

import com.sk89q.worldedit.math.Vector3;

public class BuildingConstraint extends Constraint {
	
	@Override
	public boolean validate(Chunk chunk) {
		for(Constraint c : this.constraints) {
			if(c.validate(chunk)) {
				return true;
			};
		}
		return false;
	}

	public enum ConstraintType {
		
		Position,
		Entity,
		Time
		
	}
	
	public ArrayList<Constraint> constraints = new ArrayList<Constraint>();
	
	public BuildingConstraint() {
		super();
	}
	
	public void addConstraint(ConstraintType T, Object x) {
		switch(T) {
		
		case Position:
			
			if(!(x instanceof Vector3)) {
				throw new Error("Constraint object X invalid type for " + T.toString());
			} else {
				VectorConstraint VectorConstraint = new VectorConstraint(T, x);
				constraints.add(VectorConstraint);
			}
			
			
			break;
		default:
			break;
			
		
		}
		
	}
	
}
