package chemicraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityChemistWorktable extends TileEntity implements IInventory {
	
	private String customInventoryName;
    private ItemStack[] worktableStacks = new ItemStack[10];
	
    @Override
	public String getInventoryName() {
        return this.hasCustomInventoryName() ? this.customInventoryName : "container.chemist_worktable";
    }
	
	public void setInventoryName(String name) {
        customInventoryName = name;
    }
	
	@Override
	public boolean hasCustomInventoryName() {
        return this.customInventoryName != null && this.customInventoryName.length() > 0;
    }
	
	@Override
	public int getSizeInventory() {
		return this.worktableStacks.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return isValidSlot(slot) ? this.worktableStacks[slot] : null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (isValidSlot(slot)) {
            ItemStack stack = this.worktableStacks[slot];
            this.worktableStacks[slot] = null;
            return stack;
        }
        return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (isValidSlot(slot)) {
            ItemStack stack = this.worktableStacks[slot];
            this.worktableStacks[slot] = null;
            return stack;
        }
        return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		if (isValidSlot(slot)) {
            this.worktableStacks[slot] = stack;
        }
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false :
			player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return false;
	}
	
	protected boolean isValidSlot(int slot) {
		return slot >= 0 && slot < this.worktableStacks.length;
	}
	
}
