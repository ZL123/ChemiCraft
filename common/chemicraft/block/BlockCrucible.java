package chemicraft.block;

import java.util.List;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import chemicraft.inventory.tileentity.TileEntitySmallCrucible;
import chemicraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCrucible extends BlockContainer {
	
	@SideOnly(Side.CLIENT)
	protected IIcon iconClay, iconGraphite, iconAlumina, iconMagnesia, iconZirconia,
			iconMolybdenum, iconTungsten;
	
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
		iconClay = register.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_clay_small_overlay");
        iconGraphite = register.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_graphite_small_overlay");
        iconAlumina = register.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_alumina_small_overlay");
        iconMagnesia = register.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_magnesia_small_overlay");
        iconZirconia = register.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_zirconia_small_overlay");
        iconMolybdenum = register.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_molybdenum_small_overlay");
        iconTungsten = register.registerIcon(Reference.MOD_ID + ":" + getTextureName() + "_tungsten_small_overlay");
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int side, int meta) {
		switch(meta) {
			case clayMetaNumber: return iconClay;
			case graphiteMetaNumber: return iconGraphite;
			case aluminaMetaNumber: return iconAlumina;
			case magnesiaMetaNumber: return iconMagnesia;
			case zirconiaMetaNumber: return iconZirconia;
			case tungstenMetaNumber: return iconTungsten;
			default: return iconAlumina;
		}
	}
	
	@Override
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
	
	@Override
	public int damageDropped(int meta) {
		return meta;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tabs, List list)
	{
		for(int i = 0; i < crucibleMaterials.length; i++)
		{
			list.add(new ItemStack(item, 1, i));
		}
	}

}
