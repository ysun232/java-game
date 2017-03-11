import java.util.Random;
public class Dice {
	// Instance Variable
		private int die1;
		private int die2;

		public Dice ()
		{
			die1 = 0;
			die2 = 0;
		}

		/**
		 * Simulates the rolling of 2 die by generating 2 random numbers
		 * between 1 and 6 inclusive.
		 * @return Sum of the 2 die
		 */	
		public int rollDice()
		{
			Random randomGenerator = new Random();
			die1 = randomGenerator.nextInt(6) + 1;
			die2 = randomGenerator.nextInt(6) + 1;
			return die1 + die2;
		}
		
		/** 
		 *Returns a string representation of the object. 
		 */
		public String toString()
		{
			return "You rolled a "+ die1 + " and a " + die2 + ".";
		}


}
