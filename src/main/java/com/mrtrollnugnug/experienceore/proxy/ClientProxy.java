package com.mrtrollnugnug.experienceore.proxy;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.mrtrollnugnug.experienceore.ExperienceOre;

import net.minecraft.block.Block;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.DefaultStateMapper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {

	@Override
	public void init() {
	}

	@Override
	public void registerWithMapper(Block block) {
		if (FMLCommonHandler.instance().getEffectiveSide().isClient() && block != null) {
			final String resourcePath = String.format("%s:%s", ExperienceOre.MODID,
					block.getRegistryName().getResourcePath());

			ModelLoader.setCustomStateMapper(block, new DefaultStateMapper() {
				@Override
				protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
					return new ModelResourceLocation(resourcePath, getPropertyString(state.getProperties()));
				}
			});

			List<ItemStack> subBlocks = Lists.newArrayList();
			block.getSubBlocks(Item.getItemFromBlock(block), null, subBlocks);

			for (ItemStack stack : subBlocks) {
				IBlockState state = block.getStateFromMeta(stack.getMetadata());
				ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), stack.getMetadata(),
						new ModelResourceLocation(resourcePath, getPropertyString(state.getProperties())));
			}
		}
	}

	public static String getPropertyString(Map<IProperty<?>, Comparable<?>> values, String... extrasArgs) {
		StringBuilder stringbuilder = new StringBuilder();

		for (Map.Entry<IProperty<?>, Comparable<?>> entry : values.entrySet()) {
			if (stringbuilder.length() != 0) {
				stringbuilder.append(",");
			}

			IProperty<?> iProperty = (IProperty<?>) entry.getKey();
			stringbuilder.append(iProperty.getName());
			stringbuilder.append("=");
			stringbuilder.append(getPropertyName(iProperty, (Comparable<?>) entry.getValue()));
		}
		if (stringbuilder.length() == 0) {
			stringbuilder.append("inventory");
		}

		for (String args : extrasArgs) {
			if (stringbuilder.length() != 0)
				stringbuilder.append(",");
			stringbuilder.append(args);
		}

		return stringbuilder.toString();
	}

	@SuppressWarnings("unchecked")
	private static <T extends Comparable<T>> String getPropertyName(IProperty<T> property, Comparable<?> comparable) {
		return property.getName((T) comparable);
	}

}