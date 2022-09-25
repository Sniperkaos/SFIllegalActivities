package me.cworldstar.sfdrugs.fileutils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import me.cworldstar.sfdrugs.SFDrugs;

public class Config {
	public static Map<String,File> SchematicDatabase = new HashMap<String,File>();
	public Config(SFDrugs plugin) {
		File cfig = plugin.getDataFolder();
		if(cfig.exists()) {
			
		} else {
		    for (final File f : cfig.listFiles()) {
		    	if(f.getName().split("/[,.]/")[1] == "schem") {
		    		this.register(f.getName().split("/[,.]/")[0],f);
		    	}
		    }
		}
	}

	private void register(String string, File schematic) {
		Config.SchematicDatabase.put(string,schematic);
	}
}
