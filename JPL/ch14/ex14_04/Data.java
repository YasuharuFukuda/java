package ch14.ex14_04;

public class Data {
	private static int data = 0;
	private static Object lockA = new Object();

	public static int add(int a) {
		synchronized (Data.class) {
			data += a;
			System.out.println(data);
			return data;

		}
	}


}
