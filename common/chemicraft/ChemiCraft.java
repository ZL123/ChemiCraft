package chemicraft;

import net.minecraft.creativetab.CreativeTabs;
import chemicraft.block.CCBlocks;
import chemicraft.inventory.CreativeTabCCBlocks;
import chemicraft.inventory.CreativeTabCCItems;
import chemicraft.inventory.gui.GuiHandler;
import chemicraft.item.CCItems;
import chemicraft.lib.CCRecipes;
import chemicraft.lib.Reference;
import chemicraft.misc.CommonProxy;
import chemicraft.tileentity.TileEntityChemistWorktable;
import chemicraft.tileentity.TileEntityTubing;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class ChemiCraft {
	
	@Instance(Reference.MOD_ID)
	public static ChemiCraft instance;
	
	@SidedProxy(clientSide="chemicraft.misc.ClientProxy", serverSide="chemicraft.misc.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs tabChemiCraftBlocks = new CreativeTabCCBlocks("chemiCraft_blocks");
	public static CreativeTabs tabChemiCraftItems = new CreativeTabCCItems("chemiCraft_items");
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		CCBlocks.blockRegister();
		CCItems.itemRegister();
		
	}
	
    @EventHandler
    public void init(FMLInitializationEvent event) {
    	
    	NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    	GameRegistry.registerTileEntity(TileEntityChemistWorktable.class, Reference.MOD_NAME + ":ChemistWorktable");
    	GameRegistry.registerTileEntity(TileEntityTubing.class, Reference.MOD_NAME + ":Tubing");
    	CCRecipes.recipes();
    	
    	proxy.renderThingsAndStuff();
    	
    	
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
    	
    }
    
}
