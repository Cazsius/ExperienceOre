package com.cazsius.experienceore;

import net.minecraft.block.BlockOre;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class BlockExperienceOre extends BlockOre {

	public BlockExperienceOre() {
		setSoundType(SoundType.STONE);
		setRegistryName("experienceore:experience_ore");
		setTranslationKey("experience_ore");
		setHardness(4.0F);
		setHarvestLevel("pickaxe", 2);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return null;
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		return ExperienceOre.ModConfig.OreXP;
	}
}