package chemicraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class CCItems {
	
	public static Item itemIngotMetal;
	public static Item itemDustMetal;
	
	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
		
	}
	
	public static void itemRegister() {
		
		itemIngotMetal = new ItemIngotMetal().setUnlocalizedName("CCIngot");
		itemDustMetal = new ItemDustMetal().setUnlocalizedName("CCDust");
		
		registerItem(itemIngotMetal);
		registerItem(itemDustMetal);
		
		
	}
	
	
	
}
