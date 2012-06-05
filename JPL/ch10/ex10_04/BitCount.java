package ch10.ex10_04;

//ch09.ex09_02をwhileで修正

public class BitCount {
	public static int count(int n){
		int c = 0;
		int a = 0;
		while(a < Integer.SIZE){
			c += (n & 1);
			n = n >>> 1;
			a++;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(BitCount.count(10));
	}
}
