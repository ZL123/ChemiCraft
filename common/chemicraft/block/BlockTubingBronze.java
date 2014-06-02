package chemicraft.block;

import chemicraft.tileentity.TileEntityTubing;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockTubingBronze extends BaseBlockTubing {

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityTubing();
	}

}
