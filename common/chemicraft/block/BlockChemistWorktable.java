package chemicraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import chemicraft.ChemiCraft;
import chemicraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockChemistWorktable extends Block {
	
	@SideOnly(Side.CLIENT)
    protected IIcon verticalTexture;
	
	public BlockChemistWorktable() {
		super(Material.iron);
		this.setCreativeTab(ChemiCraft.tabChemiCraftBlocks);
		this.setHardness(5.0F);
		this.setResistance(10.0F);
		this.setBlockName("chemistWorktable");
		this.setStepSound(Block.soundTypeMetal);
		this.setBlockTextureName(Reference.MOD_ID + ":chemist_worktable_");
		
	}
	
	/**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int p_149691_2_) {
        return side == 1 || side == 0 ? verticalTexture : this.blockIcon;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register) {
        this.blockIcon = register.registerIcon(this.getTextureName() + "h");
        this.verticalTexture = register.registerIcon(this.getTextureName() + "v");
    }
    
    /**
     * Called upon block activation (right click on the block.)
     */
    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) { 
    	if (player.isSneaking()) return false;
        player.openGui(ChemiCraft.instance, 1, world, x, y, z);
        return true;
    }

}
