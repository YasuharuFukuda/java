package ch04.ex04_01;

public class Battery implements EnergySource{
	private int batteryCharge = 0;

	public Battery(int charge) {
		this.batteryCharge = charge;
	}

	public boolean empty(){
		if(batteryCharge > 0)
			return false;
		else
			return true;
	}

}
