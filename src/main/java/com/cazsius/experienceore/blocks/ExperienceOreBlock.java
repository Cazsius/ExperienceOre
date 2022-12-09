package com.cazsius.experienceore.blocks;

import com.cazsius.experienceore.ConfigData;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraftforge.common.ToolType;

public class ExperienceOreBlock extends Block {

    public ExperienceOreBlock() {
        super(Properties.create(Material.ROCK)
                .sound(SoundType.METAL)
                .hardnessAndResistance(2.0F)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(1)  
                .setRequiresTool());
    }

    @Override
    public int getExpDrop(BlockState state, IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        if(silktouch == 0) {
            return ConfigData.COMMON.oreXpDrop.get();
        }
        else {
            return 0;
        }
    }
}
