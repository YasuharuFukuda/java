package ch14.ex14_06;

public class Main {
	public static void main(String[] args) {
		Runnable mt = new MessageThread();
		Runnable tt = new TimeThread((MessageThread)mt);
		new Thread(mt).start();
		new Thread(tt).start();
	}
}
