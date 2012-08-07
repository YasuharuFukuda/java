package ch14.ex14_06;


public class MessageThread implements Runnable{
	private String ms = "hello";
	private boolean flag = true;
	public static Object o = new Object();

	public void run() {
		for(;;) {
			try {
				Thread.sleep(1000);
				msgDisplay();
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

	public synchronized boolean getFlag() {
		return this.flag;
	}

	 public synchronized void inform() {
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		 flag = false;
		 notifyAll();
	 }

	 private synchronized void msgDisplay() throws InterruptedException {
		 while (flag)
			 wait();

		 System.out.println(ms);
	 }
}
