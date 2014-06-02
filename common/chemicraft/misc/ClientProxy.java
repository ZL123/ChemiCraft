package chemicraft.misc;

import chemicraft.tileentity.TileEntityTubing;
import chemicraft.tileentity.render.RenderTileEntityTubing;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void renderThingsAndStuff() {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTubing.class, new RenderTileEntityTubing());
	}
	
}
