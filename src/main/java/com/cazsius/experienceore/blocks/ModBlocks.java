package com.cazsius.experienceore.blocks;

import net.minecraftforge.registries.ObjectHolder;
import com.cazsius.experienceore.blocks.ExperienceOreBlock;
import com.cazsius.experienceore.ExperienceOre;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class ModBlocks {

        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ExperienceOre.MOD_ID);

        // Blocks
        public static final RegistryObject<Block> EXP_ORE = BLOCKS.register("exp_ore", ExperienceOreBlock::new);


}
