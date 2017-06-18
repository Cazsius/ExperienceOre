package com.mrtrollnugnug.experienceore;

import static com.mrtrollnugnug.experienceore.ExperienceOre.MODID;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ExperienceBit extends Item {
	
	
	public ExperienceBit() 
	{
		super();
		setUnlocalizedName(MODID + ".experience_bit");
		setRegistryName(MODID, "experience_bit");
	    this.setCreativeTab(CreativeTabs.MATERIALS);
		GameRegistry.register(this);
	}
	
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
			ItemStack stackIn = playerIn.getHeldItem(handIn);
			playerIn.addExperience(ConfigManager.OreXP);
	        if (!playerIn.capabilities.isCreativeMode) {
	        	stackIn.shrink(1);
	        }
			return super.onItemRightClick(worldIn, playerIn, handIn);
	}

}
