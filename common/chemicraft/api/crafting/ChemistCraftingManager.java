package chemicraft.api.crafting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.minecraft.item.ItemStack;

public class ChemistCraftingManager {
	
	private static final ChemistCraftingManager instance = new ChemistCraftingManager();
	/** List of recipes */
	@SuppressWarnings("rawtypes")
	private List recipes = new ArrayList();
	
	public static final ChemistCraftingManager getInstance() {
		return instance;
	}
	
	public List<?> getRecipeList() {
		return recipes;
	}
	
	private ChemistCraftingManager() {
		
	}
	
	@SuppressWarnings("rawtypes")
	public void addRecipe(ItemStack output, ItemStack[][] input) {
		
		int i = 0;
		HashMap map;
		
		for (map = new HashMap(); i < input.length; i += 2) {
			
		}
		
	}
	

}
