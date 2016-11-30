package com.mrtrollnugnug.experienceore;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockExperienceOre extends Block {

	public BlockExperienceOre() {
		super(Material.IRON);
		setCreativeTab(CreativeTabs.MATERIALS);
		setSoundType(SoundType.STONE);
		setUnlocalizedName("experience_ore");
		setRegistryName("experience_ore");
	}	
}
