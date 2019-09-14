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

    public static int oreXPDrop;

    //TODO Use other 4 variables during world gen
    public static int minSpawnHeight;
    public static int maxSpawnHeight;
    public static int chanceToSpawn;
    public static int veinSize;

    public static class CommonConfig {
        public final ForgeConfigSpec.IntValue oreXpDrop;
        public final ForgeConfigSpec.IntValue minSpawnHeight;
        public final ForgeConfigSpec.IntValue maxSpawnHeight;
        public final ForgeConfigSpec.IntValue chanceToSpawn;
        public final ForgeConfigSpec.IntValue veinSize;

        CommonConfig(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            oreXpDrop = builder
                    .comment("How much XP is dropped when the ore is broken")
                    .defineInRange("oreXpDrop", 10, 1, 100);
            minSpawnHeight = builder
                    .comment("The minimum height to spawn ore at.")
                    .defineInRange("minSpawnHeight", 0, 0, 256);
            maxSpawnHeight = builder
                    .comment("The maximum height to spawn ore at.")
                    .defineInRange("maxSpawnHeight", 64, 0, 256);
            chanceToSpawn = builder
                    .comment("Controls the chance to spawn in world generation.")
                    .defineInRange("chanceToSpawn", 10, 1, 100);
            veinSize = builder
                    .comment("The maximum number of ores per vein.")
                    .defineInRange("veinSize", 5, 1, 10);
            builder.pop();
        }
    }

    public static void refreshCommon()
    {
        oreXPDrop = COMMON.oreXpDrop.get();
        minSpawnHeight = COMMON.minSpawnHeight.get();
        maxSpawnHeight = COMMON.maxSpawnHeight.get();
        chanceToSpawn = COMMON.chanceToSpawn.get();
        veinSize = COMMON.veinSize.get();

    }

}
