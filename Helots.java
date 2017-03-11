
public class Helots extends Racer {
	public Helots(){}
	/**
	 * initializes children class of Racer which takes in a string to set the player name with h_.
	 * @param x
	 */
	public Helots(String x){
		super.setPosition(40);
		super.setEnergyLevel(60);
		super.setName("h_"+ x);
		}
	
	/**
	 * Method to reset the energy and position when a new game is launched after one run.
	 */
	public void reset(){
		super.setEnergyLevel(60);
		super.setPosition(40);
	}
}
