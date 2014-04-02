package chemicraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.IIcon;
import chemicraft.lib.CCLog;
import chemicraft.lib.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOreCC extends Block {
	
	/**
	 * The type of ore; determines what it drops.
	 * 
	 * 0 - Drops ore block;
	 * 1 - Drops ore item and cobblestone;
	 * 2 - Drops dusts/gems
	 */
	protected short oreType;
	
	/**
	 * How many drops the ore drops. Not applicable for ores of type 0, and ores of type 1 don't
	 * drop multiple cobblestone.
	 * 
	 * First value is minimum amount of drops.
	 * Second value is maximum amount of drops.
	 */
	protected int[] amountOfDrops = new int[2];
	
	/**
	 * Self-explanatory.
	 */
	protected boolean isAffectedByFortune;
	
	public BlockOreCC() {
		this(Reference.DEF_ORE_HARDNESS, Reference.DEF_ORE_RESIST, Reference.DEF_ORE_TYPE, Reference.DEF_ORE_DROP_AMOUNT, Reference.DEF_ORE_FORTUNE);
	}
	
	public BlockOreCC(float hardness, float resist, short type, int[] dropAmount, boolean affectedByFortune) {
		super(Material.rock);
		this.setHardness(hardness);
		this.setResistance(resist);
		this.setBlockName("CCOre");
		this.setStepSound(Block.soundTypePiston);
		this.setBlockTextureName(Reference.MOD_ID + ":ore/ore");
		this.setOreType(type);
		this.setDropAmount(dropAmount);
		
	}
	
	@Override
	public int damageDropped(int par1) {
		return par1;
	}
	
	@SideOnly(Side.CLIENT)
	protected IIcon icons;
	
	public int getOreType() {
		return this.oreType;
	}
	
	public void setOreType(short type) {
		this.oreType = type;
	}
	
	public int[] getDropAmount() {
		return this.amountOfDrops;
	}
	
	public void setDropAmount(int[] amount) {
		if(amount.length != 2) {
			CCLog.err.println("Someone tried to make an ore with an unacceptable dropAmount! Naughty.");
			return;
		} else {
		this.amountOfDrops = amount;
		}
	}
	
	public boolean getFortuneAffectedness() {
		return this.isAffectedByFortune;
	}
	
	public void setFortuneAffectedness(boolean mhm) {
		this.isAffectedByFortune = mhm;
	}
	
}
