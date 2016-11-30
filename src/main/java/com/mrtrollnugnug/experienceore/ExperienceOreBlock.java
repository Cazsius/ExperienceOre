package com.mrtrollnugnug.experienceore;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class ExperienceOreBlock extends Block {

	public ExperienceOreBlock(Material materialIn) {
		super(materialIn);
		setUnlocalizedName("experience_ore");
		setRegistryName("experience_ore");
		setCreativeTab(CreativeTabs.MATERIALS);
		setHardness(2.0F);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 2);
	}
	

}
