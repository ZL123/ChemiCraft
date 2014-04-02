package chemicraft.block;

import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class CCBlocks {
	
	public static Block CCOre;
	
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	public static void blockRegister() {
		
		CCOre = new BlockOreCC();
		
		
		registerBlock(CCOre);
		
	}
	
}
