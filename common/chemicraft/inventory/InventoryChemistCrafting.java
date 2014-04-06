package chemicraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryChemistCrafting implements IInventory {
	
	/** List of the stacks in the matrix */
    protected ItemStack[] stackList;
    /** The width of the crafting inventory */
    protected int inventoryWidth;
    /** Class containing the callbacks for the events on_GUIClosed and on_CraftMaxtrixChanged. */
    protected Container eventHandler;
    
    public InventoryChemistCrafting(Container container, int row, int column) {
    	int items = row * column;
        this.stackList = new ItemStack[items];
        this.eventHandler = container;
        this.inventoryWidth = row;
    }
    
    public int getSizeInventory()
    {
        return this.stackList.length;
    }

	@Override
	public ItemStack getStackInSlot(int par1) {
		return par1 < this.getSizeInventory() ? this.stackList[par1] : null; //I think this way is more optimistic than the default "return par1 >= this.getSizeInventory() ? null : this.stackList[par1];".
	}
	
	public ItemStack getStackInRowAndColumn(int row, int col)
    {
        if (row >= 0 && row < this.inventoryWidth)
        {
            int k = row + col * this.inventoryWidth;
            return this.getStackInSlot(k);
        }
        return null;
    }

	/**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items
     * and returns them in a new stack.
     */
	@Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        if (this.stackList[slot] != null)
        {
            ItemStack stack;

            if (this.stackList[slot].stackSize <= amount)
            {
                stack = this.stackList[slot];
                this.stackList[slot] = null;
                this.eventHandler.onCraftMatrixChanged(this);
                return stack;
            }
            else
            {
                stack = this.stackList[slot].splitStack(amount);

                if (this.stackList[slot].stackSize == 0)
                {
                    this.stackList[slot] = null;
                }

                this.eventHandler.onCraftMatrixChanged(this);
                return stack;
            }
        }
        else
        {
            return null;
        }
    }

	@Override
	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.stackList[par1] != null)
        {
            ItemStack itemstack = this.stackList[par1];
            this.stackList[par1] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		
		this.stackList[slot] = stack;
        this.eventHandler.onCraftMatrixChanged(this);
		
	}

	@Override
	public String getInventoryName() {
		return "container.chemist_worktable";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	public void markDirty() {}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) {
		return true;
	}

	public void openInventory() {}

	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int var1, ItemStack var2) {
		return true;
	}
	
}
