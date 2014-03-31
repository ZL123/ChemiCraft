package chemicraft.config;

import chemicraft.lib.DefaultValues;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ConfigLoader {
	
	public static Configuration config;
	
	public static void init(FMLPreInitializationEvent event) {
		
		config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		//Block IDs
		ConfigSettings.oreID = config.get("Blocks", "Ore", DefaultValues.oreID).getInt();
		ConfigSettings.machineID = config.get("Blocks", "Machine", DefaultValues.machineID).getInt();
		
	}
	
}
