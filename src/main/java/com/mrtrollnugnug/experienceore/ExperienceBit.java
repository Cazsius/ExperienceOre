package com.mrtrollnugnug.experienceore;

import static com.mrtrollnugnug.experienceore.ExperienceOre.MODID;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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

}
