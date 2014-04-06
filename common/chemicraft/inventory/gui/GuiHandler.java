package chemicraft.inventory.gui;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import chemicraft.block.BlockChemistWorktable;
import chemicraft.inventory.container.ContainerChemistWorktable;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		if (block instanceof BlockChemistWorktable) {
			return new ContainerChemistWorktable(player.inventory, world, x, y, z);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		Block block = world.getBlock(x, y, z);
		if (block instanceof BlockChemistWorktable) {
			return new GuiChemistWorktable(player.inventory, world, z, z, z);
		}
		return null;
	}
	

}
