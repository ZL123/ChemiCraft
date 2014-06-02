package chemicraft.tileentity;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntitySmallCrucible extends TileEntity {
	
	private ItemStack[] crucibleItems;

    public TileEntitySmallCrucible() {}

    public TileEntitySmallCrucible(ItemStack[] items) {
        this.crucibleItems = items;
    }

    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        int i;
        for(i = 0; i < crucibleItems.length; i++) {
        	compound.setInteger("Item" + i, Item.getIdFromItem(this.crucibleItems[i].getItem()));
        }
    }

    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        int i;
        for(i = 0; i < crucibleItems.length; i++) {
        	this.crucibleItems[i] = new ItemStack(Item.getItemById(compound.getInteger("Item" + i)));
        }
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.writeToNBT(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 5, nbttagcompound);
    }

    public void setAllCrucibleItems(ItemStack[] items) {
        this.crucibleItems = items;
    }
    
    /**
     * Adds a stack to the first empty slot in the crucible.
     */
    public void addCrucibleItem(ItemStack stack) {
    	for (int i = 0; i <= crucibleItems.length; i++) {
        	if (this.crucibleItems[i] == null) {
        		this.crucibleItems[i] = stack;
        	}
    	}
    }
    
    /**
     * Sets the item at specific index to a specified stack.
     * @param stack The ItemStack to be set.
     * @param index The slot at which the ItemStack is to be set.
     * @param flag How the method handles the stacks;
     *        Flag 1 only sets the stack if the slot is empty.
     *        Flag 2 doesn't care.
     *        Flag 3 only sets the stack if the slot is taken. (jerk)
     * @return If the item was set successfully.
     */
    public boolean setCrucibleItemAtIndex(ItemStack stack, int index, int flag) {
    	if (flag < 1) return false;
    	
    	boolean yayItPassed = false;
    	
    	if (flag == 1 && this.crucibleItems[index] == null) {
    		yayItPassed = true;
    	}
    	if (flag == 2) {
    		yayItPassed = true;
    	}
    	if (flag == 3 && this.crucibleItems[index] != null) {
    		yayItPassed = true;
    	}
    	
    	if (yayItPassed) {
    		this.crucibleItems[index] = stack;
    		return true;
    	}
    	
    	return false;
    }
    
    /**
     * Sets the item at specific index to nada.
     * @param index
     * @return If the item was removed successfully.
     */
    public boolean removeCrucibleItemAtIndex(int index) {
    	if (this.crucibleItems[index] != null) {
    		this.crucibleItems[index] = null;
    		return true;
    	}
    	return false;
    }

    public ItemStack[] getCrucibleItems() {
        return this.crucibleItems;
    }
	
}
