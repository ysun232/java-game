
public class Periokis extends Racer{
	
	/**
	 * Initializes the child class periokis which takes in a string to set the name as p_ and the name.
	 * @param x
	 */
	public Periokis(String x){
		super.setPosition(0);
		super.setEnergyLevel(130);
		super.setName("p_" + x);
	}
	
	/**
	 * Method to reset the energy level and also position of racers after one run of the game.
	 */
	public void reset(){
		super.setEnergyLevel(130);
		super.setPosition(0);
	}
}
