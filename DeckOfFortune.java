import java.util.Random;
public class DeckOfFortune {
private int nextCard;
	
	/** Default constructor
	 * 	Sets the top card to a number between 0 and 9
	 */
	public DeckOfFortune()
	{
		Random randomGenerator = new Random();
		nextCard = randomGenerator.nextInt(10);
	}
	
	/** Accessor method
	 * @return	nextCard 	the number of the next card
	 */
	public int getNextCard()
	{
		return nextCard+1;
	}
	
	public int pickCard(int location, Racer x)
	{
		switch(nextCard+1)
		{
		case 1: location -= 9;
			x.decreaseEnergyLevel(9);
			System.out.print("Go back 9. ");
			break;
		case 2: location = 0;
			int cheap= x.getPosition();
			x.setPosition(0);
			x.decreaseEnergyLevel(cheap);
			System.out.print("Go back to the beginning. ");
			break;
		case 3: location -= 3;
			x.decreaseEnergyLevel(3);
			System.out.print("Go back 3. ");
			break;
		case 4: location -= 8;
			x.decreaseEnergyLevel(8);
			System.out.print("Go back 8. ");
			break;
		case 5: location += 2;
			x.decreaseEnergyLevel(2);
			System.out.print("Go forward 2. ");
			break;
		case 6: location += 1;
			x.decreaseEnergyLevel(1);
			System.out.print("Go forward 1. ");
			break;
		case 7: location += 3;
			x.decreaseEnergyLevel(3);
			System.out.print("Go forward 3. ");
			break;
		case 8: location = 0;
			int cheaper= x.getPosition();
			x.setPosition(0);
			x.decreaseEnergyLevel(cheaper);
			System.out.print("Go back to the beginning. ");
			break;
		case 9: location -= 4;
			x.decreaseEnergyLevel(4);
			System.out.print("Go back 4. ");
			break;
		case 10: location += 6;
			x.decreaseEnergyLevel(6);
			System.out.print("Go forward 6. ");
			break;
		} // switch
		System.out.println("You are at location " + location);
		
		// Prepare for next turn
		nextCard = (++nextCard % 10);
		
		return location;	
	}


}
