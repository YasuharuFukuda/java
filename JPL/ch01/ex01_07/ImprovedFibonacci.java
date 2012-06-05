package ch01.ex01_07;

public class ImprovedFibonacci {
	static final int MIN_INDEX = 1;
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		System.out.println("9: " + lo);

		for(int i = 8; i >= MIN_INDEX; i--){
			if (hi % 2 == 0)
				mark = "*";
			else
				mark = "";
			System.out.println(i + ": " + hi + mark);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
