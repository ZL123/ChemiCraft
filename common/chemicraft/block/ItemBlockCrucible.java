package chemicraft.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCrucible extends ItemBlock {
	
	public ItemBlockCrucible(Block block) {
		super(block);
		this.setHasSubtypes(true);
	}
	
	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "." + BlockCrucible.crucibleMaterials[stack.getItemDamage()];
	}
	
	public int getMetadata(int par1) {
		return par1;
	}
	
	
	
	
}
