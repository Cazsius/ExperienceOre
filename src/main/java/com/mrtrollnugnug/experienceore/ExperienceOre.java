package com.mrtrollnugnug.experienceore;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ExperienceOre.MODID, version = ExperienceOre.VERSION)
public class ExperienceOre {

	public static final String MODID = "experienceore";
	public static final String VERSION = "1.0.0";

	public static Block BLOCK_EXPERIENCE_ORE;

	@Instance()
	public static ExperienceOre INSTANCE;

	@SidedProxy(clientSide = "com.mrtrollnugnug.experienceore.ClientProxy", serverSide = "com.mrtrollnugnug.experienceore.ServerProxy")
	public static CommonProxy proxy;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		BLOCK_EXPERIENCE_ORE = new BlockExperienceOre();

	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		proxy.init();
	}
}