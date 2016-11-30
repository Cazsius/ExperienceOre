package com.mrtrollnugnug.experienceore;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExperienceOre.MODID, version = ExperienceOre.VERSION)
public class ExperienceOre {

	public static final String MODID = "experienceore";
	public static final String VERSION = "1.0";
	
	//Blocks
	public static Block BlockExperienceOre;

	@Mod.Instance("experienceore")
	public static ExperienceOre instance;

	@SidedProxy(clientSide = "com.mrtrollnugnug.experienceore.ClientProxy", serverSide = "com.mrtrollnugnug.experienceore.CommonProxy")
	public static CommonProxy proxy;

	public static void preInit(FMLPreInitializationEvent event) 
	{
		BlockExperienceOre = new BlockExperienceOre();
    	GameRegistry.registerBlock(BlockExperienceOre, "experience_ore");
	}
	
	public static void init() {
		proxy.init();

	}

}
