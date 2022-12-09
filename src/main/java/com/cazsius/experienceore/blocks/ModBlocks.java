package com.cazsius.experienceore.blocks;

import net.minecraftforge.registries.ObjectHolder;
import com.cazsius.experienceore.blocks.ExperienceOreBlock;

public class ModBlocks {

        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Tutorial.MOD_ID);

        // Blocks
        public static final RegistryObject<Block> EXP_ORE = BLOCKS.register("exp_ore", ExperienceOreBlock::new);


}
