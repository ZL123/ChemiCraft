package chemicraft.energy;

public interface IEnergyConsumer {
	
	/**
	 * How much ChemiPower (CP) is requested. Set as -1 for 'as much as you can give me'.
	 * @param powerAmount
	 */
	public void requestPower(float powerAmount);
	
}
