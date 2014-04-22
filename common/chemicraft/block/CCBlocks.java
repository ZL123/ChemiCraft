package chemicraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class CCBlocks {
	
	public static Block CCOre;
	public static Block chemistWorktable;
	public static Block crucible;
	
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	public static void registerMetaBlock(Block block, Class<? extends ItemBlock> itemClass) {
		GameRegistry.registerBlock(block, itemClass, block.getUnlocalizedName().substring(5));
	}
	
	public static void blockRegister() {
		
		CCOre = new BlockOreCC();
		chemistWorktable = new BlockChemistWorktable();
		
		
		registerBlock(CCOre);
		registerBlock(chemistWorktable);
		
	}
	
}
