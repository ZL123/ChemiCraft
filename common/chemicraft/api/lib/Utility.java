package chemicraft.api.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class Utility {
	
	public static boolean isAirBlock(World aWorld, int aX, int aY, int aZ) {
		Block tID = aWorld.getBlock(aX, aY, aZ);
		if (tID != Blocks.air) {
			return tID.isAir(aWorld, aX, aY, aZ);
		}
		return true;
	}
	
	public static byte getOppositeSide(int aSide) {
		return (byte)ForgeDirection.getOrientation(aSide).getOpposite().ordinal();
	}
	
	public static int findNextEmptySlot(Object[] array) {
		for(int i = 0; i < array.length; i++) {
			if (array[i] == null) {
				return i;
			}
		}
		return -1;
	}
	
}
