package ex01_10;

public class ImprovedFibonacci {
	static final int MAX_INDEX = 9;
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;

		FibonacciData[] results = new FibonacciData[10];

		results[0] = new FibonacciData(hi);

		for(int i = 1; i <= MAX_INDEX; i++){
			if (hi % 2 == 0)
				results[i] = new FibonacciData(hi);
			else
				results[i] = new FibonacciData(hi);
			hi = lo + hi;
			lo = hi - lo;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println("values: " + results[i].getValue() + " 偶数？:" + results[i].isEven());
		}
	}
}


class FibonacciData {
	private int value;
	private boolean even;

	FibonacciData(int value) {
		this.value = value;
		if (value % 2 == 0)
			this.even = true;
		else
			this.even = false;
	}

	public int getValue() {
		return value;
	}

	public boolean isEven() {
		return even;
	}
}