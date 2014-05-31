package chemicraft.energy;

/**
 * A very cheaty shortcut to power connection. If there is a power producer next to the cable, it
 * adds it to a list of producers and notifies other cables and consumers next to this one.
 * 
 * @author ZL123
 */
public interface ICable {
	
	/**
	 * Spreads data around all connected cables so they know there is a CP emitter at certain co-ordinates.
	 * The method which calls all the other methods here (to be organized)!
	 */
	public void spreadPowerProducers();
	
	/**
	 * Locates and marks all tile entities that are instances of IPowerEmitter and ICable touching the cable
	 * @return Relative POIs.
	 */
	public int[] findAndMarkPOIs();
	
	/**
	 * Uses intel from above methods to tell cables about producers.
	 * 
	 * @param cableCoords Co-ordinates of the adjacent cable
	 * @param producerCoords Co-ordinates of the producer
	 * @return <b>true</b> if successful
	 */
	public boolean notifyAdjacentCable(int[] cableCoords, int[] producerCoords);
	
	/**
	 * Removes cables and producers from the list of known producers.
	 * 
	 * @param location The co-ordinates of the tile
	 * @return <b>true</b> if successful
	 */
	public boolean removePOIs(int[] location);
	
	/**
	 * Checks if a cable already has data about a producer.
	 */
	public boolean producerExists(int[] cableCoords, int[] producerCoords);
	
	/**
	 * Checks the producer list in a cable and sees if it has a set of co-ordinates.
	 * @param location Co-ordinates
	 * @return If successful, the index of the x co-ordinate; otherwise -1.
	 */
	public int findCoordsInProducerList(int[] location);
	
}
