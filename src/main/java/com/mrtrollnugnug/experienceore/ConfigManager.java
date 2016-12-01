package com.mrtrollnugnug.experienceore;

import java.io.File;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigManager
{
	public static Configuration config;

	public static int MinOreXP;
	public static int MaxOreXP;
	
	public static int MaxSpawnHeight;
	public static int MinSpawnHeight;
	
	public static int ChanceToSpawn;
	public static int VeinSize;
	

	public static void init(File configFile) 
	{
		if (config == null) {
			config = new Configuration(configFile);
			load();

		}
	}

	public static void load() {
				
		MinOreXP = config.getInt("MinOreXP", Configuration.CATEGORY_GENERAL, 8, 1, 99, "Controls minimum amount of XP Experience Ore will drop.");
		MaxOreXP = config.getInt("MaxOreXP", Configuration.CATEGORY_GENERAL, 12, 1, 99, "Controls maximum amount of XP Experience Ore will drop.");
		
		MaxSpawnHeight = config.getInt("MaxSpawnHeight", Configuration.CATEGORY_GENERAL, 64, 0, 256, "Controls maximum spawn height of Experience Ore.");
		MinSpawnHeight = config.getInt("MinSpawnHeight", Configuration.CATEGORY_GENERAL, 0, 0, 256, "Controls minimum spawn height of Experience Ore.");
		
		ChanceToSpawn = config.getInt("ChanceToSpawn", Configuration.CATEGORY_GENERAL, 10, 1, 100, "Controls the chance to spawn in world generation.");
		VeinSize = config.getInt("VeinSize", Configuration.CATEGORY_GENERAL, 5, 1, 10, "Controls the Vein size in world generation.");
		
		if (config.hasChanged()) 
		{
			config.save();
		}
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
		if (event.getModID().equalsIgnoreCase(ExperienceOre.MODID)) {
			load();
		}
	}
}
