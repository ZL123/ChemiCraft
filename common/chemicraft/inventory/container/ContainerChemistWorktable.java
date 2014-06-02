package chemicraft.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.world.World;
import chemicraft.block.CCBlocks;

public class ContainerChemistWorktable extends Container {
	
    public InventoryCrafting craftMatrix = new InventoryCrafting(this, 3, 3);
    public IInventory craftResult = new InventoryCraftResult();
    protected World worldObj;
    protected int posX;
    protected int posY;
    protected int posZ;
	
    public ContainerChemistWorktable(InventoryPlayer par1InventoryPlayer, World par2World, int x, int y, int z) {
        this.worldObj = par2World;
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        this.addSlotToContainer(new SlotCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 124, 35));
        int row;
        int col;
//																   slotIndex        
        for (row = 0; row < 3; ++row) {//										  xDisplayPosition
            for (col = 0; col < 3; ++col) {//													 yDisplayPosition
                this.addSlotToContainer(new Slot(this.craftMatrix, col + row * 3, 18 + col * 18, 17 + row * 18));
            }
        }

        for (row = 0; row < 3; ++row) {
            for (col = 0; col < 9; ++col) {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }
        
        for (row = 0; row < 9; ++row) {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, row, 8 + row * 18, 142));
        }

        this.onCraftMatrixChanged(this.craftMatrix);
    }
    
	@Override
	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
        return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != CCBlocks.blockChemistWorktable ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
    }
	
	/**
     * Called when the container is closed.
     */
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
        super.onContainerClosed(par1EntityPlayer);
        
        if (!this.worldObj.isRemote) {
            for (int i = 0; i < 9; ++i) {
                ItemStack stack = this.craftMatrix.getStackInSlotOnClosing(i);
                
                if (stack != null) {
                    par1EntityPlayer.dropPlayerItemWithRandomChoice(stack, false);
                }
            }
        }
    }
	
	/**
     * Callback for when the crafting matrix is changed.
     */
	@Override
    public void onCraftMatrixChanged(IInventory par1IInventory)
    {
        this.craftResult.setInventorySlotContents(0, CraftingManager.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
    }
	
	/**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
	@Override
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
		ItemStack stack = null;
        Slot slot = (Slot)this.inventorySlots.get(par2);

        if (slot != null && slot.getHasStack()) {
            ItemStack stack1 = slot.getStack();
            stack = stack1.copy();

            if (par2 == 0) {
                if (!this.mergeItemStack(stack1, 10, 46, true)) {
                    return null;
                }
                slot.onSlotChange(stack1, stack);
            }
            else if (par2 >= 10 && par2 < 37) {
                if (!this.mergeItemStack(stack1, 37, 46, false)) {
                    return null;
                }
            }
            else if (par2 >= 37 && par2 < 46) {
                if (!this.mergeItemStack(stack1, 10, 37, false)) {
                    return null;
                }
            }
            else if (!this.mergeItemStack(stack1, 10, 46, false)) {
                return null;
            }

            if (stack1.stackSize == 0) {
                slot.putStack((ItemStack)null);
            }
            else {
                slot.onSlotChanged();
            }

            if (stack1.stackSize == stack.stackSize) {
                return null;
            }

            slot.onPickupFromSlot(par1EntityPlayer, stack1);
        }

        return stack;
    }
    
}
