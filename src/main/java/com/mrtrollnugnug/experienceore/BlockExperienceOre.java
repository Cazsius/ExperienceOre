package com.mrtrollnugnug.experienceore;

import static com.mrtrollnugnug.experienceore.ExperienceOre.MODID;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BlockExperienceOre extends Block 
{

	public BlockExperienceOre() 
	{
		super(Material.IRON);
		setCreativeTab(CreativeTabs.MATERIALS);
		setSoundType(SoundType.STONE);
		setUnlocalizedName(MODID + ".experience_ore");
		setRegistryName(MODID, "experience_ore");
		setHardness(4.0F);
		setHarvestLevel("pickaxe", 2);
		GameRegistry.register(this);
		GameRegistry.register(new ItemBlock(this).setRegistryName(getRegistryName()));
		ExperienceOre.PROXY.registerWithMapper(this);
		
	}

	
	@Override
    public int quantityDropped(Random random)
    {
        return 0;
    }
}