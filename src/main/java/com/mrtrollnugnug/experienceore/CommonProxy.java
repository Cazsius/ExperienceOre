package com.mrtrollnugnug.experienceore;

import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {

	public static final ExperienceOreBlock experienceOreBlock = new ExperienceOreBlock(Material.IRON);
	
	public static void preInit() 
	{
		GameRegistry.register(experienceOreBlock);
	}
	
	public void init()
	{
		
	}

}
