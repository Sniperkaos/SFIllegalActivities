package me.cworldstar.sfdrugs;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.cworldstar.sfdrugs.utils.Items;

public class SFDrugs extends JavaPlugin implements SlimefunAddon {
	@Override
    public void onEnable() {
        // Give your Category a unique id.
    	Items ItemRegistry = new Items(this);
    	ItemRegistry.register();
    	Logger x = getLogger();
    	x.log(Level.INFO, "============================================");
    	x.log(Level.INFO, "====         SF DRUGS ENABLED            ===");
    	x.log(Level.INFO, "====                                     ====");
    	x.log(Level.INFO, "============================================");
    }
    @Override
    public void onDisable() {}

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }
    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
