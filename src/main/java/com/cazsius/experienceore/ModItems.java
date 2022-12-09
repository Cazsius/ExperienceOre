package com.cazsius.experienceore;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import com.cazsius.experienceore.blocks.ModBlocks;
import com.cazsius.experienceore.ExperienceOre;
import com.cazsius.experienceore.blocks.ModBlocks;

public class ModItems {

        public static final RegistryObject<Item> EXP_ORE_ITEM = ITEMS.register("exp_ore",
            () -> new BlockItem(ModBlocks.EXP_ORE.get(), new Item.Properties()));


    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExperienceOre.MOD_ID);

}