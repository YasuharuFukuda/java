package ex01_09;

public class Fibonacci {
	static final int MAX_INDEX = 10;
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		int count = 1;
		int[] results = new int[9];

		results[0] = hi;

		while(hi < 50) {
			results[count] = hi;
//			System.out.println("第" + count + ": " + hi);
			hi = lo + hi;
			lo = hi - lo;
			count++;
		}

		for (int i = 0; i < results.length; i++) {
			System.out.println("第" + (i + 1) + ": " + results[i]);
		}


	}

}
