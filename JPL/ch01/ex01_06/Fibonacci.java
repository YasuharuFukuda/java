package ch01.ex01_06;

public class Fibonacci {

	private static final String TITLE = "フィボナッチ数列";
	private static final String ITEM = "第";
	private static final String COLON = ":";

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		int count = 1;
		System.out.println(TITLE);
		System.out.println(ITEM + count + COLON + hi);

		while(hi < 50) {
			count++;
			System.out.println(ITEM + count + COLON + hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}

}
