package ch03.ex03_06;

public class Battery extends EnergySource{
	private int batteryCharge = 0;

	public Battery(int charge) {
		this.batteryCharge = charge;
	}

	boolean empty(){
		if(batteryCharge > 0)
			return false;
		else
			return true;
	}

}
