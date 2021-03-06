package chemicraft.lib;

import net.minecraft.util.ResourceLocation;

public class Reference {
	
	public static final String MOD_ID = "zl123_chemicraft";
	public static final String MOD_NAME = "ChemiCraft";
	public static final String VERSION = "0.0.0.0a";
	
	public static final float DEF_ORE_HARDNESS = 3.0F;
	public static final float DEF_ORE_RESIST = 5.0F;
	public static final short DEF_ORE_TYPE = 0;
	public static final int[] DEF_ORE_DROP_AMOUNT = {1,1};
	public static final boolean DEF_ORE_FORTUNE = true; //I was told making constants for everything was good.
	
	public static final ResourceLocation CHEMIST_WORKTABLE_GUI_LOC = new ResourceLocation(MOD_ID + ":/textures/gui/chemist_worktable.png");
	
}
