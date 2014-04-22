package chemicraft.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import chemicraft.inventory.tileentity.TileEntitySmallCrucible;
import chemicraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCrucible extends BlockContainer {
	
	public static final int clayMetaNumber = 0;
	public static final int graphiteMetaNumber = 1;
	public static final int aluminaMetaNumber = 2;  // Al2O3
	public static final int magnesiaMetaNumber = 3; // MgO
	public static final int zirconiaMetaNumber = 4; // ZrO2
	public static final int molybdenumMetaNumber = 5;
	public static final int tungstenMetaNumber = 6;
	
	public int crucibleIndex;
	public static final String[] crucibleMaterials = {"clay", "graphite", "alumina", "magnesia",
													  "zirconia", "molybdenum", "tungsten"};
	public boolean smallCrucible;
	
	public BlockCrucible() {
		super(Material.iron);
		this.setHardness(1.0F);
		this.setBlockTextureName("crucible");
	}
	
	@SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        this.blockIcon = register.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_" + crucibleMaterials[crucibleIndex] + "_small");
    }
	
	public void setBlockBoundsForItemRender() {
        float f = 0.375F;   //   3/8
        float f1 = 0.1875F; //  3/16
        
        this.setBlockBounds(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f, 0.5F + f1);
	}                       // 0.3125         0.3125      0.6875        0.6875
                            //  5/16           5/16        11/16        11/16
	@Override
	public boolean isOpaqueCube() {
        return false;
    }
	
	@Override
	public int getRenderType() {
        return 33;
    }
	
	@Override
	public boolean renderAsNormalBlock() {
        return false;
    }
	
	protected TileEntitySmallCrucible getCrucibleTile(World world, int x, int y, int z) {
        TileEntity tileentity = world.getTileEntity(x, y, z);
        return tileentity != null && tileentity instanceof TileEntitySmallCrucible ? (TileEntitySmallCrucible)tileentity : null;
    }
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitVecX, float hitVecY, float hitVecZ) {
        ItemStack stack = player.inventory.getCurrentItem();

        if (stack != null && stack.getItem() instanceof ItemBlock) {
            if (world.getBlockMetadata(x, y, z) != 0) {
                return false;
            } else {
                TileEntitySmallCrucible teCrucible = this.getCrucibleTile(world, x, y, z);

                if (teCrucible != null) {
                    teCrucible.addCrucibleItem(stack);
                    teCrucible.markDirty();
                    
                    if (!world.setBlockMetadataWithNotify(x, y, z, stack.getItemDamage(), 2)) {
                        world.markBlockForUpdate(x, y, z);
                    }

                    if (!player.capabilities.isCreativeMode && --stack.stackSize <= 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, (ItemStack)null);
                    }

                        return true;
                    }
                }
            }
        return false;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntitySmallCrucible();
	}
	
	public int getCrucibleIndex() {
		return crucibleIndex;
	}
	
	public void setCrucibleIndex(int index) {
		crucibleIndex = index;
	}

}
