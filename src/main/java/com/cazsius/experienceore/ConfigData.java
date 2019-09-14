package com.cazsius.experienceore;

import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class ConfigData {


    public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    static {
        final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER_SPEC = specPair.getRight();
        SERVER = specPair.getLeft();
    }

    public static int oreXPDrop;

    //TODO Use other 4 variables during world gen
    public static int minSpawnHeight;
    public static int maxSpawnHeight;
    public static int chanceToSpawn;
    public static int veinSize;

    public static class ServerConfig {
        public final ForgeConfigSpec.IntValue oreXpDrop;
        public final ForgeConfigSpec.IntValue minSpawnHeight;
        public final ForgeConfigSpec.IntValue maxSpawnHeight;
        public final ForgeConfigSpec.IntValue chanceToSpawn;
        public final ForgeConfigSpec.IntValue veinSize;

        ServerConfig(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            oreXpDrop = builder
                    .comment("How much XP is dropped when the ore is broken")
                    .defineInRange("showBeltOnPlayers", 10, 1, 100);
            minSpawnHeight = builder
                    .comment("The minimum height to spawn ore at.")
                    .defineInRange("showBeltOnPlayers", 0, 0, 256);
            maxSpawnHeight = builder
                    .comment("The maximum height to spawn ore at.")
                    .defineInRange("showBeltOnPlayers", 64, 0, 256);
            chanceToSpawn = builder
                    .comment("Controls the chance to spawn in world generation.")
                    .defineInRange("showBeltOnPlayers", 10, 1, 100);
            veinSize = builder
                    .comment("The maximum number of ores per vein.")
                    .defineInRange("showBeltOnPlayers", 5, 1, 10);
            builder.pop();
        }
    }

    public static void refreshServer()
    {
        oreXPDrop = SERVER.oreXpDrop.get();
        minSpawnHeight = SERVER.minSpawnHeight.get();
        maxSpawnHeight = SERVER.maxSpawnHeight.get();
        chanceToSpawn = SERVER.chanceToSpawn.get();
        veinSize = SERVER.veinSize.get();

    }

}
