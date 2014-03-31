package chemicraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOreCC extends Block {

	public BlockOreCC(float hardness, float resist) {
		super(Material.rock);
		this.setHardness(hardness); //Default hardness is DEF_ORE_HARDNESS in Reference class
		this.setResistance(resist); //Default resistance is DEF_ORE_RESIST in Reference class
	}
	
	@Override
	public int damageDropped(int par1) {
		return par1;
	}
	
	@SideOnly(Side.CLIENT)
	protected IIcon icons;

}
