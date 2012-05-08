package ex03_06;

public class GasTank extends EnergySource{
	private int gas = 0;

	public GasTank(int gas) {
		this.gas = gas;
	}

	boolean empty()	{
		if(gas > 0)
			return false;
		else
			return true;
	}


}
