package com.mrtrollnugnug.experienceore;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {


	public static void preInit() {
	}

	public void init() 
	{
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
	}
	

	public void registerWithMapper(Block block) {

	}

}