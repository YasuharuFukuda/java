package ch14.ex14_01;

public class ThreadTest extends Thread {
	public ThreadTest(){

	}

	public void run(){
		try {
			for (;;){
				System.out.println(Thread.currentThread());
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ThreadTest().start();
		new ThreadTest().start();
		new ThreadTest().start();
		new ThreadTest().start();
	}
}
