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
