package ch14.ex14_03;

public class Data {
	private int data = 0;
	private Object lockA = new Object();

	public int add(int a) {
		synchronized (lockA) {
			data += a;
			System.out.println(data);
			return data;

		}
	}


}
