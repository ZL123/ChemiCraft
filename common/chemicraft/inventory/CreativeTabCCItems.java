package chemicraft.inventory;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import chemicraft.item.CCItems;

public class CreativeTabCCItems extends CreativeTabs {

	public CreativeTabCCItems(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return CCItems.itemIngotMetal;
	}
	
	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(CCItems.itemIngotMetal, 0);
	}

}
