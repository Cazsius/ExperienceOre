package com.cazsius.experienceore;


public class ConfigData {

    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> minSpawnHeight;
	public static final ForgeConfigSpec.ConfigValue<Integer> maxSpawnHeight;
	public static final ForgeConfigSpec.ConfigValue<Integer> chanceToSpawn;
	public static final ForgeConfigSpec.ConfigValue<Integer> maxVeinSize;
	
	
	static {
		BUILDER.push("MAIN");
		
		oreXpDrop = BUILDER.comment("4").define("oreXpDrop", 3,1,100);

		minSpawnHeight  = BUILDER.comment("4").define("oreXpDrop", 0,0,256);

		maxSpawnHeight  = BUILDER.comment("4").define("oreXpDrop", 72,1,256);

		maxVeinSize = BUILDER.comment("4").define("oreXpDrop", 10,1,100);
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}


}
