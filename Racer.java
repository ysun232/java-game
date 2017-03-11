
public class Racer {
	//instance variables
	private String name;
	private int position;
	private int energyLevel;
	private boolean elimination=false;
	
	// Constructor
	public Racer()
	{}

	/** 
	 * Constructor
	 * @param name of player
	 */
	public Racer(String name)
	{
		this.name = name;
		position = 0;
		energyLevel=0;
	}
	/**
	 * Method to reset the position and energy level of the racer.
	 */
	public void reset(){
		position=0;
		energyLevel=0;
	}
	/**
	 * Mutator to set the name of the racer.
	 * @param x
	 */
	public void setName(String x){
		name=x;
	}
	
	/**
	 * Mutator method
	 * @param x
	 */
	public void setEnergyLevel(int x){
		energyLevel=x;
	}
	/**
	 * Method to increase the energy level by taking in an integer.
	 * @param x
	 */
	public void increaseEnergyLevel(int x){
		energyLevel+=x;
	}
	/**
	 * Method to decrease the energy level by taking in an integer.
	 * @param y
	 */
	public void decreaseEnergyLevel(int y){
		energyLevel-=y;
		if(energyLevel<=0)
			elimination=true;
	}
	/**
	 * Method to multiply the energy level by two.
	 * @return
	 */
	public int multiplyEnergyLevel(){
		return 2*energyLevel;
	}
	/**
	 * Accessor method
	 * @return
	 */
	public int getEnergyLevel(){
		return energyLevel;
	}

	/** 
	 * Accessor method
	 * @return	name	racer's name
	 */
	public String getName()
	{
		return name;
	}
	
	/** Accessor method
	 * @return	position of player
	 */
	public int getPosition()
	{
		return position;
	}
	
	/** 
	 * Mutator method
	 * @param 	n location to move racer to
	 */
	public void setPosition(int n)
	{
		position = n;
	}
	
	/**
	 * Move racer by specified number of positions
	 * @param n number of positions to move racer on the board (can be >0 or <0) 
	 */
	public void advanceBy(int n)
	{
		position += n;
		energyLevel-=n;
		if(energyLevel<=0)
			elimination=true;	
	}
	/**
	 * Accessor for the elimination boolean.
	 * @return
	 */
	public boolean isEliminated(){
		return elimination;
	}
	/**
	 * Mutator for eliminating a racer.
	 */
	public void setEliminated(){
		elimination=false;
	}

}
