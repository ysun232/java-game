
public class WheelOfFortune {
	public  int spinTheWheel(int location, Racer x)
	{
		switch((int) (Math.random()* 8 + 1))
		{
		case 1: location += 1;
		x.decreaseEnergyLevel(1);
		System.out.print("Go forward 1. ");
		break;
		case 2: location += 2;
		x.decreaseEnergyLevel(2);
		System.out.print("Go forward 2. ");
		break;
		case 3: location = 0;
		int cheap= x.getPosition();
		x.setPosition(0);
		x.decreaseEnergyLevel(cheap);
		System.out.print("Go back to the beginning. ");
		break;
		case 4 : location -=4;
		x.decreaseEnergyLevel(4);
		System.out.print("Go back 4. ");
		break;
		case 5 : location -=6;
		x.decreaseEnergyLevel(6);
		System.out.print("Go back 6. ");
		break;
		case 6 : location -=7;
		x.decreaseEnergyLevel(7);
		System.out.print("Go back 7. ");
		break;
		case 7 : location -=8;
		x.decreaseEnergyLevel(8);
		System.out.print("Go back 8. ");
		break;
		case 8 : location -=9;
		x.decreaseEnergyLevel(9);
		System.out.print("Go back 9. ");
		break;
		}// switch
		System.out.println("You are now at location " + location);
		return location;
	} // method spinTheWheel

}
