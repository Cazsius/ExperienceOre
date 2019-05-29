package com.cazsius.experienceore;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = ExperienceOre.MODID,name = "Experience Ore", version = ExperienceOre.VERSION)
public class ExperienceOre {
	public static final String MODID = "experienceore";
	public static final String VERSION = "1.0.1";
	public static Block blockExperienceOre;

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public final void onModelRegistry(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockExperienceOre),0, new ModelResourceLocation(blockExperienceOre.getRegistryName(), "normal"));
	}


	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this);
		blockExperienceOre = new BlockExperienceOre();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new WorldGen(), 0);
	}

	@SubscribeEvent
	public void onRegisterBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().register(blockExperienceOre);
	}
	@SubscribeEvent
	public void onRegisterItems(RegistryEvent.Register<Item> event) {
		event.getRegistry().register(new ItemBlock(blockExperienceOre).setRegistryName(blockExperienceOre.getRegistryName()));
	}

	@net.minecraftforge.common.config.Config(modid="experienceore",name="Experience Ore")
	public static class Config {

		//OreXP = config.getInt("OreXP", Configuration.CATEGORY_GENERAL, 10, 1, 1000, "Controls the amount of XP the ore will give upon being broken.");
		//MaxSpawnHeight = config.getInt("MaxSpawnHeight", Configuration.CATEGORY_GENERAL, 64, 0, 256, "Controls maximum spawn height of Experience Ore.");
		//MinSpawnHeight = config.getInt("MinSpawnHeight", Configuration.CATEGORY_GENERAL, 0, 0, 256, "Controls minimum spawn height of Experience Ore.");
		//ChanceToSpawn = config.getInt("ChanceToSpawn", Configuration.CATEGORY_GENERAL, 10, 1, 100, "Controls the chance to spawn in world generation.");
		//VeinSize = config.getInt("VeinSize", Configuration.CATEGORY_GENERAL, 5, 1, 10, "Controls the Vein size in world generation.");

		@net.minecraftforge.common.config.Config.Comment("How much XP is dropped when the ore is broken")
		@net.minecraftforge.common.config.Config.RangeInt(min = 1,max = 1000)
		@net.minecraftforge.common.config.Config.Name("OreXP")
		public static int OreXP = 10;

		@net.minecraftforge.common.config.Config.RangeInt(min=0,max=256)
		@net.minecraftforge.common.config.Config.Name("Maximum Spawn Height")
		@net.minecraftforge.common.config.Config.Comment("The maximum height to spawn ore at.")
		public static int maxHeight = 64;

		@net.minecraftforge.common.config.Config.RangeInt(min=0,max=256)
		@net.minecraftforge.common.config.Config.Name("Minimum Spawn Height")
		@net.minecraftforge.common.config.Config.Comment("The minimum height to spawn ore at.")
		public static int minHeight = 0;

		@net.minecraftforge.common.config.Config.RangeInt(min=1,max=100)
		@net.minecraftforge.common.config.Config.Name("Chance to Spawn")
		@net.minecraftforge.common.config.Config.Comment("Controls the chance to spawn in world generation.")
		public static int spawnChance = 10;

		@net.minecraftforge.common.config.Config.RangeInt(min=1,max=10)
		@net.minecraftforge.common.config.Config.Name("Vein Size")
		@net.minecraftforge.common.config.Config.Comment("The maximum number of ores per vein")
		public static int veinSize = 5;
	}

}