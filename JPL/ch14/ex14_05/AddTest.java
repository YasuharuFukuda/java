package ch14.ex14_05;

public class AddTest  implements Runnable {

	public void run() {
		for(;;) {
			synchronized (Data.class) {
				Data.remove(10);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
		Runnable as1 = new AddTest();
		Runnable as2 = new AddTest();
		Runnable as3 = new AddTest();
		Runnable as4 = new AddTest();

		new Thread(as1).start();
		new Thread(as2).start();
		new Thread(as3).start();
		new Thread(as4).start();
	}
}
