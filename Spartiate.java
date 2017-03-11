
public class Spartiate extends Racer {
	public Spartiate(String x){
		super.setPosition(20);
		super.setEnergyLevel(100);
		super.setName(x);
	}
	
	public void reset(){
		super.setEnergyLevel(100);
		super.setPosition(20);
	}
}
