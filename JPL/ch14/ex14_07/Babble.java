package ch14.ex14_07;

public class Babble extends Thread{
	static boolean doYeild;
	static int howOften;
	private String word;

	Babble (String whatToSay){
		word = whatToSay;
	}

	public void run(){
		for (int i = 0; i < howOften; i++) {
			System.out.println(word);
			if(doYeild)
				Thread.yield();
		}
	}

	public static void main(String[] args) {
		doYeild = new Boolean(args[0]).booleanValue();
		howOften = Integer.parseInt(args[1]);

		for(int i =  2; i < args.length; i++) {
			new Babble(args[i]).start();
		}
	}


}
