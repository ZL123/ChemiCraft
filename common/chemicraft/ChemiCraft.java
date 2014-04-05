package chemicraft;

import net.minecraft.creativetab.CreativeTabs;
import chemicraft.block.CCBlocks;
import chemicraft.inventory.CreativeTabCCBlocks;
import chemicraft.lib.Reference;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ChemiCraft {
	
	@Instance(Reference.MOD_ID)
	public static ChemiCraft instance;
	
	public static CreativeTabs tabChemiCraftBlocks = new CreativeTabCCBlocks("chemiCraft_blocks");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		CCBlocks.blockRegister();
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
}
