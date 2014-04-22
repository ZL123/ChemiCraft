package chemicraft.lib;

import chemicraft.block.CCBlocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class CCRecipes {
	
	public static void recipes() {
		
			/*
			 *  __________________________________________
			 * |                                          |
			 * |         CRAFTING TABLE RECIPES!          |
			 * |__________________________________________|
			 * 
			 */
		
		
		GameRegistry.addRecipe(new ItemStack(CCBlocks.crucible), new Object[] {"O O", " O ", 'O', Items.clay_ball});
		
		
		
		
		
		
		
	}
}
