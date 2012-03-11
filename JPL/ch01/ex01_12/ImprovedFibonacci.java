package ex01_12;

public class ImprovedFibonacci {
	static final int MIN_INDEX = 1;
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		String mark;

		System.out.println("9: " + lo);

		for(int i = 8; i >= MIN_INDEX; i--){
			String result = "";
			if (hi % 2 == 0)
				mark = "*";
			else
				mark = "";
			result += i;
			result += " :";
			result += hi;
			result += mark;
			System.out.println(result);
			hi = lo + hi;
			lo = hi - lo;
		}
	}
}
