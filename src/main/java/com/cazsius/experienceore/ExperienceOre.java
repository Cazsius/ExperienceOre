package com.cazsius.experienceore;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = ExperienceOre.MODID, name = ExperienceOre.NAME, version = ExperienceOre.VERSION)
public class ExperienceOre {

	public static final String MODID = "experienceore";
	public static final String NAME = "Experience Ore";
	public static final String VERSION = "1.0.1";
	public static Block blockExperienceOre;

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public final void onModelRegistry(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(blockExperienceOre), 0, new ModelResourceLocation(blockExperienceOre.getRegistryName(), "normal"));
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

	@Config(modid = MODID, name = NAME)
	public static class ModConfig {
		@Config.Comment("How much XP is dropped when the ore is broken")
		@Config.RangeInt(min = 1, max = 1000)
		@Config.Name("Ore XP")
		public static int OreXP = 10;

		@Config.RangeInt(min = 0, max = 256)
		@Config.Name("Maximum Spawn Height")
		@Config.Comment("The maximum height to spawn ore at.")
		public static int maxHeight = 64;

		@Config.RangeInt(min = 0, max = 256)
		@Config.Name("Minimum Spawn Height")
		@Config.Comment("The minimum height to spawn ore at.")
		public static int minHeight = 0;

		@Config.RangeInt(min = 1, max = 100)
		@Config.Name("Chance to Spawn")
		@Config.Comment("Controls the chance to spawn in world generation.")
		public static int spawnChance = 10;

		@Config.RangeInt(min = 1, max = 10)
		@Config.Name("Vein Size")
		@Config.Comment("The maximum number of ores per vein")
		public static int veinSize = 5;
	}
}