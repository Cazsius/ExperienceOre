package com.mrtrollnugnug.experienceore;

import static com.mrtrollnugnug.experienceore.ExperienceOre.MODID;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
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
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) 
    {
        return MathHelper. getRandomIntegerInRange(new Random(), ConfigManager.MinOreXP, ConfigManager.MaxOreXP);
    }

	
	@Override
    public int quantityDropped(Random random)
    {
        return 0;
    }
}