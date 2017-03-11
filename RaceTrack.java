
public class RaceTrack {
	private char [] track = new char[91];
	private int [] howMany = new int[91];
	
	//Constructor
	public RaceTrack()
	{
		track[10]= track[30] = track[50] = track[70] = 'd';
		track[20] = track[55] ='s' ;
		track[40] = track[60] = track[80] = 'w' ;
		track[17] = track[37] =  track[57] ='?' ;
	}
	
	/**
	 * Increments the count of players on a specific location. If the location is
	 * past the end of the board, the last location counter is incremented.
	 * @return	location for which to increment counter
	 */
	public void addPlayer(int loc)
	{
		if (loc >=90)
			howMany[90]++;
		else
			howMany[loc]++;
	}
	
	/**
	 * Resets the count of players at each location to back to zero
	 */
	public void resetTrack()
	{
		howMany = new int[91];
	}
	
	/** 
	 * Determines if the given location is a special location, that is one where the
	 * players spins the wheel, picks a card of fortune, moves directly to a specific
	 * location
	 * @param	loc	location on board to evaluate
	 * @return	track[loc] the character code for the location passed
	 */
	public char getCode(int loc)
	{
		if (loc > 90)
			return ' ';
		return track[loc];
	}
	
	/**
	 * Returns a string representation of the object.
	 * @return	
	 */
	public String toString()
	{
		String board = "\n";
		for(int i = 0; i < 3; i++)
		{
			for (int j = 1; j <= 30; j++)
				board += ((howMany[30 * i + j]== 0? "_":howMany[30 * i + j])+ " ");
			board += "\n";
			//for (int j = 1; j <= 30; j++)
			//	board += "- ";
			//board += "\n";
			for (int j = 1; j <= 30; j++)
				board += (track[30 * i + j] + " ");
			board += "\n\n";
		}
		return board;
	}// toString()


}
