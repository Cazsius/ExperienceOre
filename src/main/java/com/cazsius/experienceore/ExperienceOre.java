package com.cazsius.experienceore;

import com.cazsius.experienceore.blocks.ExperienceOreBlock;
import com.cazsius.experienceore.blocks.ModBlocks;
import com.cazsius.experienceore.proxy.ClientProxy;
import com.cazsius.experienceore.proxy.IProxy;
import com.cazsius.experienceore.proxy.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("experienceore")
public class ExperienceOre {

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    private static final Logger LOGGER = LogManager.getLogger();

    private static Biome biome;

    public ExperienceOre() {

        ModLoadingContext modLoadingContext = ModLoadingContext.get();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigData.COMMON_SPEC);
    }


    private void setup(final FMLCommonSetupEvent event) {}

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new ExperienceOreBlock());
        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(ModBlocks.EXPERIENCE_ORE_BLOCK, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("experienceore"));
        }

        @SubscribeEvent
        public static void onFeatureRegistryEvent(RegistryEvent.Register<Feature<?>> event) {
            ForgeRegistries.BIOMES.forEach(biome -> biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, ModBlocks.EXPERIENCE_ORE_BLOCK.getDefaultState(),
                            ConfigData.COMMON.maxVeinSize.get()), Placement.COUNT_RANGE, new CountRangeConfig(ConfigData.COMMON.chanceToSpawn.get(),
                            ConfigData.COMMON.minSpawnHeight.get(), 0, ConfigData.COMMON.maxSpawnHeight.get()))));

        }
    }
}
