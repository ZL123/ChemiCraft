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
	 */
	public void notifyAdjacentCables(int[] producerCoords);
	
	public int[] removePOIs();
	
}
