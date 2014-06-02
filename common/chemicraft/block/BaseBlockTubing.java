package chemicraft.block;

import chemicraft.ChemiCraft;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public abstract class BaseBlockTubing extends BlockContainer {
	
	final float pixel = 1.0F/16.0F;
	
	public BaseBlockTubing() {
		super(Material.iron);
		this.setCreativeTab(ChemiCraft.tabChemiCraftBlocks);
		this.useNeighborBrightness = true;
		this.setHardness(30.0F);
		this.setResistance(10.0F);
		
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		float minX, minY, minZ, maxX, maxY, maxZ;
		minX = minY = minZ = 5.5F*pixel;
		maxX = maxY = maxZ = 1-5.5F*pixel;
		if(world.getBlock(x-1, y, z) instanceof BaseBlockTubing) minX = 0.0F;
		if(world.getBlock(x, y-1, z) instanceof BaseBlockTubing) minY = 0.0F;
		if(world.getBlock(x, y, z-1) instanceof BaseBlockTubing) minZ = 0.0F;
		if(world.getBlock(x+1, y, z) instanceof BaseBlockTubing) maxX = 1.0F;
		if(world.getBlock(x, y+1, z) instanceof BaseBlockTubing) maxY = 1.0F;
		if(world.getBlock(x, y, z+1) instanceof BaseBlockTubing) maxZ = 1.0F;
		
		this.setBlockBounds(minX, minY, minZ, maxX, maxY, maxZ);
		
	}
	
}
