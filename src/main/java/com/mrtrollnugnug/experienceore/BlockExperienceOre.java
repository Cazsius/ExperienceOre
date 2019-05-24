package com.mrtrollnugnug.experienceore;

import static com.mrtrollnugnug.experienceore.ExperienceOre.MODID;

import java.util.Random;

import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockExperienceOre extends BlockOre {

	public BlockExperienceOre() {
		setCreativeTab(CreativeTabs.MATERIALS);
		setSoundType(SoundType.STONE);
		setRegistryName("experienceore:experience_ore");
		setTranslationKey("experience_ore");
		setHardness(4.0F);
		setHarvestLevel("pickaxe", 2);
		ExperienceOre.PROXY.registerWithMapper(this);
		
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}
	
	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		return ConfigManager.OreXP;
	}
}