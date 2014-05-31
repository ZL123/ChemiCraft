package chemicraft.api.lib;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class Utility {
	
	public static boolean debugMode = false;
	
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
/*	
	/**
	 * Finds a continuous path of particular blocks from an origin to a destination.
	 * 
	 * @param world The world
	 * @param originX X position of origin
	 * @param originY Y position of origin
	 * @param originZ Z position of origin
	 * @param destX X position of destination
	 * @param destY Y position of destination
	 * @param destZ You should be able to guess by now
	 * @param passableBlocks Blocks that the path is allowed to go through
	 * @return <b>true</b> if successful
	 *
	 /
	public static boolean findContinuousPath(World world, int originX, int originY, int originZ,
			int destX, int destY, int destZ, Block... passableBlocks) {
		
		//True if it has yet to find a possible route to the destination
		boolean hasToMove;
		
		//+x, +y, +z, -x, -y, -z
		
		int currentX = originX;
		int currentY = originY;
		int currentZ = originZ;
		
		if (currentX == destX && currentY == destY && currentZ == destZ) {
			return true;
		} else {
			hasToMove = true;
			
			while(hasToMove) {
				boolean goPositiveX = originX < destX ? true : false;
				boolean goPositiveY = originY < destY ? true : false;
				boolean goPositiveZ = originZ < destZ ? true : false;
				
				//Stores which direction the destination is in relative to the current position
				int[] destDirection = new int[3];
				destDirection[0] = goPositiveX ? 0 : 3;
				destDirection[1] = goPositiveY ? 1 : 4;
				destDirection[2] = goPositiveZ ? 2 : 5;
				
				while(currentX < destX) {
					
				}	
			}
		}
		return false;
	}
	*/
	
	/**
	 * Turns relative co-ords into absolute ones.
	 * 
	 * @param xPos X co-ordinate of anchor
	 * @param yPos Y co-ordinate of anchor
	 * @param zPos Z co-ordinate of anchor
	 * @param xOffset Relative X co-ordinate
	 * @param yOffset Relative Y co-ordinate
	 * @param zOffset You should be able to guess by now
	 * @return Absolute co-ordinates [x,y,z]
	 */
	public int[] convertToAbsolute(int xPos, int yPos, int zPos, int xOffset, int yOffset, int zOffset) {		
		int[] absolute = new int[3];
		absolute[0] = xPos + xOffset;
		absolute[1] = yPos + yOffset;
		absolute[2] = zPos + zOffset;
		return absolute;
	}
	
}
