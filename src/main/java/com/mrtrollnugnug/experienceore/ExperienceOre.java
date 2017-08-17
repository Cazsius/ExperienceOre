package com.mrtrollnugnug.experienceore;

import com.mrtrollnugnug.experienceore.proxy.CommonProxy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = ExperienceOre.MODID, version = ExperienceOre.VERSION)
public class ExperienceOre {
	public static final String MODID = "experienceore";
	public static final String VERSION = "1.0.0";
	public static Block BLOCK_EXPERIENCE_ORE;

	@Instance()
	public static ExperienceOre INSTANCE;

	@SidedProxy(clientSide = "com.mrtrollnugnug.experienceore.proxy.ClientProxy", serverSide = "com.mrtrollnugnug.experienceore.proxy.CommonProxy")
	public static CommonProxy PROXY;

	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		BLOCK_EXPERIENCE_ORE = new BlockExperienceOre();
		MinecraftForge.EVENT_BUS.register(new ConfigManager());
		ConfigManager.init(event.getSuggestedConfigurationFile());
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		PROXY.init();
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
	}
	
	@Mod.EventBusSubscriber
	public static class ExperienceOreHandler {
	
		@SubscribeEvent
		public static void onRegisterBlocks(RegistryEvent.Register<Block> event) {
			event.getRegistry().register(new BlockExperienceOre());
		}
		
		@SubscribeEvent
		public static void onRegisterItems(RegistryEvent.Register<Item> event) {
			event.getRegistry().register(new ItemBlock(BLOCK_EXPERIENCE_ORE).setRegistryName(BLOCK_EXPERIENCE_ORE.getRegistryName()));
		}
	}
}