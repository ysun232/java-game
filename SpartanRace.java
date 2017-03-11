import java.util.Scanner;	// for keyboard input
public class SpartanRace {
	public static void main(String[] args) {
		// Constants
		final int anotherGame = 1;
		boolean gameOver=false;

		// Variable declaration
		Racer [] player;
		Dice dice = new Dice();
		DeckOfFortune oneCard = new DeckOfFortune();
		WheelOfFortune wheel = new WheelOfFortune();
		RaceTrack board = new RaceTrack();
		Scanner keyIn = new Scanner(System.in);
		int whoseTurn = 0, numOfWinners, play;
		boolean testMode;

		//Welcome message
		System.out.println(" Spartan Race - Version 1.0\n-----------------------------------\n");
		do{
			player = setUpRacers(keyIn);
			
			// Regular or test mode?
			System.out.print("\nTest Mode? (Enter 1 for test mode): ");
			testMode = (keyIn.nextInt() == 1);
			

			//And the race is on!!!
			System.out.println( "\nWelcome racers ... how many of you will be sold as slaves today ....hahaha.\n" +
					"Ready ...  Set  ... Go!");
			do
			{
				board.resetTrack(); // set count of each location back to 0
				
				for(int k=0;k<player.length;k++){
					player[k].setEliminated();
					player[k].reset();
				}
				gameOver=false;//set the boolean game over as false after starting a new game.
				// Each racer moves
				for(int i = 0; i < player.length; i++)
				{
					if(player[i].isEliminated())//determine whether a player is eliminated or not
						System.out.println("You are eliminated, skip your turn");
					else{
					do
					{
						System.out.print("\nPlayer " + player[i].getName()+ "  - Enter a " + (i+1)+" to roll the dice ");
						whoseTurn = keyIn.nextInt();
						
					}while (whoseTurn != (i+1));
					

					if(testMode)
					{
						System.out.println("Which position does racer move to? ");
						int loc = keyIn.nextInt();
						player[i].setPosition(loc);
						System.out.println();
					}
					else
					{
						int roll = dice.rollDice();
						System.out.print(dice);
						player[i].advanceBy(roll);
					}
					System.out.print(" At location " + player[i].getPosition() + ". ");
					
					//Has racer landed on a special location?				
					switch(board.getCode(player[i].getPosition()))
					{
					case 'd':
						System.out.print("Picking a card of fortune. ");
						System.out.println("current card " +oneCard.getNextCard());
						int d= player[i].getPosition();
						player[i].setPosition(oneCard.pickCard(player[i].getPosition(), player[i]));
						player[i].increaseEnergyLevel(30);
						break;
					case 's':
						System.out.println("Moving to location 68. ");
						int s=player[i].getPosition();
						player[i].setPosition(68);
						break;
					case 'w':
						System.out.print("Spinning the wheel of fortune. ");
						int w=player[i].getPosition();
						player[i].setPosition(wheel.spinTheWheel(player[i].getPosition(), player[i]));
						player[i].decreaseEnergyLevel(w-player[i].getPosition());
						player[i].multiplyEnergyLevel();
						break;
					case '?':
						player[i].setPosition(cardOrWheel(player[i].getPosition(), oneCard, wheel, player[i]));
						break;
					default:
						System.out.println("Keep playing.");							
					}
					board.addPlayer(player[i].getPosition());
					System.out.print(" With: " + player[i].getEnergyLevel()+" energy. ");
					
					
					int counter=0;
					for(int o=0;o<player.length; o++){
						if(player[o].isEliminated())
							counter++;
							gameOver=false;
					}
					if(counter==player.length-1){
						winnersReport(1, player);
						gameOver=true;
						play=playAgain();
					}//determine if a racer is going to win because the other players ran out of energy
					
					}
				}
				if(gameOver==false)
				System.out.print(board);  // Dispay board
				
				//Any winners?
				numOfWinners = 0;
				for (int i = 0; i < player.length; i++)
					if (player[i].getPosition() >= 90)
						numOfWinners++;
				
				
			}while (numOfWinners == 0);
			
			
			// And the winner(s) is/are	
			winnersReport(numOfWinners, player);

			play = playAgain();  // Does the user want to play again?
		} while (play == anotherGame);
		
		// Closing message
		System.out.println("\n-->  Hope you enjoyed Version 1.0 of the Spartan Race game.  <--\n"); 
	}// end of main()


	// Static methods
	//---------------

	public static Racer[] setUpRacers(Scanner keyIn)
	{
		int numOfRacers;
		System.out.print("How many racers will there be (2 to 4)? ");

		// How many racers?
		do
		{
			numOfRacers = keyIn.nextInt();
			if (numOfRacers < 2 || numOfRacers > 4)
				System.out.print("\t"+numOfRacers + " racer(s) is not possible. The track can accommodate 2 to 4 players only.\n" +
						"So how many racers? ");
		} while (numOfRacers < 2 || numOfRacers > 4);

		// Get name of players and create Racer objects
		// Makes the players choose which faction they belong to
		Racer [] player = new Racer[numOfRacers];
		for (int i = 0; i < numOfRacers; i++)
		{
			System.out.print("Name of Racer #" + (i +1) + " please: ");
			String name2=keyIn.next();
			System.out.println("Are you a true Spartiate, an Helot or Perioikis? ");
			System.out.println("Please enter s for Spartiate, h for Helot or p for Perioikis");
			String hero=keyIn.next();//determine which faction each player belong to
			if(hero.equalsIgnoreCase("s")){
				player[i]=new Spartiate(name2);
			}
			if(hero.equalsIgnoreCase("h")){
				player[i]=new Helots(name2);
			}
			if(hero.equalsIgnoreCase("p")){
				player[i]=new Periokis(name2);
			}
		}
		return player;
	} // method setUpRacers

	public static int cardOrWheel(int location, DeckOfFortune d, WheelOfFortune w, Racer x)
	{
		Scanner keyIn = new Scanner(System.in);
		int choice;
		do
		{
			System.out.print("Enter 1 to spin the wheel or 2 to pick a card: ");
			choice = keyIn.nextInt();
		}while (choice != 1 && choice != 2);

		if (choice == 1)
			return w.spinTheWheel(location, x);
		return d.pickCard(location,x);
	}// method cardOrWheel

	public static void winnersReport(int n, Racer[] p)
	{
		System.out.println("\n\nWe have " + n + (n > 1? " winners!":" winner!")+
				"\nCongratulations to:");
		
		
		for (int i = 0; i < p.length; i++)
			if(p[i].getPosition() >= 89 || p[i].isEliminated()==false)
				System.out.println("\t" + p[i].getName());
		System.out.println(	"\nThe rest of you will be sold as slaves!\n");	
	} //method winnersReport
	
	public static int playAgain()
	{
		Scanner keyIn = new Scanner(System.in);
		System.out.print("Would you like to play again? (1 for yes) ");
		int again = keyIn.nextInt();
		return again;
	}// method playAgain

}// class SpartanRace