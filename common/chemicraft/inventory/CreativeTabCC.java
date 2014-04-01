package chemicraft.inventory;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import chemicraft.block.CCBlocks;

public class CreativeTabCC extends CreativeTabs {

	public CreativeTabCC(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(CCBlocks.CCOre);
	}

}
