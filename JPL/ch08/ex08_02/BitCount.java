package ex08_02;

public class BitCount {
	public static int count(int n){
		int c = 0;
		for(int j = 0; j < Integer.SIZE; j++){
			c += (n & 1);
			n = n >>> 1;
		}
		return c;
	}

	public static void main(String[] args) {
		System.out.println(BitCount.count(10));
	}
}
