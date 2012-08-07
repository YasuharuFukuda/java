package ch14.ex14_02;

public class PrintServer implements Runnable {
	private final PrintQueue requests = new PrintQueue();
	private String NAME = "printserver";

	public PrintServer() {
		new Thread(this, NAME).start();
	}
	public void print(PrintJob job){
		requests.add(job);
	}

	public void run() {
		if(Thread.currentThread().getName().equals(NAME)) {
			for(;;) {
				System.out.println("run!!");
				realPrint(requests.remove());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		} else {
			System.out.println("can not run");
		}
	}

	private void realPrint(PrintJob job){

	}

	public static void main(String[] args) {
		Runnable ps = new PrintServer();
		new Thread(ps); // run!!

		ps.run(); // can not run
	}

}
