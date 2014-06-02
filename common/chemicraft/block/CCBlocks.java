package chemicraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class CCBlocks {
	
	public static Block blockCCOre, blockChemistWorktable, blockCrucible, blockTubingBronze, blockTubingCopper, blockTubingGold, blockTubingSilver, blockTubingAluminium;
	
	public static void registerBlock(Block block) {
		GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
	}
	
	public static void registerMetaBlock(Block block, Class<? extends ItemBlock> itemClass) {
		GameRegistry.registerBlock(block, itemClass, block.getUnlocalizedName().substring(5));
	}
	
	public static void blockRegister() {
		
		blockCCOre = new BlockOreCC();
		blockChemistWorktable = new BlockChemistWorktable().setBlockName("blockChemistWorktable");
		blockTubingBronze = new BlockTubingBronze().setBlockName("blockTubingBronze");
		blockTubingCopper = new BlockTubingCopper().setBlockName("blockTubingCopper");
		blockTubingGold = new BlockTubingGold().setBlockName("blockTubingGold");
		blockTubingSilver = new BlockTubingSilver().setBlockName("blockTubingSilver");
		blockTubingAluminium = new BlockTubingAluminium().setBlockName("blockTubingAluminium");
		
		
		registerBlock(blockCCOre);
		registerBlock(blockChemistWorktable);
		registerBlock(blockTubingBronze);
		registerBlock(blockTubingCopper);
		registerBlock(blockTubingGold);
		registerBlock(blockTubingSilver);
		registerBlock(blockTubingAluminium);
		
	}
	
}
