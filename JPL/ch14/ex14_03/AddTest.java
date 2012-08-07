package ch14.ex14_03;

public class AddTest  implements Runnable {
	private Data d;

	public AddTest(Data d){
		this.d = d;
	}

	public void run() {
		for(;;) {
			d.add(10);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Data data = new Data();

		Runnable as1 = new AddTest(data);
		Runnable as2 = new AddTest(data);
		Runnable as3 = new AddTest(data);
		Runnable as4 = new AddTest(data);

		new Thread(as1).start();
		new Thread(as2).start();
		new Thread(as3).start();
		new Thread(as4).start();
	}
}
