package ex01_03;

public class Fibonacci {

	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;
		int count = 1;
		System.out.println("フィボナッチ数列");
		System.out.println("第" + count + ": " + hi);

		while(hi < 50) {
			count++;
			System.out.println("第" + count + ": " + hi);
			hi = lo + hi;
			lo = hi - lo;
		}
	}

}
