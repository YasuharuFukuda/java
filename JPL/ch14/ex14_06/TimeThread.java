package ch14.ex14_06;

import java.util.Date;

public class TimeThread implements Runnable {
	Date date;
	MessageThread mt;
	private long elapsedTime = 0;

	public TimeThread(MessageThread mt){
		this.mt = mt;
	}

	public void run() {

		for(;;) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			elapsedTime++;
			System.out.println("Time: " + elapsedTime);
			mt.inform();
		}

	}
}
