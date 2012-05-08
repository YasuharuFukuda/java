package ex04_01;

public class GasTank implements EnergySource{
	private int gas = 0;

	public GasTank(int gas) {
		this.gas = gas;
	}

	public boolean empty()	{
		if(gas > 0)
			return false;
		else
			return true;
	}


}
