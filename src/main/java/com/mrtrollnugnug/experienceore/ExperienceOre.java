package com.mrtrollnugnug.experienceore;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;

@Mod(modid = ExperienceOre.MODID, version = ExperienceOre.VERSION)
public class ExperienceOre {

	public static final String MODID = "experienceore";
	public static final String VERSION = "1.0";

	@Mod.Instance("experienceore")
	public static ExperienceOre instance;

	@SidedProxy(clientSide = "com.mrtrollnugnug.experienceore.ClientProxy", serverSide = "com.mrtrollnugnug.experienceore.CommonProxy")
	public static CommonProxy proxy;

	public static Block experienceOreBlock;

	public static void preInit() {
		
	}
	
	public static void init() {
		proxy.init();

	}

}
