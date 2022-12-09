package com.cazsius.experienceore;

import com.cazsius.experienceore.blocks.ExperienceOreBlock;
import com.cazsius.experienceore.blocks.ModBlocks;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(ExperienceOre.MOD_ID)
public class ExperienceOre {

    public static final String MOD_ID = "experienceore";

    public ExperienceOre() {

        ModLoadingContext modLoadingContext = ModLoadingContext.get();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigData.COMMON_SPEC);
    }


