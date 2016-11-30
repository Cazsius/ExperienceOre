package com.mrtrollnugnug.experienceore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ClientProxy extends CommonProxy {

	@Override
	public void init() {
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(experienceOreBlock), 0, new ModelResourceLocation(
				ExperienceOre.MODID + ":experience_ore", "inventory"));
	}

}
