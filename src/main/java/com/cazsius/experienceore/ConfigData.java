package com.cazsius.experienceore;


public class ConfigData {

        public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	public static final ForgeConfigSpec SPEC;
	
	public static final ForgeConfigSpec.ConfigValue<Integer> test1;
	
	static {
		BUILDER.push("test1");
		
		test1 = BUILDER.comment("4").define("test123", 3);
		
		BUILDER.pop();
		SPEC = BUILDER.build();
	}


}
