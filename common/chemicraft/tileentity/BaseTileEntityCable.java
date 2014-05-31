package chemicraft.tileentity;

import net.minecraft.tileentity.TileEntity;
import chemicraft.energy.ICable;
import chemicraft.energy.IEnergyConsumer;
import chemicraft.energy.IEnergyProducer;

public abstract class BaseTileEntityCable extends TileEntity implements ICable {
	
	public float currentPower;
	public int[][] knownProducers;
	
	@Override
	public void spreadPowerProducers() {
		int[] interests = findAndMarkPOIs();
		int[] posX, posY, posZ, negX, negY, negZ;
		
		if(interests[0] != 0) {
			posX = convertAndSeparate(interests, 0);
			
			if(interests[0] == 2) {
				addToProducersList(posX);
			}
		}
		if(interests[1] != 0) {
			posY = convertAndSeparate(interests, 1);
			
			if(interests[1] == 2) {
				addToProducersList(posY);
			}
		}
		if(interests[2] != 0) {
			posZ = convertAndSeparate(interests, 2);
			
			if(interests[2] == 2) {
				addToProducersList(posZ);
			}
		}
		if(interests[3] != 0) {
			negX = convertAndSeparate(interests, 3);
			
			if(interests[3] == 2) {
				addToProducersList(negX);
			}
		}
		if(interests[4] != 0) {
			negY = convertAndSeparate(interests, 4);
			
			if(interests[4] == 2) {
				addToProducersList(negY);
			}
		}
		if(interests[5] != 0) {
			negZ = convertAndSeparate(interests, 5);
			
			if(intersts[5] == 2) {
				addToProducersList(negZ);
			}
		}
		
		
		
	}
	
	@Override
	public int[] findAndMarkPOIs() {
		/*	+x, +y, +z, -x, -y, -z
		  	0 = not very interestable
		  	1 = cable
		  	2 = producer
		  	3 = consumer
		*/
		int[] interests = {0,0,0,0,0,0};
		
		if(worldObj.getTileEntity(xCoord+1, yCoord, zCoord) instanceof ICable) {
			interests[0] = 1;
		} else if(worldObj.getTileEntity(xCoord+1, yCoord, zCoord) instanceof IEnergyProducer) {
			interests[0] = 2;
		} else if(worldObj.getTileEntity(xCoord+1, yCoord, zCoord) instanceof IEnergyConsumer) {
			interests[0] = 3;
		}
		
		if(worldObj.getTileEntity(xCoord, yCoord+1, zCoord) instanceof ICable) {
			interests[1] = 1;
		} else if(worldObj.getTileEntity(xCoord, yCoord+1, zCoord) instanceof IEnergyProducer) {
			interests[1] = 2;
		} else if(worldObj.getTileEntity(xCoord, yCoord+1, zCoord) instanceof IEnergyConsumer) {
			interests[1] = 3;
		}
		
		if(worldObj.getTileEntity(xCoord, yCoord, zCoord+1) instanceof ICable) {
			interests[2] = 1;
		} else if(worldObj.getTileEntity(xCoord, yCoord, zCoord+1) instanceof IEnergyProducer) {
			interests[2] = 2;
		} else if(worldObj.getTileEntity(xCoord, yCoord, zCoord+1) instanceof IEnergyConsumer) {
			interests[2] = 3;
		}
		
		if(worldObj.getTileEntity(xCoord-1, yCoord, zCoord) instanceof ICable) {
			interests[3] = 1;
		} else if(worldObj.getTileEntity(xCoord-1, yCoord, zCoord) instanceof IEnergyProducer) {
			interests[3] = 2;
		} else if(worldObj.getTileEntity(xCoord-1, yCoord, zCoord) instanceof IEnergyConsumer) {
			interests[3] = 3;
		}
		
		if(worldObj.getTileEntity(xCoord, yCoord-1, zCoord) instanceof ICable) {
			interests[4] = 1;
		} else if(worldObj.getTileEntity(xCoord, yCoord-1, zCoord) instanceof IEnergyProducer) {
			interests[4] = 2;
		} else if(worldObj.getTileEntity(xCoord, yCoord-1, zCoord) instanceof IEnergyConsumer) {
			interests[4] = 3;
		}
		
		if(worldObj.getTileEntity(xCoord, yCoord, zCoord-1) instanceof ICable) {
			interests[5] = 1;
		} else if(worldObj.getTileEntity(xCoord, yCoord, zCoord-1) instanceof IEnergyProducer) {
			interests[5] = 2;
		} else if(worldObj.getTileEntity(xCoord, yCoord, zCoord-1) instanceof IEnergyConsumer) {
			interests[5] = 3;
		}
		
		return interests;
	}
	
	/**
	 * Takes interests and an index to convert the relative co-ordinates at that index to absolute
	 * ones.
	 * 
	 * @param interests
	 * @param index
	 * @return
	 */
	public int[] convertAndSeparate(int[] interests, int index) {
		int[] coords = {xCoord, yCoord, zCoord};
		
		switch(index) {
		case 0: coords[0] += 1;
		case 1: coords[1] += 1;
		case 2: coords[2] += 1;
		case 3: coords[0] -= 1;
		case 4: coords[1] -= 1;
		case 5: coords[2] -= 1;
		}
		
		return coords;
		
	}
	
	
	@Override
	public void notifyAdjacentCables(int[] producerCoords) {
		
	}
	
	/**
	 * Adds the producer at the given co-ordinates to the list of connected CP producers.
	 * @param producerCoords Co-ordinates of producer
	 */
	public void addToProducersList(int[] producerCoords) {
		int kpLength = knownProducers.length;
		knownProducers[kpLength][0] = producerCoords[0];
		knownProducers[kpLength][1] = producerCoords[1];
		knownProducers[kpLength][2] = producerCoords[2];		
		
	}
	
}
