package chemicraft.block;

import net.minecraft.block.Block;
import net.minecraft.util.RegistryNamespaced;
import chemicraft.config.ConfigSettings;
import chemicraft.lib.Reference;
import cpw.mods.fml.common.registry.GameData;

public class CCBlocks {
	
	public static final RegistryNamespaced blockRegistry = GameData.blockRegistry;
	
	public static void registerBlocks() {
		//addObject(numericalID, stringID, block)
		blockRegistry.addObject(ConfigSettings.oreID, "chemicraft_ore", (new BlockOreCC(Reference.DEF_ORE_HARDNESS, Reference.DEF_ORE_RESIST)).setStepSound(Block.soundTypePiston).setBlockName("chemicraft_ore").setBlockTextureName("ore"));
		
	}
	
}
