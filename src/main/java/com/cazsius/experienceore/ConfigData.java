package com.cazsius.experienceore;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ConfigData {


    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }


    public static class CommonConfig {
        public final ForgeConfigSpec.IntValue oreXpDrop;

        //TODO Use other 4 values
        public final ForgeConfigSpec.IntValue minSpawnHeight;
        public final ForgeConfigSpec.IntValue maxSpawnHeight;
        public final ForgeConfigSpec.IntValue chanceToSpawn;
        public final ForgeConfigSpec.IntValue maxVeinSize;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            oreXpDrop = builder
                    .comment("How much XP is dropped when the Experience Ore is broken")
                    .defineInRange("oreXpDrop", 15, 1, 100);
            minSpawnHeight = builder
                    .comment("The minimum height to spawn Experience Ore at.")
                    .defineInRange("minSpawnHeight", 0, 0, 256);
            maxSpawnHeight = builder
                    .comment("The maximum height to spawn Experience Ore at.")
                    .defineInRange("maxSpawnHeight", 72, 0, 256);
            chanceToSpawn = builder
                    .comment("Controls the chance to spawn Experience Ore in world generation.")
                    .defineInRange("chanceToSpawn", 12, 1, 100);
            maxVeinSize = builder
                    .comment("The maximum number of ores per vein. Please note, the average ore vein will be about half of this. EX: Vanilla Coal is 17.")
                    .defineInRange("veinSize", 10, 1, 100);
            builder.pop();
        }
    }

}
