package chemicraft.tileentity.render;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;

import org.lwjgl.opengl.GL11;

import chemicraft.block.CCBlocks;
import chemicraft.lib.Reference;
import chemicraft.tileentity.TileEntityTubing;

public class RenderTileEntityTubing extends TileEntitySpecialRenderer {

	final ResourceLocation textureBronze = new ResourceLocation(Reference.MOD_ID, "textures/blocks/pipe_energy_bronze.png");
	final ResourceLocation textureCopper = new ResourceLocation(Reference.MOD_ID, "textures/blocks/pipe_energy_copper.png");
	final ResourceLocation textureGold = new ResourceLocation(Reference.MOD_ID, "textures/blocks/pipe_energy_gold.png");
	final ResourceLocation textureSilver = new ResourceLocation(Reference.MOD_ID, "textures/blocks/pipe_energy_silver.png");
	final ResourceLocation textureAluminium = new ResourceLocation(Reference.MOD_ID, "textures/blocks/pipe_energy_aluminium.png");
	ResourceLocation thisTexture;
	
	final float pixel = 1.0F/16.0F;
	
	@Override
	public void renderTileEntityAt(TileEntity tent /*teehee*/, double translationX, double translationY, double translationZ, float f) {		
		if(tent.blockType == CCBlocks.blockTubingBronze) thisTexture = textureBronze;
		else if(tent.blockType == CCBlocks.blockTubingCopper) thisTexture = textureCopper;
		else if(tent.blockType == CCBlocks.blockTubingGold) thisTexture = textureGold;
		else if(tent.blockType == CCBlocks.blockTubingSilver) thisTexture = textureSilver;
		else if(tent.blockType == CCBlocks.blockTubingAluminium) thisTexture = textureAluminium;
		
		GL11.glTranslated(translationX, translationY, translationZ);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.bindTexture(thisTexture);
		drawAnchor();
		
		TileEntityTubing tube = (TileEntityTubing) tent;
		for(int i = 0; i < tube.tubeConnections.length; i++) {
			if(tube.tubeConnections[i] != null) drawConnector(tube.tubeConnections[i]);
		}
		
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glTranslated(-translationX, -translationY, -translationZ);
		
	}
	
	public void drawAnchor() {
		Tessellator tsltr = Tessellator.instance;
		tsltr.startDrawingQuads();
		
		tsltr.addVertexWithUV(1-5.5*pixel, 5.5*pixel, 1-5.5*pixel, 10*pixel, 10*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1-5.5*pixel, 1-5.5*pixel, 10*pixel, 6*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1-5.5*pixel, 1-5.5*pixel, 6*pixel, 6*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 5.5*pixel, 1-5.5*pixel, 6*pixel, 10*pixel);
		
		tsltr.addVertexWithUV(1-5.5*pixel, 5.5*pixel, 5.5*pixel, 10*pixel, 10*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1-5.5*pixel, 5.5*pixel, 10*pixel, 6*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1-5.5*pixel, 1-5.5*pixel, 6*pixel, 6*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 5.5*pixel, 1-5.5*pixel, 6*pixel, 10*pixel);
		
		tsltr.addVertexWithUV(5.5*pixel, 5.5*pixel, 5.5*pixel, 10*pixel, 10*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1-5.5*pixel, 5.5*pixel, 10*pixel, 6*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1-5.5*pixel, 5.5*pixel, 6*pixel, 6*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 5.5*pixel, 5.5*pixel, 6*pixel, 10*pixel);

		tsltr.addVertexWithUV(5.5*pixel, 5.5*pixel, 1-5.5*pixel, 10*pixel, 10*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1-5.5*pixel, 1-5.5*pixel, 10*pixel, 6*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1-5.5*pixel, 5.5*pixel, 6*pixel, 6*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 5.5*pixel, 5.5*pixel, 6*pixel, 10*pixel);
		//top
		tsltr.addVertexWithUV(1-5.5*pixel, 1-5.5*pixel, 1-5.5*pixel, 10*pixel, 10*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1-5.5*pixel, 5.5*pixel, 10*pixel, 6*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1-5.5*pixel, 5.5*pixel, 6*pixel, 6*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1-5.5*pixel, 1-5.5*pixel, 6*pixel, 10*pixel);
		//bottom
		tsltr.addVertexWithUV(5.5*pixel, 5.5*pixel, 1-5.5*pixel, 10*pixel, 10*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 5.5*pixel, 5.5*pixel, 10*pixel, 6*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 5.5*pixel, 5.5*pixel, 6*pixel, 6*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 5.5*pixel, 1-5.5*pixel, 6*pixel, 10*pixel);
		
		tsltr.draw();
	}

	public void drawConnector(ForgeDirection direction) {
		Tessellator tsltr = Tessellator.instance;
		tsltr.startDrawingQuads();
		
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		if(direction.equals(ForgeDirection.UP)) {
			
		}
		else if(direction.equals(ForgeDirection.DOWN)) {
			GL11.glRotatef(180.0F, 1.0F, 0.0F, 0.0F);
		}
		else if(direction.equals(ForgeDirection.SOUTH)) {
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		}
		else if(direction.equals(ForgeDirection.NORTH)) {
			GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
		}
		else if(direction.equals(ForgeDirection.WEST)) {
			GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		}
		else if(direction.equals(ForgeDirection.EAST)) {
			GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
		}
		
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		
		tsltr.addVertexWithUV(1-5.5*pixel, 1-5.5*pixel, 1-5.5*pixel, 10*pixel, 10*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1, 1-5.5*pixel, 14*pixel, 10*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1, 1-5.5*pixel, 14*pixel, 6*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1-5.5*pixel, 1-5.5*pixel, 10*pixel, 6*pixel);

		tsltr.addVertexWithUV(5.5*pixel, 1-5.5*pixel, 5.5*pixel, 10*pixel, 10*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1, 5.5*pixel, 14*pixel, 10*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1, 5.5*pixel, 14*pixel, 6*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1-5.5*pixel, 5.5*pixel, 10*pixel, 6*pixel);
		
		tsltr.addVertexWithUV(1-5.5*pixel, 1-5.5*pixel, 5.5*pixel, 10*pixel, 10*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1, 5.5*pixel, 14*pixel, 10*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1, 1-5.5*pixel, 14*pixel, 6*pixel);
		tsltr.addVertexWithUV(1-5.5*pixel, 1-5.5*pixel, 1-5.5*pixel, 10*pixel, 6*pixel);

		tsltr.addVertexWithUV(5.5*pixel, 1-5.5*pixel, 1-5.5*pixel, 10*pixel, 10*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1, 1-5.5*pixel, 14*pixel, 10*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1, 5.5*pixel, 14*pixel, 6*pixel);
		tsltr.addVertexWithUV(5.5*pixel, 1-5.5*pixel, 5.5*pixel, 10*pixel, 6*pixel);
		
		tsltr.draw();
		
		GL11.glTranslatef(0.5F, 0.5F, 0.5F);
		if(direction.equals(ForgeDirection.UP)) {
			
		}
		else if(direction.equals(ForgeDirection.DOWN)) {
			GL11.glRotatef(-180.0F, 1.0F, 0.0F, 0.0F);
		}
		else if(direction.equals(ForgeDirection.SOUTH)) {
			GL11.glRotatef(-90.0F, 1.0F, 0.0F, 0.0F);
		}
		else if(direction.equals(ForgeDirection.NORTH)) {
			GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
		}
		else if(direction.equals(ForgeDirection.WEST)) {
			GL11.glRotatef(-90.0F, 0.0F, 0.0F, 1.0F);
		}
		else if(direction.equals(ForgeDirection.EAST)) {
			GL11.glRotatef(90.0F, 0.0F, 0.0F, 1.0F);
		}
		GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
		
		
	}

}
