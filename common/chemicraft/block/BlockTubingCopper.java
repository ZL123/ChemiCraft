package chemicraft.block;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import chemicraft.tileentity.TileEntityTubing;

public class BlockTubingCopper extends BaseBlockTubing {

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityTubing();
	}

}
