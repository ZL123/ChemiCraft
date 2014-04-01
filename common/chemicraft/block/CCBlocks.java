package chemicraft.block;

import net.minecraft.block.Block;
import chemicraft.lib.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

public class CCBlocks {
	
	public static Block CCOre;
	
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	public static void blockRegister() {
		
		CCOre = new BlockOreCC(Reference.DEF_ORE_HARDNESS, Reference.DEF_ORE_RESIST);
		
		
		registerBlock(CCOre);
		
	}
	
}
